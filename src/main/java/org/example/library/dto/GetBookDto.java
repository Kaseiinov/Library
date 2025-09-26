package org.example.library.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetBookDto {
    @NotBlank
    private String ticket;
    @NotNull
    private Long bookId;
    @NotNull
    private LocalDate returnDate;
}
