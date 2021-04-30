package com.template.graphqlServer.exceptions;

import java.util.List;

import org.springframework.stereotype.Component;

import graphql.GraphQLError;
import graphql.kickstart.execution.error.GraphQLErrorHandler;

@Component
public class CustomGraphQLErrorHandler implements GraphQLErrorHandler{

	@Override
	public List<GraphQLError> processErrors(List<GraphQLError> errors) {
		//Aquí se puede personalizar lo que se envía en el error, o qué mensaje se va a devolver, o simplemente se devuelve todo como en este caso.
		return errors;
	}
	
}
