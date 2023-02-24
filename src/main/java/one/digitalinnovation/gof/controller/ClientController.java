package one.digitalinnovation.gof.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.gof.model.Client;
import one.digitalinnovation.gof.service.ClientService;

@RestController
@RequestMapping("clients")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping
	public ResponseEntity<Iterable<Client>> listClients() {
		return ResponseEntity.ok(clientService.listClients());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Client> retrieveClient(@PathVariable Long id) {
		return ResponseEntity.ok(clientService.retrieveClient(id));
	}

	@PostMapping
	public ResponseEntity<Client> createClient(@RequestBody Client client) {
		clientService.createClient(client);
		return ResponseEntity.ok(client);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
		clientService.updateClient(id, client);
		return ResponseEntity.ok(client);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
		clientService.deleteClient(id);
		return ResponseEntity.ok().build();
	}
}
