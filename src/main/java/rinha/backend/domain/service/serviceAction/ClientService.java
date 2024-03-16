package rinha.backend.domain.service.serviceAction;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rinha.backend.domain.service.customException.ClientNotFoundException;
import rinha.backend.domain.model.Client;
import rinha.backend.domain.repositories.ClientRepository;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;

    public Client getClientById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
    }
}
