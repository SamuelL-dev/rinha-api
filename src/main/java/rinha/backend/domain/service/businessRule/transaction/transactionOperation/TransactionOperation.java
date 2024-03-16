package rinha.backend.domain.service.businessRule.transaction.transactionOperation;

import rinha.backend.domain.enuns.TransactionType;

public interface TransactionOperation {

    TransactionType getType();
    void applyTransactionOperation(TransactionOperationArgs args);
}
