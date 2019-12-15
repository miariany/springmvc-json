package com.syahmia.model;
import java.util.Map;

/*
  For exposing the mode data in JSON format to view using the @ResponseBody annotation
*/
public class FormJsonResponseModel {

	private Form formModel;
	private boolean validated;
	private Map<String , String> errorMessage;
	
	
	public Form getFormModel() {
		return formModel;
	}
	public void setFormModel(Form formModel) {
		this.formModel = formModel;
	}
	public boolean isValidated() {
		return validated;
	}
	public void setValidated(boolean validated) {
		this.validated = validated;
	}
	public Map<String, String> getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(Map<String, String> errorMessage) {
		this.errorMessage = errorMessage;
	}
}
