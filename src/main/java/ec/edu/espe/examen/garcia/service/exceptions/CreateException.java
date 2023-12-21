package ec.edu.espe.examen.garcia.service.exceptions;

public class CreateException extends RuntimeException{
    public CreateException(String message){
        super(message);
    }
    public CreateException(String message, Exception cause){
        super(message, cause);
    }
}
