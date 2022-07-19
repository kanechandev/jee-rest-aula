package rest.exer16;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Telefone {
	private String nome;
	private String telefone;
	
	public Telefone() {
		super();
	}
	public Telefone(String nome, String telefone) {
		super();
		this.nome = nome;
		this.telefone = telefone;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
}
