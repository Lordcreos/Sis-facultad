package com.uisrael.complementario.controlador;

import java.util.List;

import com.uisrael.complementario.modelo.entidades.Estudiante;

public interface EstudianteController {
	public List<Estudiante> listaEstudiantes();
	public void insertarEstudiante(Estudiante estudiante);
	public void actualizarEstudiante(Estudiante estudiante);
	public void borrarEstudiante(Estudiante estudiante);
	public Estudiante getById(int id);
}
