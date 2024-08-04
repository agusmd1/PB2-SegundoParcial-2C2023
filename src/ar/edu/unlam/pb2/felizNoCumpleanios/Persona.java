package ar.edu.unlam.pb2.felizNoCumpleanios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Persona {

	private String nombre;
	private Integer edad;
	private Double altura;
	private Double peso;
	private Double dineroDisponibleParaComprar;
	private ArrayList<Alimento> alimentosDisponibles = new ArrayList<>();

	public Persona(String nombre, Integer edad, Double altura, Double peso, Double dineroDisponibleParaComprar) {
		this.nombre = nombre;
		this.edad = edad;
		this.altura = altura;
		this.peso = peso;
		this.dineroDisponibleParaComprar = dineroDisponibleParaComprar;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getDineroDisponibleParaComprar() {
		return dineroDisponibleParaComprar;
	}

	public void setDineroDisponibleParaComprar(double dineroDisponibleParaComprar) {
		this.dineroDisponibleParaComprar = dineroDisponibleParaComprar;
	}

	public void comprarAlimento(Alimento alimento) throws DineroInsuficienteException {
		if (dineroDisponibleParaComprar >= alimento.getPrecio()) {
			dineroDisponibleParaComprar -= alimento.getPrecio();
			alimentosDisponibles.add(alimento);
			ordenarAlimentosPorNombreDescendente();
		} else {
			throw new DineroInsuficienteException("No hay suficiente dinero para comprar el alimento.");
		}
	}

	public void consumirAlimento(Alimento alimento) throws SinAlimentosDisponiblesException {
		if (alimentosDisponibles.isEmpty()) {
			throw new SinAlimentosDisponiblesException("No hay alimentos disponibles para consumir.");
		}

		if (alimentosDisponibles.contains(alimento)) {
			alimento.consumir(this);
			alimentosDisponibles.remove(alimento);
		} else {
			throw new SinAlimentosDisponiblesException("El alimento no está disponible para consumir.");
		}
	}

	public ArrayList<Alimento> getAlimentosDisponibles() {
		return alimentosDisponibles;
	}

	private void ordenarAlimentosPorNombreDescendente() {
		Collections.sort(alimentosDisponibles, Comparator.comparing(Alimento::getNombre).reversed());
	}

}
