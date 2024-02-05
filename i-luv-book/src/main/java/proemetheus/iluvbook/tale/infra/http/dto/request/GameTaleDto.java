package proemetheus.iluvbook.tale.infra.http.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class GameTaleDto {
    @NotBlank
    private String model;
    @NotEmpty
    private String content;
}
