package exam.revision.CryptoPractice3.services;

import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import exam.revision.CryptoPractice3.model.Crypto;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@Service
public class CryptoService {
    

    private static final String URL = "https://min-api.cryptocompare.com/data/price";

    public String getPrice(String coin, String currency){
        String url = UriComponentsBuilder.fromUriString(URL)
                                         .queryParam("fsym", coin)
                                         .queryParam("tsyms", currency)
                                         .toUriString();

        RequestEntity<Void> request = RequestEntity.get(url).build();
        RestTemplate template = new RestTemplate();
        ResponseEntity <String> response;
        response = template.exchange(request, String.class);

        String payload = response.getBody();

        System.out.println(payload);

        // Reader strReader = new StringReader(payload);
        // JsonReader jsonReader = Json.createReader(strReader);
        // JsonObject jsonObject = jsonReader.readObject();
        
        // List<Crypto> list = new LinkedList<>();
        // list.add(Crypto.create(jsonObject));
        return payload;

    }
}
