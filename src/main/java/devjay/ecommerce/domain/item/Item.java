package devjay.ecommerce.domain.item;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Item {
    @Setter
    protected Long id;

    protected final String name;
    protected final int price;
    protected int quantity;

    protected Item(String name, int price, int quantity) {
        if (!isPositive(price, quantity)) {
            throw new IllegalArgumentException("Price and quantity must be greater than 0.");
        }

        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    private boolean isPositive(int... numbers) {
        for (int number : numbers) {
            if (number < 0) {
                return false;
            }
        }
        return true;
    }

    protected int getTotalPrice() {
        return quantity * price;
    }

    protected int addQuantity(int quantity) {
        this.quantity += quantity;

        return this.quantity;
    }

    protected int removeQuantity(int quantity) {
        int subtracted = this.quantity - quantity;

        if (subtracted < 0) {
            throw new IllegalStateException("수량은 음수가 될 수 없습니다.");
        }

        this.quantity -= quantity;

        return this.quantity;
    }
}
