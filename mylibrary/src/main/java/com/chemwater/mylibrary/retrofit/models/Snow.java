
package com.chemwater.mylibrary.retrofit.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Snow implements Parcelable
{

    @SerializedName("3h")
    @Expose
    private Float _3h;
    public final static Creator<Snow> CREATOR = new Creator<Snow>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Snow createFromParcel(Parcel in) {
            return new Snow(in);
        }

        public Snow[] newArray(int size) {
            return (new Snow[size]);
        }

    }
    ;

    protected Snow(Parcel in) {
        this._3h = ((Float) in.readValue((Float.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Snow() {
    }

    /**
     * 
     * @param _3h
     */
    public Snow(Float _3h) {
        super();
        this._3h = _3h;
    }

    public Float get3h() {
        return _3h;
    }

    public void set3h(Float _3h) {
        this._3h = _3h;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(_3h);
    }

    public int describeContents() {
        return  0;
    }

}
