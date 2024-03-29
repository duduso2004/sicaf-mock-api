package br.gov.fazenda.mg.mock.sicaf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SicafResponseDTO {

    @Builder.Default
    private List<SicafDTO> status = new ArrayList<>();

}
