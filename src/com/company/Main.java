package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> name = new ArrayList<>();
        ArrayList<Integer> height = new ArrayList<>();

        // read data from file
        try {
            System.setProperty("file.encoding", "UTF8");
            FileReader file = new FileReader("hegy.txt");
            LineNumberReader lnr = new LineNumberReader(file);
            String line;

            while((line = lnr.readLine()) != null) {
                int ln = lnr.getLineNumber();
                if (ln % 2 == 0) height.add(Integer.parseInt(line));
                else name.add(line);
            }

            file.close();
            lnr.close();
        } catch (IOException e) {
            System.out.println("Can't find the file! " + e);
        }

        // loop through mountains and calculate some stats
        int maxHeight = 0; int sumHeight = 0; int countHeight = 0;
        for (Integer aHeight : height) {

            // get the tallest mountain
            if (aHeight > maxHeight) maxHeight = aHeight;

            // get the average height
            sumHeight += aHeight;

            // count mountains where height > 8000
            if (aHeight > 8000) countHeight++;

        }
        String maxName = name.get(height.indexOf(maxHeight));
        double avgHeight = sumHeight / height.size();

        System.out.println("Tallest mountain: " + maxName + ", " + maxHeight + "m");
        System.out.println("Average height of the mountains: " + avgHeight);
        System.out.println("Number of mountains where height > 8000: " + countHeight);

    }
}
