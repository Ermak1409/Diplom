package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class PageNews {


    public ViewInteraction newsScreen = onView(withId(R.id.container_list_news_include));
    public ViewInteraction sort = onView(withId(R.id.sort_news_material_button));
    public ViewInteraction filter = onView(withId(R.id.filter_news_material_button));
    public ViewInteraction filterScreen = onView(withId(R.id.filter_news_title_text_view));
    public ViewInteraction category = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    public ViewInteraction applyNews = onView(withId(R.id.filter_button));
    public ViewInteraction autoFilter = onView(withId(R.id.all_news_cards_block_constraint_layout));


}
