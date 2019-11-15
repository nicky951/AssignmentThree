package com.example.assignmentthree;

import java.util.ArrayList;
import java.util.List;

public class FavList {
    static public ArrayList<Cat> catlist = new ArrayList<>();

    public static void addCat(Cat cat) {

        catlist.add(cat);
    }

    public static void print() {
        for(int i =0; i < catlist.size(); i++) {
            System.out.println(catlist.get(i).getName());
        }
    }

    public static ArrayList<Cat> returnList(){
        return catlist;
    }
}
