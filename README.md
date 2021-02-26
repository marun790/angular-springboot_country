# angular-springboot_country
## this project using frontend as angular backend as springboot
#### Technical specifications

**Stack**|**Version**
---------|-----------
Java        | 8.0
spring-boot | 2.3.5.RELEASE/Hoxton.SR8


#### Backend implementation
* Feign configuration and exposing rest service
```

    <dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-openfeign</artifactId>
		</dependency>

```

application.properties
```
spring.application.name=countries-service
server.port=8081
management.server.servlet.context-path=/countries
feign.name=country-service-proxy
feign.url=https://restcountries.eu

```

CountryServicesApplication.java

```

@SpringBootApplication
@EnableFeignClients //Enable feign configuration
public class CountryServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountryServicesApplication.class, args);
	}

}

```
CountriesProxy.java - which consumes the rest service

```
@FeignClient(name = "${feign.name}", url = "${feign.url}")
public interface CountriesProxy {

    @GetMapping(value = "/rest/v2/all")
    List<CountryInfo> getAllCountryDetails();

}

```
#### Frontend implementation

>ng new country-services-ui