package com.example.consumer.controller;

import com.example.consumer.dto.PacienteDTO;
import com.example.consumer.message.KafkaProducerMessage;
import com.example.consumer.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private KafkaProducerMessage kafkaProducerMessage;

    @PostMapping("/post-paciente")
    public ResponseEntity postPaciente(@RequestBody PacienteDTO pacienteDTO) {
        kafkaProducerMessage.sendMessage(pacienteDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<PacienteDTO>> getListaPaciente() {
        return ResponseEntity.status(HttpStatus.FOUND).body(pacienteService.getPacientes());
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePaciente(
            @RequestBody PacienteDTO pacienteDTO,
            @PathVariable("id") String id) {
        pacienteService.updatePaciente(pacienteDTO, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePaciente(@PathVariable("id") String id) {
        pacienteService.deletePaciente(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
