package proemetheus.iluvbook.tale.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proemetheus.iluvbook.tale.application.dto.TaleCreateCommand;
import proemetheus.iluvbook.tale.domain.factory.CreatedTale;

@Service
@RequiredArgsConstructor
public class TaleCommandService {

    private final TaleManageService taleManageService;

    // 동화 생성
    public CreatedTale create(TaleCreateCommand taleCreateCommand, String group) {
        String createdTale = createTale(taleCreateCommand, group);
        String[] contents = createdTale.split("\n");

        return new CreatedTale(extractTitle(contents[0]), extractContents(contents), taleCreateCommand.getKeywords());
    }

    private String extractTitle(String responseTitle) {
        StringBuilder st = new StringBuilder();
        char[] tmp = responseTitle.toCharArray();

        for (int i = 7; i < tmp.length; i++) {
            st.append(tmp[i]);
        }
        return st.toString();
    }

    private String extractContents(String[] contents) {
        StringBuilder st = new StringBuilder();
        for (int i = 10; i < contents.length; i++) {
            st.append(contents[i]);
        }
        return st.toString();
    }

    private String createTale(TaleCreateCommand taleCreateCommand, String group) {
        return taleManageService.post(taleCreateCommand.getModel(), taleCreateCommand.getKeywords(), group);
    }
}
