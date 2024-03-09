package rinha.backend.api.exceptionHandler.commonStandardError;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.Instant;

@JsonPropertyOrder(value = {"timestamp", "status", "error", "message", "path"})
public record StandardError(
        @JsonProperty("timestamp") Instant timestamp,
        @JsonProperty("status") Integer status,
        @JsonProperty("message") String message,
        @JsonProperty("path") String path
) {
}
