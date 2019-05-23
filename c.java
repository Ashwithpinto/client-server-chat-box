import java.io.*;
import java.net.*;
public class c
{
  public static void main(String[] args) throws Exception
  {
     Socket sock = new Socket("127.0.0.1", 6700);
     BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
     OutputStream ostream = sock.getOutputStream();
     PrintWriter pwrite = new PrintWriter(ostream, true);
     InputStream istream = sock.getInputStream();
     BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
     int rcount = 0,scount=0;
     System.out.println("Welcome to Chatzapp :");
     String rMessage, sMessage;
     while(true)
     {
        System.out.print("Client : ");
        sMessage = keyRead.readLine();
        pwrite.println(sMessage);
	scount++;
        pwrite.flush(); try{
        if((rMessage=receiveRead.readLine()).indexOf("OVER") == -1)
        {
            System.out.println("Server : "+rMessage);
	    rcount++;
        }
	else
		break; }
	catch (NullPointerException e) {
System.exit(0);}

      }
      System.out.println("Connection Terminated");
      System.out.println("Sent Messages : "+scount);
      System.out.println("Received Messages : "+rcount);

      sock.close();

    }
}
