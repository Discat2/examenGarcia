package ec.edu.espe.examen.garcia.service.exceptions;

public class DeleteException extends RuntimeException {
    public DeleteException(String message) {
        super(message);
    }

    public DeleteException(String message, Exception cause) {
        super(message, cause);    
    }
}
