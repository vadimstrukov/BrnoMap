package cz.brno.map.utils;

/**
 * Created by strukov on 6/29/16.
 */

// General interface for XML parser
public interface IConverter<T> {
    T deserialize(Class classToDeserialize);
}
