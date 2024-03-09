package rinha.backend.api.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import rinha.backend.domain.model.Client;

import java.time.LocalDateTime;

@Getter
public class BalanceDTO {

    private final Integer total;

    @JsonProperty("data_extrato")
    private final LocalDateTime statementDate;

    @JsonProperty("limite")
    private final Integer balanceLimit;
    public BalanceDTO(Client client) {
        this.total = client.getBalance();
        this.statementDate = LocalDateTime.now();
        this.balanceLimit = client.getBalanceLimit();
    }
}
