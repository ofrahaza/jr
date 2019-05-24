package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    private static int count;
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {1, 0, 1, 1},
                {1, 0, 0, 0}
        };
        byte[][] a3 = new byte[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1);
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2);
        int count3 = getRectangleCount(a3);
        System.out.println("count = " + count3);

        //new int[]{0,3,0,1}

        //a1 = changeNumbers(findCoordinates(a2, 3,0), a2);
        /*
        for (int x = 0; x < a2.length; x++) {
            System.out.println();
            for (int y = 0; y < a2[x].length; y++) {
                System.out.print(a2[x][y] + " ");
            }
        }
        System.out.println();*/
    }

    public static int getRectangleCount(byte[][] a) {
        count = 0;
        //byte[][] b;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if(a[i][j] == 1) {
                  /*

                  for (int x = 0; x < a.length; x++) {
                        System.out.println();
                        for (int y = 0; y < a[x].length; y++) {
                            System.out.print(a[x][y] + " ");
                        }
                    }
                    System.out.println();

                   */
                    a = changeNumbers(findCoordinates(a, i, j), a);
                    count++;

                }
            }
        }

        return count;
    }

    private static byte[][] changeNumbers(int[] coordinates, byte[][] a) {
        for (int i = coordinates[0]; i <= coordinates[1]; i++) {
            for (int j = coordinates[2]; j <= coordinates[3]; j++) {
                a[i][j] = 0;
            }
        }
        return a;
    }

    private static int[] findCoordinates(byte[][] a, int startI, int startJ) {
        int endI = startI;
        int endJ = startJ;
        int coordinates[] = new int[4];
        int tempI = -1;

        for (int i = startI; i < a.length; i++) {
            if (endI == tempI) break;
            for (int j = startJ; j < a[i].length; j++) {
                if (a[i][j] == 0 && j == startJ) {
                    endI = i-1; tempI = i-1;
                    break;
                } else if (a[i][j] == 0 && j != startJ) {
                    endJ = j-1;
                    break;
                } else if (a[i][j] == 1 && i == a.length - 1) {
                    endI = i; tempI = i-1;
                    break;
                } else if (a[i][j] == 1 && j == a[i].length - 1) {
                    endJ = j;
                    break;
                }

            }
        }
        coordinates[0] = startI;
        coordinates[1] = endI;
        coordinates[2] = startJ;
        coordinates[3] = endJ;
        return coordinates;
    }
}
