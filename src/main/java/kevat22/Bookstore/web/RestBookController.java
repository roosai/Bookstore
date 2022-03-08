package kevat22.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kevat22.Bookstore.domain.Book;
import kevat22.Bookstore.domain.BookRepository;
import kevat22.Bookstore.domain.Category;
import kevat22.Bookstore.domain.CategoryRepository;

@RestController
public class RestBookController {

@Autowired
private BookRepository repository;
private CategoryRepository crepository;
	
	@RequestMapping(value="/books", method = RequestMethod.GET)
	public List<Book> booklistRest() {
		return (List<Book>) repository.findAll();
	}
	
	@RequestMapping(value="/books/{id}", method = RequestMethod.GET)
	public Optional<Book> findBookRest(@PathVariable("id") Long id) {
		return repository.findById(id);
	
	}
	@RequestMapping(value="categories", method = RequestMethod.GET)
	public List<Category> categorylistRest(){
		return (List<Category>) crepository.findAll();
	}
	@PostMapping("books")
	Book addbook(@RequestBody Book addbook) {
		return repository.save(addbook);
	}

	@PutMapping("/books/{id}")
	Book replaceBook(@RequestBody Book newBook, @PathVariable Long id) {
		newBook.setId(id);
		return repository.save(newBook);
	}

	@DeleteMapping("/books/{id}")
	void deleteBook(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
	
	

