package biblioteca;

public class Livro extends Publicacao implements Emprestavel {

	private String autores;
	private int qtdeExamplares;

	public Livro(int codPublicacao, String titulo, String editora, int ano,
			String autores, int qtdeExamplares) {
		super(codPublicacao, titulo, editora, ano);
		this.autores = autores;
		this.qtdeExamplares = qtdeExamplares;
	}

	public Livro(int codPublicacao, String titulo, String editora, int ano,
			String autores) {
		super(codPublicacao, titulo, editora, ano);
		this.autores = autores;
		this.qtdeExamplares = 0;
	}

	public String getAutores() {
		return autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}

	public int getQtdeExamplares() {
		return qtdeExamplares;
	}

	@Override
	public int maisUmLivro() {
		return qtdeExamplares++;
	}

	@Override
	public int menosUmLivro() throws Exception {
		if (qtdeExamplares > 0) {
			return qtdeExamplares--;
		} else {
			throw new Exception(
					"Quantidade de examplares Ž 0, sendo impossivel subtrair um livro.");
		}
	}

}
