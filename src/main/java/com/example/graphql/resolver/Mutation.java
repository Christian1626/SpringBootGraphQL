package com.example.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphql.exception.AuthorNotFoundException;
import com.example.graphql.exception.BookNotFoundException;
import com.example.graphql.model.Author;
import com.example.graphql.model.Book;
import com.example.graphql.repository.AuthorRepository;
import com.example.graphql.repository.BookRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author LEROY Christian - Orange / IMT / OLPS / SOFT
 */
@Component
public class Mutation implements GraphQLMutationResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;

    }

    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        return authorRepository.save(author);
    }

    public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
        Book book = new Book();
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException("The author was not found", authorId));
        book.setAuthor(author);
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount != null ? pageCount : 0);

        return bookRepository.save(book);
    }

    public boolean deleteBook(Long id) {
        bookRepository.deleteById(id);
        return true;
    }

    public Book updateBookPageCount(Integer pageCount, Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("The book to be updated was not found", id));
        book.setPageCount(pageCount);
        return bookRepository.save(book);
    }
}
