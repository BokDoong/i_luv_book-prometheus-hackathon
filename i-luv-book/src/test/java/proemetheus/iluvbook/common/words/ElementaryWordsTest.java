package proemetheus.iluvbook.common.words;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class ElementaryWordsTest {

    @Test
    void getWordLength() {
        System.out.println(ElementaryWords.getWordLength());
    }

    @Test
    void getWordTest() {
        System.out.println(ElementaryWords.getWord(10));
    }

    @Test
    void randomTest() {
        List<String> randomWords = MiddleWords.getRandomWords();
        for (int i = 0; i < 5; i++) {
            System.out.println(randomWords.get(i));
        }
    }
}
