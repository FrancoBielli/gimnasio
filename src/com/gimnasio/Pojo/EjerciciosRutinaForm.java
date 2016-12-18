package com.gimnasio.Pojo;

import java.util.List;

import com.gimnasio.Pojo.EjerciciosRutina;

public class EjerciciosRutinaForm {

	private List<EjerciciosRutina> ejerciciosRutina;

	public List<EjerciciosRutina> getEjerciciosRutina() {
		return ejerciciosRutina;
	}

	public void setEjerciciosRutina(List<EjerciciosRutina> ejerciciosRutina) {
		this.ejerciciosRutina = ejerciciosRutina;
	}

	@Override
	public String toString() {
		return "EjerciciosRutinaForm [ejerciciosRutina=" + ejerciciosRutina + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ejerciciosRutina == null) ? 0 : ejerciciosRutina.hashCode());
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
		EjerciciosRutinaForm other = (EjerciciosRutinaForm) obj;
		if (ejerciciosRutina == null) {
			if (other.ejerciciosRutina != null)
				return false;
		} else if (!ejerciciosRutina.equals(other.ejerciciosRutina))
			return false;
		return true;
	}
	

}