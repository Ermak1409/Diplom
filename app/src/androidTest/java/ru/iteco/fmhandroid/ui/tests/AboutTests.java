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
import ru.iteco.fmhandroid.ui.steps.StepsAbout;
import ru.iteco.fmhandroid.ui.steps.StepsAuthorization;
import ru.iteco.fmhandroid.ui.steps.StepsMain;

@LargeTest
public class AboutTests {

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule = new ActivityTestRule<>(AppActivity.class);

    StepsMain main = new StepsMain();
    StepsAbout about = new StepsAbout();
    StepsAuthorization auth = new StepsAuthorization();

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
    @DisplayName("Ссылка Политика конфиденциальности")
    public void transitionToPrivacyPolicy() {
        main.openAbout();
        about.isAboutScreen();
        about.checkPrivacy();
        about.backButton();
    }

    @Test
    @DisplayName("Ссылка Пользовательское соглашение")
    public void transitionToTermsOfUse() {
        main.openAbout();
        about.isAboutScreen();
        about.checkTerms();
        about.backButton();
    }

}
