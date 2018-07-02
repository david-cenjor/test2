package com.mycorp;
import java.text.ParseException;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.xml.ws.Response;

import org.junit.Test;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycorp.support.DatosCliente;

import junit.framework.TestCase;
import util.datos.UsuarioAlta;

public class ZendeskServiceTest extends TestCase {

	@Test
    public void testAltaTicketZendesk() {
		ZendeskService zs = new ZendeskService();
		UsuarioAlta usuarioAlta = new UsuarioAlta();
		String respuesta;
		String[] lineasRespuesta;
		
		zs.ZENDESK_ERROR_MAIL_FUNCIONALIDAD = "234";
        respuesta = zs.altaTicketZendesk(usuarioAlta, "userAgent");
        lineasRespuesta = respuesta.split("\\n");
        assertNotNull(respuesta);
        assertEquals(4, lineasRespuesta.length);
    }

	@Test(expected = ResourceAccessException.class)
    public void testGetDatosCliente() {
		ZendeskService zs = new ZendeskService();
		DatosCliente dc = null;
		
		zs.restTemplate = new RestTemplate();
		//TODO inyectar correctamente restTemplate
		
		dc = zs.getDatosCliente("http://localhost:8080/test-endpoint", DatosCliente.class, "1111");      
		assertNotNull(dc);
    }
	
	@Test
    public void testGetDatosBravoFromDatosCliente() throws ParseException {
		ZendeskService zs = new ZendeskService();
		DatosCliente dc = null;
		StringBuilder datosBravo = null;

		datosBravo = zs.getDatosBravoFromDatosCliente(dc);

        assertNotNull(datosBravo);
    }
	
	@Test
    public void testCrearTicketZendesk() {
		ZendeskService zs = new ZendeskService();
		StringBuilder datosBravo = null;
		ObjectMapper mapper = new ObjectMapper();		
		StringBuilder datosServicio = new StringBuilder(); 
		UsuarioAlta usuarioAlta = new UsuarioAlta();
		StringBuilder datosUsuario = new StringBuilder(); 
		StringBuilder clientName = new StringBuilder();
		
		//TODO insertar datos de prueba para estos objetos
		
		boolean envioCorrecto = false;
		
		zs.crearTicketZendesk(mapper, datosServicio, usuarioAlta, datosUsuario, datosBravo, clientName);

		assertFalse(envioCorrecto);
    }
	
}
