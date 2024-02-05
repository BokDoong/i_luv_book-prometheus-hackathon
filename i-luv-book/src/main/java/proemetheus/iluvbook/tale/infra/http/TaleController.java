package proemetheus.iluvbook.tale.infra.http;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import proemetheus.iluvbook.tale.application.TaleCommandService;
import proemetheus.iluvbook.tale.application.TaleManageService;
import proemetheus.iluvbook.tale.application.TranslateService;
import proemetheus.iluvbook.tale.application.dto.TaleCreateCommand;
import proemetheus.iluvbook.tale.domain.factory.CreatedTale;
import proemetheus.iluvbook.tale.infra.http.dto.request.GameTaleDto;
import proemetheus.iluvbook.tale.infra.http.dto.request.RecommendTaleRequest;
import proemetheus.iluvbook.tale.infra.http.dto.request.TaleCreateDto;
import proemetheus.iluvbook.tale.infra.http.dto.TaleDtoConverter;
import proemetheus.iluvbook.tale.infra.http.dto.request.TranslateRequestDto;
import proemetheus.iluvbook.tale.infra.http.dto.response.WordResponse;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fairytale")
@RequiredArgsConstructor
public class TaleController {

    private final TaleCommandService taleCommandService;
    private final TaleManageService taleManageService;
    private final TranslateService translateService;
    private final TaleDtoConverter converter;

    @PostMapping("")
    public CreatedTale create(@Validated @RequestBody TaleCreateDto taleCreateDto, @RequestParam("age-group") String group) {
        return taleCommandService.create(toCreateCommand(taleCreateDto), group);
    }

    @GetMapping("/recommended-questions")
    public List<String> questions(@RequestBody RecommendTaleRequest recommendTaleRequest) {
        return taleManageService.recommendQuestions(recommendTaleRequest);
    }

    @GetMapping("/recommended-words")
    public List<String> words(@RequestBody RecommendTaleRequest recommendTaleRequest) {
        return taleManageService.recommendWords(recommendTaleRequest);
    }

    @GetMapping("/loading")
    public WordResponse playHangMan() {
        return taleManageService.selectRandomWord();
    }

    @PostMapping("/translate")
    public String naverPapagoTranslate(@RequestBody TranslateRequestDto translateRequestDto) {
        return translateService.naverPapagoTranslate(translateRequestDto).getTranslatedText();
    }

    @GetMapping("/games/start")
    public String playGames(@Validated @RequestBody TaleCreateDto taleCreateDto) {
        return taleManageService.makeOptionalTales(taleCreateDto);
    }

    @GetMapping("/games/ongoing")
    public String playGames(@Validated @RequestBody GameTaleDto gameTaleDto, @RequestParam("stage") String stage) {
        return taleManageService.makeContinualTales(gameTaleDto, stage);
    }

    private TaleCreateCommand toCreateCommand(TaleCreateDto taleCreateDto) {
        return converter.toCreateCommand(taleCreateDto);
    }
}
