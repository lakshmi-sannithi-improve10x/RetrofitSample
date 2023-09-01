package com.improve10x.retrofitsample;

import com.google.gson.annotations.SerializedName;

public class TodoItem {
    @SerializedName("_id")
    public String id;
    public String task;
    public String description;
}
