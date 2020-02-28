package io.github.gorgex.timetable.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import io.github.gorgex.timetable.R;
import io.github.gorgex.timetable.model.Course;

public class RecyclerViewAdapter extends FirestoreRecyclerAdapter<Course, RecyclerViewAdapter.ViewHolder> {

    public RecyclerViewAdapter(@NonNull FirestoreRecyclerOptions<Course> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Course model) {
        holder.setCoursesData(model);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_course, parent, false));
    }

    class ViewHolder extends RecyclerView.ViewHolder {

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
}
