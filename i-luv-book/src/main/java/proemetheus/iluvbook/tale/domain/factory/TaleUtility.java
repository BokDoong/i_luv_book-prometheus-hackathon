package proemetheus.iluvbook.tale.domain.factory;

import lombok.experimental.UtilityClass;
import proemetheus.iluvbook.tale.domain.Tale;
import proemetheus.iluvbook.tale.domain.factory.dto.TaleFactoryDto;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class TaleUtility {

    public static List<TaleFactoryDto> createEngTaleMessages(List<String> keywords, String age) {
        List<TaleFactoryDto> messages = new ArrayList<>();
        messages.add(new TaleFactoryDto("user", "Make a english fairy tale and its title with keywords for Korean Children " + age +
                ". Following Keywords are " + String.join(",", keywords) +
                ".\nPlease limit the number of fairy tale characters to 1,000 characters" +
                ".\nConsider the level appropriate for the child's age" +
                ".\nPresent the three created Options of fairy tale to the user" +
                ".\nFirst, show me the fairy tale's title. you keep in mind following shape. The shape of the title 'Title : title content'" +
                ".\nThen, Show me the fairy tale. you keep in mind following shape. The shape of the title 'Fairy Tale : fairy tale's content'"));
        return messages;
    }

    public static List<TaleFactoryDto> recommendQuestions(String tale) {
        List<TaleFactoryDto> messages = new ArrayList<>();
        messages.add(new TaleFactoryDto("system", "You are a test-taker who makes multiple choice questions based on English fairy tales for children ages 5 to 10. " +
                "Please consider the level of the children and make 5 questions that fit the type of questions I give you."));
        messages.add(new TaleFactoryDto("assistant", "You can ask questions based on this English fairy tale. Fairy tale: " + tale));
        messages.add(new TaleFactoryDto("user", "Give me Following questions and each answer. Furthermore each question has three options.\n" +
                "1) one question of asking the main character's name.\n" +
                "2) two questions of asking content's comprehension.\n" +
                "3) two question of asking the word from a fairy tale and choosing the meaning from the choice."));
        messages.add(new TaleFactoryDto("user", "Format of the question is 'Question:question content'." +
                "And format of the options are '1) first option\n 2) second option\n 3) third option\n" +
                "And format of the answer is 'Answer: answer content'"));
//        messages.add(new TaleFactoryDto("user", "Each sentence of Question, 3 optional sentences and an answer has to end with format 'End'"));
        return messages;
    }

    public static List<TaleFactoryDto> recommendWords(String tale) {
        List<TaleFactoryDto> messages = new ArrayList<>();
        messages.add(new TaleFactoryDto("system", "You are a selector from a given english fairy tale"));
        messages.add(new TaleFactoryDto("assistant", "Fairy tale: " + tale));
        messages.add(new TaleFactoryDto("user", "Please select 10 good educational words used in fairy tales.\n" +
                "  please show me the word fit follow shape, the shape ot the word 'word:meaning of korean word not describe just word'."));
       return messages;
    }

    // 게임
    public static List<TaleFactoryDto> gameStart(List<String> keywords) {
        List<TaleFactoryDto> messages = new ArrayList<>();

        String text =
                """
                        user input :
                        """
                        +
                        String.join(",", keywords)
                        +
                        """
                                    ""\"# (완)
                                # 사용자 정보 입력
                                   "You are a English fairy tale writer. "
                                    "The kid's gonna give you a keyword as input"
                                    "Make a fairy tale with keywords. "
                                    "The child's level is lower grade in elementary school in Korea"
                                   "Make English fairy tales easy for children to read"
                                    "Make English fairy tales use at least 10 words in List1"
                                    "Please make about 1000 characters of English fairy tale"
                                   \s
                                   \s
                                # Action 대화형 동화 제작 프로세스\s
                                                
                                  You will repeat this process some times iteration should be followed by the previous fairy tale and content.\s
                                  Eventually you will complete one fairy tale. you must keep this rules in mind.
                                                
                                  "Rules"
                                  Create keyword-based fairy tales:
                                                
                                    1. Receives keywords from the user.
                                    Based on these keywords, you create action option of three different fairy tales. Make sure each has its own unique action.
                                    for example, The story just before the fairy tale has to cross the crossroads.\s
                                   \s
                                    2. At that time, three options are given whether to go left or right or center
                                    (action must be brief and clear. Ex1) Left or right, Ex2) Jump or run  )
                                   \s
                                   3. The user informs which of the three fairy tales was selected.  \s
                                  \s
                                   4. you write the tale based on selecetd Option(action)should be followed by the previous fairy tale and content.
                                  \s
                                    5. you must not insert "sexual", 'criminal' keyword in Fairytale
                                                
                                # 동화 생성 조건
                                  'End of Rule'
                                  ""\"
                                  "Please write a fairy tale in English" # 영어로 영어 동화 생성
                                  "Don't put the end at 'the end' of the fairy tale"  #The end 붙이지 말 것
                                  "Never say words other than fairy tale content, except to distinguish between three options" # 필수 예외처리\s
                                  "For example, do not print something like 'User's selection:'" # 예외 처리\s
                                  "you must make the name of the character in English" #캐릭터 이름 영어로 설정 필수\s
                                  "Please make such Option about 50 characters"
                                  "Please make such Option about 50 characters"
                                   \s
                                # 완
                                # 옵션의 출력형식 지정\s
                                ""\"
                                  Present the three created Options of fairy tale to the user.
                                  Let the user choose one of them. you must to give Option, The name of the option at this time is  '**Fairy Tale Option (1,2,3) : title'
                                ""\"
                                """;
        messages.add(new TaleFactoryDto("user",  text));

        return messages;
    }


    public static List<TaleFactoryDto> gameContinue(String tale) {
        List<TaleFactoryDto> messages = new ArrayList<>();
        String text = """
                      tale input :         
                """
                +
                tale
                +

                """
                            "You are a English fairy tale writer. "
                            "The kid's gonna give you the story as input"
                            # 아이의 수준은 초등 저학년으로 가정
                            "The child is in the lower grades of elementary school in korea."
                            "Make English fairy tales for the child's level."
                            "Keep in mind the rules given when writing a fairy tale"
                                        
                            # 대화형 동화 제작 프로세스
                            ""\"
                            'Rules :'
                                        
                            1.You are given a base fairy tale as an input.\s
                                        
                            2.You should write the fairy tale that follows to fit the context of the base fairy tale.
                                        
                            3.you create action option of three different fairy tales. Make sure each has its own unique action.
                            for example, The story just before the fairy tale has to cross the crossroads.\s
                                        
                            2. At that time, three options are given whether to go left or right or center
                            (action must be brief and clear. Ex1) Left or right, Ex2) Jump or run  )
                                        
                           4. you write the tale should be followed by the previous fairy tale and content.
                                        
                            5. you must not insert "sexual", 'criminal' keyword in Fairytale   \s
                                        
                            6. Options and tale must be created separately   \s
                                        
                            Eventually you will complete one fairy tale.
                            ""\"
                                        
                            ""\"
                            Response format:  \s
                                new Fairy Tale content that you made
                                        
                                **Fairy Tale Option 1: Option title**
                                Option Content
                                **Fairy Tale Option 2:  Option title**
                                Option content
                                **Fairy Tale Option 3: Option title**
                                Option content
                            ""
                                        
                                        
                                        
                          ""\"
                            "Please write a fairy tale in English"  # 영어로 영어 동화 생성
                            "Don't put the end at 'the end' of the fairy tale"  # The end 붙이지 말 것
                            "Never say words other than fairy tale content, except to distinguish between three options"  # 필수 예외처리\s
                            "For example, do not print something like 'User's selection:'"  # 예외 처리\s
                            "you must make the name of the character in English"  # 캐릭터 이름 영어로 설정 필수\s
                            "Please make such Option about 50 characters"
                            "Please make about 1000 characters of English fairy tale"
                           \s
                                        
                            ""\"
                              Present the three created Options of fairy tale to the user.
                              Let the user choose one of them. you must to give Option, The name of the option at this time is  '**Fairy Tale Option (1,2,3) : title'
                           \s
                            ""\"
                        """;

        messages.add(new TaleFactoryDto("user",  text));

        return messages;
    }

    public static List<TaleFactoryDto> gameSet(String tale) {
        List<TaleFactoryDto> messages = new ArrayList<>();
        String text = """
                      tale input :         
                """
                +
                tale
                +
                """
                            "You are a English fairy tale writer. "
                            "The kid's gonna give you the story as input"
                            "The child is in the lower grades of elementary school in korea."
                            "Make English fairy tales for the child's level."
                            "Keep in mind the rules given when writing a fairy tale"
                                        
                            # 대화형 동화 제작 프로세스
                            ""\"
                            'Rules :'
                           \s
                            1.You are given a base fairy tale as an input.\s
                          \s
                            2.You should write the fairy tale that follows to fit the context of the base fairy tale.
                          \s
                           3. you write the tale should be followed by the previous fairy tale and content.
                          \s
                            4. you must not insert "sexual", 'criminal' keyword in Fairytale   \s
                               \s
                            Eventually you will complete one fairy tale.
                            ""\"
                           \s
                            ""\"
                           \s
                           \s
                          ""\"
                          "Please write a fairy tale in English" # 영어로 영어 동화 생성
                          "Don't put the end at 'the end' of the fairy tale"  #The end 붙이지 말 것
                          "Never say words other than fairy tale content, except to distinguish between three options" # 필수 예외처리\s
                          "For example, do not print something like 'User's selection:'" # 예외 처리\s
                          "you must make the name of the character in English" #캐릭터 이름 영어로 설정 필수\s
                          "Please make about 500 characters of English fairy tale"
                           \s
                                   \s
                        ""\"
                        ""\"
                        """;
        messages.add(new TaleFactoryDto("user",  text));

        return messages;
    }

}
