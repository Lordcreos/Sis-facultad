package com.uisrael.complementario.vista;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.uisrael.complementario.controlador.EstudianteController;
import com.uisrael.complementario.controlador.FacultadController;
import com.uisrael.complementario.controlador.impl.EstudianteControllerImpl;
import com.uisrael.complementario.controlador.impl.FacultadControllerImpl;
import com.uisrael.complementario.modelo.entidades.Estudiante;
import com.uisrael.complementario.modelo.entidades.Facultad;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class FacultadVista implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private FacultadController facultadController;
	private EstudianteController estudianteController;
	private Facultad facultad;
	private Estudiante estudiante;
	private List<Facultad> listaFacultades;
	private List<Estudiante> listaEstudiantes;
	
	@PostConstruct
	public void init() {
		facultadController = new FacultadControllerImpl();
		estudianteController = new EstudianteControllerImpl();
		facultad = new Facultad();
		estudiante = new Estudiante();
		listaFacultades = new ArrayList<Facultad>();
		listaEstudiantes = new ArrayList<Estudiante>();
		listarFacultades();
		listarEstudiantes();
	}
	
	public void listarFacultades(){
		listaFacultades = facultadController.listaFacultades();
	}
	
	public void listarEstudiantes() {
		listaEstudiantes = estudianteController.listaEstudiantes();
	}
	
	public void insertarFacultad(){
		String mensaje = "";
		
		try {
			if(facultad.getId() <= 0) {
				facultadController.insertarFacultad(facultad);
				estudiante.setFkFacultad(facultad);
				estudianteController.actualizarEstudiante(estudiante);
				mensaje = "Facultad creada correctamente";
			}else {
				facultadController.actualizarFacultad(facultad);
				mensaje = "Usuario actualizado correctamente";
			}
			listarFacultades();
			limpiar();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "info", mensaje));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", "Oh no!, se ha producido un error"));
		}
	}
	
	public void borrarFacultad(int id){
		try {
			Facultad facultadActual = new Facultad();
			facultadActual.setId(id);
			facultadController.borrarFacultad(facultadActual);
			listarFacultades();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "info", "Facultad eliminada correctamente"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", "No se puede eliminar, por la clave foranea en estudiantes"));
		}
	}	
	
	public void cargarFacultad(int id){
		Facultad facultadDb = facultadController.getById(id);
		facultad.setId(facultadDb.getId());
		facultad.setNombre(facultadDb.getNombre());
		facultad.setDireccion(facultadDb.getDireccion());
		facultad.setTelefono(facultadDb.getTelefono());
		facultad.setEstado(facultadDb.isEstado());
	}
	
	public void limpiar() {
		facultad.setId(0);
		facultad.setNombre(null);
		facultad.setDireccion(null);
		facultad.setTelefono(null);
		facultad.setEstado(true);
		estudiante.setId(0);
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public List<Facultad> getListaFacultades() {
		return listaFacultades;
	}

	public void setListaFacultades(List<Facultad> listaFacultades) {
		this.listaFacultades = listaFacultades;
	}

	public List<Estudiante> getListaEstudiantes() {
		return listaEstudiantes;
	}

	public void setListaEstudiantes(List<Estudiante> listaEstudiantes) {
		this.listaEstudiantes = listaEstudiantes;
	}
	
	
	
}
