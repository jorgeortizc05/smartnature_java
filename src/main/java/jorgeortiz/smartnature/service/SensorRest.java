package jorgeortiz.smartnature.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import jorgeortiz.smartnature.bussiness.SensorBuss;
import jorgeortiz.smartnature.modelo.Sensor;

@Path("/sensor")
public class SensorRest {

	@Inject
	private SensorBuss senBuss;
	
	@POST
	@Path("/insertar")
	@Consumes("application/json")
	@Produces("application/json")
	public Respuesta insertar(Sensor item) {
		Respuesta respuesta = new Respuesta();
		Response.ResponseBuilder builder = null;
		Map<String, String> data = new HashMap<>();

		try {
			senBuss.guardarSensor(item);
			respuesta.setCodigo(1);
			respuesta.setMensaje("Guardado Satisfactorio");
			data.put("code", "1");
			data.put("message", "OK");
			return respuesta;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			respuesta.setCodigo(99);
			respuesta.setMensaje("Error al guardar");
			data.put("code", "99");
			data.put("message", e.getMessage());
			builder = Response.status(Response.Status.OK).entity(data);
			return respuesta;
		}
	}
	
	@Path("/read")
	@GET
	@Produces("application/json")
	public Sensor getDevice(@QueryParam("id") int id) {
		try {
			return senBuss.buscarSensor(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@Path("/list")
	@GET
	@Produces("application/json")
	public List<Sensor> getSensor() {
		try {
			return senBuss.getSensors();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
