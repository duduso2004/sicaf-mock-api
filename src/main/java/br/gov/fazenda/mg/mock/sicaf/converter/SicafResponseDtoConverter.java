package br.gov.fazenda.mg.mock.sicaf.converter;

import br.gov.fazenda.mg.mock.sicaf.dto.SicafDTO;
import br.gov.fazenda.mg.mock.sicaf.model.SicafMock;
import org.springframework.stereotype.Component;

@Component
public class SicafResponseDtoConverter {

    public SicafDTO toSicafDto(SicafMock sicafMock) {
        return SicafDTO.builder()
                .anoExercicio(sicafMock.getAnoExercicio())
                .codStatus(sicafMock.getCodigoStatus())
                .descricao(sicafMock.getDescricao())
                .build();
    }

}
