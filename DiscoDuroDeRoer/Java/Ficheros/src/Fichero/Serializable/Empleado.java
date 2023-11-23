package Fichero.Serializable;

import java.io.Serializable;

public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L; 

	private String nombre;
	private String apellido;
	private int edad;
	private double salario;

	public Empleado(String nombre, String apellido, int edad, double salario) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.salario = salario;
	}

	public Empleado(String nombre, String apellido, int edad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}

	public Empleado(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Empleado(String nombre) {
		this.nombre = nombre;
	}

	public Empleado() {
	}

	// Getters & Setters

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}
