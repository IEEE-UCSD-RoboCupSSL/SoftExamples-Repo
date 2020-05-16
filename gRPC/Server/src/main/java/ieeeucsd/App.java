package ieeeucsd;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Server started!" );
        //new EgServer("127.0.0.1", 8980);
        EgServer server = new EgServer(8980);
        server.start();
        server.awaitStop();
    }
}
