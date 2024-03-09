package rinha.backend.domain.service;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import rinha.backend.api.dtos.response.StatementDTO;
import rinha.backend.domain.customException.ClientNotFoundException;
import rinha.backend.domain.model.Client;
import rinha.backend.domain.repositories.ClientRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;

    public Client getClientById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
    }
}
