package proemetheus.iluvbook.tale.infra.http.dto.request;

import lombok.Getter;

@Getter
public class RecommendTaleRequest {
    String model;
    String content;
}
