
public class ListTarefas {

	public static void main(String[] args) {
		No no1 = new No();
		No no2 = new No();
		No no3 = new No();
		No no4 = new No();
		
		no1.setValor("hoje");
		no2.setValor("Amanhã");
		no3.setValor("Domingo");
		no4.setValor("Final de semana");
		
		Lista listTest = new Lista();
		
		listTest.inserir(listTest, no1.getValor());
		listTest.inserir(listTest, no2.getValor());
		listTest.inserir(listTest, no3.getValor());
		listTest.inserir(listTest, no4.getValor());
		
		listTest.print(listTest);
		
		listTest.remover(listTest, no3.getValor());
		
		listTest.print(listTest);
		
	}

}
