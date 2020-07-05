package com.km;

import java.io.File;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String path = "C:\\Users\\Administrator\\Desktop\\output";
        File file = new File(path);
        changeFileName(file.getPath());
    }

    private static void changeFileName(String path) {
        File file = new File(path);
        File[] array = file.listFiles();
        for (int i = 0; i < array.length; i++) {
            String name = array[i].getName();
            String suffix = name.substring(name.lastIndexOf('.')+1);
            if(suffix.equals("jpg")||suffix.equals("png")){
                Date date = new Date();
                array[i].setLastModified(date.getTime());
            }
        }
    }
}
