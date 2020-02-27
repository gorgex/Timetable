package io.github.gorgex.timetable.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Course implements Parcelable {

    private String title, type, lecturer, from, to, location;

    public Course() {
    }

    public Course(String title, String type, String lecturer, String from, String to, String location) {
        this.title = title;
        this.type = type;
        this.lecturer = lecturer;
        this.from = from;
        this.to = to;
        this.location = location;
    }

    private Course(Parcel in) {
        title = in.readString();
        type = in.readString();
        lecturer = in.readString();
        from = in.readString();
        to = in.readString();
        location = in.readString();
    }

    public static final Creator<Course> CREATOR = new Creator<Course>() {
        @Override
        public Course createFromParcel(Parcel in) {
            return new Course(in);
        }

        @Override
        public Course[] newArray(int size) {
            return new Course[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(type);
        parcel.writeString(lecturer);
        parcel.writeString(from);
        parcel.writeString(to);
        parcel.writeString(location);
    }
}
