package com.rduyam.optimizertruck.proxies;


import com.rduyam.optimizertruck.CustomProperties;
import com.rduyam.optimizertruck.model.Logisticien;
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
public class LogisticienProxy {


    @Autowired
    private CustomProperties props;


    public Iterable<Logisticien> getAllLogisticiens() {

        String baseApiUrl = props.getApiUrl();
        String getLogisticienUrl = baseApiUrl + "/logisticiens";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Logisticien>> response = restTemplate.exchange(
                getLogisticienUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Logisticien>>() {}
        );

        log.debug("Get Logisticien call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Logisticien getLogisticien(Long id) {
        String baseApiUrl = props.getApiUrl();
        String getLogisticienUrl = baseApiUrl + "/logisticien/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Logisticien> response = restTemplate.exchange(
                getLogisticienUrl,
                HttpMethod.GET,
                null,
                Logisticien.class
        );

        log.debug("Get Logisticien call " + response.getStatusCode().toString());

        return response.getBody();
    }


    public Logisticien createLogisticien(Logisticien logisticien) {
        String baseApiUrl = props.getApiUrl();
        String createLogisticienUrl = baseApiUrl + "/logisticien";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Logisticien> request = new HttpEntity<Logisticien>(logisticien);
        ResponseEntity<Logisticien> response = restTemplate.exchange(
                createLogisticienUrl,
                HttpMethod.POST,
                request,
                Logisticien.class);

        log.debug("Create Logisticien call " + response.getStatusCode().toString());

        return response.getBody();
    }


    public Logisticien updateLogisticien(Logisticien logisticien) {
        String baseApiUrl = props.getApiUrl();
        String updateLogisticienUrl = baseApiUrl + "/logisticien/" + logisticien.getIdLogisticien();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Logisticien> request = new HttpEntity<Logisticien>(logisticien);
        ResponseEntity<Logisticien> response = restTemplate.exchange(
                updateLogisticienUrl,
                HttpMethod.PUT,
                request,
                Logisticien.class);

        log.debug("Update Logisticien call " + response.getStatusCode().toString());

        return response.getBody();
    }


    public void deleteLogisticien(Long id) {
        String baseApiUrl = props.getApiUrl();
        String deleteLogisticienUrl = baseApiUrl + "/logisticien/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteLogisticienUrl,
                HttpMethod.DELETE,
                null,
                Void.class);

        log.debug("Delete Logisticien call " + response.getStatusCode().toString());
    }

}
