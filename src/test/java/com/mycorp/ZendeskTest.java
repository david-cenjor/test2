package com.mycorp;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycorp.Zendesk.Builder;
import com.mycorp.support.DatosCliente;
import com.mycorp.support.Ticket;
import com.ning.http.client.AsyncHttpClient;

import junit.framework.TestCase;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:config/applicationContext.xml"})
public class ZendeskTest extends TestCase {
	
	@Test
    public <T> void testHandle() {
		Zendesk zd = new Zendesk.Builder("").build();
		zd.handle(DatosCliente.class, "sdf", DatosCliente.class);
		
        assertTrue( true );
    }
	
	@Test
    public <T> void testCreateMapper() {
		ObjectMapper om = Zendesk.createMapper();
        assertNotNull(om);
    }
	
	@Test
    public <T> void testBuild() {
		Builder builder = new Zendesk.Builder("url");
		builder.setToken("token");
        assertNotNull(builder.build());
        
        builder.setToken(null);
        assertNotNull(builder.build());
    }
	
	@Resource
	ZendeskService zendeskService;
	
	@Test
    public <T> void testCreateTicket() {
		Ticket ticket = new Ticket();
		Builder builder = new Zendesk.Builder("url");
		builder.setUsername("username");
		builder.setToken("token");
		Zendesk zd = builder.build();
		
		ticket = zd.createTicket(ticket);
		assertNotNull(ticket);
    }
	
}
