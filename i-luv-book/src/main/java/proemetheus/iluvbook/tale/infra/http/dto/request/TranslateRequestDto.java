package proemetheus.iluvbook.tale.infra.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TranslateRequestDto {
    String source;
    String target;
    String text;
}
