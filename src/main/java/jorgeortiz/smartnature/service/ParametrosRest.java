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

import jorgeortiz.smartnature.bussiness.DeviceBuss;
import jorgeortiz.smartnature.bussiness.ParametrosBuss;
import jorgeortiz.smartnature.modelo.Device;
import jorgeortiz.smartnature.modelo.Parametros;

@Path("/parametro")
public class ParametrosRest {

	@Inject
	private ParametrosBuss paramBuss;
	
	
	@Path("/last")
	@GET
	@Produces("application/json")
	public Parametros getLastParametro() {
		try {
			return paramBuss.getLastParametro();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
