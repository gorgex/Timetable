package io.github.gorgex.timetable.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;

import io.github.gorgex.timetable.R;
import io.github.gorgex.timetable.adapters.CoursesRecyclerAdapter;
import io.github.gorgex.timetable.model.Course;

public class DayFragment extends Fragment {

    private ArrayList<Course> courses = new ArrayList<>();
    private FirebaseFirestore database;
    private FirestoreRecyclerAdapter recyclerAdapter;
    private RecyclerView recyclerView;

    public DayFragment() {
    }

//    public void addItem(Course course) {
//        courses.add(course);
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_day, container, false);
//        adapter = new CoursesRecyclerAdapter(courses);

        database = FirebaseFirestore.getInstance();
        Query query = database.collection("monday");
        FirestoreRecyclerOptions<Course> options = new FirestoreRecyclerOptions.Builder<Course>()
                .setQuery(query, Course.class)
                .build();

        recyclerAdapter = new FirestoreRecyclerAdapter<Course, ViewHolder>(options) {
            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_course, parent, false));
            }

            @Override
            protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Course model) {
                holder.setCoursesData(courses.get(position));
            }
        };

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(recyclerAdapter);
        return view;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title, type, lecturer, time, location;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            type = itemView.findViewById(R.id.type);
            lecturer = itemView.findViewById(R.id.lecturer);
            time = itemView.findViewById(R.id.time);
            location = itemView.findViewById(R.id.location);
        }

        void setCoursesData(Course course) {
            title.setText(course.getTitle());
            type.setText(course.getType());
            lecturer.setText(course.getLecturer());
            time.setText(String.format(itemView.getResources().getString(R.string.time), course.getFrom(), course.getTo()));
            location.setText(course.getLocation());
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        recyclerAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        recyclerAdapter.stopListening();
    }
}
