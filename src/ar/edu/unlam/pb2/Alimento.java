package ar.edu.unlam.pb2;

public class Alimento {
	
	private Double precio;
	private String nombre;

	public Alimento(Double precio, String nombre) {
		this.precio = precio;
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
