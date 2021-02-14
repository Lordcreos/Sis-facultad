package com.uisrael.complementario.modelo.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import com.uisrael.complementario.modelo.dao.EstudianteDao;
import com.uisrael.complementario.modelo.entidades.Estudiante;

public class EstudianteDaoImpl extends GenericDaoImpl<Estudiante> implements EstudianteDao{

	@Override
	public List<Estudiante> listaEstudiantes() {
		TypedQuery<Estudiante> tq = this.entityManager.createQuery("SELECT e FROM Estudiante e ", Estudiante.class);
		return tq.getResultList();
	}

	@Override
	public void insertarEstudiante(Estudiante estudiante) {
		try {
			this.beginTransaction();
			this.create(estudiante);
			this.commit();
		} catch (Exception e) {
			this.rollback();
		}
	}

	@Override
	public void actualizarEstudiante(Estudiante estudiante) {
		try {
			this.beginTransaction();
			this.update(estudiante);
			this.commit();
		} catch (Exception e) {
			this.rollback();
		}
	}

	@Override
	public void borrarEstudiante(Estudiante estudiante) {
		try {
			this.beginTransaction();
			this.delete(estudiante);
			this.commit();
		} catch (Exception e) {
			this.rollback();
		}
	}

	@Override
	public Estudiante getById(int id) {
		TypedQuery<Estudiante> tq = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.id = ?1", Estudiante.class);
		tq.setParameter(1, id);
		return tq.getSingleResult();
	}

}
