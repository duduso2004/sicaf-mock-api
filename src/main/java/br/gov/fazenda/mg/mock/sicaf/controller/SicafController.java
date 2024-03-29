package br.gov.fazenda.mg.mock.sicaf.controller;

import br.gov.fazenda.mg.mock.sicaf.controller.dto.SicafResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.io.InputStream;

import static java.util.Optional.ofNullable;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/obterStatusVeiculoSicaf")
public class SicafController {

    private final ObjectMapper mapper;

    private static final String JSON_PATH_PATTERN = "/%s.json";
    private static final String RESPONSE_DEFAULT = "/default.json";

    @SneakyThrows
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public Mono<SicafResponseDTO> obterStatusVeiculoSicaf(@RequestParam Long renavam) {
        final var jsonFileInputStream = ofNullable(getInputStreamFile(JSON_PATH_PATTERN.formatted(renavam)))
                .orElse(getInputStreamFile(RESPONSE_DEFAULT));
        return Mono.just(this.mapper.readValue(jsonFileInputStream, SicafResponseDTO.class));
    }

    private InputStream getInputStreamFile(String file) {
        return this.getClass().getResourceAsStream(file);
    }

}
