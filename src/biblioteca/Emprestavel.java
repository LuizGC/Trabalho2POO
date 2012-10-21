package biblioteca;

public interface Emprestavel {

	/**
	 * @return
	 */
	public int maisUmLivro();

	/**
	 * @return
	 * @throws Exception
	 */
	public int menosUmLivro() throws Exception;

	/**
	 * @return
	 */
	public int getCodPublicacao();
}
