package io.github.gorgex.timetable.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Course implements Parcelable {

    private String name, type, lecturer, from, to, auditorium;

    public Course() {
    }

    public Course(String name, String type, String lecturer, String from, String to, String auditorium) {
        this.name = name;
        this.type = type;
        this.lecturer = lecturer;
        this.from = from;
        this.to = to;
        this.auditorium = auditorium;
    }

    Course(Parcel in) {
        name = in.readString();
        type = in.readString();
        lecturer = in.readString();
        from = in.readString();
        to = in.readString();
        auditorium = in.readString();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(String auditorium) {
        this.auditorium = auditorium;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(type);
        parcel.writeString(lecturer);
        parcel.writeString(from);
        parcel.writeString(to);
        parcel.writeString(auditorium);
    }
}
