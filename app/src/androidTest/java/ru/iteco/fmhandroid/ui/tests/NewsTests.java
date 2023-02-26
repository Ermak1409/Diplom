package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;

import android.os.SystemClock;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.StepsAuthorization;
import ru.iteco.fmhandroid.ui.steps.StepsMain;
import ru.iteco.fmhandroid.ui.steps.StepsNews;

@RunWith(AllureAndroidJUnit4.class)
public class NewsTests {

    StepsAuthorization auth = new StepsAuthorization();
    StepsMain main = new StepsMain();
    StepsNews news = new StepsNews();

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void authCheck() {
        SystemClock.sleep(5000);
        try {
            main.isMainScreen();
        } catch (NoMatchingViewException e) {
            auth.validAuth();
        }
        SystemClock.sleep(1000);
    }


    @Test
    @DisplayName("Сортировка новостей")
    public void sortNews() {
        main.openNews();
        news.sortNews();
        news.isNewsScreen();
    }

    @Test
    @DisplayName("Фильтрация новостей, Объявление")
    public void filterNewsAdd() {
        main.openNews();
        news.isNewsScreen();
        news.filterNews();
        news.isFilterScreen();
        news.selectFilterCategory("Объявление");
        closeSoftKeyboard();
        news.applyNews();
        news.checkAutoFilter();

    }

    @Test
    @DisplayName("Фильтрация новостей, День рождения")
    public void filterNewsBirthday() {
        main.openNews();
        news.filterNews();
        news.isFilterScreen();
        news.selectFilterCategory("День рождения");
        closeSoftKeyboard();
        news.applyNews();
        news.checkAutoFilter();
    }

    @Test
    @DisplayName("Фильтрация новостей, Зарплата")
    public void filterNewsSalary() {
        main.openNews();
        news.filterNews();
        news.isFilterScreen();
        news.selectFilterCategory("Зарплата");
        closeSoftKeyboard();
        news.applyNews();
        news.checkAutoFilter();
    }

    @Test
    @DisplayName("Фильтрация новостей, Профсоюз")
    public void filterNewsUnion() {
        main.openNews();
        news.filterNews();
        news.isFilterScreen();
        news.selectFilterCategory("Профсоюз");
        closeSoftKeyboard();
        news.applyNews();
        news.checkAutoFilter();
    }

    @Test
    @DisplayName("Фильтрация новостей, Праздник")
    public void filterNewsHoliday() {
        main.openNews();
        news.filterNews();
        news.isFilterScreen();
        news.selectFilterCategory("Праздник");
        closeSoftKeyboard();
        news.applyNews();
        news.checkAutoFilter();
    }

    @Test
    @DisplayName("Фильтрация новостей, Массаж")
    public void filterNewsMassage() {
        main.openNews();
        news.filterNews();
        news.isFilterScreen();
        news.selectFilterCategory("Массаж");
        closeSoftKeyboard();
        news.applyNews();
        news.checkAutoFilter();
    }

    @Test
    @DisplayName("Фильтрация новостей, Благодарность")
    public void filterNewsGratitude() {
        main.openNews();
        news.filterNews();
        news.isFilterScreen();
        news.selectFilterCategory("Благодарность");
        closeSoftKeyboard();
        news.applyNews();
        news.checkAutoFilter();
    }

    @Test
    @DisplayName("Фильтрация новостей, Нужна помощь")
    public void filterNewsHelp() {
        main.openNews();
        news.filterNews();
        news.isFilterScreen();
        news.selectFilterCategory("Нужна помощь");
        closeSoftKeyboard();
        news.applyNews();
        news.checkAutoFilter();
    }

}
