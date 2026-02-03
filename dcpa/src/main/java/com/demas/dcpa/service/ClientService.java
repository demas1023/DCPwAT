package com.demas.dcpa.service;

import com.demas.dcpa.data.dto.ClientDTO;
import com.demas.dcpa.data.entity.Client;
import com.demas.dcpa.data.mapper.ClientMapper;
import com.demas.dcpa.data.rol.ClientRoles;
import com.demas.dcpa.repository.ClientRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    public ClientService(ClientRepository clientRepository, PasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ClientDTO findClientByEmail(String email) {
        Optional<Client> clientOpt = clientRepository.findClientByEmail(email);
        if(clientOpt.isPresent()) {
            return ClientMapper.getClientDTO(clientOpt.get());
        } else {
            throw new RuntimeException("Client not found");
        }

    }

    public ClientDTO findClientByName(String name) {
        Optional<Client> clientOpt = clientRepository.findClientByName(name);
        if (clientOpt.isPresent()) {
            return ClientMapper.getClientDTO(clientOpt.get());
        } else {
            throw new RuntimeException("Client not found");
        }
    }

    public ClientDTO findClientById(int id) {
        Optional<Client> clientOpt = clientRepository.findClientById(id);
        if (clientOpt.isPresent()) {
            return ClientMapper.getClientDTO(clientOpt.get());
        } else {
            throw new RuntimeException("Client not found");
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    public List<ClientDTO> findAllClients() {
        return clientRepository.findAllClients().stream()
                .map(ClientMapper::getClientDTO)
                .collect(Collectors.toList());
    }



    public boolean addClient(ClientDTO client, String password) {
        Client clientEntity = ClientMapper.getClient(client);
        clientEntity.setPassword(passwordEncoder.encode(password));
        return clientRepository.addClient(clientEntity);
    }

    //TODO: IMPLEMENT SECURITY AKA ONLY THE SPECIFIC CLIENT CAN UPDATE/DELETE THIS
    public boolean updateClient(ClientDTO client) {
        Client clientEntity = ClientMapper.getClient(client);
        Client clientDB = clientRepository.findClientByName(clientEntity.getNickname()).get(); //TODO: ensure no errors trough Optional.isPresent()
        clientDB.setRol(clientEntity.getRol());
        clientDB.setEmail(clientEntity.getEmail());
        clientDB.setNickname(clientEntity.getNickname());
        return clientRepository.updateClient(clientDB);
    }

    public boolean updatePassword(ClientDTO client, String password) {
        Client clientEntity = ClientMapper.getClient(client);
        Client clientDB = clientRepository.findClientByName(clientEntity.getNickname()).get(); //TODO: ensure no errors trough Optional.isPresent()
        clientDB.setRol(clientEntity.getRol());
        clientDB.setEmail(clientEntity.getEmail());
        clientDB.setNickname(clientEntity.getNickname());
        clientEntity.setPassword(passwordEncoder.encode(password));
        return clientRepository.updateClient(clientEntity);
    }

    public boolean deleteClient(ClientDTO client) {
        Client clientDB = clientRepository.findClientByName(client.getNickname()).get(); //TODO: ensure no errors trough Optional.isPresent()
        return clientRepository.deleteClient(clientDB);
    }

}
