package BookDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.masai.model.Book;
import com.masai.model.BookException;
import com.masai.model.EMUtil;

@Component
public class BookDAOImpl implements BookDAO{

	@Override
	public List<Book> getAllBooks() {
		EntityManager em=EMUtil.provideManager();
		
		String jpql="from Book";
		Query q=em.createQuery(jpql);
		 
		List<Book> books=q.getResultList();
		
		em.close();
		return books;
	}

	@Override
	public Book getBookById(Integer id) throws BookException {
		
		EntityManager em=EMUtil.provideManager();
		
		Book bk= em.find(Book.class,id);
		if(bk==null) {
			throw new BookException("Book  Not found with this Id :"+id);
		}
		else {
			em.close();
			return bk;
		}
		
	
	}

	@Override
	public Book saveBook(Book book) {
		
		EntityManager em=EMUtil.provideManager();
		
		em.getTransaction().begin();
		
		em.persist(book);
		
		em.getTransaction().commit();
		
		em.close();
		return book;
	}

	@Override
	public Book deleteBookById(Integer id) throws BookException {
		EntityManager em=EMUtil.provideManager();
		
		Book bk= em.find(Book.class, id);
		
		if(bk!=null) {
			String jpql="Delete from Book where BookId= :id";
			Query q=em.createQuery(jpql);
			q.setParameter("id", id);
			
		}
		else {
			throw new BookException("Book Not Exist with this Id :"+id);
		}

		em.close();
		return bk;
	}

	@Override
	public Book UpdateBookById(Book book) throws BookException {
		
		EntityManager em=EMUtil.provideManager();
		
		Book bk= em.find(Book.class, book.getBookId());
		
		if(bk!=null) {
			em.getTransaction().begin();
			
			em.merge(book);
			
			em.getTransaction().commit();
		}
		else {
			throw new BookException("Books Not found");
		}
		
		return bk;
	}

	

}
