import java.util.Scanner;

public class ListTarefas {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Lista listTest = new Lista();
		No no = new No();
		int opcao = 0;
		
		do{
			System.out.println("Digite 0-Sair, 1-Adicionar, 2-excluir, 3-Concluir Tarefa e 4-Imprimir:");
			opcao = sc.nextInt();
		

			if(opcao == 1) {
				System.out.println("Digite uma tarefa: ");
				no.setValor(sc.next());
				listTest.inserir(listTest, no.getValor());
			}if(opcao == 2) {
				System.out.println("Digite uma tarefa: ");
				int valor = sc.nextInt();
				listTest.remover(listTest, valor);
			}if(opcao == 3) {
				System.out.println("Digite uma tarefa: ");
				int valor = sc.nextInt();
				listTest.concluir(listTest,valor);
			}if(opcao == 4) {
				listTest.print(listTest);
			}

		}while(opcao != 0);

	}

}
