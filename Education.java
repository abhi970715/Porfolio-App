package com.example.myfirstapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Education implements Parcelable {
    private String name;
    private String degree;
    private String year;

    public Education(String name, String degree, String year) {
        this.name = name;
        this.degree = degree;
        this.year = year;
    }

    protected Education(Parcel in) {
        name = in.readString();
        degree = in.readString();
        year=in.readString();
    }

    public static final Creator<Education> CREATOR = new Creator<Education>() {
        @Override
        public Education createFromParcel(Parcel in) {
            return new Education(in);
        }

        @Override
        public Education[] newArray(int size) {
            return new Education[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(degree);
        parcel.writeString(year);
    }
}
