package devjay.ecommerce.domain.item;

import devjay.ecommerce.domain.common.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Item {
    @Setter
    protected Long id;

    protected String name;
    protected int price;
    protected int quantity;
    protected Timestamp timestamp;
    @Setter
    protected SellStatus sellStatus;

    protected Item(String name, int price, int quantity) {
        if (isNegative(price, quantity)) {
            throw new IllegalArgumentException("가격과 수량은 0보다 커야 합니다.");
        }

        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.timestamp = new Timestamp();
        this.sellStatus = SellStatus.STOPPED;
    }

    private boolean isNegative(int... numbers) {
        for (int number : numbers) {
            if (number < 0) {
                return true;
            }
        }
        return false;
    }

    protected String updateName(String name) {
        this.name = name;

        return this.name;
    }

    protected int updatePrice(int price) {
        if (isNegative(price)) {
            throw new IllegalArgumentException("가격은 0보다 커야 합니다.");
        }

        this.price = price;

        return this.price;
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

        if (this.quantity == 0) {
            setSellStatus(SellStatus.SOLD_OUT);
        }

        return this.quantity;
    }
}
