package biblioteca;

public class Livro extends Publicacao implements Emprestavel {

	private String autores;
	private int qtdeExamplares;

	/**
	 * @param codPublicacao
	 * @param titulo
	 * @param editora
	 * @param ano
	 * @param autores
	 * @param qtdeExamplares
	 */
	public Livro(int codPublicacao, String titulo, String editora, int ano,
			String autores, int qtdeExamplares) {
		super(codPublicacao, titulo, editora, ano);
		this.autores = autores;
		this.qtdeExamplares = qtdeExamplares;
	}

	/**
	 * @param codPublicacao
	 * @param titulo
	 * @param editora
	 * @param ano
	 * @param autores
	 */
	public Livro(int codPublicacao, String titulo, String editora, int ano,
			String autores) {
		super(codPublicacao, titulo, editora, ano);
		this.autores = autores;
		this.qtdeExamplares = 0;
	}

	/**
	 * @return
	 */
	public String getAutores() {
		return autores;
	}

	/**
	 * @param autores
	 */
	public void setAutores(String autores) {
		this.autores = autores;
	}

	/**
	 * @return
	 */
	public int getQtdeExamplares() {
		return qtdeExamplares;
	}

	/* (non-Javadoc)
	 * @see biblioteca.Emprestavel#maisUmLivro()
	 */
	@Override
	public int maisUmLivro() {
		return qtdeExamplares++;
	}

	/* (non-Javadoc)
	 * @see biblioteca.Emprestavel#menosUmLivro()
	 */
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
