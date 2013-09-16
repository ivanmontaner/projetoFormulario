package br.com.projetoFormulario.domain;

import junit.framework.Assert;

import org.junit.Test;

import br.com.caelum.vraptor.util.test.MockValidator;

public class FieldTest {

	@Test
	public void labelDeveSerObrigatorio(){
		MockValidator validator = new MockValidator();
		Field field = newField();
	
		field.setLabel(null);
		
		field.validate(validator);
		
		Assert.assertTrue(validator.hasErrors());
	}
	
	@Test
	public void tipoDeveSerObrigatorio(){
		MockValidator validator = new MockValidator();
		Field field = newField();
		
		field.setType(null);
		
		field.validate(validator);
		
		Assert.assertTrue(validator.hasErrors());
	}
	
	@Test
	public void quandoTipoCampoRadioDeveTerPeloMenosUmRadio(){
		MockValidator validator = new MockValidator();
		Field field = newField();
		
		field.setType("radio");
		field.setRadios(null);
		
		field.validate(validator);
		
		Assert.assertTrue(validator.hasErrors());
	}
	
	private Field newField() {
		Field field = new Field();
		field.setLabel("Nome");
		field.setType("text");
		return field;
	}
}
