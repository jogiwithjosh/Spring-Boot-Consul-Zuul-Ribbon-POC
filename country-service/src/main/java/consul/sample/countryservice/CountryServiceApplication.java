package consul.sample.countryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collections;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
@RestController
public class CountryServiceApplication {

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public Principal user(Principal principal) {
		return principal;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Object> home() {
		return new ResponseEntity<>(Collections.singletonMap("message", "country-service"), HttpStatus.OK);
	}

	public static void main(String[] args) {
		SpringApplication.run(CountryServiceApplication.class, args);
	}
}
