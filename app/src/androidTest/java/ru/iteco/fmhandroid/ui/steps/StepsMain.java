package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.page.PageMain;

public class StepsMain {
    PageMain main = new PageMain();

    public void isMainScreen() {
        Allure.step("Проверка главного окна");
        main.allClaims.check(matches(isDisplayed()));
        main.allNews.check(matches(isDisplayed()));
    }

    public void openClaims() {
        Allure.step("Переход на страницу Claims");
        main.mainMenuButton.perform(click());
        main.claims.perform(click());
        main.claimsScreen.check(matches(isDisplayed()));
    }

    public void openNews() {
        Allure.step("Переход на страницу News");
        main.mainMenuButton.perform(click());
        main.news.perform(click());
        main.newsScreen.check(matches(isDisplayed()));
    }

    public void openAbout() {
        Allure.step("Переход на страницу About");
        main.mainMenuButton.perform(click());
        main.about.perform(click());
        main.aboutScreen.check(matches(isDisplayed()));
    }

    public void clickButtonAllNews() {
        Allure.step("ереход по ссылке All News на странице");
        main.allNews.perform(click());
        main.newsScreen.check(matches(isDisplayed()));
    }

    public void clickButtonAllClaims() {
        Allure.step("Переход по ссылке All Claims на странице");
        main.allClaims.perform(click());
        main.claimsScreen.check(matches(isDisplayed()));
    }

    public void logOut() {
        Allure.step("Выход из приложения");
        main.profile.perform(click());
        main.logOut.perform(click());
        main.authScreen.check(matches(isDisplayed()));
    }
}
