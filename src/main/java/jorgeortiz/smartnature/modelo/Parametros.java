package jorgeortiz.smartnature.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "parametro")
//Para el mantenimiento de la persona
public class Parametros implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	
	@NotNull
	@Range(min=0, max=1)
	private Integer estado = 0; //0 desactivado 1 activado

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	

	
	
}
