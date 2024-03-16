package rinha.backend.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rinha.backend.api.dtos.request.TransactionRequestDTO;
import rinha.backend.api.dtos.response.StatementDTO;
import rinha.backend.api.dtos.response.TransactionResponseDTO;
import rinha.backend.domain.model.Client;
import rinha.backend.domain.model.Transaction;
import rinha.backend.domain.repositories.TransactionRepository;
import rinha.backend.domain.service.serviceAction.ClientService;
import rinha.backend.domain.service.serviceAction.TransactionService;

import java.util.List;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
public class ClientController {

    private final TransactionRepository transactionRepository;

    private final ClientService clientService;

    private final TransactionService transactionService;

    @PostMapping("/{clientId}/transacoes")
    public ResponseEntity<TransactionResponseDTO> createTransactionForClient(@PathVariable Long clientId, @RequestBody @Valid TransactionRequestDTO data) {
        this.transactionService.createTransaction(clientId, data);

        final Client updatedClient = clientService.getClientById(clientId);

        final TransactionResponseDTO response = new TransactionResponseDTO(updatedClient);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{clientId}/extrato")
    public ResponseEntity<StatementDTO> getStatementById(@PathVariable final Long clientId) {
        final Client client = clientService.getClientById(clientId);

        final List<Transaction> transactionList = transactionRepository.findTop10ByClientIdOrderByRealizedInDesc(clientId);
        StatementDTO statementDTO = new StatementDTO(client, transactionList);

        return ResponseEntity.ok(statementDTO);
    }
}
