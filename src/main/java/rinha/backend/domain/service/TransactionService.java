package rinha.backend.domain.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import rinha.backend.api.dtos.request.TransactionRequestDTO;
import rinha.backend.api.dtos.response.TransactionDTO;
import rinha.backend.domain.enuns.TransactionType;
import rinha.backend.domain.model.Client;
import rinha.backend.domain.model.Transaction;
import rinha.backend.domain.service.transaction.operation.TransactionOperation;
import rinha.backend.domain.service.transaction.operation.TransactionOperationArgs;
import rinha.backend.domain.repositories.TransactionRepository;
import rinha.backend.domain.service.transaction.validation.TransactionValidator;
import rinha.backend.domain.service.transaction.validation.TransactionValidatorArgs;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final ModelMapper mapper;

    private final TransactionRepository repository;

    private final ClientService clientService;

    private final List<TransactionValidator> transactionValidator;

    private final List<TransactionOperation> transactionOperations;

    @Transactional
    public TransactionDTO createTransaction(Long clientId, TransactionRequestDTO transaction) {
        final Client client = clientService.getClientById(clientId);

        final TransactionType type = transaction.type();

        final Integer transactionValue = transaction.amount();

        final Transaction newTransaction = this.createNewTransaction(transaction, client);

        this.transactionValidator.stream()
                .filter(it -> it.getTypeTransaction() == type)
                .forEach(v ->
                        v.validate(
                                new TransactionValidatorArgs(
                                        newTransaction,
                                        client,
                                        transactionValue
                                )
                        )
                );

        this.transactionOperations.stream()
                .filter(it -> it.getType() == type)
                .forEach(it ->
                        it.applyTransactionOperation(new TransactionOperationArgs(
                                transaction,
                                client,
                                transactionValue
                        )));

        this.repository.save(newTransaction);

        return mapper.map(newTransaction, TransactionDTO.class);
    }

    private Transaction createNewTransaction(TransactionRequestDTO transaction, Client client) {
        Transaction newTransaction = new Transaction(transaction.type(), transaction.amount(), transaction.description(), client);
        return newTransaction;
    }
}
