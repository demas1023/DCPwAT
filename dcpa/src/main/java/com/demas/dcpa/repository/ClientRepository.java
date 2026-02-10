package com.demas.dcpa.repository;

import com.demas.dcpa.data.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {


    Optional<Client> findClientByNickname(String name);
    Optional<Client> findClientByEmail(String email);

    List<Client> findAllClientsByNickname(String name); //possible search option

}
