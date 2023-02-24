package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Client;

public interface ClientService {

	Iterable<Client> listClients();

	Client retrieveClient(Long id);

	void createClient(Client client);

	void updateClient(Long id, Client client);

	void deleteClient(Long id);

}
