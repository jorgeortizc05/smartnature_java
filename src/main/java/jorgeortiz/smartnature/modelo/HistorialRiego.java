package jorgeortiz.smartnature.modelo;

import java.io.Serializable;
import java.util.Date;
/*
 * Realizado por: Jorge Luis Ortiz Caceres
 * Fecha Creacion: 01/02/2019
 * Fecha Modificacion: 
 * Modificado por: Jorge Luis Ortiz Caceres
 * Descripcion: Se creo la entidad Historial
 * DescripcionModificacion: 
 */

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

@Entity
@Table(name = "historial_riego")
public class HistorialRiego implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="hist_generator", initialValue=1, allocationSize = 1,  sequenceName="hist_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "hist_generator")
	@NotNull
	@Column(name = "id")
	private int id;
	
	@Column(name = "fecha")
	private Date fecha = new Date();
	
	@Column(name = "volumen_agua")
	private Double volumenAgua;
	
	@Column(name = "rol")
	private String rol;
	
	@Column(name = "tiempo_riego")
	private int tiempoRiego; //en minutos
	
	@Column(name = "temperatura_ambiente")
	private Double temperaturaAmbiente;
	
	@Column(name = "humedad_suelo")
	private Double humedadSuelo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Plataforma plataforma;
	
	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "plat_id", nullable = false)
	 * 
	 * @JsonIgnore private Plataforma plataforma;
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getVolumenAgua() {
		return volumenAgua;
	}

	public void setVolumenAgua(Double volumenAgua) {
		this.volumenAgua = volumenAgua;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public int getTiempoRiego() {
		return tiempoRiego;
	}

	public void setTiempoRiego(int tiempoRiego) {
		this.tiempoRiego = tiempoRiego;
	}

	public Double getTemperaturaAmbiente() {
		return temperaturaAmbiente;
	}

	public void setTemperaturaAmbiente(Double temperaturaAmbiente) {
		this.temperaturaAmbiente = temperaturaAmbiente;
	}

	public Double getHumedadSuelo() {
		return humedadSuelo;
	}

	public void setHumedadSuelo(Double humedadSuelo) {
		this.humedadSuelo = humedadSuelo;
	}

	public Plataforma getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataforma plataforma) {
		this.plataforma = plataforma;
	}

	
	

}
