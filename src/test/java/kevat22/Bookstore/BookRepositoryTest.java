package kevat22.Bookstore;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import kevat22.Bookstore.domain.Book;
import kevat22.Bookstore.domain.BookRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository repository;
	
	@Test
	public void findByAuthorShouldReturnSize() {
		List<Book> books =repository.findByAuthor("Liane Moriarty");
		assertThat(books).hasSize(1);
	}
	
	@Test
	public void findByAuthorShouldReturnAuthor() {
		List<Book> books = repository.findByAuthor("Liane Moriarty");
		assertThat(books.get(0).getAuthor()).isEqualTo("Liane Moriarty");
	}
	@Test
	public void insertNewBook() {
		Book book = new Book("Kauhukakara", "SupperNanny", "76839-3198", 2020, 15.9, null);
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}

}
