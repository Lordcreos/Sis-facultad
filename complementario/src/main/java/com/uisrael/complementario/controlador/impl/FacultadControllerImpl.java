package com.uisrael.complementario.controlador.impl;

import java.util.List;

import com.uisrael.complementario.controlador.FacultadController;
import com.uisrael.complementario.modelo.dao.FacultadDao;
import com.uisrael.complementario.modelo.dao.impl.FacultadDaoImpl;
import com.uisrael.complementario.modelo.entidades.Facultad;

public class FacultadControllerImpl implements FacultadController{
	
	private FacultadDao facultadDao; 

	@Override
	public List<Facultad> listaFacultades() {
		facultadDao = new FacultadDaoImpl();
		return facultadDao.listaFacultades();
	}

	@Override
	public void insertarFacultad(Facultad facultad) {
		facultadDao = new FacultadDaoImpl();
		facultadDao.insertarFacultad(facultad);
	}

	@Override
	public void actualizarFacultad(Facultad facultad) {
		facultadDao = new FacultadDaoImpl();
		facultadDao.actualizarFacultad(facultad);
	}

	@Override
	public void borrarFacultad(Facultad facultad) {
		facultadDao = new FacultadDaoImpl();
		facultadDao.borrarFacultad(facultad);
	}

	@Override
	public Facultad getById(int id) {
		facultadDao = new FacultadDaoImpl();
		return facultadDao.getById(id);
	}

}
