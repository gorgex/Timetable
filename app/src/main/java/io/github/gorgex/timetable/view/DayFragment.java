package io.github.gorgex.timetable.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;

import io.github.gorgex.timetable.R;
import io.github.gorgex.timetable.adapters.CoursesRecyclerAdapter;
import io.github.gorgex.timetable.adapters.RecyclerViewAdapter;
import io.github.gorgex.timetable.model.Course;

public class DayFragment extends Fragment {

    private FirebaseFirestore database = FirebaseFirestore.getInstance();
    private CollectionReference coursesRef = database.collection("courses");

    private View view;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    public DayFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_day, container, false);

        Query query = coursesRef.whereArrayContains("day", "friday");

        FirestoreRecyclerOptions<Course> options = new FirestoreRecyclerOptions.Builder<Course>()
                .setQuery(query, Course.class)
                .build();

        recyclerViewAdapter = new RecyclerViewAdapter(options);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(recyclerViewAdapter);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        recyclerViewAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        recyclerViewAdapter.stopListening();
    }
}
