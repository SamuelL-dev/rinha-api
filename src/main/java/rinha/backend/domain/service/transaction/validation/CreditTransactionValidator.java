package rinha.backend.domain.service.transaction.validation;


import lombok.Getter;
import org.springframework.stereotype.Component;
import rinha.backend.domain.customException.InsufficientDebitBalanceException;
import rinha.backend.domain.enuns.TransactionType;

@Component
@Getter
public class CreditTransactionValidator implements TransactionValidator {


    @Override
    public TransactionType getTypeTransaction() {
        return TransactionType.c;
    }

    @Override
    public void validate(TransactionValidatorArgs args) {
        if(TransactionType.c == args.transacion().getType() && args.transactionValue() > args.client().getBalanceLimit()) {
            throw new InsufficientDebitBalanceException("Insufficient balance for credit transaction");
        }
    }
}