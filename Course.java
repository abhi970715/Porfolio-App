package com.example.myfirstapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Course implements Parcelable {
private String org;
private String year;
private String degree;

    public Course(String org, String year, String degree) {
        this.org = org;
        this.year = year;
        this.degree = degree;
    }

    protected Course(Parcel in) {
        org = in.readString();
        year = in.readString();
        degree = in.readString();
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

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(org);
        parcel.writeString(year);
        parcel.writeString(degree);
    }
}
