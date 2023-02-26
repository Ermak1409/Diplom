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
import ru.iteco.fmhandroid.ui.steps.StepsClaims;
import ru.iteco.fmhandroid.ui.steps.StepsMain;

@RunWith(AllureAndroidJUnit4.class)

public class ClaimsTests {
    StepsAuthorization auth = new StepsAuthorization();
    StepsClaims claims = new StepsClaims();
    StepsMain main = new StepsMain();


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
    @DisplayName("Создание новой претензии (Chaims)")
    public void creatingNewClaim() {
        main.openClaims();
        claims.addNew();
        claims.isCreatingScreen();
        claims.enterTitle("Заголовок");
        claims.enterExecutor("Ivanov Ivan Ivanovich");
        claims.dateCreationClaims();
        claims.clickOkClaimButton();
        claims.timeCreationClaims();
        claims.clickOkClaimButton();
        claims.enterDescription("Претензия");
        claims.saveButton();
        claims.isClaimsScreen();
    }

    @Test
    @DisplayName("Создание новой претензии (Chaims) без заполнения строки Title")
    public void creatingNewClaimWithoutTitle() {
        main.openClaims();
        claims.addNew();
        claims.isCreatingScreen();
        claims.enterExecutor("Ivanov Ivan Ivanovich");
        claims.dateCreationClaims();
        claims.clickOkClaimButton();
        claims.timeCreationClaims();
        claims.clickOkClaimButton();
        claims.enterDescription("Претензия");
        claims.saveButton();
        claims.checkEmpty();
    }

    @Test
    @DisplayName("Создание новой претензии (Chaims) без заполнения строки Data")
    public void creatingNewClaimWithoutDate() {
        main.openClaims();
        claims.addNew();
        claims.isCreatingScreen();
        claims.enterTitle("Заголовок");
        claims.enterExecutor("Ivanov Ivan Ivanovich");
        claims.timeCreationClaims();
        claims.clickOkClaimButton();
        claims.enterDescription("Претензия");
        claims.saveButton();
        claims.checkEmpty();
    }

    @Test
    @DisplayName("Создание новой претензии (Chaims) без заполнения строки Time")
    public void creatingNewClaimWithoutTime() {
        main.openClaims();
        claims.addNew();
        claims.isCreatingScreen();
        claims.enterTitle("Заголовок");
        claims.enterExecutor("Ivanov Ivan Ivanovich");
        claims.dateCreationClaims();
        claims.clickOkClaimButton();
        claims.enterDescription("Претензия");
        claims.saveButton();
        claims.checkEmpty();
    }

    @Test
    @DisplayName("Создание новой претензии (Chaims) без заполнения строки Description")
    public void creatingNewClaimWithoutDescription() {
        main.openClaims();
        claims.addNew();
        claims.isCreatingScreen();
        claims.enterTitle("Заголовок");
        claims.enterExecutor("Ivanov Ivan Ivanovich");
        claims.dateCreationClaims();
        claims.clickOkClaimButton();
        claims.timeCreationClaims();
        claims.clickOkClaimButton();
        claims.saveButton();
        claims.checkEmpty();
    }

    @Test
    @DisplayName("Создание новой претензии (Chaims), без заполнения строки Executor")
    public void creatingNewClaimWithoutExecutor() {
        main.openClaims();
        claims.addNew();
        claims.isCreatingScreen();
        claims.enterTitle("Заголовок");
        claims.dateCreationClaims();
        claims.clickOkClaimButton();
        claims.timeCreationClaims();
        claims.clickOkClaimButton();
        claims.enterDescription("Претензия");
        claims.saveButton();
        claims.isClaimsScreen();
    }


    @Test
    @DisplayName("Создание новой претензии (Chaims), с пустыми строками")
    public void creatingEmptyNewClaim() {
        main.openClaims();
        claims.addNew();
        claims.isCreatingScreen();
        claims.saveButton();
        claims.checkEmpty();
    }

}
