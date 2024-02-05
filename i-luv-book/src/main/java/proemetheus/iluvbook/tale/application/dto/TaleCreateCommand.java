package proemetheus.iluvbook.tale.application.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class TaleCreateCommand {
    private String model;
    private List<String> keywords;
}
