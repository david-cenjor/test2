package com.mycorp;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.mycorp.support.DatosCliente;

public class RestTemplateTest extends RestTemplate {

	@Override
	public <T> T getForObject(String url, Class<T> responseType, Object... urlVariables) throws RestClientException {
		DatosCliente dc;
		dc = new DatosCliente();
		dc.setNombre("un nombre");
		dc.setFechaNacimiento("1980/01/01");
		dc.setGenCTipoDocumento(new Integer(1));
		dc.setGenTTipoCliente(new Integer(1));
		return responseType.cast(dc);
	}

}
