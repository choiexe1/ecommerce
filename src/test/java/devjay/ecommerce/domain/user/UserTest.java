package devjay.ecommerce.domain.user;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    @DisplayName("포인트 추가")
    void addPoint() {
        // GIVEN
        User user = createUser(Role.USER);

        // WHEN
        Long result = user.addPoint(10L);

        // THEN
        Assertions.assertThat(result).isEqualTo(10L);
    }

    @Test
    @DisplayName("포인트 조회")
    void getPoint() {
        // GIVEN
        User user = createUser(Role.USER);

        // WHEN
        user.addPoint(10L);
        Long point = user.getPoint();

        // THEN
        Assertions.assertThat(point).isEqualTo(10L);
    }

    @Test
    @DisplayName("포인트 차감")
    void removePoint() {
        // GIVEN
        User user = createUser(Role.USER);

        // WHEN
        user.addPoint(100L);
        Long removePoint = user.removePoint(10L);

        // THEN
        Assertions.assertThat(removePoint).isEqualTo(90L);
    }

    @Test
    @DisplayName("포인트 차감 시 음수가 될 수 없어야 한다.")
    void removePointCannotBeNegative() {
        // GIVEN
        User user = createUser(Role.USER);

        // WHEN
        user.addPoint(10L);
        Long removePoint = user.removePoint(10L);

        // THEN
        assertThrows(IllegalStateException.class, () -> {
            user.removePoint(1L);
        }, "포인트가 음수로 차감되었는데 예외가 발생하지 않았습니다.");
    }

    private static User createUser(Role role) {
        return new User("test", "test", role, "test");
    }
}