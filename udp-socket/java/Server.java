
/*
 * Compile: javac --release 11 Server.java
 * Run: java Server
 */


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.*;

public class Server {

    static byte[] buffer = new byte[10000];

    public static void main(String args[]) throws IOException {
        DatagramSocket socket;
        DatagramPacket receivedPacket, responsePacket;
        int portToListen = 1234;

        socket = new DatagramSocket(portToListen);

        System.out.println("Server started");
        while(true) {
            
            receivedPacket = new DatagramPacket(buffer, buffer.length);

            try {
                socket.receive(receivedPacket);
            }
            catch (Exception e) {
                System.out.println(e.toString());
            }

            // print IP address and port number
            System.out.print("[" + receivedPacket.getAddress()
                                 + " : " + receivedPacket.getPort() + "] : ");
            
            // print packet content
            String received = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
            System.out.println(received);
            

            
            // reply
            String msg = "[Server: packet received, thank you]";
            buffer = msg.getBytes();
            responsePacket = new DatagramPacket(buffer, buffer.length,
                                                receivedPacket.getAddress(),
                                                receivedPacket.getPort());
            try {
                socket.send(responsePacket);
            }
            catch (Exception e) {
                System.out.println(e.toString());
            }
            

        }


    }
}
