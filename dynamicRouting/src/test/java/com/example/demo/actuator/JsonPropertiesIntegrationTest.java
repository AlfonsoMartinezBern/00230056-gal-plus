package com.example.demo.actuator;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConfigPropertiesDemoApplication.class, 
initializers = JsonPropertyContextInitializer.class)
public class JsonPropertiesIntegrationTest {
	//Pruebas de integración

	@Autowired
	private JsonProperties jsonProperties;

	@Autowired
	private CustomJsonProperties customJsonProperties;

	@Test
	public void whenPropertiesLoadedViaJsonPropertySource_thenLoadFlatValues() {
		assertEquals("mailer@mail.com", jsonProperties.getHost());
		assertEquals(9090, jsonProperties.getPort());
		assertTrue(jsonProperties.isResend());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void whenPropertiesLoadedViaJsonPropertySource_thenLoadListValues() {
		//Prueba la vinculación de valores de lista
		assertThat(jsonProperties.getTopics(), Matchers.is(Arrays.asList("spring", "boot")));
	}
	
	@Test
	public void whenPropertiesLoadedViaJsonPropertySource_thenNestedLoadedAsMap() {
		//Prueba de acceso a los datos anidados a través del mapa
	    assertEquals("sender", jsonProperties.getSender().get("name"));
	    assertEquals("street", jsonProperties.getSender().get("address"));
	}
	
	@Test
	public void whenLoadedIntoEnvironment_thenFlatValuesPopulated() {
		//Prueba el enlace de datos desde el espacio de nombres personalizado
	    assertEquals("mailer@mail.com", customJsonProperties.getHost());
	    assertEquals(9090, customJsonProperties.getPort());
	    assertTrue(customJsonProperties.isResend());
	}
	
	@Test
	public void whenLoadedIntoEnvironment_thenValuesLoadedIntoClassObject() {
	    assertNotNull(customJsonProperties.getSender());
	    assertEquals("sender", customJsonProperties.getSender()
	      .getName());
	    assertEquals("street", customJsonProperties.getSender()
	      .getAddress());
	}
}
