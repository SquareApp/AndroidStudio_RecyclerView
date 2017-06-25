package com.squareapp.android_training;

/**
 * Created by Valentin Purrucker on 22.06.2017.
 */

public class MyObject
{

    private String task;
    private String description;
    private String date;


    public MyObject(String task, String description, String date)
    {
        setTask(task);
        setDescription(description);
        setDate(date);
    }


    public String getTask()
    {
        return task;
    }

    public void setTask(String task)
    {
        this.task = task;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String hobby)
    {
        this.description = hobby;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
