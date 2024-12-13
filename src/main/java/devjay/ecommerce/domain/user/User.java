package devjay.ecommerce.domain.user;

import devjay.ecommerce.domain.address.Address;
import devjay.ecommerce.domain.common.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Getter
public class User {
    @Setter
    private Long id;
    @Setter
    private Role role;
    private final String username;
    private final String password;
    private final String name;
    private final Timestamp timestamp;
    private Long point = 0L;

    public User(String username, String password, Role role, String name) {
        this.username = username;
        this.role = role;
        this.password = password;
        this.name = name;
        this.timestamp = new Timestamp();
    }

    @Setter
    private Address address;

    public Long addPoint(Long point) {
        this.point += point;

        return this.point;
    }

    public Long removePoint(Long point) {
        long subtracted = this.point - point;

        if (subtracted < 0) {
            throw new IllegalStateException("포인트는 음수가 될 수 없습니다.");
        }

        this.point -= point;

        return this.point;
    }
}
