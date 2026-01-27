package com.demas.dcpa.service;

import com.demas.dcpa.data.entity.Client;
import com.demas.dcpa.repository.ClientRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    public ClientService(ClientRepository clientRepository, PasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<Client> findClientByEmail(String email) {
        return clientRepository.findClientByEmail(email);
    }

    public Client findClientByName(String name) {
        Optional<Client> clientOpt = clientRepository.findClientByName(name);
        if (clientOpt.isPresent()) {
            return clientOpt.get();
        } else {
            throw new RuntimeException("Client not found");
        }
    }

    public Optional<Client> findClientById(int id) {
        return clientRepository.findClientById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public List<Client> findAllClients() {
        return clientRepository.findAllClients();
    }



    public boolean addClient(Client client) { //TODO: Implement client creation
        return clientRepository.addClient(client);
    }

    //TODO: IMPLEMENT SECURITY AKA ONLY THE SPECIFIC CLIENT CAN UPDATE/DELETE THIS
    public boolean updateClient(Client client) { //TODO: Implement client update
        return clientRepository.updateClient(client);
    }

    public boolean deleteClient(Client client) {
        return clientRepository.deleteClient(client);
    }

}
