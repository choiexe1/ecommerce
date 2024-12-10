package devjay.ecommerce.domain.user;

import devjay.ecommerce.domain.address.Address;
import devjay.ecommerce.domain.common.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Getter
public class User {
    @Setter
    private Long id;
    private final String username;
    private final String password;
    private final String name;
    private final Timestamp timestamp;
    private Long point = 0L;

    public User(String username, String password, String name) {
        this.username = username;
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

        if (subtracted <= 0) {
            throw new IllegalArgumentException("입력 값이 기존 값에 비해 많습니다.");
        }

        this.point -= point;

        return this.point;
    }
}
