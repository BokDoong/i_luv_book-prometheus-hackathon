package proemetheus.iluvbook.tale.domain.factory;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CreatedTale {
    String title;
    String engTale;
    List<String> keywords;

    public CreatedTale(String title, String engTale, List<String> keywords) {
        this.title = title;
        this.engTale = engTale;

        this.keywords = new ArrayList<>();
        this.keywords.addAll(keywords);
    }
}

