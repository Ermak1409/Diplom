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
import ru.iteco.fmhandroid.ui.steps.StepsAbout;
import ru.iteco.fmhandroid.ui.steps.StepsAuthorization;
import ru.iteco.fmhandroid.ui.steps.StepsMain;

@RunWith(AllureAndroidJUnit4.class)
public class AboutTests {
    StepsAuthorization auth = new StepsAuthorization();
    StepsMain main = new StepsMain ();
    StepsAbout about = new StepsAbout();


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
    @DisplayName("Ссылка Политика конфиденциальности")
    public void transitionToPrivacyPolicy(){
        main.openAbout();
        about.isAboutScreen();
        about.checkPrivacy();
        about.backButton();
    }

    @Test
    @DisplayName("Ссылка Пользовательское соглашение")
    public void transitionToTermsOfUse(){
        main.openAbout();
        about.isAboutScreen();
        about.checkTerms();
        about.backButton();
    }

}
