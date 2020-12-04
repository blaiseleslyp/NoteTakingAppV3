package com.example.notetakingappv3;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")

public class Note
{
    @PrimaryKey
    private int id;
    private String title;
    @ColumnInfo(name = "note_column")
    private String notBody;

    private int priority;

    public Note(String title, String notBody, int priority) {
        this.title = title;
        this.notBody = notBody;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getNotBody() {
        return notBody;
    }

    public int getPriority() {
        return priority;
    }

    public void setId(int id) {
        this.id = id;
    }
}

