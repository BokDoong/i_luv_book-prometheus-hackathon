package proemetheus.iluvbook.tale.infra.http.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

import java.util.List;

@Getter
public class TaleCreateDto {
    @NotBlank
    private String model;
    @NotEmpty
    private List<String> keywords;
}
