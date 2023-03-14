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
import ru.iteco.fmhandroid.ui.steps.StepsClaims;
import ru.iteco.fmhandroid.ui.steps.StepsMain;


@LargeTest

public class ClaimsTests {
    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule = new ActivityTestRule<>(AppActivity.class);
    StepsMain main = new StepsMain();
    StepsClaims claims = new StepsClaims();
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
