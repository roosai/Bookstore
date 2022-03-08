package kevat22.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import kevat22.Bookstore.domain.Book;
import kevat22.Bookstore.domain.BookRepository;
import kevat22.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value= {"/", "/booklist"})
	public String booklist (Model model) {
		System.out.println("fetch all books");
		for (Book book : repository.findAll()) {
			System.out.println(book.toString());
		}model.addAttribute("books",repository.findAll());
		return "booklist";
	}

	@PreAuthorize("hasAuthority('ADMIN')") 
	@RequestMapping(value="/add")
	public String addBook (Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", crepository.findAll());
		return "addbook";
	}
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		model.addAttribute("categories", crepository.findAll());
		return "editbook";
	}

	@GetMapping("/index")
	public String showIndex() {
		return "This is the index page";
	}

}
