package proemetheus.iluvbook.tale.infra.http.dto;

import org.springframework.stereotype.Component;
import proemetheus.iluvbook.tale.application.dto.TaleCreateCommand;
import proemetheus.iluvbook.tale.infra.http.dto.request.TaleCreateDto;

@Component
public class TaleDtoConverter {
    public TaleCreateCommand toCreateCommand(TaleCreateDto dto) {
        return TaleCreateCommand.builder()
                .model(dto.getModel())
                .keywords(dto.getKeywords())
                .build();
    }
}
