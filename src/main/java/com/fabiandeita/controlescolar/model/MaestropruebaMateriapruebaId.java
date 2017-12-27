package com.fabiandeita.controlescolar.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * MaestropruebaMateriapruebaId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class MaestropruebaMateriapruebaId implements java.io.Serializable {

	// Fields

	private Long maestrosMaestroId;
	private Long materiasMateriaId;

	// Constructors

	/** default constructor */
	public MaestropruebaMateriapruebaId() {
	}

	/** full constructor */
	public MaestropruebaMateriapruebaId(Long maestrosMaestroId, Long materiasMateriaId) {
		this.maestrosMaestroId = maestrosMaestroId;
		this.materiasMateriaId = materiasMateriaId;
	}

	// Property accessors

	@Column(name = "maestros_maestro_id", nullable = false)

	public Long getMaestrosMaestroId() {
		return this.maestrosMaestroId;
	}

	public void setMaestrosMaestroId(Long maestrosMaestroId) {
		this.maestrosMaestroId = maestrosMaestroId;
	}

	@Column(name = "materias_materia_id", nullable = false)

	public Long getMateriasMateriaId() {
		return this.materiasMateriaId;
	}

	public void setMateriasMateriaId(Long materiasMateriaId) {
		this.materiasMateriaId = materiasMateriaId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MaestropruebaMateriapruebaId))
			return false;
		MaestropruebaMateriapruebaId castOther = (MaestropruebaMateriapruebaId) other;

		return ((this.getMaestrosMaestroId() == castOther.getMaestrosMaestroId())
				|| (this.getMaestrosMaestroId() != null && castOther.getMaestrosMaestroId() != null
						&& this.getMaestrosMaestroId().equals(castOther.getMaestrosMaestroId())))
				&& ((this.getMateriasMateriaId() == castOther.getMateriasMateriaId())
						|| (this.getMateriasMateriaId() != null && castOther.getMateriasMateriaId() != null
								&& this.getMateriasMateriaId().equals(castOther.getMateriasMateriaId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getMaestrosMaestroId() == null ? 0 : this.getMaestrosMaestroId().hashCode());
		result = 37 * result + (getMateriasMateriaId() == null ? 0 : this.getMateriasMateriaId().hashCode());
		return result;
	}

}