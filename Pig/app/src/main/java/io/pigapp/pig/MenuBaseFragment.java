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
public abstract class MenuBaseFragment extends Fragment {

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static MenuBaseFragment newInstance(int sectionNumber) {
        MenuBaseFragment fragment;
        switch(sectionNumber) {
            case 0:
                fragment = new MenuProfileFragment();
                break;
            case 1:
                fragment = new MenuFridgeFragment();
                break;
            case 2:
                fragment = new MenuMealplanFragment();
                break;
            default:
                fragment = new MenuSettingsFragment();
                break;
        }
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(getTitle());
    }

    public abstract String getTitle();
}
