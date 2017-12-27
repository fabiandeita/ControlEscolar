package com.fabiandeita.controlescolar.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * MaestropruebaMateriaprueba entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "maestroprueba_materiaprueba", catalog = "everis_escolar")
public class MaestropruebaMateriaprueba extends AbstractMaestropruebaMateriaprueba implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public MaestropruebaMateriaprueba() {
	}

	/** full constructor */
	public MaestropruebaMateriaprueba(MaestropruebaMateriapruebaId id) {
		super(id);
	}

}
