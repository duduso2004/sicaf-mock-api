package br.gov.fazenda.mg.mock.sicaf.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SicafDTO {

    @JsonProperty("ano_exercicio")
    private Integer anoExercicio;

    @JsonProperty("codigo_status")
    private Integer codStatus;

    @JsonProperty("descricao")
    private String descricao;

}
