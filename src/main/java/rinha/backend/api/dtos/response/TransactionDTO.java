package rinha.backend.api.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import rinha.backend.domain.enuns.TransactionType;
import rinha.backend.domain.model.Transaction;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class TransactionDTO {

    @JsonProperty("valor")
    private Integer amount;

    @JsonProperty("tipo")
    private TransactionType type;

    @JsonProperty("descricao")
    private String description;

    @JsonProperty("realizada_em")
    private LocalDateTime realizedIn;

    public TransactionDTO(Transaction transaction) {
        this.amount = transaction.getAmount();
        this.type = transaction.getType();
        this.description = transaction.getDescription();
        this.realizedIn = transaction.getRealizedIn();
    }
}
