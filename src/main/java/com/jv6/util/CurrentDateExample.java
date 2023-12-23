package com.jv6.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class CurrentDateExample {
	public String currentDate() {
		LocalDate currentDate = LocalDate.now();
		System.out.println("Ngày hiện tại: " + currentDate);
		// Tạo đối tượng SimpleDateFormat với định dạng mong muốn
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String formattedDate = currentDate.format(formatter);
		System.out.println("Ngày tháng năm định dạng: " + formattedDate);
        return formattedDate;
	}
}
