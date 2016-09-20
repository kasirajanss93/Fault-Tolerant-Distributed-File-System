package ds;
import java.rmi.*;
public interface dsint extends Remote
{
   public byte[] getvideo(String filename)throws RemoteException;
}