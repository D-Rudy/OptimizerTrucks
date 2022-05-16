package com.rduyam.optimizertruck.proxies;


import com.rduyam.optimizertruck.CustomProperties;
import com.rduyam.optimizertruck.model.Responsable;
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
public class ResponsableProxy {


    @Autowired
    private CustomProperties props;


    public Iterable<Responsable> getAllResponsable() {

        String baseApiUrl = props.getApiUrl();
        String getResponsableUrl = baseApiUrl + "/centrales";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Responsable>> response = restTemplate.exchange(
                getResponsableUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Responsable>>() {}
        );

        log.debug("Get Responsable call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Responsable getResponsable(Long id) {
        String baseApiUrl = props.getApiUrl();
        String getResponsableUrl = baseApiUrl + "/centrale/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Responsable> response = restTemplate.exchange(
                getResponsableUrl,
                HttpMethod.GET,
                null,
                Responsable.class
        );

        log.debug("Get Responsable call " + response.getStatusCode().toString());

        return response.getBody();
    }


    public Responsable createCentrale(Responsable responsable) {
        String baseApiUrl = props.getApiUrl();
        String createResponsableUrl = baseApiUrl + "/centrale";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Responsable> request = new HttpEntity<Responsable>(responsable);
        ResponseEntity<Responsable> response = restTemplate.exchange(
                createResponsableUrl,
                HttpMethod.POST,
                request,
                Responsable.class);

        log.debug("Create Centrale call " + response.getStatusCode().toString());

        return response.getBody();
    }


    public Centrale updateCentrale(Centrale centrale) {
        String baseApiUrl = props.getApiUrl();
        String updateCentraleUrl = baseApiUrl + "/centrale/" + centrale.getIdCentrale();

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


    public void deleteCentrale(Long id) {
        String baseApiUrl = props.getApiUrl();
        String deleteCentraleUrl = baseApiUrl + "/centrale/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteCentraleUrl,
                HttpMethod.DELETE,
                null,
                Void.class);

        log.debug("Delete Centrale call " + response.getStatusCode().toString());
    }

}
