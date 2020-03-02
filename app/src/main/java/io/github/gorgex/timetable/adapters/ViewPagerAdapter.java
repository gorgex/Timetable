package io.github.gorgex.timetable.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import io.github.gorgex.timetable.view.DayFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final static int ITEMS = 7;

    private final List<String> fragmentTitleList = new ArrayList<String>(ITEMS) {{
        add("Monday");
        add("Tuesday");
        add("Wednesday");
        add("Thursday");
        add("Friday");
        add("Saturday");
        add("Sunday");
    }};

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
            default:
                return DayFragment.newInstance("monday");
            case 1:
                return DayFragment.newInstance("tuesday");
            case 2:
                return DayFragment.newInstance("wednesday");
            case 3:
                return DayFragment.newInstance("thursday");
            case 4:
                return DayFragment.newInstance("friday");
            case 5:
                return DayFragment.newInstance("saturday");
            case 6:
                return DayFragment.newInstance("sunday");
        }
    }

    @Override
    public int getCount() {
        return ITEMS;
    }

    public CharSequence getPageTitle(int position) {
        return fragmentTitleList.get(position);
    }
}
