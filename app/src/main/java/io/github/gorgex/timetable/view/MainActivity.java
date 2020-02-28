package io.github.gorgex.timetable.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.Calendar;

import io.github.gorgex.timetable.R;
import io.github.gorgex.timetable.adapters.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbar();

        viewPager = findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        DayFragment monday = new DayFragment();
        DayFragment tuesday = new DayFragment();
        DayFragment wednesday = new DayFragment();
        DayFragment thursday = new DayFragment();
        DayFragment friday = new DayFragment();
        DayFragment saturday = new DayFragment();
        DayFragment sunday = new DayFragment();

        viewPagerAdapter.addFragment(monday, "Monday");
        viewPagerAdapter.addFragment(tuesday, "Tuesday");
        viewPagerAdapter.addFragment(wednesday, "Wednesday");
        viewPagerAdapter.addFragment(thursday, "Thursday");
        viewPagerAdapter.addFragment(friday, "Friday");
        viewPagerAdapter.addFragment(saturday, "Saturday");
        viewPagerAdapter.addFragment(sunday, "Sunday");

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
        int day = 0;

        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.MONDAY:
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
            default:
                break;
        }

        return day;
    }
}
