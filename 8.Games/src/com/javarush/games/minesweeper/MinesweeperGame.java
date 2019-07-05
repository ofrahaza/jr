package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;

import java.util.ArrayList;

public class MinesweeperGame extends Game {
    private static final int SIDE = 15;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField = 0, countFlags = 0, countClosedTiles = SIDE*SIDE;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private boolean isGameStopped;
    private int score = 0;

    private void countMineNeighbors() {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                ArrayList<GameObject> neighborsCountCurrent = new ArrayList<>();
                if (!gameField[i][j].isMine) {
                    neighborsCountCurrent = getNeighbors(gameField[i][j]);
                    for (GameObject gameObject : neighborsCountCurrent) {
                        if (gameObject.isMine) gameField[i][j].countMineNeighbors++;
                    }
                }
            }
        }
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        if (!isGameStopped) {
          openTile(x, y);
        } else {
            restart();
        }
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x,y);
    }

    private void markTile(int x, int y) {
        if (!isGameStopped) {
            if (!gameField[y][x].isOpen && countFlags != 0 & !gameField[y][x].isFlag) {
                gameField[y][x].isFlag = true;
                countFlags--;
                setCellColor(x, y, Color.YELLOW);
                setCellValue(x, y, FLAG);

            } else if (gameField[y][x].isFlag) {
                gameField[y][x].isFlag = false;
                countFlags++;
                setCellColor(x, y, Color.ORANGE);
                setCellValue(x, y, "");


            }
        }
    }

    private void openTile(int x, int y) {
        if (!gameField[y][x].isOpen && !gameField[y][x].isFlag && !isGameStopped) {
            if (gameField[y][x].countMineNeighbors == 0 && !gameField[y][x].isMine) {
                gameField[y][x].isOpen = true;
                setCellColor(x, y, Color.GREEN);
                setCellValue(x, y, "");
                countClosedTiles--;
                score += 5;
                setScore(score);
                if (countClosedTiles == countMinesOnField) win();
                for (GameObject object : getNeighbors(gameField[y][x])) {
                    if (!object.isOpen) {
                        openTile(object.x, object.y);
                    }
                }
            } else if (!gameField[y][x].isMine && gameField[y][x].countMineNeighbors != 0) {
                gameField[y][x].isOpen = true;
                setCellColor(x, y, Color.GREEN);
                setCellNumber(x, y, gameField[y][x].countMineNeighbors);
                countClosedTiles--;
                score += 5;
                setScore(score);
                if (countClosedTiles == countMinesOnField) win();
            } else {
                gameField[y][x].isOpen = true;
                setCellValueEx(x, y, Color.RED, MINE);
                gameOver();
            }
        }
    }

    private ArrayList<GameObject> getNeighbors(GameObject object) {
        ArrayList<GameObject> mineCount = new ArrayList<>();
        GameObject gameObject = object;
        int i = gameObject.y;
        int j = gameObject.x;
        if (i != 0) mineCount.add(gameField[i-1][j]);
        if (i != SIDE-1) mineCount.add(gameField[i+1][j]);
        if (j != 0) mineCount.add(gameField[i][j-1]);
        if (j != SIDE-1) mineCount.add(gameField[i][j+1]);
        if (i != SIDE-1 && j != SIDE-1) mineCount.add(gameField[i+1][j+1]);
        if (i != SIDE-1 && j != 0) mineCount.add(gameField[i+1][j-1]);
        if (i != 0 && j != SIDE-1) mineCount.add(gameField[i-1][j+1]);
        if (i != 0 && j != 0) mineCount.add(gameField[i-1][j-1]);

        return mineCount;
    }


    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        setScore(score);
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                boolean isMine = false;
                if (getRandomNumber(10) == 1 || getRandomNumber(10) == 2) {
                    isMine = true;
                    countMinesOnField++;
                }
                gameField[i][j] = new GameObject(j,i, isMine);
                setCellValue(j, i, "");
                setCellColor(i, j, Color.ORANGE);
            }
        }
        countFlags = countMinesOnField;
        countMineNeighbors();
    }

    private void gameOver() {
        showMessageDialog(Color.BLACK, "LOSER! HAHAHAHAHA!", Color.RED, 30);
        isGameStopped = true;
    }

    private void win() {
        showMessageDialog(Color.BLACK, "Повезло просто...", Color.GREEN, 10);
        isGameStopped = true;
    }

    private void restart() {
        isGameStopped = false;
        score = 0;
        setScore(score);
        countClosedTiles = SIDE*SIDE;
        countMinesOnField = 0;
        createGame();
    }
}
