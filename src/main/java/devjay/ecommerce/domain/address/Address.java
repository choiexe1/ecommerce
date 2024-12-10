package devjay.ecommerce.domain.address;

import java.util.Map;
import java.util.Set;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Address {
    private static final Map<Province, Set<City>> SUPPORTED_CITIES = Map.of(
            Province.SEOUL, Set.of(City.GANGNAM, City.MAPO),
            Province.GYEONGGI, Set.of(City.PAJU)
    );

    private Province province;
    private City city;
    private String district;
    private String streetAddress;
    private String detailAddress;

    private Address() {
    }

    public Address(Province province, City city, String district, String streetAddress, String detailAddress) {
        if (!isSupportedCity(province, city)) {
            throw new IllegalArgumentException("지원하지 않는 City입니다: " + city + " in " + province);
        }

        this.province = province;
        this.city = city;
        this.district = district;
        this.streetAddress = streetAddress;
        this.detailAddress = detailAddress;
    }

    private boolean isSupportedCity(Province province, City city) {
        return SUPPORTED_CITIES.getOrDefault(province, Set.of()).contains(city);
    }
}
