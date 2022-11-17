package tests.browserstack.steps;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class Steps {

    public Steps skipLanguage() {
        step("Skip language alert", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click());
        return this;
    }

    public Steps searchRequest(String searchRequest) {
        step("Input search request", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys(searchRequest);
        });
        return this;
    }

    public Steps verifyContentFound() {
        step("Verify content found", () ->
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                    .shouldHave(sizeGreaterThan(0)));
        return this;
    }

    public Steps openFirstArticle() {
        step("Open first found article", () ->
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).first().click());
        return this;
    }

    public Steps openRequestArticle(String searchRequest) {
        step("Open article by request", () ->
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).findBy(text(searchRequest)).click());
        return this;
    }

    public Steps checkContentArticle(String searchRequest) {
        step("Check content article", () ->
            $(AppiumBy.className("android.widget.TextView")).shouldHave(Condition.text(searchRequest)));
        return this;
    }
}
