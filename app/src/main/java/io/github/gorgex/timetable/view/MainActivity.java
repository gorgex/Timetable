package io.github.gorgex.timetable.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;
import java.util.Calendar;

import io.github.gorgex.timetable.R;
import io.github.gorgex.timetable.adapters.CoursesRecyclerAdapter;
import io.github.gorgex.timetable.adapters.ViewPagerAdapter;
import io.github.gorgex.timetable.model.Course;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Course> courses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbar();

        ViewPager viewPager = findViewById(R.id.viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        TabLayout tabLayout = findViewById(R.id.tabLayout);
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

//        monday.addItem(new Course("მონაცემთა ბაზები", "ლექცია", "მ.ხაჩიძე", "19:00", "20:00", "201"));
//        tuesday.addItem(new Course("მონაცემთა ბაზები", "ლაბორატორიული", "მ.არჩუაძე", "20:00", "21:00", "415"));
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        testRef.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
//                if (e != null) {
//                    Log.d(TAG, e.toString());
//                    return;
//                }
//
//                if (documentSnapshot.exists()) {
//                    Log.d(TAG, ""+documentSnapshot.getString("message"));
//                }
//            }
//        });
//    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
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
