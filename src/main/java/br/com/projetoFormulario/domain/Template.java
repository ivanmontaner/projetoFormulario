package br.com.projetoFormulario.domain;

import java.util.List;

import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;

public class Template {

	private String id;
	private String title;
	private List<Field> fields;
	
	public List<Field> getFields() {
		return fields;
	}
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public void validate(Validator validator) {
		validator.checking(new Validations() {{
			that(title != null && title != "", "title", "title.is.required");
		}});
	}
}