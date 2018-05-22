package com.alz.jee.customer.rest;

import java.util.List;

import javax.validation.ValidationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.api.validation.ResteasyConstraintViolation;
import org.jboss.resteasy.api.validation.ResteasyViolationException;

import com.alz.jee.common.ErrorObject;

@Provider
public class MyValidationExpHandler implements ExceptionMapper<ValidationException> {

	@Override
	public Response toResponse(ValidationException exception) {
		if (exception instanceof ResteasyViolationException) {
			ResteasyViolationException rve = (ResteasyViolationException) exception;
			List<ResteasyConstraintViolation> violations = rve.getViolations();
			StringBuilder sBuilder = new StringBuilder();
			for (ResteasyConstraintViolation resteasyConstraintViolation : violations) {
				sBuilder.append(resteasyConstraintViolation.getMessage());
				sBuilder.append(" ");
			}
			return Response.status(Status.BAD_REQUEST)
		               .entity(new ErrorObject().setErrorCause(303)
		                                        .setErrorMessage(sBuilder.toString()))
		               .build();
		}
		return Response.status(Status.BAD_REQUEST)
		               .entity(new ErrorObject().setErrorCause(303)
		                                        .setErrorMessage(exception.getMessage()))
		               .build();
	}

}
