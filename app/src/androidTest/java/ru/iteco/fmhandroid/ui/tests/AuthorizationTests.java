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
public class AuthorizationTests {


    StepsAuthorization auth = new StepsAuthorization();
    StepsMain main = new StepsMain();

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void authCheck() {
        SystemClock.sleep(5000);
        try {
            auth.checkAuthorizationScreen();
        } catch (NoMatchingViewException e) {
            main.logOut();
        }
    }

    @Test
    @DisplayName("Авторизация существующим пользователем")
    public void validAuth() {
        auth.checkAuthorizationScreen();
        auth.validAuth();
        main.logOut();
    }

    @Test
    @DisplayName("Авторизация не существующим пользователем")
    public void invalidUser() {
        auth.checkAuthorizationScreen();
        auth.inputLogin("login");
        auth.inputPassword("password");
        auth.clickButtonEnter();
        auth.wrongLoginOrPass();
    }

    @Test
    @DisplayName("Авторизация без ввода логина и пароля")
    public void emptyAuth() {
        auth.checkAuthorizationScreen();
        auth.clickButtonEnter();
        auth.emptyLoginOrPass();
    }

    @Test
    @DisplayName("Авторизация только по логину")
    public void authLogin() {
        auth.checkAuthorizationScreen();
        auth.inputLogin("login2");
        auth.inputPassword("");
        auth.clickButtonEnter();
        auth.emptyLoginOrPass();
    }

    @Test
    @DisplayName("Авторизация только по паролю")
    public void authPassword() {
        auth.checkAuthorizationScreen();
        auth.inputLogin("");
        auth.inputPassword("password2");
        auth.clickButtonEnter();
        auth.emptyLoginOrPass();
    }

}
