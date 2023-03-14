package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.ui.helper.Helper.waitShown;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.StepsAuthorization;
import ru.iteco.fmhandroid.ui.steps.StepsMain;


@LargeTest
public class MainTests {
    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule = new ActivityTestRule<>(AppActivity.class);
    static StepsAuthorization auth = new StepsAuthorization();
    static StepsMain main = new StepsMain();

    @Before
    public void authCheck() {
        onView(isRoot()).perform(waitShown(R.id.container_custom_app_bar_include_on_fragment_main, 8000));
        try {
            main.isMainScreen();
        } catch (NoMatchingViewException e) {
            auth.validAuth();
        }
    }


    @Test
    @DisplayName("Переход на страницу Claims")
    public void openMenuClaims() {
        main.openClaims();
    }

    @Test
    @DisplayName("Переход на страницу News")
    public void openMenuNews() {
        main.openNews();
    }

    @Test
    @DisplayName("Переход на страницу About")
    public void openMenuAbout() {
        main.openAbout();
    }

    @Test
    @DisplayName("Переход по ссылке All News на странице")
    public void openAllNews() {
        main.clickButtonAllNews();
    }

    @Test
    @DisplayName("Переход по ссылке All Claims на странице")
    public void openAllClaims() {
        main.clickButtonAllClaims();
    }

}

