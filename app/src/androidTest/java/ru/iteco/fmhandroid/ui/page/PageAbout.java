package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class PageAbout {


    public ViewInteraction title = onView(withId(R.id.about_version_title_text_view));
    public ViewInteraction privacy = onView(withId(R.id.about_privacy_policy_value_text_view));
    public ViewInteraction terms = onView(withId(R.id.about_terms_of_use_value_text_view));
    public ViewInteraction backButton = onView(withId(R.id.about_back_image_button));

}
