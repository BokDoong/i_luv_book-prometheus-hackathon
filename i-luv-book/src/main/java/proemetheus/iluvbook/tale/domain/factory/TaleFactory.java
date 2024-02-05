package proemetheus.iluvbook.tale.domain.factory;

import proemetheus.iluvbook.tale.domain.factory.dto.TaleFactoryDto;

import java.util.List;

public interface TaleFactory {
    String getGptResponse(String model, List<TaleFactoryDto> messages);
}
