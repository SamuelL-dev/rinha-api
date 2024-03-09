package rinha.backend.api.dtos.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import rinha.backend.domain.model.Client;

@NoArgsConstructor
@Getter
public class TransactionResponseDTO {

    @JsonProperty("limite")
    private Integer limite;

    @JsonProperty("saldo")
    private Integer saldo;

    public TransactionResponseDTO(Client client) {
        this.limite = client.getBalanceLimit();
        this.saldo = client.getBalance();
    }
}
