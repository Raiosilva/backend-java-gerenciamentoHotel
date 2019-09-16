package com.oliveira.raimundo.controller.exception;

import java.util.ArrayList;
import java.util.List;

import com.oliveira.raimundo.controller.exception.FieldMessage;
import com.oliveira.raimundo.controller.exception.StandarError;

public class ValidationError extends StandarError {
	private static final long serialVersionUID = 1L;

	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);

	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message));
	}

}
