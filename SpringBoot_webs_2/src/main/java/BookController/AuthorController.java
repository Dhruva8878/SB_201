package BookController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Book;
import com.masai.model.BookDTO;
import com.masai.model.BookException;

import BookDao.BookDAO;

@Component
@RestController
public class AuthorController {

	@Autowired
	public BookDAO bkd;
	
	@GetMapping("author/books")
	public ResponseEntity<List<Book>> getAllBooks(){
		
		List<Book> books= bkd.getAllBooks();
		
		return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
	}
	
	@GetMapping("author/book/{id}")
	public ResponseEntity<Book> getBookByIdhandler(@PathVariable("id") Integer id) throws BookException{
		Book bk=bkd.getBookById(id);
		
		 Book b2=new Book(id, "Ram", "Valmiki","DailyNews","Novel",500,2500, "D123");
		 
		return new ResponseEntity<Book>(b2,HttpStatus.OK);	
	}
	
	@PostMapping("/author/saveBook")
	public ResponseEntity<Book> saveBookHandler(@RequestBody Book book){
		
		Book bk= bkd.saveBook(book);
		
		return new ResponseEntity<Book>(bk,HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/author/deleteBook/{id}")
	public ResponseEntity<Book> deleteBookHandler(@PathVariable("id") Integer id) throws BookException{
		
		Book bk=bkd.deleteBookById(id);
		
		return new ResponseEntity<Book>(bk,HttpStatus.OK);
			
	}
	
	@PutMapping("/author/updateBook")
	public ResponseEntity<Book> updateBookHandler(@RequestBody Book book) throws BookException{
		 
	   	Book bk= bkd.UpdateBookById(book);
	   	
	   	return new ResponseEntity<Book>(bk,HttpStatus.OK);
	    
	}
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBookReader(){
		
		List<Book> books= bkd.getAllBooks();
		
		return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<BookDTO> getBookByIdReader(@PathVariable("id") Integer id) throws BookException{
		Book bk=bkd.getBookById(id);
		
		 BookDTO b2=new BookDTO(bk.getName(),bk.getAuthor(),
				 bk.getPublication(), bk.getCategory(), bk.getPages(), bk.getPrice());
		 
		 
		return new ResponseEntity<BookDTO>(b2,HttpStatus.OK);	
	}
	
}
