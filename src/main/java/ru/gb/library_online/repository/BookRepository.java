package ru.gb.library_online.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.gb.library_online.model.Book;

import java.util.List;

@Repository
@AllArgsConstructor
public class BookRepository {
    private final JdbcTemplate jdbc;

    public List<Book> getAll() {
        String sql = "SELECT book.id, book.nameBook, book.price, desc.description " +
                "FROM bookTable AS book " +
                "LEFT JOIN booksDescription AS desc ON book.id = desc.id";

        RowMapper<Book> bookRowMapper = (r, i) -> {
            Book rowObject = new Book();
            rowObject.setId(r.getInt("id"));
            rowObject.setNameBook(r.getString("nameBook"));
            rowObject.setPrice(r.getInt("price"));
            rowObject.setDescription(r.getString("description"));

            return rowObject;
        };

        return jdbc.query(sql, bookRowMapper);
    }

    public Book saveBook(Book book) {
        System.out.println(book);
        String sqlBookTable = "INSERT INTO bookTable (nameBook, price) VALUES (?, ?)";
        jdbc.update(sqlBookTable, book.getNameBook(), book.getPrice());

        String sqlDescriptionTable = "INSERT INTO booksDescription (description) VALUES (?)";
        jdbc.update(sqlDescriptionTable, book.getDescription());

        return book;
    }

    public Book getBookById(int id) {
        String sql = "SELECT book.id, book.nameBook, book.price, desc.description " +
                "FROM bookTable AS book " +
                "LEFT JOIN booksDescription AS desc ON book.id = desc.id WHERE book.id = " + id;

        RowMapper<Book> bookRowMapper = (r, i) -> {
            Book rowObject = new Book();
            rowObject.setId(r.getInt("id"));
            rowObject.setNameBook(r.getString("nameBook"));
            rowObject.setPrice(r.getInt("price"));
            rowObject.setDescription(r.getString("description"));

            return rowObject;
        };

        List<Book> books = jdbc.query(sql, bookRowMapper);

        if (books.isEmpty()) {
            return null;
        } else {
            return books.get(0);
        }
    }
}
