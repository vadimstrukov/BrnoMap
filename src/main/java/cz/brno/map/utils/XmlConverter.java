package cz.brno.map.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;


/**
 * Created by strukov on 6/29/16.
 */

// Main class for XML parsing
@Component
public class XmlConverter<T> implements IConverter<T> {

    // API URL with password
    private static final String URL = "http://www.aldr.cz/download/seznam.cz?password=W5xrLAZ-2755";

    // Method deserializes given XML from URL
    // Used JAXB XML parser
    @Override
    @SuppressWarnings(value = "unchecked")
    //TODO: more than one class can be added
    public T deserialize(Class classToDeserialize) {

        try  {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(URL);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();

            JAXBContext jaxbContext = JAXBContext.newInstance(classToDeserialize);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            T object = (T) unmarshaller.unmarshal(entity.getContent());

            EntityUtils.consume(entity);
            return object;
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
