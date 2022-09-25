package BookDao;

import java.util.List;

import com.masai.model.Book;
import com.masai.model.BookException;

public interface BookDAO {
	
	public List<Book> getAllBooks();
	public Book getBookById(Integer id) throws BookException;
	public Book saveBook(Book book);
	public Book deleteBookById(Integer id) throws BookException;
	public Book UpdateBookById(Book book) throws BookException;

}
