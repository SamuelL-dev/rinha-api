package rinha.backend.domain.customException;

import java.io.Serial;

public class ClientNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;


    public ClientNotFoundException(String message) {
        super(message);
    }

    public ClientNotFoundException(Long id) {
        this(String.format(
                "The person id: %d wasn't found on database", id));
    }
}
