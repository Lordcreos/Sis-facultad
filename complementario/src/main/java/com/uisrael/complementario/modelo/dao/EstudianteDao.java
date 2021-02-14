package com.uisrael.complementario.modelo.dao;

import java.util.List;

import com.uisrael.complementario.modelo.entidades.Estudiante;

public interface EstudianteDao {
	public List<Estudiante> listaEstudiantes();
	public void insertarEstudiante(Estudiante estudiante);
	public void actualizarEstudiante(Estudiante estudiante);
	public void borrarEstudiante(Estudiante estudiante);
	public Estudiante getById(int id);
}
