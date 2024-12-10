package devjay.ecommerce.domain.address;

import lombok.Getter;

@Getter
public enum City {
    PAJU("파주"), MAPO("마포"), GANGNAM("강남");

    private final String name;

    City(String name) {
        this.name = name;
    }
}