package com.example.consumer.client;

import com.example.consumer.dto.PacienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class PacienteClient {

    private final String SERVICE_URI = "http://localhost:8080/estab";

    @Autowired
    RestTemplate restTemplate;

    public List<PacienteDTO> listPaciente() {
        ResponseEntity<PacienteDTO[]> responseEntity = restTemplate.getForEntity(SERVICE_URI+"/paciente/", PacienteDTO[].class);
        return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
    }

    public void updatePaciente(PacienteDTO pacienteDTO, String id) {
        restTemplate.put(SERVICE_URI+"/paciente/"+id, pacienteDTO, String.class);
    }

    public void deletePaciente(String id) {
        restTemplate.delete(SERVICE_URI+"/paciente/"+id);
    }

}
