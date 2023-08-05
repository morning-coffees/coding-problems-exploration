package com.example.demo;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IngAugust2023ApplicationTests {

	@Test
	void contextLoads() {
		Sol1 sol = new Sol1();
		String[] param = {"sS"};

		System.out.println("Woahh2 -> " + Arrays.toString(sol.start2(param)));
		System.out.println("Woahh -> " + Arrays.toString(sol.start(param)));
		
//        assertEquals("https://localhost:80/a/b", Normalizer.normalize("https://:80/a/b"));
//        assertEquals("http://localhost:80/", Normalizer.normalize(""));
//        assertEquals("http://example.com:80/", Normalizer.normalize("example.com"));
//        assertEquals("http://example.com:80/a/b", Normalizer.normalize("example.com/a/b"));
//        assertEquals("https://example.com:80/a/b", Normalizer.normalize("https://example.com/a/b"));
	}

}
