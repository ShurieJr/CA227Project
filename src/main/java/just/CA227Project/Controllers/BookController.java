package just.CA227Project.Controllers;

import just.CA227Project.Models.Book;
import just.CA227Project.Services.BookService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/books/")
public class BookController {
    //injection bookservice
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    //requests
    //get all books
    @GetMapping("all")
    public Collection<Book> getAllBooks() {
        return service.getAllBooks();
    }

    //get book by id
    @GetMapping("{id}")
    public Book getById(@PathVariable Long id) {
        return service.getBookById(id);
    }

    //save book
    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book newBook) {
       Book savedBook= service.saveBook(newBook);
        HttpHeaders myheaders = new HttpHeaders();
        myheaders.add("posting" ,
                "posting with ResponseEntitty!");
        return ResponseEntity.status(HttpStatus.OK)
                .headers(myheaders).body(savedBook);
    }

    //update
    @PutMapping("{id}")
    public void update(@PathVariable Long id,
                       @RequestBody Book newBook) {
        service.updateBook(id, newBook);
    }

    //delete
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.deleteBook(id);
    }
}
