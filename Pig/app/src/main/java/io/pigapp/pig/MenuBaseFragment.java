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
    private static final String ARG_SECTION_NUMBER = "section_number";

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(getArguments().getInt(ARG_SECTION_NUMBER), getTitle());
    }

    public abstract String getTitle();
}
