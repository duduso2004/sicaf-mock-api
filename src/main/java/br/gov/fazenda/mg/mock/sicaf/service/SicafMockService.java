package br.gov.fazenda.mg.mock.sicaf.service;

import br.gov.fazenda.mg.mock.sicaf.converter.SicafResponseDtoConverter;
import br.gov.fazenda.mg.mock.sicaf.dto.SicafResponseDTO;
import br.gov.fazenda.mg.mock.sicaf.repository.SicafMockRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SicafMockService {

    private static final Long ID_RESPONSE_DEFAULT = 0L;

    private final SicafMockRepository repository;
    private final SicafResponseDtoConverter converter;

    @SneakyThrows
    public Mono<SicafResponseDTO> recuperarMock(Long renavam) {
        final var response = SicafResponseDTO.builder().build();
        this.repository.findByRenavamOrderByAnoExercicioAsc(renavam)
                .switchIfEmpty(this.repository.findByRenavamOrderByAnoExercicioAsc(ID_RESPONSE_DEFAULT))
                .map(this.converter::toSicafDto)
                .subscribe(result -> response.getStatus().add(result));
        return Mono.just(response);
    }

}
