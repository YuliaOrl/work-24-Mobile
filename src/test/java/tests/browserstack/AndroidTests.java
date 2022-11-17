package tests.browserstack;

import org.junit.jupiter.api.Test;
import tests.browserstack.steps.Steps;

public class AndroidTests extends TestBase {
    Steps steps = new Steps();

    @Test
    void mobileSearchWordTest() {
        String searchWord = "Selenide";

        steps
             .skipLanguage()
             .searchRequest(searchWord)
             .verifyContentFound()
             .openFirstArticle()
             .checkContentArticle(searchWord);
    }

    @Test
    void mobileSearchPhraseTest() {
        String searchPhrase = "Mobile testing";

        steps
             .skipLanguage()
             .searchRequest(searchPhrase)
             .verifyContentFound()
             .openRequestArticle(searchPhrase)
             .checkContentArticle(searchPhrase);
    }
}
