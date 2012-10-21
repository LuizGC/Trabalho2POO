package biblioteca;

public class Periodico extends Publicacao {

	private int numEdicao;
	private int mes;

	/**
	 * @param codPublicacao
	 * @param titulo
	 * @param editora
	 * @param ano
	 * @param numEdicao
	 * @param mes
	 */
	public Periodico(int codPublicacao, String titulo, String editora, int ano,
			int numEdicao, int mes) {
		super(codPublicacao, titulo, editora, ano);
		this.numEdicao = numEdicao;
		this.mes = mes;
	}

	/**
	 * @return
	 */
	public int getNumEdicao() {
		return numEdicao;
	}

	/**
	 * @param numEdicao
	 */
	public void setNumEdicao(int numEdicao) {
		this.numEdicao = numEdicao;
	}

	/**
	 * @return
	 */
	public int getMes() {
		return mes;
	}

	/**
	 * @param mes
	 */
	public void setMes(int mes) {
		this.mes = mes;
	}

}
