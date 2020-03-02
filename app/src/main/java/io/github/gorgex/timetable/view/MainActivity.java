package io.github.gorgex.timetable.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.Calendar;

import io.github.gorgex.timetable.R;
import io.github.gorgex.timetable.adapters.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbar();

        ViewPager viewPager = findViewById(R.id.viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(getCurrentDay());
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0);
        }
    }

    public int getCurrentDay() {
        Calendar calendar = Calendar.getInstance();
        int day;

        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.MONDAY:
            default:
                day = 0;
                break;
            case Calendar.TUESDAY:
                day = 1;
                break;
            case Calendar.WEDNESDAY:
                day = 2;
                break;
            case Calendar.THURSDAY:
                day = 3;
                break;
            case Calendar.FRIDAY:
                day = 4;
                break;
            case Calendar.SATURDAY:
                day = 5;
                break;
            case Calendar.SUNDAY:
                day = 6;
                break;
        }

        return day;
    }
}
