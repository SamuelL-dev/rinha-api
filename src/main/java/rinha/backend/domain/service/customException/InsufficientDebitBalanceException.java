package rinha.backend.domain.service.customException;

import java.io.Serial;

public class InsufficientDebitBalanceException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public InsufficientDebitBalanceException(String message) {
        super(message);
    }
}
