package biblioteca;

public abstract class Publicacao {

	private int codPublicacao;
	private String titulo;
	private String editora;
	private int ano;

	public Publicacao(int codPublicacao, String titulo, String editora, int ano) {
		this.codPublicacao = codPublicacao;
		this.titulo = titulo;
		this.editora = editora;
		this.ano = ano;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

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
