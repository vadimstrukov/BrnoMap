package cz.brno.map.utils;

/**
 * Created by strukov on 8/4/16.
 */
public interface IValidator<T> {
    T validate(String id, T t);
}
