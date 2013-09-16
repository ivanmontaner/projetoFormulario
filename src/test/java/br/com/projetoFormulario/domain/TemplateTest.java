package br.com.projetoFormulario.domain;

import org.junit.Test;

import junit.framework.Assert;
import br.com.caelum.vraptor.util.test.MockValidator;

public class TemplateTest {

	@Test
	public void tituloDeveSerObrigatorio(){
		MockValidator validator = new MockValidator();
		Template template = new Template();
		
		template.validate(validator);
		
		Assert.assertTrue(validator.hasErrors());
	}
	
	
	
}
