package telran.converter.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import telran.converter.dto.ConverterDto;

public class ConverterApp {

	public static void main(String[] args) throws URISyntaxException, IOException {
		RestTemplate restTemplate = new RestTemplate();
		RequestEntity<String> requestEntity = new RequestEntity<>(HttpMethod.GET, new URI("http://data.fixer.io/api/latest?access_key=ac4343bf99b60876ab5ba3c643aaed9d"));
		ResponseEntity<ConverterDto> responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<ConverterDto>(){});
		
		ConverterDto converters = responseEntity.getBody();
		System.out.println(converters);

		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("Please enter first currency:");
			String name1 = br.readLine().toUpperCase();
			System.out.println("Please enter second currency:");
			String name2 = br.readLine().toUpperCase();
			System.out.println("Please enter how many money you want convert:");
			double value = Double.parseDouble(br.readLine());
			Map<String, Double> rates = responseEntity.getBody().getRates();
			double res = rates.get(name1) / rates.get(name2) * value;
			System.out.println(res);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}