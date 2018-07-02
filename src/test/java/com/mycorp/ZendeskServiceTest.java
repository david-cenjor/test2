package com.mycorp;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.xml.ws.Response;

import org.junit.Test;

import com.mycorp.support.DatosCliente;

import junit.framework.TestCase;
import util.datos.DatosClientes;
import util.datos.UsuarioAlta;

public class ZendeskServiceTest extends TestCase {

	@Test
    public void testGetDatosCliente() {
		ZendeskService zs = new ZendeskService();
		DatosCliente dc = null;
		boolean hayExcepcion = false;
		try {
			dc = zs.getDatosCliente("http://localhost:8080/test-endpoint", DatosCliente.class, "1111");
		} catch (Exception e) {
			hayExcepcion = true;
		}
		assertFalse(hayExcepcion);
        assertNotNull(dc);
    }
	
}
