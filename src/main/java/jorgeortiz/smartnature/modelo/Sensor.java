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
 * Descripcion: Se creo la entidad Sensores
 * DescripcionModificacion: 
 */

@Entity
@Table(name = "sensor")
public class Sensor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="sen_generator", initialValue=1, allocationSize = 1,  sequenceName="sen_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "sen_generator")
	@NotNull
	@Column(name = "id")
	private int id;
	
	@Column(name = "temp_ambiente")
	private Double tempAmbiente;
	
	@Column(name = "humedad_suelo")
	private Double humedadSuelo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Device device;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getTempAmbiente() {
		return tempAmbiente;
	}

	public void setTempAmbiente(Double tempAmbiente) {
		this.tempAmbiente = tempAmbiente;
	}

	public Double getHumedadSuelo() {
		return humedadSuelo;
	}

	public void setHumedadSuelo(Double humedadSuelo) {
		this.humedadSuelo = humedadSuelo;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}
	
	
}
