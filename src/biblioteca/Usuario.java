package biblioteca;

import java.util.Calendar;

public class Usuario {

	private String nome;
	private String cpf;
	private String endereco;
	private String fone;
	private Calendar dataPenalizacao;
	
	public Usuario(String nome, String cpf, String endereco,
			String fone) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.fone = fone;
		this.dataPenalizacao = null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public Calendar getDataPenalizacao() {
		return dataPenalizacao;
	}

	public void setDataPenalizacao(Calendar dataPenalizacao) {
		this.dataPenalizacao = dataPenalizacao;
	}

	@Override
	public boolean equals(Object obj) {
		Usuario usuario = (Usuario) obj;
		if(usuario.cpf.equals(this.cpf))
			return true;
		else
			return false;
	
	}

	@Override
	public String toString() {
		return this.nome + " - " + this.cpf + " - " + this.endereco + " - " + this.fone;
	}
	
	
	
}
