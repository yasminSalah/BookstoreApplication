package com.javatpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
@SpringBootApplication

public class BookstoreApplication 
{
public static void main(String[] args) 
{
SpringApplication.run(BookstoreApplication.class, args);
}
}
