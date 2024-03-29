package br.gov.fazenda.mg.mock.sicaf.service;

import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static java.util.Optional.ofNullable;

@Service
public class MockService {

    private static final String JSON_PATH_PATTERN = "/%s.json";
    private static final String RESPONSE_DEFAULT = "/default.json";

    private final Map<Long, URL> mapaRetornos = new HashMap<>();
    private final URL retornoDefault = getFileUrl(RESPONSE_DEFAULT);

    public void carregarMapaRetornos() {
        this.mapaRetornos.put(210415533L, getFileUrl(JSON_PATH_PATTERN.formatted(210415533L)));
        this.mapaRetornos.put(239900049L, getFileUrl(JSON_PATH_PATTERN.formatted(239900049L)));
        this.mapaRetornos.put(241755352L, getFileUrl(JSON_PATH_PATTERN.formatted(241755352L)));
        this.mapaRetornos.put(902031031L, getFileUrl(JSON_PATH_PATTERN.formatted(902031031L)));
        this.mapaRetornos.put(911245774L, getFileUrl(JSON_PATH_PATTERN.formatted(911245774L)));
        this.mapaRetornos.put(1304958024L, getFileUrl(JSON_PATH_PATTERN.formatted(1304958024L)));
        this.mapaRetornos.put(1365265193L, getFileUrl(JSON_PATH_PATTERN.formatted(1365265193L)));
    }

    public URL recuperarRetorno(Long renavam) {
        return ofNullable(this.mapaRetornos.get(renavam)).orElse(this.retornoDefault);
    }

    private URL getFileUrl(String file) {
        return this.getClass().getResource(file);
    }

}
