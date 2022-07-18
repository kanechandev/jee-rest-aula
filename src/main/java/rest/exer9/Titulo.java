package rest.exer9;

import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Titulo {

	private String sacado;
	private double valor;
	
	public Titulo() {
		
	}
	
	public Titulo(String sacado, double valor) {
		super();
		this.sacado = sacado;
		this.valor = valor;
	}
	
	public void validar() throws NegocioException{
		String erros = "";
		if(sacado == null) {
			erros+="Sacado é obrigatório";
		}
		if(valor == 0) {
			erros+="Valor é obrigatório";
		}
		if(!erros.isEmpty()) {
			throw new NegocioException(erros);
		}
	}

	public String getSacado() {
		return sacado;
	}

	public void setSacado(String sacado) {
		this.sacado = sacado;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Titulo [sacado=" + sacado + ", valor=" + valor + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(sacado, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Titulo other = (Titulo) obj;
		return Objects.equals(sacado, other.sacado) && Objects.equals(valor, other.valor);
	}
	
}
