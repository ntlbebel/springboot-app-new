package pl.bebel.springbootapp;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
public class AnimalFactClient {

    public List<AnimalFact> getAnimalFact(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AnimalFact[]> exchange = restTemplate.exchange("https://cat-fact.herokuapp.com/facts/random?animal_type=dog&amount=2",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                AnimalFact[].class
        );

//      exchange.getStatusCodeValue();
        System.out.println("status code:" + exchange.getStatusCodeValue());
        Arrays.stream(exchange.getBody()).forEach(System.out::println);

        return Arrays.asList(exchange.getBody());
    }
}
