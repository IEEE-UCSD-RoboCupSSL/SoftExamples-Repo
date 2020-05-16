package ieeeucsd;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import MyProto.*;
import MyProto.Rpc.greet;
import io.grpc.stub.StreamObserver;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class EgServer {

    private int port;
    private Server server;

    public EgServer(String ip, int port) {
        this.port = port;
        server = ServerBuilder.forPort(port).addService(new RpcService()).build();
    }

    public EgServer(int port) {
        this.port = port;
        server = ServerBuilder.forPort(port).addService(new RpcService()).build();   
    }

    public void start() throws IOException {
        if(server != null) {
            server.start();
        } 
    }

    public void stop(int waitTime) throws InterruptedException {
        if(server != null) {
            server.shutdown().awaitTermination(waitTime, TimeUnit.SECONDS);
            server.awaitTermination();
        }
    }

    public void awaitStop() throws InterruptedException {
        if(server != null) {
            server.awaitTermination();
        }
    }

    private static class RpcService extends exampleGrpc.exampleImplBase {
        @Override
        public void sayHi(greet greeting, StreamObserver<greet> responseObserver) {
            System.out.println("Msg from " + greeting.getIdentity() + " : " + greeting.getMsg());
            greet hi = greet.newBuilder().setMsg("Hi, I'm server\n").build();
            responseObserver.onNext(hi);
            responseObserver.onCompleted();
        }
    }

}