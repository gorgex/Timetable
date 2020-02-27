package io.github.gorgex.timetable.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import io.github.gorgex.timetable.R;
import io.github.gorgex.timetable.model.Course;

public class CoursesRecyclerAdapter extends RecyclerView.Adapter<CoursesRecyclerAdapter.ViewHolder> {

    private ArrayList<Course> courses;

    public CoursesRecyclerAdapter(ArrayList<Course> courses) {
        this.courses = courses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_course, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setCoursesData(courses.get(position));
    }

    @Override
    public int getItemCount() {
        return courses.size();
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
