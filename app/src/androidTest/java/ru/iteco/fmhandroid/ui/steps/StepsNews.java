package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.page.PageNews;

public class StepsNews {

    PageNews news = new PageNews();


    public void isNewsScreen() {
        Allure.step("Проверить, что это oкно новостей");
        news.newsScreen.check(matches(isDisplayed()));
    }

    public void sortNews() {
        Allure.step("Нажать кнопку сортировки новостей");
        news.sort.perform(click());
    }

    public void filterNews() {
        Allure.step("Нажать кнопку фильтрации");
        news.filter.perform(click());
    }

    public void isFilterScreen() {
        Allure.step("Проверить, что это окно новостей");
        news.filterScreen.check(matches(isDisplayed()));
    }

    public void selectFilterCategory(String text) {
        Allure.step("Выбрать категорию фильтрации");
        news.category.perform(click());
        news.category.perform(replaceText(text));
    }

    public void applyNews() {
        Allure.step("Подтверждение фильтрации новостей");
        news.applyNews.perform(click());
    }

    public void checkAutoFilter() {
        Allure.step("Проверка после фильтрации");
        news.autoFilter.check(matches(isDisplayed()));
    }
}
