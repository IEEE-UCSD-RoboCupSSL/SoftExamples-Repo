package ieeeucsd;

import MyProto.*;
import MyProto.Rpc.greet;


public class App 
{
    public static void main( String[] args )
    {
        
        greet send = greet.newBuilder().setMsg("hi").build();

        greet receive = send;
        System.out.println(receive.getMsg());
        
        
        
    }
}
