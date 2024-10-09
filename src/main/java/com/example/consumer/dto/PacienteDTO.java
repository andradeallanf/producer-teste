package com.example.consumer.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude
public class PacienteDTO {

    private Long cdPaciente;

    private String nmPaciente;

    private String cpfPaciente;

}
