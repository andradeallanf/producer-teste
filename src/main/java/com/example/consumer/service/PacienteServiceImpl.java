package com.example.consumer.service;

import com.example.consumer.client.PacienteClient;
import com.example.consumer.dto.PacienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteClient pacienteClient;

    @Override
    public List<PacienteDTO> getPacientes() {
        return pacienteClient.listPaciente();
    }

    @Override
    public void updatePaciente(PacienteDTO pacienteDTO, String cdPaciente) {
        pacienteClient.updatePaciente(pacienteDTO, cdPaciente);
    }

    @Override
    public void deletePaciente(String cdPaciente) {
        pacienteClient.deletePaciente(cdPaciente);
    }
}
