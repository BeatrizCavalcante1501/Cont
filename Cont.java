import java.rmi.*;

public interface Cont extends Remote {
    // Retorna o valor atual do contador
    public float getValue() throws RemoteException;

    // Incrementa o contador e retorna seu novo valor
    public float nextValue() throws RemoteException;
}