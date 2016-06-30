package cz.brno.map.utils;

/**
 * Created by strukov on 6/29/16.
 */
public interface IConverter<T> {
    T deserialize(Class ... classesToDeserialize);
}
