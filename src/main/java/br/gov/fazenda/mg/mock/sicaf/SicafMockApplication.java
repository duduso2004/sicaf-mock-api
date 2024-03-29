package br.gov.fazenda.mg.mock.sicaf;

import br.gov.fazenda.mg.mock.sicaf.service.MockService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SicafMockApplication implements ApplicationRunner {

	private final MockService mockService;

	public static void main(String[] args) {
		SpringApplication.run(SicafMockApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.mockService.carregarMapaRetornos();
	}

}
