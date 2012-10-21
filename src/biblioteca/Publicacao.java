package biblioteca;

public abstract class Publicacao {

	private int codPublicacao;
	private String titulo;
	private String editora;
	private int ano;

	/**
	 * @param codPublicacao
	 * @param titulo
	 * @param editora
	 * @param ano
	 */
	public Publicacao(int codPublicacao, String titulo, String editora, int ano) {
		this.codPublicacao = codPublicacao;
		this.titulo = titulo;
		this.editora = editora;
		this.ano = ano;
	}

	/**
	 * @return
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return
	 */
	public String getEditora() {
		return editora;
	}

	/**
	 * @param editora
	 */
	public void setEditora(String editora) {
		this.editora = editora;
	}

	/**
	 * @return
	 */
	public int getAno() {
		return ano;
	}

	/**
	 * @param ano
	 */
	public void setAno(int ano) {
		this.ano = ano;
	}

	/**
	 * @return
	 */
	public int getCodPublicacao() {
		return codPublicacao;
	}

	@Override
	public boolean equals(Object obj) {
		Publicacao publicacao = (Publicacao) obj;
		if (publicacao.codPublicacao == this.codPublicacao)
			return true;
		else
			return false;

	}

	@Override
	public String toString() {
		return codPublicacao + " - " + titulo + " - " + ano + " - " + editora;
	}

}
