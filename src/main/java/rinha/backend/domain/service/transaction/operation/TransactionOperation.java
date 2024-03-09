package rinha.backend.domain.service.transaction.operation;

import rinha.backend.domain.enuns.TransactionType;

public interface TransactionOperation {

    TransactionType getType();
    void applyTransactionOperation(TransactionOperationArgs args);
}
