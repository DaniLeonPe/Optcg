package es.ies.puerto.optcg.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UnauthorizedException  extends Exception{
    private static final long serialVersionUID = 1L;
    public static final String MESSAGE_ERROR = "Unauthorized action";

    public UnauthorizedException(String message){
        super(message);
    }
}
