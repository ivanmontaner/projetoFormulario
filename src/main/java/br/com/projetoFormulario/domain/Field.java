package br.com.projetoFormulario.domain;

import java.util.List;

import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;

public class Field {

	private String label;
	private String type;
	private String placeHolder;
	private boolean required;
	private List<Radio> radios;
	private int maxLength;
	
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
	public List<Radio> getRadios() {
		return radios;
	}
	public void setRadios(List<Radio> radios) {
		this.radios = radios;
	}

	public void validate(Validator validator) {
		validator.checking(new Validations() {{
			that(label != null && label != "", "label", "label.is.required");
			that(type  != null && type  != "", "type",  "type.is.required");
			
			if (type != null && type.equals("radio")) {
				that(radios != null && radios.size() > 0, "radios", "radio.size.lower.than.one");
			}
		}});
	}
	public int getMaxLength() {
		return maxLength;
	}
	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}
}