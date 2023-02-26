package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import android.os.SystemClock;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.page.PageClaims;

public class StepsClaims {
    PageClaims claims = new PageClaims();


    public void addNew() {
        Allure.step("Нажать кнопку добавления заявки");
        claims.create.perform(click());
    }

    public void isCreatingScreen() {
        Allure.step("Проверка окна создания заявки");
        claims.creatingScreen.check(matches(isDisplayed()));
    }

    public void enterTitle(String text) {
        Allure.step("Ввести заголовок");
        claims.createTitle.perform(replaceText(text));
    }

    public void enterExecutor(String text) {
        Allure.step("Выбрать из списка ФИО исполнителя");
        claims.createExecutor.perform(replaceText(text));
    }

    public void enterDate(String text) {
        Allure.step("Ввести дату");
        claims.createDate.perform(replaceText(text));
    }

    public void enterTime(String text) {
        Allure.step("Ввести время");
        claims.createTime.perform(replaceText(text));
    }

    public void enterDescription(String text) {
        Allure.step("Ввести описание заявки");
        claims.createDescription.perform(replaceText(text), closeSoftKeyboard());
    }

    public void saveButton() {
        Allure.step("Нажать на кнопку сохранить");
        claims.saveButton.perform(click());
        SystemClock.sleep(1000);
    }

    public void checkEmpty() {
        Allure.step("Проверка уведомления о пустых полях");
        claims.emptyFieldsWarning.check(matches(isDisplayed()));
    }


    public void dateCreationClaims() {
        claims.editDate.perform(click());

    }

    public void timeCreationClaims() {
        claims.editTime.perform(click());

    }

    public void clickOkClaimButton() {
        claims.okButton.perform(click());

    }
    public void isClaimsScreen() {
        Allure.step("Проверка, окна заявок");
        claims.claimsScreen.check(matches(isDisplayed()));
    }

}
