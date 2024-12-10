package devjay.ecommerce.domain.address;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AddressTest {

    @Test
    @DisplayName("Province가 지원하지 않는 City로 Address 생성 시 예외가 발생해야 한다.")
    void 유효하지_않은_주소_예외발생() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Address(Province.SEOUL, City.PAJU, "오류동", "테스트로", "1번지");
        });
    }

    @Test
    @DisplayName("유효한 Province와 City 조합으로 Address가 정상 생성되어야 한다.")
    void 올바른_주소_생성() {
        Address address = new Address(Province.SEOUL, City.GANGNAM, "삼성동", "테스트로", "1번지");
        Assertions.assertNotNull(address);
    }

    @Test
    @DisplayName("모든 값이 같으면 동일한 주소로 판단한다.")
    void 동일한_주소_비교() {
        // GIVEN
        Address addressA = new Address(Province.GYEONGGI, City.PAJU, "금촌동", "테스트로", "1번지");
        Address addressB = new Address(Province.GYEONGGI, City.PAJU, "금촌동", "테스트로", "1번지");

        // WHEN
        boolean equals = addressA.equals(addressB);

        // THEN
        Assertions.assertTrue(equals);
    }

    @Test
    @DisplayName("속성이 하나라도 다르면 다른 주소로 판단한다.")
    void 다른_주소_비교() {
        // GIVEN
        Address addressA = new Address(Province.GYEONGGI, City.PAJU, "금촌동", "테스트로", "1번지");
        Address addressB = new Address(Province.GYEONGGI, City.PAJU, "금촌동", "테스트로", "2번지");

        // WHEN
        boolean equals = addressA.equals(addressB);

        // THEN
        Assertions.assertFalse(equals);
    }
}