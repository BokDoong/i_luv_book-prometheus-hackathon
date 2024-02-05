package proemetheus.iluvbook.tale.infra.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class WordResponse {
    String word;
    String translation;
}
