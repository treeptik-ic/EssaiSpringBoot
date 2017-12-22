package fr.lamaud;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

public class HelloControllerIT {

	 	@LocalServerPort
	    private int port;

	    private URL base;

	    @Autowired
	    private TestRestTemplate template;

	    @Before
	    public void setUp() throws Exception {
	    	System.out.println(port);
	        this.base = new URL("http://localhost:" + port + "/");
	    }

	    @Test
	    public void getHello() throws Exception {
	        ResponseEntity<String> response = template.getForEntity(base.toString(),
	                String.class);
	        assertThat(response.getBody(), equalTo("Greetings from Spring Boot!"));
	    }
}
