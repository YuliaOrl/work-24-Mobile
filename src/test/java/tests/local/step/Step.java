package tests.local.step;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class Step {

    public Step skipLanguage() {
        step("Skip language alert", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click());
        return this;
    }

    public Step searchRequest(String searchRequest) {
        step("Input search request", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys(searchRequest);
        });
        return this;
    }

    public Step verifyContentFound() {
        step("Verify content found", () ->
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                    .shouldHave(sizeGreaterThan(0)));
        return this;
    }

    public Step openFirstArticle() {
        step("Open first found article", () ->
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).first().click());
        return this;
    }

    public Step openRequestArticle(String searchRequest) {
        step("Open article by request", () ->
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title")).findBy(text(searchRequest)).click());
        return this;
    }

    public Step checkContentArticle(String searchRequest) {
        step("Check content article", () ->
            $(AppiumBy.className("android.view.View")).shouldHave(Condition.text(searchRequest)));
        return this;
    }
}
