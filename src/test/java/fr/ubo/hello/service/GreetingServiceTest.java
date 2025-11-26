package fr.ubo.hello.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import fr.ubo.hello.bean.Greeting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class GreetingServiceTest {

    @Test
    public void badGreeting() throws ClientProtocolException, IOException{
        HttpClient client=new DefaultHttpClient();
        HttpGet mockRequest = new HttpGet("http://localhost:8080/ArchiJEEWSRestTP/greeting");
        HttpResponse mockResponse = client.execute(mockRequest);
        int statusCode = mockResponse.getStatusLine().getStatusCode();
        assertEquals(404, statusCode);

        // Si code 404, ne parse pas le contenu XML, car ce n'est pas du XML valide
        if (statusCode == 200) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(mockResponse.getEntity().getContent()));
            XmlMapper mapper = new XmlMapper();
            Greeting g = mapper.readValue(rd, Greeting.class);
            assertNotNull(g);
            assertFalse(g.getMessage().contains("mariam"));
            assertEquals("name est obligatorie. Merci de le renseigner", g.getMessage());
        }
    }
}
