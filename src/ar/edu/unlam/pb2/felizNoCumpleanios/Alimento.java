package ar.edu.unlam.pb2.felizNoCumpleanios;

abstract class Alimento implements Comparable<Alimento> {
	private String nombre;
	private Double precio;

	public Alimento(String nombre, Double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public abstract void consumir(Persona alicia);

	public Double getPrecio() {
		return precio;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public int compareTo(Alimento otro) {
		// Ordenar por nombre de manera descendente
		return otro.getNombre().compareTo(this.getNombre());

	}
}