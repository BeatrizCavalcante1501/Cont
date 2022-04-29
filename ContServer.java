//Bibliotecas
import java.rmi.*;
import java.util.Scanner;
import java.rmi.server.*;
import java.rmi.registry.*;

public class ContServer implements ContServerI {

    public ContServer() {

    }

    public static void main(String[] args) {
        try {
            System.out.println("Iniciando Servidor...");  //printa que o servidor está sendo iniciado
            ContServer server = new ContServer();
            ContServerI stub = (ContServerI) UnicastRemoteObject.exportObject(server, 0); //através do stub vai se obter acesso remoto da função createcont 

            // Registra a stub no RMI Registry para que a mesma seja acessada pelos clientes
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Server", stub); //vai procurar o registro com  denominado 0 e vai poder acessar o stub

            System.out.println("Servidor pronto");


        } catch (Exception e) {
          
        }

    }

    // Retorna uma outra referencia com a qual o contador pode ser acessado
    @Override
    public Cont createCont(float initValue) throws RemoteException {
        try {
            ContObjeto counter = new ContObjeto(initValue);
            Cont stubCounter = (Cont) UnicastRemoteObject.exportObject(counter, 0);
            Registry registry = LocateRegistry.getRegistry(); //vai criar um registro para o cliente para o cliente acessar o contador
            registry.bind("Counter", stubCounter);
            System.out.println("Criando contador com o inicial: " + counter.getValue());
        } catch (AlreadyBoundException e) {
      
            e.printStackTrace();
        }
        return null;
    }

}