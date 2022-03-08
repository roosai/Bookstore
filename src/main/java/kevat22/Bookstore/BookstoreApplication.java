package kevat22.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import org.springframework.boot.CommandLineRunner;

import kevat22.Bookstore.domain.Book;
import kevat22.Bookstore.domain.BookRepository;
import kevat22.Bookstore.domain.Category;
import kevat22.Bookstore.domain.CategoryRepository;
import kevat22.Bookstore.domain.User;
import kevat22.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
	return (args) ->{
			log.info("save a couple of books");
			crepository.save(new Category("Horror"));
		crepository.save(new Category("Romance"));
		crepository.save(new Category("Novel"));
	
		repository.save(new Book("Rec", "Marisha Rasi-Koskinen", "978-951", 2020, 21.50, crepository.findByName("Horror").get(0)));
		repository.save(new Book("Nainen joka unohti", "Liane Moriarty", "978-951-0", 2010, 10.60, crepository.findByName("Romance").get(0)));			
	
		User user1 = new User("user", "$2a$10$PAbu7CUptO/9LI.Nops/A.wgdTsP48j52tqo0y3D1w2yf0w5iwCN6", "USER");
		User user2 = new User("admin", "$2a$10$ipEletBPLOajV3WrNvLve.dWinBYZDbUVZKENp3Ys6L2Ac6mFkkiG", "ADMIN");
		urepository.save(user1);
		urepository.save(user2);
		
		
		log.info("fetch all books");
		for (Book book : repository.findAll()) {
			log.info(book.toString());
		}
	};
	}
	

}
