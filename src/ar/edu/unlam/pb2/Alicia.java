package ar.edu.unlam.pb2;

public class Alicia {
	
	private Double altura;
	private Double peso;
	private String nombre;
	private Integer edad;
	private Double dineroParaComprar;
	
	
	public Alicia(Double altura, Double peso, String nombre, Integer edad, Double dineroParaComprar) {
		this.altura = altura;
		this.peso = peso;
		this.nombre = nombre;
		this.edad = edad;
		this.dineroParaComprar = dineroParaComprar;
	}


	public Double getAltura() {
		return altura;
	}


	public void setAltura(Double altura) {
		this.altura = altura;
	}


	public Double getPeso() {
		return peso;
	}


	public void setPeso(Double peso) {
		this.peso = peso;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getEdad() {
		return edad;
	}


	public void setEdad(Integer edad) {
		this.edad = edad;
	}


	public Double getDineroParaComprar() {
		return dineroParaComprar;
	}


	public void setDineroParaComprar(Double dineroParaComprar) {
		this.dineroParaComprar = dineroParaComprar;
	}
	
	
	
	
}
