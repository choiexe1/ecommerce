package devjay.ecommerce.domain.item;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ItemTest {

    @Test
    @DisplayName("수량이나 가격이 0보다 작으면 예외가 발생해야 한다.")
    void quantityAndPriceCreationException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Book("bookA", -100, 10);
        }, "가격이 음수인데 예외가 발생하지 않았습니다.");

        assertThrows(IllegalArgumentException.class, () -> {
            new Book("bookA", 1000, -5);
        }, "수량이 음수인데 예외가 발생하지 않았습니다.");

        assertThrows(IllegalArgumentException.class, () -> {
            new Book("bookA", -100, -5);
        }, "가격과 수량이 모두 음수인데 예외가 발생하지 않았습니다.");
    }

    @Test
    @DisplayName("가격 합계는 수량 * 가격이어야 한다.")
    void getTotalPrice() {
        // GIVEN
        Item book = new Book("bookA", 1000, 10);

        // WHEN
        int totalPrice = book.getTotalPrice();

        // THEN
        Assertions.assertThat(totalPrice).isEqualTo(10_000);
    }

    @Test
    @DisplayName("아이템 수량을 추가하면 더해진 수량을 반환해야 한다.")
    void addQuantity() {
        // GIVEN
        Book book = new Book("bookA", 1000, 0);
        // WHEN
        int result = book.addQuantity(10);
        int quantity = book.getQuantity();

        // THEN
        Assertions.assertThat(result).isEqualTo(10);
        Assertions.assertThat(quantity).isEqualTo(10);
    }

    @Test
    @DisplayName("아이템 수량을 차감하면 남은 수량을 반환해야 한다.")
    void removeQuantity() {
        // GIVEN
        Item book = new Book("bookA", 1000, 2);
        // WHEN
        int restQuantity = book.removeQuantity(1);
        int quantity = book.getQuantity();

        // THEN
        Assertions.assertThat(restQuantity).isEqualTo(1);
        Assertions.assertThat(quantity).isEqualTo(1);
    }

    @Test
    @DisplayName("아이템 수량 차감시 수량은 음수가 될 수 없어야 한다.")
    void removeQuantityCannotBeNegative() {
        Item item = new Book("bookA", 1000, 10);

        assertThrows(IllegalStateException.class, () -> {
            item.removeQuantity(15);
        }, "수량이 음수로 차감되었는데 예외가 발생하지 않았습니다.");
    }

    @Test
    @DisplayName("이름을 업데이트하면 새로운 이름이 반환되어야 한다.")
    void updateName() {
        // GIVEN
        Item book = new Book("bookA", 1000, 10);

        // WHEN
        String updatedName = book.updateName("Book");

        // THEN
        Assertions.assertThat(updatedName).isEqualTo("Book");
    }

    @Test
    @DisplayName("가격을 0보다 작은 값으로 업데이트하면 예외가 발생해야 한다.")
    void updatePriceWithNegativeValue() {
        Item book = new Book("bookA", 1000, 10);

        assertThrows(IllegalArgumentException.class, () -> {
            book.updatePrice(-100);
        }, "가격이 음수일 때 예외가 발생하지 않았습니다.");
    }

    @Test
    @DisplayName("가격을 0보다 큰 값으로 업데이트하면 가격이 업데이트되어야 한다.")
    void updatePriceWithPositiveValue() {
        // GIVEN
        Item book
                = new Book("bookA", 1000, 10);

        // WHEN
        int updatedPrice = book.updatePrice(1500);

        // THEN
        Assertions.assertThat(updatedPrice).isEqualTo(1500);
    }

    @Test
    @DisplayName("수량이 0이 되면 sellStatus가 자동으로 false로 변경되어야 한다.")
    void quantityBecomesZeroAutomaticallyChangesSellStatus() {
        // GIVEN
        Item book = new Book("펜", 1000, 5);

        // WHEN
        book.setSellStatus(SellStatus.SELLING);
        book.removeQuantity(5);

        // THEN
        Assertions.assertThat(book.sellStatus).isEqualTo(SellStatus.SOLD_OUT);
    }
}