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
public class MenuFridgeFragment extends MenuBaseFragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static MenuFridgeFragment newInstance(int sectionNumber) {
        MenuFridgeFragment fragment = new MenuFridgeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_menu_fridge, container, false);
        return rootView;
    }

    public MenuFridgeFragment() {
    }

    @Override
    public String getTitle() {
        return getString(R.string.main_activity_drawer_fridge);
    }
}