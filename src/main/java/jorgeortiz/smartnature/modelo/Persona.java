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
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/*
 * Realizado por: Jorge Luis Ortiz Caceres
 * Fecha Creacion: 29/11/2018
 * Fecha Modificacion: 01/02/2019
 * Modificado por: Jorge Luis Ortiz Caceres
 * Descripcion: Se creo la entidad persona
 * DescripcionModificacion: Se reestructuro los atributos segun las necesidades
 */

@Entity
@Table(name = "persona")
//Para el mantenimiento de la persona
public class Persona implements Serializable{
	private static final long serialVersionUID = 1L;//Por defecto

	@Id
	@SequenceGenerator(name="per_generator", initialValue=1, allocationSize = 1,  sequenceName="per_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "per_generator")
	@NotNull
	@Column(name = "id")
	private int id;
	
	@NotNull
	@NotEmpty
	@Size(min = 4, max = 200)
	@Column(name = "nombre")
	private String nombre;
	
	@NotNull
	@NotEmpty
	@Size(min = 4, max = 200)
	@Column(name = "apellido")
	private String apellido;

	@Email
	@Column(name = "email")
	@NotNull
	@NotEmpty(message = "Es obligatorio")
	private String email;
	
	@Column(name = "telefono")
	private String telefono;
	
	//@NotEmpty
	//@Size(min = 4, max = 15)
	@Column(name = "pass")
	private String pass;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Ubicacion ubicacion;

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	

}
