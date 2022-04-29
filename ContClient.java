
import java.rmi.registry.*;
import java.util.Scanner;

public class ContClient {
    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        try {
            // recebe uma referência para o registro do RMI
            Registry registry = LocateRegistry.getRegistry(host);
            // Vai procurar pelo registro da stub no servidor
            ContServerI stub = (ContServerI) registry.lookup("Server");

            // recebe o metodo do servidor e imprime a mensagem
            System.out.print("Por favor, digite um Valor: ");
            Scanner in = new Scanner(System.in);
            float valor = in.nextFloat();

            stub.createCont(valor);

            Cont stubCounter = (Cont) registry.lookup("Counter");  //está procurando pelo contador
            int op;
            for(op=0; op!=3;){ //começa de 0 
                System.out.println("\nPor favor, escolha uma opcao:");
                System.out.println("1 - Exibir valor atual do Contador");
                System.out.println("2 - Incrementar valor do Contador");
                System.out.println("3 - Sair");
                op = in.nextInt();
                if(op==1){
                    float value = stubCounter.getValue();
		            System.out.println("\n\nValor atual do Contador: " + value);
                }else{
                    if(op==2){
                        float proxvalor = stubCounter.nextValue();
                        System.out.println("\nNovo Valor: " + proxvalor);
                    }else{
                        if(op!=3){
                            System.out.println("\nDesculpe, opcao invalida!");
                        }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
