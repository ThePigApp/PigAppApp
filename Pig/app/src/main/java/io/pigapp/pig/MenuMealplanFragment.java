package io.pigapp.pig;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jgzuke on 15-06-05.
 */
public class MenuMealplanFragment extends MenuBaseFragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static MenuMealplanFragment newInstance(int sectionNumber) {
        MenuMealplanFragment fragment = new MenuMealplanFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_menu_mealplan, container, false);
        return rootView;
    }

    public MenuMealplanFragment() {
    }

    @Override
    public String getTitle() {
        return getString(R.string.main_activity_drawer_mealplan);
    }
}