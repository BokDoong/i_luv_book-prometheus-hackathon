package proemetheus.iluvbook.tale.application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import proemetheus.iluvbook.tale.infra.http.dto.request.TranslateRequestDto;
import proemetheus.iluvbook.tale.infra.http.dto.response.TranslateResponseDto;

@Service
public class TranslateService {

    @Value("${naver.client-id}")
    private String clientId;
    @Value("${naver.client-secret}")
    private String clientSecret;


    public TranslateResponseDto.Result naverPapagoTranslate(TranslateRequestDto translateRequestDto) {

        WebClient webClient = WebClient.builder()
                .baseUrl("https://openapi.naver.com/v1/papago/n2mt")
                .build();
        TranslateResponseDto response = webClient.post().uri(
                        uriBuilder -> uriBuilder.queryParam("source", translateRequestDto.getSource())
                                .queryParam("target", translateRequestDto.getTarget())
                                .queryParam("text", translateRequestDto.getText())
                                .build()
                )
                .header("X-Naver-Client-Id", clientId)
                .header("X-Naver-Client-Secret", clientSecret)
                .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .retrieve()
                .bodyToMono(TranslateResponseDto.class).block();
        return response.getMessage().getResult();
    }
}
