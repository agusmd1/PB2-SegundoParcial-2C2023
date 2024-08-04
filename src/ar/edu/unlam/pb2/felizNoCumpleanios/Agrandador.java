package ar.edu.unlam.pb2.felizNoCumpleanios;

class Agrandador extends Alimento {
	public Agrandador(String nombre, Double precio) {
		super(nombre, precio);
	}

	@Override
	public void consumir(Persona alicia) {
		// Habilidad de hacer crecer a nuestro personaje 40 cms
		if (alicia.getAltura() + 40 <= 280) {
			alicia.setAltura(alicia.getAltura() + 40);
		}
	}
}
