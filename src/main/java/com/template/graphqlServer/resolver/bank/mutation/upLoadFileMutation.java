package com.template.graphqlServer.resolver.bank.mutation;

import java.util.UUID;

import org.springframework.stereotype.Component;

import graphql.kickstart.servlet.context.DefaultGraphQLServletContext;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class upLoadFileMutation implements GraphQLMutationResolver{
	
	public UUID uploadFile(DataFetchingEnvironment environment) {
		log.info("Uploading file");
		
		DefaultGraphQLServletContext context = environment.getContext();
		
		context.getFileParts().forEach(
					part -> log.info("uploading: {}, size {}", part.getSubmittedFileName(), part.getSize())
				);
		
		return UUID.randomUUID();
		
	}
}
