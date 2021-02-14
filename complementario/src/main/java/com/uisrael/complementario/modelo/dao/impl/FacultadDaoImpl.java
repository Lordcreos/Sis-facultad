package com.uisrael.complementario.modelo.dao.impl;

import java.util.List;


import javax.persistence.TypedQuery;
import com.uisrael.complementario.modelo.dao.FacultadDao;
import com.uisrael.complementario.modelo.entidades.Facultad;

public class FacultadDaoImpl extends GenericDaoImpl<Facultad> implements FacultadDao{

	@Override
	public List<Facultad> listaFacultades() {
		TypedQuery<Facultad> tq = this.entityManager.createQuery("SELECT f FROM Facultad f ", Facultad.class);
		return tq.getResultList();
	}

	@Override
	public void insertarFacultad(Facultad facultad) {
		try {
			this.beginTransaction();
			this.create(facultad);
			this.commit();
		} catch (Exception e) {
			this.rollback();
		}
	}

	@Override
	public void actualizarFacultad(Facultad facultad) {
		try {
			this.beginTransaction();
			this.update(facultad);
			this.commit();
		} catch (Exception e) {
			this.rollback();
		}
	}

	@Override
	public void borrarFacultad(Facultad facultad) {
		try {
			this.beginTransaction();
			this.delete(facultad);
			this.commit();
		} catch (Exception e) {
			this.rollback();
		}
	}

	@Override
	public Facultad getById(int id) {
		TypedQuery<Facultad> tq = this.entityManager.createQuery("SELECT f FROM Facultad f WHERE f.id = ?1", Facultad.class);
		tq.setParameter(1, id);
		return tq.getSingleResult();
	}

}
