package com.template.graphqlServer.model.domain;

import java.util.List;
import java.util.UUID;

import lombok.Builder;
import lombok.Setter;

@Setter
@Builder
public class Client {
	UUID id;
	String firstName;
	List<String> middleNames;
	String lastName;
	Client client;
}
