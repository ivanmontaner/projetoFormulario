package br.com.projetoFormulario.domain;

import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;

public class Field {

	private String label;
	private String type;
	private String placeHolder;
	private boolean required;
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPlaceHolder() {
		return placeHolder;
	}
	public void setPlaceHolder(String placeHolder) {
		this.placeHolder = placeHolder;
	}
	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}

	public void validate(Validator validator) {
		validator.checking(new Validations() {{
			that(label != null && label != "", "label", "label.is.required");
			that(type  != null && label != "", "type",  "type.is.required");
		}});
	}
}
