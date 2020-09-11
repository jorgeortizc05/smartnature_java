package jorgeortiz.smartnature.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/*
 * Realizado por: Jorge Luis Ortiz Caceres
 * Fecha Creacion: 01/02/2019
 * Fecha Modificacion: 
 * Modificado por: Jorge Luis Ortiz Caceres
 * Descripcion: Se creo la entidad Planta
 * DescripcionModificacion: 
 */
@Entity
@Table(name = "planta")
@NamedQuery(name = "Planta.findAll", query = "SELECT p FROM Planta p")
public class Planta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "plan_generator", initialValue = 1, allocationSize = 1, sequenceName = "plan_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "plan_generator")
	@NotNull
	@Column(name = "id")
	private int id;

	@Column(name = "plan_nombre")
	private String nombre;

	@Column(name = "plan_descripcion")
	private String descripcion;

	@Column(name = "cantidad_agua")
	private Double cantidadAgua;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Plataforma plataforma;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getCantidadAgua() {
		return cantidadAgua;
	}

	public void setCantidadAgua(Double cantidadAgua) {
		this.cantidadAgua = cantidadAgua;
	}

	public Plataforma getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}

}
