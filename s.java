import java.io.*;
import java.net.*;
public class s
{
  public static void main(String[] args) throws Exception
  {
      ServerSocket sersock = new ServerSocket(6700);
      System.out.println("Server ");
      Socket sock = sersock.accept( );
      BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
      OutputStream ostream = sock.getOutputStream();
      PrintWriter pwrite = new PrintWriter(ostream, true);
      InputStream istream = sock.getInputStream();
      BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
      String rMessage, sMessage;
      while(true)
      { try{
        if((rMessage=receiveRead.readLine()).indexOf("OVER")== -1 )
        {
           System.out.println("Client : " + rMessage);
        }
	else{
	    System.out.println("Connection Terminated");
      sersock.close();
      sock.close();}}catch(NullPointerException e) {System.exit(0);}
	System.out.print("Server : ");
        sMessage = keyRead.readLine();
        pwrite.println(sMessage);
        pwrite.flush();
      }

    }
}
