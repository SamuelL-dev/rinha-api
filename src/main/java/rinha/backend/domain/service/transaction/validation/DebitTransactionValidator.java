package rinha.backend.domain.service.transaction.validation;

import lombok.Getter;
import org.springframework.stereotype.Component;
import rinha.backend.domain.customException.InsufficientDebitBalanceException;
import rinha.backend.domain.enuns.TransactionType;

@Component
@Getter
public class DebitTransactionValidator implements TransactionValidator {

    private final TransactionType transactionType = TransactionType.d;

    @Override
    public TransactionType getTypeTransaction() {
        return TransactionType.d;
    }

    @Override
    public void validate(TransactionValidatorArgs args) {
        if(args.client().getTotalAvailable() < args.transactionValue()) {
            throw new InsufficientDebitBalanceException("Insufficient balance for debit transaction");
        }
    }
}
