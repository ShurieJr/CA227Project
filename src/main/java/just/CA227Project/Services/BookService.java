package just.CA227Project.Services;

import just.CA227Project.Models.Book;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookService {
    //temp storage
    Map<Long, Book> books = new ConcurrentHashMap<>();
    //auto id
    private AtomicLong autoId = new AtomicLong();

    //operations------ methods
    //getAll Books
    public Collection<Book> getAllBooks() {
        return books.values();
    }
    //get book by id
    public Book getBookById(Long id){
        return books.get(id);
    }

    //save book
    public Book saveBook(Book newBook){
        //check the id
        Long bookId= newBook.getId() != null
                ? newBook.getId()
                : autoId.incrementAndGet();
        newBook.setId(bookId);
        books.put(bookId , newBook);
        return newBook;
    }

    //update
    public Book updateBook(Long id , Book newBook){
        if(books.containsKey(id)){
            //update
            Book oldBook = getBookById(id);

            oldBook.setAuthor(newBook.getAuthor());
            oldBook.setTitle(newBook.getTitle());

            books.put(id , oldBook);
            return newBook;
        }
        else
            return null;
    }

    //delete
    public void deleteBook(Long id){
        books.remove(id);
    }

}
