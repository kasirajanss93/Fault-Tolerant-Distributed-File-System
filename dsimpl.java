package ds;
import java.rmi.*;
import java.io.*;
public class dsimpl implements dsint
{
   byte[] buffer;
   public byte[] getvideo(String filename)throws RemoteException
  {
     try
        {
           File f=new File("mapping.xml");
          FileInputStream fis=new FileInputStream(f);
          buffer=new byte[30*1024*1024];
          fis.read(buffer,0,buffer.length);
          fis.close();
	  //f.close();
        }
     catch(Exception e)
        {
             System.out.println(e);
        }
	  return buffer;
}
}