package cz.brno.map;

import cz.brno.map.model.ItemsCollection;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;

/**
 * Created by strukov on 6/28/16.
 */
public class HttpHelper {

    private String URL = "http://www.aldr.cz/download/seznam.cz?password=W5xrLAZ-2755";

    public ItemsCollection getBody() throws JAXBException, IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(URL);

        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {

            JAXBContext jaxbContext = JAXBContext.newInstance(ItemsCollection.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return (ItemsCollection) jaxbUnmarshaller.unmarshal(response.getEntity().getContent());
        }
    }
}
