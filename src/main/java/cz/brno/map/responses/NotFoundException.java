package cz.brno.map.responses;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by strukov on 8/4/16.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Requested information is not found!")
public class NotFoundException extends RuntimeException {

    public NotFoundException(String id){
        super(id + " is not found!");
    }
}
