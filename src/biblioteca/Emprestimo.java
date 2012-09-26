package biblioteca;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Emprestimo {

	private static int proximoNumero = 0;
	
	private int numero;
	private Calendar dataEmprestimo;
	private Calendar dataPrevDevolucao;
	private Usuario usuario;
	private List<ItemEmprestado> itens;
	
	public Emprestimo(Usuario usuario, Calendar dataPrevDevolucao) {
		this.numero = proximoNumero++;
		this.dataEmprestimo = GregorianCalendar.getInstance();
		this.dataPrevDevolucao = dataPrevDevolucao;
		this.usuario = usuario;
		this.itens = new ItensEmprestadosArray();
	}

	public int getNumero() {
		return numero;
	}

	public Calendar getDataEmprestimo() {
		return dataEmprestimo;
	}

	public Calendar getDataPrevDevolucao() {
		return dataPrevDevolucao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public boolean adicionarPublicação(Emprestavel publicacao) throws Exception{
		publicacao.menosUmLivro();
		return itens.add(new ItemEmprestado(publicacao));				
	}
	
	public void excluirItem(Emprestavel publicacao){
		itens.remove(new ItemEmprestado(publicacao));
	}
	
	public void devolucao(Emprestavel publicacao){
		int elementIndex = itens.indexOf(publicacao);
		ItemEmprestado itemEmprestado = itens.get(elementIndex);
		itemEmprestado.devolver();
	}
	
	public void devolucaoDeTodosItensEmprestados(){
		for(ItemEmprestado itemEmprestado : itens){
			itemEmprestado.devolver();
		}
	}
	
	public boolean contem(Emprestavel publicacao){
		int indexItem = itens.indexOf(new ItemEmprestado(publicacao));
		if(indexItem == -1 || itens.get(indexItem).getDataDevolucao() != null)
			return false;
		return true;
	}
	
	public boolean equals(Object obj){
		Emprestimo emprestimo = (Emprestimo) obj;
		if(emprestimo.numero == this.numero)
			return true;
		else
			return false;	
	}

	@Override
	public String toString() {
		String toString = "emprestimo: " + numero + " - " + dataEmprestimo.getTime().toString() + " - " + dataPrevDevolucao.getTime().toString() + "\n";
		for(ItemEmprestado item : itens){
			toString += "item: " +item.getPublicacao().toString() + "\n";
		}
		return toString;
	}

	
	
}
