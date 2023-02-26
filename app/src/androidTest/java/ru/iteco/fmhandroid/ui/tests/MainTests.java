package ru.iteco.fmhandroid.ui.tests;

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


@RunWith(AllureAndroidJUnit4.class)
public class MainTests {
    static StepsAuthorization auth = new StepsAuthorization();
    static StepsMain main = new StepsMain();

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
