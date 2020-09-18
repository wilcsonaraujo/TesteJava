public class Lista {
	No cabeca;
	
	public Lista inserir(Lista list, String valor) {
		No node = new No();
		node.setProximo(null);
		node.setValor(valor);
		
		if(list.cabeca == null) {
			list.cabeca = node;
		}else {
			No ultimo = list.cabeca;
			while (ultimo.getProximo() != null) {
				ultimo = ultimo.getProximo();
			}
			ultimo.setProximo(node);
		}
		
		return list;		
	}
	
	public Lista remover(Lista list, int index) {
		No pNode = list.cabeca, prev = null;
		
		if(index == 0 && pNode != null) {
			list.cabeca = pNode.getProximo();
			
			System.out.println("Item Removido!");
			
			return list;
		}
		
		int cont = 0;
		
		while(pNode != null){
			if(cont == index) {
				prev.setProximo(pNode.getProximo());
				
				System.out.println("Item Removido!");
				break;
			}else {
				prev = pNode;
				pNode = pNode.getProximo();
				cont++;
			}
			
		}
		
		if(pNode == null) {
			System.out.println("Item inexistente!");
		}
		
		return list;
	}
	
	public Lista concluir(Lista list, int index) {
		No pNode = list.cabeca;
		
		if(index == 0 && pNode != null) {
			pNode.setStatus("Concluído");
			return list;
		}
		
		int cont = 0;
		
		while(pNode != null){
			if(cont == index) {
				pNode.setStatus("Concluído");

				break;
			}else {
				pNode.setStatus("Concluído");
				cont++;
			}
			
		}
		
		if(pNode == null) {
			System.out.println("Item inexistente!");
		}

		return list;
	}
	
	public void print(Lista list) {
		No pNode = list.cabeca;
		
		System.out.println("Lista: ");
		
		while (pNode != null) {
			System.out.println(pNode.getValor() + " " + pNode.getStatus());
			
			pNode = pNode.getProximo();
		}
	}
}
