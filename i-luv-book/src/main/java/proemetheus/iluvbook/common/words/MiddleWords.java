package proemetheus.iluvbook.common.words;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MiddleWords {

    private static final List<String> words = Arrays.asList("able", "absolute", "accent", "accept", "access", "accident", "account", "accuse", "achieve", "adapt", "admire", "admit", "adopt", "advance", "advantage", "adventure", "advertize", "advice", "advise", "affair", "affect", "afford", "agent", "aid", "aim", "airline", "airport", "alarm", "alcohol", "alive", "allow", "aloud", "alter", "although", "altogether", "amaze", "ambulance", "among", "amount", "amuse", "analysis", "angel", "anger", "announce", "annoy", "annual", "ant", "anxious", "apart", "appeal", "appear", "apply", "appoint", "appreciate", "approach", "appropriate", "argue", "army", "arrange", "arrest", "article", "aside", "asleep", "assess", "assign", "assist", "associate", "assume", "atmosphere", "attach", "attack", "attempt", "attend", "attention", "attitude", "attract", "audience", "automatic", "average", "avoid", "awake", "award", "aware", "awkward", "background", "bacon", "balance", "balloon", "band", "bang", "bar", "bare", "bark", "basis", "battery", "battle", "bay", "bean", "beat", "beer", "beg", "belief", "belong", "bench", "bend", "beneath", "benefit", "bet", "beyond", "billion", "bin", "bind", "bit", "bite", "bitter", "blame", "blank", "blanket", "bless", "blind", "block", "blonde", "bloom", "blow", "boil", "bomb", "bond", "boom", "boot", "bore", "boss", "bother", "bounce", "bow", "bowl", "brain", "brake", "branch", "brand", "breast", "breath", "breathe", "brick", "brief", "brilliant", "broad", "bubble", "budget", "bug", "bump", "bunch", "burst", "bury", "bush", "cable", "cage", "calculate", "calendar", "calm", "capable", "cape", "capital", "captain", "career", "carpet", "cart", "cast", "castle", "catalogue", "category", "cause", "ceiling", "cell", "century", "chain", "chairman", "challenge", "champion", "channel", "character", "characteristic", "charge", "charm", "chart", "chase", "chat", "cheek", "cheer", "chest", "chew", "chief", "chip", "choice", "chop", "cigarette", "cinema", "circumstance", "citizen", "civil", "claim", "clerk", "click", "client", "cliff", "climate", "clip", "clue", "coach", "coal", "coast", "code", "coin", "combine", "comedy", "comfort", "command", "comment", "commerce", "committee", "common", "communicate", "community", "compare", "complain", "complete", "complex", "complicate", "concentrate", "concept", "concern", "concert", "confirm", "conflict", "confuse", "connect", "conscious", "consider", "constant", "consume", "contact", "contain", "content", "contest", "context", "continue", "contract", "contribute", "converse", "convince", "cop", "cope", "copy", "correct", "cottage", "cotton", "cough", "council", "count", "countryside", "county", "crack", "crash", "crawl", "create", "credit", "crime", "crisis", "crisp", "crowd", "crown", "cruel", "cure", "curious", "curl", "current", "cute", "cycle", "damage", "dare", "darling", "dawn", "deal");

    public static String getWord(int idx) {
        return words.get(idx);
    }

    public static int getWordLength() {
        return words.size();
    }

    public static List<String> getRandomWords() {

        Random rand = new Random();
        List<String> randomWords = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            randomWords.add(words.get(rand.nextInt(words.size()))); // 0 이상 100 미만의 난수 생성
        }

        return randomWords;
    }
}
