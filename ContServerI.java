import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.*;

public interface ContServerI extends Remote {
    public Cont createCont(float initValue) throws RemoteException;
}

