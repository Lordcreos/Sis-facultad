package com.uisrael.complementario.controlador;

import java.util.List;

import com.uisrael.complementario.modelo.entidades.Facultad;

public interface FacultadController {
	public List<Facultad> listaFacultades();
	public void insertarFacultad(Facultad facultad);
	public void actualizarFacultad(Facultad facultad);
	public void borrarFacultad(Facultad facultad);
	public Facultad getById(int id);
}
