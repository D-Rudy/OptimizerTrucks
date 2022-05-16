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


    public Iterable<Responsable> getAllResponsables() {

        String baseApiUrl = props.getApiUrl();
        String getResponsableUrl = baseApiUrl + "/responsables";

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
        String getResponsableUrl = baseApiUrl + "/responsable/" + id;

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


    public Responsable createResponsable(Responsable responsable) {
        String baseApiUrl = props.getApiUrl();
        String createResponsableUrl = baseApiUrl + "/responsable";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Responsable> request = new HttpEntity<Responsable>(responsable);
        ResponseEntity<Responsable> response = restTemplate.exchange(
                createResponsableUrl,
                HttpMethod.POST,
                request,
                Responsable.class);

        log.debug("Create Responsable call " + response.getStatusCode().toString());

        return response.getBody();
    }


    public Responsable updateResponsable(Responsable responsable) {
        String baseApiUrl = props.getApiUrl();
        String updateResponsableUrl = baseApiUrl + "/responsable/" + responsable.getIdResponsable();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Responsable> request = new HttpEntity<Responsable>(responsable);
        ResponseEntity<Responsable> response = restTemplate.exchange(
                updateResponsableUrl,
                HttpMethod.PUT,
                request,
                Responsable.class);

        log.debug("Update Responsable call " + response.getStatusCode().toString());

        return response.getBody();
    }


    public void deleteResponsable(Long id) {
        String baseApiUrl = props.getApiUrl();
        String deleteResponsableUrl = baseApiUrl + "/responsable/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteResponsableUrl,
                HttpMethod.DELETE,
                null,
                Void.class);

        log.debug("Delete Responsable call " + response.getStatusCode().toString());
    }

}
