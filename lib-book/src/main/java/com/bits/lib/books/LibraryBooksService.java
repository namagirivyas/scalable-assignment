package com.bits.lib.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LibraryBooksService {

	public static void main(String[] args) {
		SpringApplication.run(LibraryBooksService.class, args);
	}

}
