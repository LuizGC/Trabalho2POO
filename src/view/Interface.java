package view;

import java.util.Calendar;

import javax.swing.JOptionPane;

import biblioteca.Biblioteca;
import biblioteca.Emprestavel;
import biblioteca.Emprestimo;
import biblioteca.Livro;
import biblioteca.Periodico;
import biblioteca.Publicacao;
import biblioteca.Usuario;

public class Interface {

	private static Interface instance;
	private Biblioteca biblioteca;

	private Interface() {

	}

	public static Interface getInstance() {
		if (instance == null) {
			instance = new Interface();
			instance.biblioteca = new Biblioteca();
		}
		return instance;
	}

	/**
	 * Classe que constrói a interface do usuário.
	 */
	public void gerarMenu() {
		String menu = "SISTEMA DE GERENCIAMENTO DE BILIOTECA\n"
				+ "1 - Cadastrar um novo usuario\n"
				+ "2 - Cadastrar uma nova publicacao\n"
				+ "3 - Cadastrar um novo emprestimo\n"
				+ "4 - Adicionar um item ao emprestimo\n"
				+ "5 - Excluir um usuário\n" + "6 - Excluir uma publicacao\n"
				+ "7 - Excluir um emprestimo\n"
				+ "8 - Excluir um item do emprestimo\n"
				+ "9 - Devolver Todos as publicacoes de um emprestimo\n"
				+ "10 - Devolver uma publicacao de um emprestimo\n"
				+ "11 - Pesquisar publicacao por titulo\n"
				+ "12 - Pesquisar livro por autor\n" + "13 - Listar Usuarios\n"
				+ "14 - Listar Publicacoes\n"
				+ "15 - Listar Emprestimos e seus itens\n" + "16 - Sair\n"
				+ "Acao: ";
		while (true) {
			try {
				menuAction(JOptionPane.showInputDialog(menu));
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,
						"Você deve utilizar somente numeros inteiros.");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
	}

	private void menuAction(String action) throws Exception,
			NumberFormatException {
		switch (Integer.valueOf(action)) {
		case 1:// Cadastrar um novo usuario
			cadastrarNovoUsuario();
			break;
		case 2:// Cadastrar uma nova Publicacao
			cadastrarNovaPublicacao();
			break;
		case 3:// Cadastrar um novo Emprestimo
			cadastrarNovoEmprestimo();
			break;
		case 4:
			cadastrarItemParaEmprestimo();
			break;
		case 5:
			excluirUsuario();
			break;
		case 6:
			excluirPublicacao();
			break;
		case 7:
			excluirEmprestimo();
			break;
		case 8:
			excluirItemEmprestimo();
			break;
		case 9:
			devolverTodosItensEmprestimo();
			break;
		case 10:
			devolverUmItensEmprestimo();
			break;
		case 11:
			buscarPublicacaoTitulo();
			break;
		case 12:
			buscarPublicacaoAutor();
			break;
		case 13:
			listarUsuarios();
			break;
		case 14:
			listarPublicacao();
			break;
		case 15:
			listarEmprestimos();
			break;
		case 16:
			System.exit(0);
			break;
		default:
			throw new Exception("Você deve apertar um numero de 1 a 16.");
		}
	}

	private void cadastrarNovoUsuario() throws NumberFormatException {
		String nome = JOptionPane.showInputDialog("Nome do usuario:");
		String cpf = JOptionPane.showInputDialog("Cpf do usuario:");
		String endereco = JOptionPane.showInputDialog("Endereco do usuario:");
		String fone = JOptionPane.showInputDialog("Fone do usuario:");
		Usuario usuario = new Usuario(nome, cpf, endereco, fone);
		biblioteca.add(usuario);
	}

	private void cadastrarNovaPublicacao() throws NumberFormatException,
			Exception {
		switch (Integer.valueOf(JOptionPane
				.showInputDialog("1 - Livro\n2 - Periodico\ntipo:"))) {
		case 1:// Cadastrar um novo usuario
			cadastrarNovoLivro();
			break;
		case 2:// Cadastrar um novo usuario
			cadastrarNovoPeriodico();
			break;
		default:
			throw new Exception("Você deve escolher 1 - Livro ou 2 - Periodico");
		}
	}

	private void cadastrarNovoLivro() throws NumberFormatException {
		int codPublicacao = Integer.valueOf(JOptionPane
				.showInputDialog("Codigo da Publicacao"));
		String titulo = JOptionPane.showInputDialog("Titulo da Publicacao");
		String editora = JOptionPane.showInputDialog("Editora da Publicacao");
		int ano = Integer.valueOf(JOptionPane
				.showInputDialog("Ano da Publicacao"));
		String autores = JOptionPane.showInputDialog("Autores da Publicacao");
		int qtdeExamplares = Integer.valueOf(JOptionPane
				.showInputDialog("Quantidade de Examplares da Publicacao"));

		Publicacao publicacao = new Livro(codPublicacao, titulo, editora, ano,
				autores, qtdeExamplares);
		biblioteca.getPublicacoes().add(publicacao);
	}

	private void cadastrarNovoPeriodico() throws NumberFormatException {
		int codPublicacao = Integer.valueOf(JOptionPane
				.showInputDialog("Codigo da Publicacao"));
		String titulo = JOptionPane.showInputDialog("Titulo da Publicacao");
		String editora = JOptionPane.showInputDialog("Editora da Publicacao");
		int ano = Integer.valueOf(JOptionPane
				.showInputDialog("Ano da Publicacao"));
		int numEdicao = Integer.valueOf(JOptionPane
				.showInputDialog("Autores da Publicacao"));
		int mes = Integer.valueOf(JOptionPane
				.showInputDialog("Quantidade de Examplares da Publicacao"));

		Publicacao publicacao = new Periodico(codPublicacao, titulo, editora,
				ano, numEdicao, mes);
		biblioteca.getPublicacoes().add(publicacao);
	}

	private void cadastrarNovoEmprestimo() throws NumberFormatException,
			Exception {
		String cpf = JOptionPane.showInputDialog("Cpf do usuario:");
		Usuario usuario = new Usuario("", cpf, "", "");
		int indexusuario = biblioteca.getUsuarios().indexOf(usuario);

		Calendar dataPrevDevolucao = Calendar.getInstance();
		dataPrevDevolucao.add(Calendar.DAY_OF_MONTH, 7);

		Emprestimo emprestimo = new Emprestimo(biblioteca.getUsuarios().get(
				indexusuario), dataPrevDevolucao);

		cadastrarItemParaEmprestimo(emprestimo);

		biblioteca.getEmprestimos().add(emprestimo);

	}

	private void cadastrarItemParaEmprestimo(Emprestimo emprestimo)
			throws NumberFormatException, Exception {
		Publicacao publicacao = buscarPublicacao();
		if (publicacao != null) {

			if (publicacao instanceof Emprestavel)
				emprestimo.adicionarPublicação((Emprestavel) publicacao);
			else
				JOptionPane.showMessageDialog(null,
						"Essa publicação não pode ser emprestada");
		} else {
			JOptionPane.showMessageDialog(null, "Não existe esse elemento");
		}

		if (JOptionPane.showConfirmDialog(null,
				"Deseja inserir mais uma publicacao") == 0)
			cadastrarItemParaEmprestimo(emprestimo);
	}

	private void cadastrarItemParaEmprestimo() throws NumberFormatException,
			Exception {
		Emprestimo emprestimo = buscarEmprestimo();
		if (emprestimo == null)
			throw new Exception("Não existe esse emprestimo");
		else
			cadastrarItemParaEmprestimo(emprestimo);
	}

	private Emprestimo buscarEmprestimo() {
		int numeroEmprestimo = Integer.valueOf(JOptionPane
				.showInputDialog("Numero do Emprestimo"));
		return biblioteca.getEmprestimo(numeroEmprestimo);
	}

	private Publicacao buscarPublicacao() {
		int codPublicacao = Integer.valueOf(JOptionPane
				.showInputDialog("Codigo da Publicacao"));
		return biblioteca.getPublicacao(codPublicacao);
	}

	private void excluirUsuario() throws Exception {
		String cpf = JOptionPane.showInputDialog("Cpf do usuario:");
		Usuario usuario = new Usuario("", cpf, "", "");
		int indexUsuario = biblioteca.getUsuarios().indexOf(usuario);
		if (indexUsuario == -1) {
			throw new Exception("Não existe esse usuario");
		} else {
			biblioteca.remove(biblioteca.getUsuarios().get(indexUsuario));
		}
	}

	private void excluirPublicacao() throws NumberFormatException, Exception {

		Publicacao publicacao = buscarPublicacao();
		if (publicacao == null) {
			throw new Exception("Não existe essa publicacao");
		} else {
			biblioteca.remove(publicacao);
		}
	}

	private void excluirEmprestimo() throws NumberFormatException, Exception {
		Emprestimo emprestimo = buscarEmprestimo();
		biblioteca.remove(emprestimo);
	}

	private void excluirItemEmprestimo() throws NumberFormatException,
			Exception {
		Emprestimo emprestimo = buscarEmprestimo();
		Publicacao publicacao = biblioteca
				.getPublicacao(getCodPublicacao(emprestimo));
		biblioteca.remove(emprestimo, (Emprestavel) publicacao);
	}

	private int getCodPublicacao(Emprestimo emprestimo) {
		return Integer.valueOf(JOptionPane.showInputDialog(emprestimo
				.toString() + "\n" + "Item a ser deletado:"));
	}

	private void listarUsuarios() {
		String listaUsuarios = "";
		for (Usuario usuario : biblioteca.getUsuarios()) {
			listaUsuarios += usuario.toString() + "\n";
		}
		JOptionPane.showMessageDialog(null, listaUsuarios);

	}

	private void listarPublicacao() {
		String listaPublicacoes = "";
		for (Publicacao publicacao : biblioteca.getPublicacoes()) {
			listaPublicacoes += publicacao.toString() + "\n";
		}
		JOptionPane.showMessageDialog(null, listaPublicacoes);
	}

	private void listarEmprestimos() {
		String listaEmprestimos = "";
		for (Emprestimo emprestimo : biblioteca.getEmprestimos()) {
			listaEmprestimos += emprestimo.toString();
		}
		JOptionPane.showMessageDialog(null, listaEmprestimos);
	}

	private void devolverTodosItensEmprestimo() throws Exception {
		Emprestimo emprestimo = buscarEmprestimo();
		biblioteca.realizarDevolucaoDeTodosOsItens(emprestimo);
	}

	private void devolverUmItensEmprestimo() throws Exception {
		Emprestimo emprestimo = buscarEmprestimo();
		Publicacao publicacao = biblioteca
				.getPublicacao(getCodPublicacao(emprestimo));
		biblioteca.realizarDevolucao(emprestimo, (Emprestavel) publicacao);
	}

	private void buscarPublicacaoTitulo() {
		String titulo = JOptionPane.showInputDialog("Titulo da publicacao");
		String listaPublicacao = "";
		for (Publicacao publicacao : biblioteca.pesquisarTitulo(titulo)) {
			listaPublicacao += publicacao.toString() + "\n";
		}
		JOptionPane.showMessageDialog(null, listaPublicacao);
	}

	private void buscarPublicacaoAutor() {
		String autor = JOptionPane.showInputDialog("Autor da publicacao");
		String listaPublicacao = "";
		for (Publicacao publicacao : biblioteca.pesquisarAutor(autor)) {
			listaPublicacao += publicacao.toString() + "\n";
		}
		JOptionPane.showMessageDialog(null, listaPublicacao);
	}

}
