package biblioteca;

import java.util.Calendar;

public class ItemEmprestado {

	private Calendar dataDevolucao;
	private Emprestavel publicacao;

	/**
	 * @param publicacao
	 */
	public ItemEmprestado(Emprestavel publicacao) {
		this.dataDevolucao = null;
		this.publicacao = publicacao;
	}

	/**
	 * @return
	 */
	public Calendar getDataDevolucao() {
		return dataDevolucao;
	}

	/**
	 * @return
	 */
	public Emprestavel getPublicacao() {
		return publicacao;
	}

	/**
	 * 
	 */
	public void devolver() {
		publicacao.maisUmLivro();
		dataDevolucao = Calendar.getInstance();
	}

	@Override
	public boolean equals(Object obj) {
		ItemEmprestado item = (ItemEmprestado) obj;
		if (this.publicacao.getCodPublicacao() == item.getPublicacao()
				.getCodPublicacao())
			return true;
		else
			return false;
	}
}
