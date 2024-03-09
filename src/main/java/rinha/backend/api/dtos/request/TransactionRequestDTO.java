package rinha.backend.api.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import rinha.backend.domain.enuns.TransactionType;

public record TransactionRequestDTO(
        @NotNull @JsonProperty("valor") Integer amount,
        @Enumerated(EnumType.ORDINAL) @JsonProperty("tipo") TransactionType type,
        @NotNull @Size(min = 1, max = 10) @JsonProperty("descricao") String description
){
}
