package proemetheus.iluvbook.tale.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import proemetheus.iluvbook.common.words.ElementaryWords;
import proemetheus.iluvbook.tale.domain.factory.TaleFactory;
import proemetheus.iluvbook.tale.domain.factory.TaleUtility;
import proemetheus.iluvbook.tale.infra.http.dto.request.GameTaleDto;
import proemetheus.iluvbook.tale.infra.http.dto.request.RecommendTaleRequest;
import proemetheus.iluvbook.tale.infra.http.dto.request.TaleCreateDto;
import proemetheus.iluvbook.tale.infra.http.dto.request.TranslateRequestDto;
import proemetheus.iluvbook.tale.infra.http.dto.response.WordResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaleManageService {

    private final TaleFactory taleFactory;
    private final TranslateService translateService;

    // 동화 생성
    public String post(String model, List<String> keywords, String group) {
        return makeTitleAndTale(model, keywords, group);
    }

    // 로딩화면 단어 추천
    public WordResponse selectRandomWord() {
        String word = ElementaryWords.getRandomWord();
        String translation = translateWord(word);
        return new WordResponse(word, translation);
    }

    // 질문 추천
    public List<String> recommendQuestions(RecommendTaleRequest recommendTaleRequest) {
        List<String> questionsResponses = new ArrayList<>();

        String answer = taleFactory.getGptResponse(recommendTaleRequest.getModel(), TaleUtility.recommendQuestions(recommendTaleRequest.getContent()));
        String[] problems = answer.split("Question:");
        questionsResponses.addAll(Arrays.asList(problems).subList(1, problems.length));

        return questionsResponses;
    }

    // 단어 추천
    public List<String> recommendWords(RecommendTaleRequest recommendTaleRequest) {
        String answer = taleFactory.getGptResponse(recommendTaleRequest.getModel(), TaleUtility.recommendWords(recommendTaleRequest.getContent()));
        String[] gpt_words = answer.split("\n");
        List<String> words = new ArrayList<>();
        words.addAll(Arrays.asList(gpt_words));
        return words;
    }

    // 게임
    public String makeOptionalTales(TaleCreateDto taleCreateDto) {
        return taleFactory.getGptResponse(taleCreateDto.getModel(), TaleUtility.gameStart(taleCreateDto.getKeywords()));
    }

    public String makeContinualTales(GameTaleDto gameTaleDto, String stage) {
        if (stage.equals("continue")) {
            return taleFactory.getGptResponse(gameTaleDto.getModel(), TaleUtility.gameContinue(gameTaleDto.getContent()));
        } else if (stage.equals("end")) {
            return taleFactory.getGptResponse(gameTaleDto.getModel(), TaleUtility.gameSet(gameTaleDto.getContent()));
        }

        return null;
    }

    private String translateWord(String word) {
        return translateService.naverPapagoTranslate(new TranslateRequestDto("en", "ko", word)).getTranslatedText();
    }

    private String makeTitleAndTale(String model, List<String> keywords, String group) {
        if (group.equals("infant")) {
            return taleFactory.getGptResponse(model, TaleUtility.createEngTaleMessages(keywords, "of an infant's age"));
        } else if (group.equals("low-grade")) {
            return taleFactory.getGptResponse(model, TaleUtility.createEngTaleMessages(keywords, "in the lower grades of elementary school"));
        } else if (group.equals("high-grade")) {
            return taleFactory.getGptResponse(model, TaleUtility.createEngTaleMessages(keywords, "in the upper grades of elementary school"));
        }

        return null;
    }
}
