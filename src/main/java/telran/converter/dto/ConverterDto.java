package telran.converter.dto;

import java.time.LocalDate;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ConverterDto {
	boolean success;
	long timestamp;
	String base;
	@JsonFormat(pattern = "yyyy-MM-dd")
	LocalDate date;
    Map<String, Double> rates;
}
