package io.github.gorgex.timetable.model;

public class Course {

    private String title, type, lecturer, day, from, to, location;

    public Course() {
    }

    public Course(String title, String type, String lecturer, String day, String from, String to, String location) {
        this.title = title;
        this.type = type;
        this.lecturer = lecturer;
        this.day = day;
        this.from = from;
        this.to = to;
        this.location = location;
    }

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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
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
}
