package rinha.backend.api.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import rinha.backend.domain.model.Client;
import rinha.backend.domain.model.Transaction;

import java.util.List;

@Getter
@Setter
public class StatementDTO {

    @JsonProperty("saldo")
    private final BalanceDTO balance;

    @JsonProperty("ultimas_transacoes")
    private final List<TransactionDTO> lastTransactions;


    public StatementDTO(Client client, List<Transaction> lastTransactions) {
        this.balance = new BalanceDTO(client);
        this.lastTransactions = lastTransactions
                .stream()
                .map(TransactionDTO::new)
                .toList();
    }
}
