package consul.sample.cityservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collections;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
@RestController
public class CityServiceApplication {

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public Principal user(Principal principal) {
		return principal;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Object> home() {
		return new ResponseEntity<>(Collections.singletonMap("message", "city-service"), HttpStatus.OK);
	}

	@Configuration
	@EnableWebSecurity
	public static class security extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {

			http

					.csrf().disable()
					.httpBasic().disable()
			;
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(CityServiceApplication.class, args);
	}
}
