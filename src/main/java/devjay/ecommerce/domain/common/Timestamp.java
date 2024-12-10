package devjay.ecommerce.domain.common;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
public class Timestamp {

    @DateTimeFormat
    private final LocalDateTime createdAt = LocalDateTime.now();

    @DateTimeFormat
    private LocalDateTime updatedAt;

    @DateTimeFormat
    private LocalDateTime deletedAt;
}
