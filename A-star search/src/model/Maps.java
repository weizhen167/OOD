package model;


import java.util.Random;

public class Maps {

    public static int[][] MAP;

    public static boolean buildmap(int x, int y) {
        Random rand = new Random();
        int[][] xl = new int[x][y];
        int[] yl = new int[y];
        int ii = 0;
        while (ii < x) {
            int i = 0;
            yl = new int[y];
            while (i < y) {
                int tt = rand.nextInt(4);
                if (tt != 3) {
                    if (ii % 2 == 0 && i % 2 == 0) {
                        yl[i] = 0;
                    }
                    if (ii % 2 == 0 && i % 2 == 1) {
                        yl[i] = 1;
                    }
                    if (ii % 2 == 1 && i % 2 == 0) {
                        yl[i] = 1;
                    }
                    if (ii % 2 == 1 && i % 2 == 1) {
                        yl[i] = 0;
                    }
                }
                if (tt == 3) {
                    int tt1 = rand.nextInt(4);
                    if(tt1 == 0){
                        yl[i] = 2;
                    }
                    if(tt1 == 1){
                        yl[i] = 3;
                    }
                    if(tt1 == 2){
                        yl[i] = 4;
                    }
                    if(tt1 == 3){
                        yl[i] = 5;
                    }
                    if(tt1 == 4){
                        yl[i] = 6;
                    }                
                }
                
                i = i + 1;
            }
            xl[ii] = yl;
            ii = ii + 1;
        }
        MAP = xl;
        return true;
    }
}
