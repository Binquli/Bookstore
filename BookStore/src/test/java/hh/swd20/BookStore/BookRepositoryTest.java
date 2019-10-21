package hh.swd20.BookStore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.BookStore.domain.Book;
import hh.swd20.BookStore.domain.BookRepository;
import hh.swd20.BookStore.domain.Category;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository brepository;

    @Test
    public void findByTitleShouldReturnBook() {
		List<Book> books = brepository.findByTitle("Viisikko");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Enid Blyton");
    }
    
    @Test
    public void createNewBook() {
    	Book book = new Book("Puhdistus", "Sofi Oksanen", "14,90€", 2008, 1112481, new Category("Historiallinen"));
    	brepository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    

}