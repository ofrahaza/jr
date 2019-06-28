package com.javarush.task.task21.Hippodrome;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    public Hippodrome(List horses) {
        this.horses = horses;
    }
    public static Hippodrome game;
    public List<Horse> horses = new ArrayList<>();

    public static void main(String args[]) throws InterruptedException {
        game = new Hippodrome(new ArrayList());
        game.horses.add(new Horse("Lucky", 3, 0));
        game.horses.add(new Horse("Silver", 3, 0));
        game.horses.add(new Horse("Popcorn", 3, 0));
        game.run();
        game.printWinner();
    }

    public List<Horse> getHorses() {
        return horses;
    }
    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }
    
    public void move() {
        for (Horse h : horses) {
            h.move();
        }
    }

    public void print() {
        for (Horse h : horses) {
            h.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }

    }

    public Horse getWinner() {
        double distance = 0;
        Horse winnerHorse = new Horse("new",0,0);
        for (Horse h : horses) {
            if(h.getDistance() > distance) {
                distance = h.getDistance();
                winnerHorse = h;
            }
        }
        return winnerHorse;
    }

    public void printWinner() {
        System.out.println("Winner is "+getWinner().getName()+"!");
    }
}
