package main.task2;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hellos\n" + Instant.now());
        LocalDateTime dateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String formattedTimestamp = dateTime.format(formatter);

        System.out.println(formattedTimestamp);
	}

}
