package biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public class Biblioteca {

	private List<Usuario> usuarios;
	private List<Publicacao> publicacoes;
	private List<Emprestimo> emprestimos;

	/**
	 * 
	 */
	public Biblioteca() {
		this.usuarios = new ArrayList<Usuario>();
		this.publicacoes = new ArrayList<Publicacao>();
		this.emprestimos = new ArrayList<Emprestimo>();
	}

	/**
	 * @param usuario
	 */
	public void add(Usuario usuario) {
		usuarios.add(usuario);
	}

	/**
	 * @param publicacao
	 */
	public void add(Publicacao publicacao) {
		publicacoes.add(publicacao);
	}

	/**
	 * @param emprestimo
	 */
	public void add(Emprestimo emprestimo) {
		emprestimos.add(emprestimo);
	}

	/**
	 * @param emprestimo
	 * @param publicacao
	 * @throws Exception
	 */
	public void add(Emprestimo emprestimo, Emprestavel publicacao)
			throws Exception {
		emprestimo.adicionarPublicação(publicacao);
	}

	/**
	 * @param usuario
	 * @throws Exception
	 */
	public void remove(Usuario usuario) throws Exception {
		for (Emprestimo emprestimo : emprestimos) {
			if (emprestimo.getUsuario().equals(usuario))
				throw new Exception(
						"Usuario possui emprestimos só pode ser removido se o emprestimo pendente for finalizar.");
		}
		usuarios.remove(usuario);
	}

	/**
	 * @param publicacao
	 * @throws Exception
	 */
	public void remove(Publicacao publicacao) throws Exception {
		if (publicacao instanceof Emprestavel) {
			for (Emprestimo emprestimo : emprestimos) {
				if (emprestimo.contem((Emprestavel) publicacao))
					throw new Exception(
							"Essa publicacao esta emprestada só pode ser removido se emprestimo pendente for finalizado.");
			}
		}
		publicacoes.remove(publicacao);
	}

	/**
	 * @param emprestimo
	 * @throws Exception
	 */
	public void remove(Emprestimo emprestimo) throws Exception {
		emprestimo = this.getEmprestimo(emprestimo.getNumero());
		emprestimo.devolucaoDeTodosItensEmprestados();
		emprestimos.remove(emprestimo);
	}

	/**
	 * @param emprestimo
	 * @param publicacao
	 * @throws Exception
	 */
	public void remove(Emprestimo emprestimo, Emprestavel publicacao)
			throws Exception {
		emprestimo = this.getEmprestimo(emprestimo.getNumero());
		emprestimo.excluirItem(publicacao);
	}

	/**
	 * @param emprestimo
	 * @param publicacao
	 * @throws Exception
	 */
	public void realizarDevolucao(Emprestimo emprestimo, Emprestavel publicacao)
			throws Exception {
		emprestimo = this.getEmprestimo(emprestimo.getNumero());
		emprestimo.excluirItem(publicacao);
	}

	/**
	 * @param emprestimo
	 * @throws Exception
	 */
	public void realizarDevolucaoDeTodosOsItens(Emprestimo emprestimo)
			throws Exception {
		emprestimo = this.getEmprestimo(emprestimo.getNumero());
		emprestimo.devolucaoDeTodosItensEmprestados();
	}

	/**
	 * @param titulo
	 * @return
	 */
	public List<Publicacao> pesquisarTitulo(String titulo) {
		List<Publicacao> titulosParecidos = new ArrayList<Publicacao>();
		for (Publicacao publicacao : publicacoes) {
			if (publicacao.getTitulo().contains(titulo))
				titulosParecidos.add(publicacao);
		}
		return titulosParecidos;
	}

	/**
	 * @param nome
	 * @return
	 */
	public List<Livro> pesquisarAutor(String nome) {
		List<Livro> titulosParecidos = new ArrayList<Livro>();
		for (Publicacao publicacao : publicacoes) {
			if (publicacao instanceof Livro)
				if (((Livro) publicacao).getAutores().contains(nome))
					titulosParecidos.add((Livro) publicacao);
		}
		return titulosParecidos;
	}

	/**
	 * @return
	 */
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * @return
	 */
	public List<Publicacao> getPublicacoes() {
		return publicacoes;
	}

	/**
	 * @return
	 */
	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	/**
	 * @param numeroEmprestimo
	 * @return
	 */
	public Emprestimo getEmprestimo(int numeroEmprestimo) {
		Emprestimo emprestimo = null;
		for (Emprestimo emprestimoInteracao : emprestimos)
			if (emprestimoInteracao.getNumero() == numeroEmprestimo) {
				emprestimo = emprestimoInteracao;
				break;
			}
		return emprestimo;
	}

	/**
	 * @param codPublicacao
	 * @return
	 */
	public Publicacao getPublicacao(int codPublicacao) {
		Publicacao publicacao = null;
		for (Publicacao publicacaoInteracao : publicacoes)
			if (publicacaoInteracao.getCodPublicacao() == codPublicacao) {
				publicacao = publicacaoInteracao;
				break;
			}
		return publicacao;
	}

}
