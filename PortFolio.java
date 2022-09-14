package com.example.myfirstapp;

import android.os.Parcel;
import android.os.Parcelable;

public class PortFolio implements Parcelable {
    private String name;
    private String position;
    private Education education;
    private Course course;
    private String gitHubUserName;

    public PortFolio(String name, String position, Education education, Course course, String gitHubUserName) {
        this.name = name;
        this.position = position;
        this.education = education;
        this.course = course;
        this.gitHubUserName = gitHubUserName;
    }

    protected PortFolio(Parcel in) {
        name = in.readString();
        position = in.readString();
        education = in.readParcelable(Education.class.getClassLoader());
        course = in.readParcelable(Course.class.getClassLoader());
        gitHubUserName = in.readString();
    }

    public static final Creator<PortFolio> CREATOR = new Creator<PortFolio>() {
        @Override
        public PortFolio createFromParcel(Parcel in) {
            return new PortFolio(in);
        }

        @Override
        public PortFolio[] newArray(int size) {
            return new PortFolio[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getGitHubUserName() {
        return gitHubUserName;
    }

    public void setGitHubUserName(String gitHubUserName) {
        this.gitHubUserName = gitHubUserName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(position);
        parcel.writeParcelable(education, i);
        parcel.writeParcelable(course, i);
        parcel.writeString(gitHubUserName);
    }
}
