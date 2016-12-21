package com.gimnasio.Pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ejercicios_rutina")
public class EjerciciosRutina implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@Min(value=1)
	private int series;
	@NotNull
	@Min(value=1)
	private int repeticiones;
	
	@NotNull
	@Min(value=1)
	private int descanso;
	private int dia;
	private double peso;
	
	@ManyToOne
	@NotNull
	@JoinColumn(name="ejercicio_id")
	private Ejercicio ejercicio;
	
	@ManyToOne
	@JoinColumn(name="rutina_id")
	private Rutina rutina;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSeries() {
		return series;
	}

	public void setSeries(int series) {
		this.series = series;
	}

	public int getRepeticiones() {
		return repeticiones;
	}

	public void setRepeticiones(int repeticiones) {
		this.repeticiones = repeticiones;
	}

	public int getDescanso() {
		return descanso;
	}

	public void setDescanso(int descanso) {
		this.descanso = descanso;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public Ejercicio getEjercicio() {
		return ejercicio;
	}

	public void setEjercicio(Ejercicio ejercicio) {
		this.ejercicio = ejercicio;
	}

	public Rutina getRutina() {
		return rutina;
	}

	public void setRutina(Rutina rutina) {
		this.rutina = rutina;
	}

	@Override
	public String toString() {
		return "EjerciciosRutina [id=" + id + ", series=" + series + ", repeticiones=" + repeticiones + ", descanso="
				+ descanso + ", dia=" + dia + ", peso=" + peso + ", ejercicio=" + ejercicio + ", rutina=" + rutina
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + descanso;
		result = prime * result + dia;
		result = prime * result + ((ejercicio == null) ? 0 : ejercicio.hashCode());
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(peso);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + repeticiones;
		result = prime * result + ((rutina == null) ? 0 : rutina.hashCode());
		result = prime * result + series;
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
		EjerciciosRutina other = (EjerciciosRutina) obj;
		if (descanso != other.descanso)
			return false;
		if (dia != other.dia)
			return false;
		if (ejercicio == null) {
			if (other.ejercicio != null)
				return false;
		} else if (!ejercicio.equals(other.ejercicio))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
			return false;
		if (repeticiones != other.repeticiones)
			return false;
		if (rutina == null) {
			if (other.rutina != null)
				return false;
		} else if (!rutina.equals(other.rutina))
			return false;
		if (series != other.series)
			return false;
		return true;
	}
	
	

}
