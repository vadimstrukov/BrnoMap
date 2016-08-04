package cz.brno.map.utils;

import cz.brno.map.responses.NotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by strukov on 8/4/16.
 */
@Component
public class Validator<T> implements IValidator<T> {

    @Override
    public T validate(String id, T t) {
        if(t == null) throw new NotFoundException(id);
        else return t;
    }
}
