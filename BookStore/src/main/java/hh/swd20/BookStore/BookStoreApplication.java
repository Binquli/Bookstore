	package hh.swd20.BookStore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import hh.swd20.BookStore.domain.Book;
import hh.swd20.BookStore.domain.BookRepository;
import hh.swd20.BookStore.domain.Category;
import hh.swd20.BookStore.domain.CategoryRepository;

@SpringBootApplication
public class BookStoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookStoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
		@Bean
		public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository crepository) { 
			return (args) -> {
				log.info("save a couple of cars");
				Category categoryromaani = new Category("Romaani");
				crepository.save(categoryromaani);
				
				crepository.save(new Category("Seikkailu"));
				crepository.save(new Category("Kauhu"));
				
				bookRepository.save(new Book("Viisikko", "Enid Blyton", "19,90€", 1940, 1215, categoryromaani));
				bookRepository.save(new Book("Harry Potter ja Viisasten kivi", "J.K. Rowling", "29,90€", 1997, 1912, crepository.findByName("Seikkailu").get(0)));	
				
				log.info("nouda kirjat");
				for (Book book : bookRepository.findAll()) {
					log.info(book.toString());
				}

			};
	}

}
