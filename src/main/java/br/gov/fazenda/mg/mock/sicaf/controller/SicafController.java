package br.gov.fazenda.mg.mock.sicaf.controller;

import br.gov.fazenda.mg.mock.sicaf.dto.SicafResponseDTO;
import br.gov.fazenda.mg.mock.sicaf.service.SicafMockService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/obterStatusVeiculoSicaf")
public class SicafController {

    private final SicafMockService sicafMockService;

    @SneakyThrows
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public Mono<SicafResponseDTO> obterStatusVeiculoSicaf(@RequestParam Long renavam) {
        return this.sicafMockService.recuperarMock(renavam);
    }

}
