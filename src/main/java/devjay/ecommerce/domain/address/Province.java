package devjay.ecommerce.domain.address;

import lombok.Getter;

@Getter
public enum Province {
    SEOUL("서울"), GYEONGGI("경기");

    private final String name;

    Province(String name) {
        this.name = name;
    }
}