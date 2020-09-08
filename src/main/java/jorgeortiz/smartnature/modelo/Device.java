package jorgeortiz.smartnature.modelo;

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

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "device")
public class Device {

	@Id
	@SequenceGenerator(name="dev_generator", initialValue=1, allocationSize = 1,  sequenceName="dev_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "dev_generator")
	@NotNull
	@Column(name = "id")
	private int id;
	
	@NotEmpty
	@NotNull
	@Column(name = "nombre")
	@Size(min = 5, max = 100)
	private String nombre;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Plataforma plataforma;
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	private Ubicacion ubicacion;*/

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

	public Plataforma getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}
	
}
