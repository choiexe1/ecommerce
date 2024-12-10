package devjay.ecommerce.domain.user;

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

    private static User createUser(Role role) {
        return new User("test", "test", role, "test");
    }
}