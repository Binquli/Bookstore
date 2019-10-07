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
import hh.swd20.BookStore.domain.User;
import hh.swd20.BookStore.domain.UserRepository;

@SpringBootApplication
public class BookStoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookStoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
		@Bean
		public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository crepository, UserRepository urepository) { 
			return (args) -> {
				log.info("save a couple of books");
				Category categoryromaani = new Category("Romaani");
				crepository.save(categoryromaani);
				
				crepository.save(new Category("Seikkailu"));
				crepository.save(new Category("Kauhu"));
				
				bookRepository.save(new Book("Viisikko", "Enid Blyton", "19,90€", 1940, 1215, categoryromaani));
				bookRepository.save(new Book("Harry Potter ja Viisasten kivi", "J.K. Rowling", "29,90€", 1997, 1912, crepository.findByName("Seikkailu").get(0)));	
				
				User user1 = new User ("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
				User user2 = new User ("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
				urepository.save(user1);
				urepository.save(user2);
				
				log.info("nouda kirjat");
				for (Book book : bookRepository.findAll()) {
					log.info(book.toString());
				}

			};
	}

}
