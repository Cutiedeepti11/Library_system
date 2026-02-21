package org.example.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication {
    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
        System.out.println("\n=========================================================");
        System.out.println(" WEB SERVER STARTED! Open http://localhost:8080 in your browser");
        System.out.println("=========================================================\n");
    }
}