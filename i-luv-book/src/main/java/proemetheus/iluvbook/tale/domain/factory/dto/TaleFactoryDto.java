package proemetheus.iluvbook.tale.domain.factory.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class TaleFactoryDto implements Serializable {
    private String role;
    private String content;

    @Builder
    public TaleFactoryDto(String role, String content) {
        this.role = role;
        this.content = content;
    }
}
