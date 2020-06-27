package jorgeortiz.smartnature.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

/*
 * Realizado por: Jorge Luis Ortiz Caceres
 * Fecha Creacion: 01/02/2019
 * Fecha Modificacion: 
 * Modificado por: Jorge Luis Ortiz Caceres
 * Descripcion: Se creo la entidad Plataforma
 * DescripcionModificacion: 
 */
@Entity
@Table(name = "plataforma")
public class Plataforma implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "plat_generator", initialValue = 1, allocationSize = 1, sequenceName = "plat_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "plat_generator")
	@NotNull
	@Column(name = "plat_id")
	private int id;

	@Column(name = "plat_nombre")
	private String nombre;

	@Column(name = "plat_descripcion")
	private String descripcion;

	@Column(name = "serial")
	private String serial;

	@ManyToOne(fetch = FetchType.LAZY)
	private TipoSuelo tipoSuelo;

	

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

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public TipoSuelo getTipoSuelo() {
		return tipoSuelo;
	}

	public void setTipoSuelo(TipoSuelo tipoSuelo) {
		this.tipoSuelo = tipoSuelo;
	}

}
