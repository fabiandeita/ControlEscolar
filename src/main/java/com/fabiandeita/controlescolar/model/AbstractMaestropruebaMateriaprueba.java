package com.fabiandeita.controlescolar.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;

/**
 * AbstractMaestropruebaMateriaprueba entity provides the base persistence
 * definition of the MaestropruebaMateriaprueba entity. @author MyEclipse
 * Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractMaestropruebaMateriaprueba implements java.io.Serializable {

	// Fields

	private MaestropruebaMateriapruebaId id;

	// Constructors

	/** default constructor */
	public AbstractMaestropruebaMateriaprueba() {
	}

	/** full constructor */
	public AbstractMaestropruebaMateriaprueba(MaestropruebaMateriapruebaId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "maestrosMaestroId", column = @Column(name = "maestros_maestro_id", nullable = false)),
			@AttributeOverride(name = "materiasMateriaId", column = @Column(name = "materias_materia_id", nullable = false)) })

	public MaestropruebaMateriapruebaId getId() {
		return this.id;
	}

	public void setId(MaestropruebaMateriapruebaId id) {
		this.id = id;
	}

        
        
}