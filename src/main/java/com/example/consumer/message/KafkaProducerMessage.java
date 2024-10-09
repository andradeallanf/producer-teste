package com.example.consumer.message;

import com.example.consumer.dto.PacienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerMessage {

    @Autowired
    private KafkaTemplate<String, PacienteDTO> kafkaTemplate;

    private final String KAFKA_TOPIC = "paciente-topic";

    public void sendMessage(PacienteDTO pacienteDTO) {
        kafkaTemplate.send(KAFKA_TOPIC, pacienteDTO);
    }
}
