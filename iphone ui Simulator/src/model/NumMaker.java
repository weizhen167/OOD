package model;

import java.util.ArrayList;
import java.util.Random;

public class NumMaker {

    private int kk = 0;

    public NumMaker(int i) {
        this.kk = i;
    }

    public ArrayList<Integer> mk200plus() {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i = 200;
        while (i < kk) {
            int number = random.nextInt(kk / 2) + 200;
            if (!list.contains(number)) {
                list.add(number);
                i++;
            }
        }
        return list;
    }

    public ArrayList<Integer> mk200m() {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i = 0;
        while (i < kk / 2) {
            int number = random.nextInt(kk / 2) + 1;
            if (!list.contains(number)) {
                list.add(number);
                i++;
            }
        }
        return list;
    }

    public ArrayList<Integer> mkUniqueArray() {
        ArrayList<Integer> list = new ArrayList<Integer>(mk200m());
        list.addAll(mk200plus());
        return list;
    }
}
