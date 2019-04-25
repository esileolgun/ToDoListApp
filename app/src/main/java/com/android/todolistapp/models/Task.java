package com.android.todolistapp.models;

import java.io.Serializable;

public class Task {

    boolean status;
    String taskName;


    public Task(boolean status, String taskName) {
        this.status = status;
        this.taskName = taskName;
    }

    public Task(String taskName) {
        this.taskName=taskName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
