package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'm'},
                {'l', 'a', 'g', 'r', 'o', 'o'},
                {'m', 'm', 'p', 'r', 'r', 'h'},
                {'p', 'e', 'e', 'e', 'j', 'j'}
        };
       // detectAllWords(crossword, "home", "same");

        for (Word  w : detectAllWords(crossword, "home", "same")) {
            System.out.println(w.toString());
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> wordsList = new ArrayList<>();
        String s = null;
        for (int l = 0; l < words.length; l++) {
            s = words[l];
            int wordLength = s.length();

            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[i].length; j++) {
                    if (crossword[i][j] == s.charAt(0)){

                        if(checkOn3Hours(crossword, i,j,s)) {
                            if(findWordOn3Hours(crossword, i,j,s) != null) {
                                wordsList.add(findWordOn3Hours(crossword, i,j,s));
                            }
                        }

                        if(checkOn3Hours(crossword, i,j,s) && checkOn6Hours(crossword, i,j,s)) {
                            if(findWordOn4Hours(crossword, i,j,s) != null) {
                                wordsList.add(findWordOn4Hours(crossword, i,j,s));
                            }
                        }

                        if(checkOn6Hours(crossword, i,j,s)) {
                            if(findWordOn6Hours(crossword, i,j,s) != null) {
                                wordsList.add(findWordOn6Hours(crossword, i,j,s));
                            }
                        }

                        if(checkOn6Hours(crossword, i,j,s) && checkOn9Hours(crossword, i,j,s)) {
                            if(findWordOn7Hours(crossword, i,j,s) != null) {
                                wordsList.add(findWordOn7Hours(crossword, i,j,s));
                            }
                        }

                        if(checkOn9Hours(crossword, i,j,s)) {
                            if(findWordOn9Hours(crossword, i,j,s) != null) {
                                wordsList.add(findWordOn9Hours(crossword, i,j,s));
                            }
                        }

                        if(checkOn9Hours(crossword, i,j,s) && checkOn12Hours(crossword, i,j,s)) {
                            if(findWordOn10Hours(crossword, i,j,s) != null) {
                                wordsList.add(findWordOn10Hours(crossword, i,j,s));
                            }
                        }

                        if(checkOn12Hours(crossword, i,j,s)) {
                            if(findWordOn12Hours(crossword, i,j,s) != null) {
                                wordsList.add(findWordOn12Hours(crossword, i,j,s));
                            }
                        }

                        if(checkOn12Hours(crossword, i,j,s) && checkOn3Hours(crossword, i,j,s)) {
                            if(findWordOn1Hours(crossword, i,j,s) != null) {
                                wordsList.add(findWordOn1Hours(crossword, i,j,s));
                            }
                        }
                    }
                }
            }
        }
        return wordsList;
    }

    private static Word findWordOn1Hours (int[][] crossword, int i, int j, String word) {
        int x1 = j, y1 = i, x2 = j, y2 = i;
        Word result = new Word(word);
        for (int z = 0; z < word.length(); z++ ) {
            if (!(word.charAt(z) == crossword[y2][x2])){
                return null;
            } --y2; ++x2;
            if (z==word.length()-1) {
                result.setStartPoint(x1,y1);
                result.setEndPoint(--x2,++y2);
                return result;
            }
        }
        return null;
    }

    private static Word findWordOn3Hours (int[][] crossword, int i, int j, String word) {
        int x1 = j, y1 = i, x2 = j, y2 = i;
        Word result = new Word(word);
        for (int z = 0; z < word.length(); z++ ) {
            if (!(word.charAt(z) == crossword[y2][x2])){
                return null;
            }
            ++x2;
            if (z==word.length()-1) {
                result.setStartPoint(x1,y1);
                result.setEndPoint(--x2,y2);
                return result;
            }
        }
        return null;
    }

    private static Word findWordOn4Hours (int[][] crossword, int i, int j, String word) {
        int x1 = j, y1 = i, x2 = j, y2 = i;
        Word result = new Word(word);
        for (int z = 0; z < word.length(); z++ ) {
            if (!(word.charAt(z) == crossword[y2][x2])){
                return null;
            } ++y2; ++x2;
            if (z==word.length()-1) {
                result.setStartPoint(x1,y1);
                result.setEndPoint(--x2,--y2);
                return result;
            }
        }
        return null;
    }

    private static Word findWordOn6Hours (int[][] crossword, int i, int j, String word) {
        int x1 = j, y1 = i, x2 = j, y2 = i;
        Word result = new Word(word);
        for (int z = 0; z < word.length(); z++ ) {
            if (!(word.charAt(z) == crossword[y2][x2])){
                return null;
            } ++y2;
            if (z==word.length()-1) {
                result.setStartPoint(x1,y1);
                result.setEndPoint(x2,--y2);
                return result;
            }
        }
        return null;
    }

    private static Word findWordOn7Hours (int[][] crossword, int i, int j, String word) {
        int x1 = j, y1 = i, x2 = j, y2 = i;
        Word result = new Word(word);
        for (int z = 0; z < word.length(); z++ ) {
            if (!(word.charAt(z) == crossword[y2][x2])){
                return null;
            } ++y2; --x2;
            if (z==word.length()-1) {
                result.setStartPoint(x1,y1);
                result.setEndPoint(++x2,--y2);
                return result;
            }
        }
        return null;
    }

    private static Word findWordOn9Hours (int[][] crossword, int i, int j, String word) {
        int x1 = j, y1 = i, x2 = j, y2 = i;
        Word result = new Word(word);
        for (int z = 0; z < word.length(); z++ ) {
            if (!(word.charAt(z) == crossword[y2][x2])){
                return null;
            } --x2;
            if (z==word.length()-1) {
                result.setStartPoint(x1,y1);
                result.setEndPoint(++x2,y2);
                return result;
            }
        }
        return null;
    }

    private static Word findWordOn10Hours (int[][] crossword, int i, int j, String word) {
        int x1 = j, y1 = i, x2 = j, y2 = i;
        Word result = new Word(word);
        for (int z = 0; z < word.length(); z++ ) {
            if (!(word.charAt(z) == crossword[y2][x2])){
                return null;
            } --y2; --x2;
            if (z==word.length()-1) {
                result.setStartPoint(x1,y1);
                result.setEndPoint(++x2,++y2);
                return result;
            }
        }
        return null;
    }

    private static Word findWordOn12Hours (int[][] crossword, int i, int j, String word) {
        int x1 = j, y1 = i, x2 = j, y2 = i;
        Word result = new Word(word);
        for (int z = 0; z < word.length(); z++ ) {
            if (!(word.charAt(z) == crossword[y2][x2])){
                return null;
            } --y2;
            if (z==word.length()-1) {
                result.setStartPoint(x1,y1);
                result.setEndPoint(x2,++y2);
                return result;
            }
        }
        return null;
    }



    private static boolean checkOn3Hours (int[][] crossword, int i, int j, String word) {
        if(j + word.length() <= crossword[i].length) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkOn6Hours (int[][] crossword, int i, int j, String word) {
        if(i + word.length() <= crossword.length) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkOn9Hours (int[][] crossword, int i, int j, String word) {
        if(j + 1 - word.length() >= 0) {
            return true;
        } else {
            return false;
        }
    }


    private static boolean checkOn12Hours (int[][] crossword, int i, int j, String word) {
        if(i + 1 - word.length() >= 0) {
            return true;
        } else {
            return false;
        }
    }




    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
