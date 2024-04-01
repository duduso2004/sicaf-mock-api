package br.gov.fazenda.mg.mock.sicaf.service;

import br.gov.fazenda.mg.mock.sicaf.dto.SicafResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class MockService {

    private static final String JSON_PATH_PATTERN = "/%s.json";
    private static final String RESPONSE_DEFAULT = "/default.json";

    private final ObjectMapper mapper;
    private final Map<Long, SicafResponseDTO> mapaRetornos = new HashMap<>();

    @SneakyThrows
    public void carregarMapaRetornos() {
        this.mapaRetornos.put(0L, this.mapper.readValue(getFileUrl(RESPONSE_DEFAULT), SicafResponseDTO.class));
        this.mapaRetornos.put(210415533L, this.mapper.readValue(getFileUrl(JSON_PATH_PATTERN.formatted(210415533L)), SicafResponseDTO.class));
        this.mapaRetornos.put(239900049L, this.mapper.readValue(getFileUrl(JSON_PATH_PATTERN.formatted(239900049L)), SicafResponseDTO.class));
        this.mapaRetornos.put(241755352L, this.mapper.readValue(getFileUrl(JSON_PATH_PATTERN.formatted(241755352L)), SicafResponseDTO.class));
        this.mapaRetornos.put(902031031L, this.mapper.readValue(getFileUrl(JSON_PATH_PATTERN.formatted(902031031L)), SicafResponseDTO.class));
        this.mapaRetornos.put(911245774L, this.mapper.readValue(getFileUrl(JSON_PATH_PATTERN.formatted(911245774L)), SicafResponseDTO.class));
        this.mapaRetornos.put(1304958024L, this.mapper.readValue(getFileUrl(JSON_PATH_PATTERN.formatted(1304958024L)), SicafResponseDTO.class));
        this.mapaRetornos.put(1365265193L, this.mapper.readValue(getFileUrl(JSON_PATH_PATTERN.formatted(1365265193L)), SicafResponseDTO.class));
    }

    public SicafResponseDTO recuperarRetorno(Long renavam) {
        final var responseDefault = this.mapaRetornos.get(0L);
        return ofNullable(this.mapaRetornos.get(renavam)).orElse(responseDefault);
    }

    private URL getFileUrl(String file) {
        return this.getClass().getResource(file);
    }

}
