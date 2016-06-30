package cz.brno.map.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;


/**
 * Created by strukov on 6/29/16.
 */
@Component
public class XmlConverter<T> implements IConverter<T> {

    private static final String URL = "http://www.aldr.cz/download/seznam.cz?password=W5xrLAZ-2755";


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
