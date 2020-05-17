

/*
 * Compile: javac --release 11 Client.java
 * Run: java Client
 */



import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.*;

public class Client {
    
    static DatagramSocket socket;
    static InetAddress ip;
    static int port;
    static byte[] buffer = new byte[10000];
    
    public static void main(String argv[]) throws IOException{
        
        socket = new DatagramSocket();
        ip = InetAddress.getLocalHost();
        port = 1234;
        

        while(true) {
            
            String msg = "Hi, Server!";
            buffer = msg.getBytes();
            try {
                socket.send(new DatagramPacket(buffer, buffer.length, ip, port));
            }
            catch (Exception e) {
                System.out.println("1: " + e.toString());
            }

            buffer = new byte[10000];
            DatagramPacket response = new DatagramPacket(buffer, buffer.length);
            try {
                socket.receive(response);
                String received = new String(response.getData(), 0, response.getLength());
                System.out.println(received);
            }
            catch (Exception e) {
                System.out.println("2: " + e.toString());
            }   
            
        }



    }
}