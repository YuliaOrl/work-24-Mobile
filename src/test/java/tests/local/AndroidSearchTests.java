package tests.local;

import org.junit.jupiter.api.Test;
import tests.local.step.Step;

public class AndroidSearchTests extends TestBase {
    Step step = new Step();

    @Test
    void mobileSearchWordTest() {
        String searchWord = "Selenide";

        step
             .skipLanguage()
             .searchRequest(searchWord)
             .verifyContentFound()
             .openFirstArticle()
             .checkContentArticle(searchWord);
    }

    @Test
    void mobileSearchPhraseTest() {
        String searchPhrase = "Mobile testing";

        step
             .skipLanguage()
             .searchRequest(searchPhrase)
             .verifyContentFound()
             .openRequestArticle(searchPhrase)
             .checkContentArticle(searchPhrase);
    }
}

//    back();
//    switchTo().alert().accept();