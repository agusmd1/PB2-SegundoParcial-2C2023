package ar.edu.unlam.pb2.felizNoCumpleanios;

public class SinAlimentosDisponiblesException extends Exception {
	private static final long serialVersionUID = 1L;

	public SinAlimentosDisponiblesException(String mensaje) {
		super(mensaje);
	}
}
