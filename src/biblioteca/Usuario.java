package biblioteca;

import java.util.Calendar;

public class Usuario {

	private String nome;
	private String cpf;
	private String endereco;
	private String fone;
	private Calendar dataPenalizacao;

	/**
	 * @param nome
	 * @param cpf
	 * @param endereco
	 * @param fone
	 */
	public Usuario(String nome, String cpf, String endereco, String fone) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.fone = fone;
		this.dataPenalizacao = null;
	}

	/**
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return
	 */
	public String getFone() {
		return fone;
	}

	/**
	 * @param fone
	 */
	public void setFone(String fone) {
		this.fone = fone;
	}

	/**
	 * @return
	 */
	public Calendar getDataPenalizacao() {
		return dataPenalizacao;
	}

	/**
	 * @param dataPenalizacao
	 */
	public void setDataPenalizacao(Calendar dataPenalizacao) {
		this.dataPenalizacao = dataPenalizacao;
	}

	@Override
	public boolean equals(Object obj) {
		Usuario usuario = (Usuario) obj;
		if (usuario.cpf.equals(this.cpf))
			return true;
		else
			return false;

	}

	@Override
	public String toString() {
		return this.nome + " - " + this.cpf + " - " + this.endereco + " - "
				+ this.fone;
	}

}
