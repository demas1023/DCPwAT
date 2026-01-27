package com.demas.dcpa.data.mapper;

import com.demas.dcpa.data.dto.ClientDTO;
import com.demas.dcpa.data.entity.Client;

public class ClientMapper {
    public static ClientDTO getClientDTO(Client client) {
        return new ClientDTO(client.getNickname(), client.getEmail(), client.getRol());
    }

    public static Client getClient(ClientDTO clientDTO) {
        return new Client(clientDTO.getNickname(), clientDTO.getEmail(), clientDTO.getRol());
    }
}
