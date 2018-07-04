package com.mycorp;

import util.datos.UsuarioAlta;

public class UsuarioAltaTest extends UsuarioAlta {

	@Override
	public String getEmail() {
		return "abc@aaa.com";
	}
	
	@Override
	public String getNumPoliza() {
		return "351365813";
	}
	
	@Override
	public String getNumDocAcreditativo() {
		return "132123";
	}

}
