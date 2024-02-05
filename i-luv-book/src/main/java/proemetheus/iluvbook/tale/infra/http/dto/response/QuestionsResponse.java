package proemetheus.iluvbook.tale.infra.http.dto.response;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class QuestionsResponse {
    String question;
    List<String> options;
    String answer;

    public QuestionsResponse(String question, String first, String second, String third, String answer) {
        this.question = question;
        this.answer = answer;

        options = new ArrayList<>();
        options.add(first);
        options.add(second);
        options.add(third);
    }
}
