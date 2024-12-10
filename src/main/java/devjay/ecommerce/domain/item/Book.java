package devjay.ecommerce.domain.item;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book extends Item {
    @NotNull
    private String publisher;
    private String isbn;
    private String author;

    public Book(String name, int price, int quantity) {
        super(name, price, quantity);
    }
}
