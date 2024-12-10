package devjay.ecommerce.domain.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book extends Item {
    private String publisher;
    private String isbn;
    private String author;

    public Book(String name, int price, int quantity) {
        super(name, price, quantity);
    }

    public Book(String name, int price, int quantity, String publisher, String isbn, String author) {
        super(name, price, quantity);
        this.publisher = publisher;
        this.isbn = isbn;
        this.author = author;
    }
}
