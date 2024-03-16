package rinha.backend.domain.service.businessRule.transaction.transactionValidation;

import rinha.backend.domain.enuns.TransactionType;

public interface TransactionValidator {

    TransactionType getTypeTransaction();
    void validate(TransactionValidatorArgs args);
}
