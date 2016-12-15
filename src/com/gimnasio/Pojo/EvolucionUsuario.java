package com.gimnasio.Pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="evolucion_usuario")
public class EvolucionUsuario {
	
	@Id
	@GeneratedValue
	private int id;
	
	private float peso;
	
	@Column(name="porcentaje_grasa")
	private float porcentajeGrasa;
	
	@Column(name="porcentaje_musculo")
	private float porcentajeMusculo;
	
	private float imc;
	
	private Timestamp fecha;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getPorcentajeGrasa() {
		return porcentajeGrasa;
	}

	public void setPorcentajeGrasa(float porcentajeGrasa) {
		this.porcentajeGrasa = porcentajeGrasa;
	}

	public float getPorcentajeMusculo() {
		return porcentajeMusculo;
	}

	public void setPorcentajeMusculo(float porcentajeMusculo) {
		this.porcentajeMusculo = porcentajeMusculo;
	}

	public float getImc() {
		return imc;
	}

	public void setImc(float imc) {
		this.imc = imc;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "EvolucionUsuario [id=" + id + ", peso=" + peso + ", porcentajeGrasa=" + porcentajeGrasa
				+ ", porcentajeMusculo=" + porcentajeMusculo + ", imc=" + imc + ", fecha=" + fecha + ", usuario="
				+ usuario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + id;
		result = prime * result + Float.floatToIntBits(imc);
		result = prime * result + Float.floatToIntBits(peso);
		result = prime * result + Float.floatToIntBits(porcentajeGrasa);
		result = prime * result + Float.floatToIntBits(porcentajeMusculo);
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		EvolucionUsuario other = (EvolucionUsuario) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id != other.id)
			return false;
		if (Float.floatToIntBits(imc) != Float.floatToIntBits(other.imc))
			return false;
		if (Float.floatToIntBits(peso) != Float.floatToIntBits(other.peso))
			return false;
		if (Float.floatToIntBits(porcentajeGrasa) != Float.floatToIntBits(other.porcentajeGrasa))
			return false;
		if (Float.floatToIntBits(porcentajeMusculo) != Float.floatToIntBits(other.porcentajeMusculo))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	
	
}
