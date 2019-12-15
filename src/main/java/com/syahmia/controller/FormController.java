package com.syahmia.controller;

import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syahmia.model.FormJsonResponseModel;
import com.syahmia.model.Form;

@Controller
public class FormController {

	@GetMapping("/")
	public String submitForm() {
		
		return "submitForm";
	}
	
	@PostMapping(value="/saveProcess", produces= {MediaType.APPLICATION_JSON_VALUE} )
	@ResponseBody 
	public FormJsonResponseModel saveProcess (@ModelAttribute @Valid Form formModel, BindingResult result) {
		
		FormJsonResponseModel response = new FormJsonResponseModel();
		if(result.hasErrors()) {
			//Get error msg
			
			Map<String, String> errors = result.getFieldErrors().stream()
		               .collect(
		                     Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)
		                 );
			
			response.setValidated(false);
			response.setErrorMessage(errors);
			
		}else {
			
			response.setValidated(true);
			response.setFormModel(formModel);
			
		}
		String one = response.getFormModel().getName();
		String two = response.getFormModel().getAge();
		Boolean val = response.isValidated();
		System.out.println("Name = "+one+" Age="+two+" Validate="+val);
		
		return response;
	}
	
}
