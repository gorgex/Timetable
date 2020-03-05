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

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import io.github.gorgex.timetable.R;
import io.github.gorgex.timetable.adapters.RecyclerViewAdapter;
import io.github.gorgex.timetable.model.Course;

public class DayFragment extends Fragment {

    private FirebaseFirestore database = FirebaseFirestore.getInstance();
    private CollectionReference coursesRef = database.collection("courses");

    private MainActivity mainActivity;

    private RecyclerViewAdapter recyclerViewAdapter;

    private String day;

    public DayFragment() {
    }

    public static DayFragment newInstance(String day) {
        Bundle args = new Bundle();
        DayFragment fragment = new DayFragment();
        args.putString("day", day);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            day = getArguments().getString("day");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_day, container, false);

        mainActivity = (MainActivity) getContext();

        Query query = coursesRef.whereEqualTo("day", day).orderBy("from", Query.Direction.ASCENDING);
        FirestoreRecyclerOptions<Course> options = new FirestoreRecyclerOptions.Builder<Course>()
                .setQuery(query, Course.class)
                .build();

        recyclerViewAdapter = new RecyclerViewAdapter(options);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(recyclerViewAdapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    mainActivity.getFabInstance().shrink();
                } else if (dy < 0) {
                    mainActivity.getFabInstance().extend();
                }
            }
        });
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
