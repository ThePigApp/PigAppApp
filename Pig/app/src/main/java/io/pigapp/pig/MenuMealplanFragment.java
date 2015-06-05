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