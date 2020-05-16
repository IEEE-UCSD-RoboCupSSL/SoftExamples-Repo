package ieeeucsd;

import MyProto.*;
import MyProto.Rpc.greet;
import MyProto.exampleGrpc.exampleBlockingStub;
import io.grpc.Channel;
import io.grpc.StatusRuntimeException;

public class Client {
    private final exampleBlockingStub blockStub;
    String name;

    public Client(Channel channel, String name) {
        blockStub = exampleGrpc.newBlockingStub(channel);
        this.name = name;
    }

    public String greetServer(String str) {
        greet send = greet.newBuilder().setMsg(str).setIdentity(name).build();
        greet receive = null;
        try {
            receive = blockStub.sayHi(send);
        }
        catch (StatusRuntimeException e) {}

        if(receive != null) {
            // System.out.println("Got reply from server: " + receive.getMsg());
            return receive.getMsg();
        }

        return null;
    }
}