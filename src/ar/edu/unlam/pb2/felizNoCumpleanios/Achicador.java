package ar.edu.unlam.pb2.felizNoCumpleanios;

class Achicador extends Alimento {
	public Achicador(String nombre, Double precio) {
		super(nombre, precio);
	}

	@Override
	public void consumir(Persona alicia) {
		// deberia hacer que la altura-50 sea mayor a 50 para poder achicarse
		if (alicia.getAltura() - 50 >= 50) {
			alicia.setAltura(alicia.getAltura() - 50);
		}
	}

}
