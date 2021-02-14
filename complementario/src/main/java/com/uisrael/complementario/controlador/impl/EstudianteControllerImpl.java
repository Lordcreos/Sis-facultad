package com.uisrael.complementario.controlador.impl;

import java.util.List;

import com.uisrael.complementario.controlador.EstudianteController;
import com.uisrael.complementario.modelo.dao.EstudianteDao;
import com.uisrael.complementario.modelo.dao.impl.EstudianteDaoImpl;
import com.uisrael.complementario.modelo.entidades.Estudiante;

public class EstudianteControllerImpl implements EstudianteController{
	private EstudianteDao estudianteDao;

	@Override
	public List<Estudiante> listaEstudiantes() {
		estudianteDao = new EstudianteDaoImpl();
		return estudianteDao.listaEstudiantes();
	}

	@Override
	public void insertarEstudiante(Estudiante estudiante) {
		estudianteDao = new EstudianteDaoImpl();
		estudianteDao.insertarEstudiante(estudiante);
	}

	@Override
	public void actualizarEstudiante(Estudiante estudiante) {
		estudianteDao = new EstudianteDaoImpl();
		estudianteDao.actualizarEstudiante(estudiante);
	}

	@Override
	public void borrarEstudiante(Estudiante estudiante) {
		estudianteDao = new EstudianteDaoImpl();
		estudianteDao.borrarEstudiante(estudiante);
	}

	@Override
	public Estudiante getById(int id) {
		estudianteDao = new EstudianteDaoImpl();
		return estudianteDao.getById(id);
	}

}
