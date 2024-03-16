package rinha.backend.domain.service.businessRule.transaction.transactionValidation;

import rinha.backend.domain.model.Client;
import rinha.backend.domain.model.Transaction;

public record TransactionValidatorArgs(
        Transaction transacion,
        Client client,
        Integer transactionValue
) {
}
