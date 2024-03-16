package rinha.backend.domain.service.businessRule.transaction.validation;

import rinha.backend.domain.enuns.TransactionType;

public interface TransactionValidator {

    TransactionType getTypeTransaction();
    void validate(TransactionValidatorArgs args);
}
