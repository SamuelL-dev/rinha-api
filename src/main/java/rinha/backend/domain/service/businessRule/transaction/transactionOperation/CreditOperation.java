package rinha.backend.domain.service.businessRule.transaction.transactionOperation;

import lombok.Getter;
import org.springframework.stereotype.Component;
import rinha.backend.domain.enuns.TransactionType;

@Component
@Getter
public class CreditOperation implements TransactionOperation{

    @Override
    public TransactionType getType() {
        return TransactionType.c;
    }
    @Override
    public void applyTransactionOperation(TransactionOperationArgs args) {
        if(args.transaction().type() == TransactionType.c) {
            Integer newBalance = args.client().getBalance() + args.transactionValue();
            args.client().setBalance(newBalance);
        }
    }
}
