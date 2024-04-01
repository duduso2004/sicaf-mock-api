package br.gov.fazenda.mg.mock.sicaf.repository;

import br.gov.fazenda.mg.mock.sicaf.model.SicafMock;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface SicafMockRepository extends R2dbcRepository<SicafMock, Long> {

    Flux<SicafMock> findByRenavamOrderByAnoExercicioAsc(Long renavam);

}
