package biblioteca;

public class Periodico extends Publicacao {

	private int numEdicao;
	private int mes;

	public Periodico(int codPublicacao, String titulo, String editora, int ano,
			int numEdicao, int mes) {
		super(codPublicacao, titulo, editora, ano);
		this.numEdicao = numEdicao;
		this.mes = mes;
	}

	public int getNumEdicao() {
		return numEdicao;
	}

	public void setNumEdicao(int numEdicao) {
		this.numEdicao = numEdicao;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

}
