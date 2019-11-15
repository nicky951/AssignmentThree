package com.example.assignmentthree;

import java.util.List;

public class CatResponse {

    public String name;
    public CatList results;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }
    public CatList getResults() {
        return results;
    }
}

