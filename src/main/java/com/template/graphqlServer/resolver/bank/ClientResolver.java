package com.template.graphqlServer.resolver.bank;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Component;

import com.template.graphqlServer.model.domain.BankAccount;
import com.template.graphqlServer.model.domain.Client;

import graphql.execution.DataFetcherResult;
import graphql.kickstart.execution.error.GenericGraphQLError;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ClientResolver implements GraphQLResolver<BankAccount>{  //Este es un resolver que puede obtener info de fuente diferente pero en este caso implementamos GraphQLResolver
																	  //y por parámetro recibe la clase de la que hará parte la entidad resultante de este resolver, de esta forma le decimos
																	  //a grahpQL que lo que retorne este resolver hará parte integral de otro resolver "padre" el cual es el que se encuentra
																      //como parámetro. 

	//public Client client(BankAccount bankAccount) {                           //Recibe como parámetro el resolver Padre. 
	public CompletableFuture<DataFetcherResult<Client>>  client(BankAccount bankAccount) { //Al declararlo con DataFetcherResult podemos obtener la data y posibles errores para controlarlos. 
		//Al usar CompletableFuture podemos usar Asincronismo para ejecutar las peticiones, esto para los resolvers que no dependen de otros y hacer
		//aún más eficientes las peticiones. 
		
		final ExecutorService executorService = Executors.newFixedThreadPool(
					Runtime.getRuntime().availableProcessors()
				);
		
		log.info("Stop here");
		
		return CompletableFuture.supplyAsync(
				() -> {
					log.info("Requesting client data for bank account id {}", bankAccount.getId());
					return DataFetcherResult.<Client>newResult() //Esta es la forma en la que se construye la entidad DataFetcherResult 
							.data(Client.builder()
								.id(UUID.randomUUID())
								.firstName("Philip")
								.lastName("Starritt")
								.build())
							.error(new GenericGraphQLError("Could not get sub-client id"))
							.build();
				},
				executorService);
		
	}
	
}
