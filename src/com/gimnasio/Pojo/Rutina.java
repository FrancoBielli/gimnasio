package com.gimnasio.Pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="rutina")
public class Rutina {

	@Id
	@GeneratedValue
	private int id;
	@NotNull
	@Min(value=1)
	private int semanas;
	@NotNull
	@Min(value=1)
	@Max(value=5)
	private int dias;
	@NotNull
	@Min(value=4)
	@Max(value=10)
	@Column(name="ejercicios_por_dia")
	private int ejerciciosPorDia;
	@NotNull
	@NotEmpty
	private String nombre;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSemanas() {
		return semanas;
	}
	public void setSemanas(int semanas) {
		this.semanas = semanas;
	}
	public int getDias() {
		return dias;
	}
	public void setDias(int dias) {
		this.dias = dias;
	}
	public int getEjerciciosPorDia() {
		return ejerciciosPorDia;
	}
	public void setEjerciciosPorDia(int ejerciciosPorDia) {
		this.ejerciciosPorDia = ejerciciosPorDia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Rutina [id=" + id + ", semanas=" + semanas + ", dias=" + dias + ", ejerciciosPorDia=" + ejerciciosPorDia
				+ ", nombre=" + nombre + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dias;
		result = prime * result + ejerciciosPorDia;
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + semanas;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rutina other = (Rutina) obj;
		if (dias != other.dias)
			return false;
		if (ejerciciosPorDia != other.ejerciciosPorDia)
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (semanas != other.semanas)
			return false;
		return true;
	}

	
	
}
