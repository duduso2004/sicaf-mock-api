package br.gov.fazenda.mg.mock.sicaf;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SicafMockApplication {

	public static void main(String[] args) {
		SpringApplication.run(SicafMockApplication.class, args);
	}

}
