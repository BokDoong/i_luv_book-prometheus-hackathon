package proemetheus.iluvbook.tale.infra.chatgpt;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import proemetheus.iluvbook.tale.domain.factory.TaleFactory;
import proemetheus.iluvbook.tale.domain.factory.dto.TaleFactoryDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GptTaleFactory implements TaleFactory {

    @Value("${gpt.key}")
    String key;

    @Override
    public String getGptResponse(String model, List<TaleFactoryDto> messages) {

        Map<String, Object> bodyMap = new HashMap<>();
        createMessageForm(model, messages, bodyMap);

        WebClient webClient =
                WebClient
                        .builder()
                        .baseUrl("https://api.openai.com")
                        .build();

        String response =
                webClient
                        .post()
                        .uri("/v1/chat/completions")
                        .header("Authorization", "Bearer " + key)
                        .header("Content-Type","application/json;charset=utf-8")
                        .bodyValue(bodyMap)
                        .retrieve()
                        .bodyToMono(String.class)
                        .block();

        return getResponseContent(response);
    }

    private String getResponseContent(String response) {
        JSONObject rjson = new JSONObject(response);
        JSONArray choices = rjson.getJSONArray("choices");
        JSONObject itemJson = choices.getJSONObject(0);
        JSONObject msg = itemJson.getJSONObject("message");

        return msg.getString("content");
    }

    private void createMessageForm(String model, List<TaleFactoryDto> messages, Map<String, Object> bodyMap) {
        bodyMap.put("model", model);
        bodyMap.put("stream", false);
        bodyMap.put("messages", messages);
    }
}
