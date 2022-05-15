package com.rduyam.optimizertruck.proxies;


import com.rduyam.optimizertruck.CustomProperties;
import com.rduyam.optimizertruck.model.Centrale;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class CentraleProxy {

    @Autowired
    private CustomProperties props;


    public Iterable<Centrale> getAllCentrales() {

        String baseApiUrl = props.getApiUrl();
        String getCentraleUrl = baseApiUrl + "/centrales";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Centrale>> response = restTemplate.exchange(
                getCentraleUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Centrale>>() {}
        );

        log.debug("Get Centrales call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Centrale getCentrale(String id) {
        String baseApiUrl = props.getApiUrl();
        String getCentraleUrl = baseApiUrl + "/centrales/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Centrale> response = restTemplate.exchange(
                getCentraleUrl,
                HttpMethod.GET,
                null,
                Centrale.class
        );

        log.debug("Get Centrale call " + response.getStatusCode().toString());

        return response.getBody();
    }


    public Centrale createEmployee(Centrale centrale) {
        String baseApiUrl = props.getApiUrl();
        String createCentraleUrl = baseApiUrl + "/centrales";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Centrale> request = new HttpEntity<Centrale>(centrale);
        ResponseEntity<Centrale> response = restTemplate.exchange(
                createCentraleUrl,
                HttpMethod.POST,
                request,
                Centrale.class);

        log.debug("Create Centrale call " + response.getStatusCode().toString());

        return response.getBody();
    }


    public Centrale updateCentrale(Centrale centrale) {
        String baseApiUrl = props.getApiUrl();
        String updateCentraleUrl = baseApiUrl + "/centrales/" + centrale.getId();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Centrale> request = new HttpEntity<Centrale>(centrale);
        ResponseEntity<Centrale> response = restTemplate.exchange(
                updateCentraleUrl,
                HttpMethod.PUT,
                request,
                Centrale.class);

        log.debug("Update Centrale call " + response.getStatusCode().toString());

        return response.getBody();
    }


    public void deleteCentrale(String id) {
        String baseApiUrl = props.getApiUrl();
        String deleteCentraleUrl = baseApiUrl + "/centrales/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteCentraleUrl,
                HttpMethod.DELETE,
                null,
                Void.class);

        log.debug("Delete Centrale call " + response.getStatusCode().toString());
    }

}
