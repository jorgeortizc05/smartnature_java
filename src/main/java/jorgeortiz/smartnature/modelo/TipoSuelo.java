package jorgeortiz.smartnature.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
/*
 * Realizado por: Jorge Luis Ortiz Caceres
 * Fecha Creacion: 29/11/2018
 * Fecha Modificacion: 29/11/2018
 * Modificado por: Jorge Luis Ortiz Caceres
 * Descripcion: Se creo la entidad TipoSuelo
 */

@Entity
@Table(name = "tipo_suelo")
//Entidad Tipo Suelo
public class TipoSuelo implements Serializable {

	private static final long serialVersionUID = 1L;// Por Defecto

	@Id
	@SequenceGenerator(name = "ts_generator", initialValue = 1, allocationSize = 1, sequenceName = "ts_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ts_generator")
	@NotNull
	@Column(name = "id")
	private int id;

	@NotNull
	@NotEmpty
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "densidad")
	private int densidad;

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

	public int getDensidad() {
		return densidad;
	}

	public void setDensidad(int densidad) {
		this.densidad = densidad;
	}
	
	
}
