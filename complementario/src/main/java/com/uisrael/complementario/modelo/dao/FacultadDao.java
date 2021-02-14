package com.uisrael.complementario.modelo.dao;

import java.util.List;

import com.uisrael.complementario.modelo.entidades.Facultad;

public interface FacultadDao {
	public List<Facultad> listaFacultades();
	public void insertarFacultad(Facultad facultad);
	public void actualizarFacultad(Facultad facultad);
	public void borrarFacultad(Facultad facultad);
	public Facultad getById(int id);
}
