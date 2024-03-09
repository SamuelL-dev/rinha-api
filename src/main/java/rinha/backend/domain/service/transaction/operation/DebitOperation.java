package rinha.backend.domain.service.transaction.operation;

import lombok.Getter;
import org.springframework.stereotype.Component;
import rinha.backend.domain.enuns.TransactionType;

@Component
@Getter
public class DebitOperation implements TransactionOperation{
    @Override
    public TransactionType getType() {
        return TransactionType.d;
    }

    @Override
    public void applyTransactionOperation(TransactionOperationArgs args) {
        if(args.transaction().type() == TransactionType.d) {
            Integer newBalance = args.client().getBalance() - args.transactionValue();
            args.client().setBalance(newBalance);
        }
    }
}
