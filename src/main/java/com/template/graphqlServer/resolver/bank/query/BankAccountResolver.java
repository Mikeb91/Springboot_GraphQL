package com.template.graphqlServer.resolver.bank.query;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.template.graphqlServer.model.domain.BankAccount;
import com.template.graphqlServer.model.domain.Currency;

import graphql.GraphQLException;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BankAccountResolver implements GraphQLQueryResolver {

	public BankAccount bankAccount(UUID id) {
		log.info("Retrieving bank account id: {}", id);

//		Client clientA = Client.builder().id(UUID.randomUUID()).firstName("Philip").lastName("Starritt").build();
//		Client clientB = Client.builder().id(UUID.randomUUID()).firstName("Philip2").lastName("Starritt2").build();
//
//		clientA.setClient(clientB); //recusividad - Si se usa, debemos tener cuidado con los ataques de negación de servicio. 
//		clientB.setClient(clientA); // por esta razón se debería definir en la configuración de GraphQL la profunidad permitida máxima. 
									// max-query-depth: 5 - En esta caso por ejemplo, esta propiedad en .yml solo admite 5 niveles. 
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		return BankAccount
				.builder()
				.id(id)
				.currency(Currency.USD)
				.build();
		
//		throw new GraphQLException("GraphQL: Client Unavailable"); - With this we can test the Exception Handler. 

	}

}
