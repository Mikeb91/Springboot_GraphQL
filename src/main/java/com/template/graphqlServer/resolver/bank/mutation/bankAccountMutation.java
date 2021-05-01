package com.template.graphqlServer.resolver.bank.mutation;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.template.graphqlServer.model.domain.BankAccount;
import com.template.graphqlServer.model.domain.Currency;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class bankAccountMutation implements GraphQLMutationResolver {

	public BankAccount createBankAccount(CreateBankAccountInput input) { // this is how we can send info to server. 
		log.info("Creating bank account for {}", input); 

		return BankAccount
				.builder()
				.id(UUID.randomUUID())
				.currency(Currency.USD)
				.build();
	}

}
