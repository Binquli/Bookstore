package hh.swd20.BookStore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import hh.swd20.BookStore.domain.Book;
import hh.swd20.BookStore.domain.BookRepository;

@SpringBootApplication
public class BookStoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookStoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
		@Bean
		public CommandLineRunner carDemo(BookRepository bookRepository) { 
			return (args) -> {
				log.info("save a couple of cars");
				
				bookRepository.save(new Book("Viisikko", "Enid Blyton", "19,90€", 1940, 1215));
				bookRepository.save(new Book("Harry Potter ja Viisasten kivi", "J.K. Rowling", "29,90€", 1997, 1912));	
				
				log.info("nouda kirjat");
				for (Book book : bookRepository.findAll()) {
					log.info(book.toString());
				}

			};
	}

}
