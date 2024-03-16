package rinha.backend.domain.service.businessRule.transaction.transactionOperation;

import rinha.backend.api.dtos.request.TransactionRequestDTO;
import rinha.backend.domain.model.Client;

public record TransactionOperationArgs(
        TransactionRequestDTO transaction,

        Client client,

        Integer transactionValue
) {
}