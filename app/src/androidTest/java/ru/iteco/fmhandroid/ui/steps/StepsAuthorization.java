package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static org.hamcrest.Matchers.allOf;

import static ru.iteco.fmhandroid.ui.helper.Helper.waitShown;

import android.os.SystemClock;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.page.Authorization;

public class StepsAuthorization {
    Authorization auth = new Authorization();
    StepsMain main = new StepsMain();

    public void checkAuthorizationScreen() {
        Allure.step("Проверка oкна авторизации");
        auth.authScreen.check(matches(isDisplayed()));
    }

    public void inputLogin(String login) {
        Allure.step("Ввести логин");
        auth.login.check(matches(isEnabled()));
        auth.login.perform(replaceText(login));
    }

    public void inputPassword(String password) {
        Allure.step("Ввести пароль");
        auth.password.check(matches(isEnabled()));
        auth.password.perform(replaceText(password));
    }

    public void clickButtonEnter() {
        Allure.step("Нажать кнопку Войти");
        auth.signInButton.perform(click());
    }

    public void validAuth(){
        Allure.step("Ввести логин");
        auth.login.check(matches(isEnabled()));
        auth.login.perform(replaceText("login2"));
        Allure.step("Ввести пароль");
        auth.password.check(matches(isEnabled()));
        auth.password.perform(replaceText("password2"));
        Allure.step("Нажать на кнопку Войти");
        auth.signInButton.perform(click());
//        onView(isRoot()).perform(waitShown(R.id.container_custom_app_bar_include_on_fragment_main, 8000));
        main.isMainScreen();
    }
    public void emptyLoginOrPass(){
        Allure.step("Пустой логин или пароль");
        onView(allOf(withContentDescription("Login and password cannot be empty"), isDisplayed()));
    }
    public void wrongLoginOrPass(){
        Allure.step("Неверный логин или пароль");
        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }
}
