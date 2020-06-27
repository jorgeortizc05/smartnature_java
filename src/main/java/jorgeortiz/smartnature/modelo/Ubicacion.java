package jorgeortiz.smartnature.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "ubicacion")
public class Ubicacion {
	
	@Id
	@SequenceGenerator(name="ub_generator", initialValue=1, allocationSize = 1,  sequenceName="ub_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ub_generator")
	@NotNull
	@Column(name = "id")
	private int id;

	@NotNull
	@NotEmpty
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "descripcion")
	private String descripcion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
