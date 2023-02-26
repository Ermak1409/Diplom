package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.core.AllOf;

import ru.iteco.fmhandroid.R;

public class PageClaims {
    public ViewInteraction claimsScreen = onView(withId(R.id.claim_list_recycler_view));
    public ViewInteraction create = onView(withId(R.id.add_new_claim_material_button));
    public ViewInteraction saveButton = onView(withId(R.id.save_button));
    public ViewInteraction emptyFieldsWarning = onView(withText("Fill empty fields"));

    public ViewInteraction creatingScreen = onView(withText("Creating"));
    public ViewInteraction createTitle = onView(withId(R.id.title_edit_text));
    public ViewInteraction createExecutor = onView(withId(R.id.executor_drop_menu_auto_complete_text_view));
    public ViewInteraction createDate = onView(withId(R.id.date_in_plan_text_input_edit_text));
    public ViewInteraction createTime = onView(withId(R.id.time_in_plan_text_input_edit_text));
    public ViewInteraction okButton = onView(AllOf.allOf(withId(android.R.id.button1)));
    public ViewInteraction createDescription = onView(withId(R.id.description_edit_text));
    public ViewInteraction editDate = onView(withId(R.id.date_in_plan_text_input_edit_text));
    public ViewInteraction editTime = onView(withId(R.id.time_in_plan_text_input_edit_text));

}
