package com.mycorp;
import java.text.ParseException;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.xml.ws.Response;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycorp.support.DatosCliente;
import com.mycorp.support.MensajeriaService;

import junit.framework.TestCase;
import util.datos.UsuarioAlta;

public class ZendeskServiceTest extends TestCase {

	private DatosCliente getDatosCliente(){
		ZendeskService zs = new ZendeskService();
		zs.restTemplate = new RestTemplateTest();
		DatosCliente dc = zs.getDatosCliente(null, DatosCliente.class, null);
		return dc;
	}
	
	@Test(expected = ResourceAccessException.class)
    public void testGetDatosCliente() {
		//ZendeskService zs = new ZendeskService();
		//DatosCliente dc = null;
		//zs.restTemplate = new RestTemplateTest();
		//dc = zs.getDatosCliente(null, DatosCliente.class, null);
		DatosCliente dc = this.getDatosCliente();
		assertNotNull(dc);
    }
	
	@Test
    public void testGetDatosBravoFromDatosCliente() throws ParseException {
		StringBuilder datosBravo = null;
		ZendeskService zs = new ZendeskService();
		DatosCliente dc = null;
		
		zs.restTemplate = new RestTemplateTest();
		
		dc = zs.getDatosCliente(null, DatosCliente.class, null);
		datosBravo = zs.getDatosBravoFromDatosCliente(dc);

        assertNotNull(datosBravo);
    }
	
	@Autowired
    @Qualifier( "emailService" )
    MensajeriaService emailService;
	
	@Test
    public void testEnviarCorreoElectronico() {
		ZendeskService zs = new ZendeskService();
		zs.restTemplate = new RestTemplateTest();
		zs.ZENDESK_ERROR_MAIL_FUNCIONALIDAD = "1";
		zs.ZENDESK_ERROR_DESTINATARIO = "error@aaa.com";
		StringBuilder datosUsuario = new StringBuilder();
		StringBuilder datosBravo = new StringBuilder();
		MensajeriaServiceTest emailServiceTest = new MensajeriaServiceTest();
		assertTrue(zs.enviarCorreoElectronico(emailServiceTest, datosUsuario, datosBravo));
	}
	
	/*
	@Test
    public void testCrearTicketZendesk() {
		ZendeskService zs = new ZendeskService();
		zs.restTemplate = new RestTemplateTest();
		
		zs.PETICION_ZENDESK = "PETICION_ZENDESK";
		zs.TOKEN_ZENDESK = "TOKEN_ZENDESK";
		zs.ZENDESK_ERROR_DESTINATARIO = "ZENDESK_ERROR_DESTINATARIO";
		zs.ZENDESK_ERROR_MAIL_FUNCIONALIDAD = "ZENDESK_ERROR_MAIL_FUNCIONALIDAD";
		zs.ZENDESK_USER = "ZENDESK_USER";
		zs.URL_ZENDESK = "URL_ZENDESK";
		
		StringBuilder datosBravo = new StringBuilder("");
		ObjectMapper mapper = new ObjectMapper();		
		StringBuilder datosServicio = new StringBuilder(); 
		UsuarioAlta usuarioAlta = new UsuarioAltaTest();
		StringBuilder datosUsuario = new StringBuilder(); 
		StringBuilder clientName = new StringBuilder("Nombreprueba");
		
		//TODO insertar datos de prueba para estos objetos
		
		boolean envioCorrecto = false;
		zs.crearTicketZendesk(mapper, datosServicio, usuarioAlta, datosUsuario, datosBravo, clientName);
		assertFalse(envioCorrecto);
    }
	*/
	
	
	@Test
    public void testGetPoliza() {
		ZendeskService zs = new ZendeskService();
		zs.restTemplate = new RestTemplateTest();
		UsuarioAlta usuarioAlta = new UsuarioAltaTest();
		assertNotNull(zs.getPoliza(usuarioAlta));
	}
}
