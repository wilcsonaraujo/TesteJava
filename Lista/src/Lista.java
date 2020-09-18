
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
	
	public Lista remover(Lista list, String chave) {
		No pNode = list.cabeca, prev = null;
		
		if(pNode != null && pNode.getValor() == chave) {
			list.cabeca = pNode.getProximo();
			
			System.out.println(chave + " Item Removido!");
			
			return list;
		}
		
		while(pNode != null && pNode.getValor() != chave){
			prev = pNode;
			pNode = pNode.getProximo();
		}
		
		if(pNode != null) {
			prev.setProximo(pNode.getProximo());
			
			System.out.println(chave + " Item Removido!");
		}
		if(pNode == null) {
			System.out.println(chave + " Item não existe!");
		}
		
		return list;
	}
	
	public void print(Lista list) {
		No pNode = list.cabeca;
		
		System.out.println("Lista: ");
		
		while (pNode != null) {
			System.out.println(pNode.getValor() + " ");
			
			pNode = pNode.getProximo();
		}
	}
}
