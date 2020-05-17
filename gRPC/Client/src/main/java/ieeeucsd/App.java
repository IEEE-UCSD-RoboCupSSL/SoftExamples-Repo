package ieeeucsd;

import java.util.concurrent.TimeUnit;

import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        String name = "127.0.0.1";
        int port = 8980;
        ManagedChannel channel = ManagedChannelBuilder.forAddress(name, port).usePlaintext().build();
        
        // different connection states: https://github.com/grpc/grpc/blob/master/doc/connectivity-semantics-and-api.md
        System.out.println("Connecting ...");
        while(channel.getState(true) != ConnectivityState.READY);

        try {
            Client client = new Client(channel, name);
            String reply = client.greetServer("Hi, this is client, what's up \n");
            if(reply != null) {
                System.out.println("Got reply from server: " + reply);
            }
        }
        finally {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        }
        
        
    }
}
