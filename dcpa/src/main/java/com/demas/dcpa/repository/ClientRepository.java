package com.demas.dcpa.repository;

import com.demas.dcpa.data.entity.Client;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository {

    boolean addClient(Client client);
    boolean updateClient(Client client);
    boolean deleteClient(Client client);

    Optional<Client> findClientByName(String name);
    Optional<Client> findClientById(int id);
    Optional<Client> findClientByEmail(String email);

    List<Client> findAllClients();
    List<Client> findAllClientsByName(String name); //possible search option

}
