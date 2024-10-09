package com.example.consumer.service;

import com.example.consumer.dto.PacienteDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PacienteService {


    List<PacienteDTO> getPacientes();

    void updatePaciente (PacienteDTO pacienteDTO, String cdPaciente);

    void deletePaciente (String cdPaciente);

}
