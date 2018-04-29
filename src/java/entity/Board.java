package entity;


import enums.State;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Board {

    private Set<Cell> activeCellsOnBoard;
    private Set<Cell> nextGenrationCell;



    public Set<Cell> getNextGenrationCell() {
        if (nextGenrationCell == null) {
            nextGenrationCell = new HashSet<>();
        }
        return nextGenrationCell;
    }

    /**
     * @return the activeCellsOnBoard
     */
    public Set<Cell> getActiveCellsOnBoard() {
        return activeCellsOnBoard;
    }

    /**
     * @param activeCells the single cell
     */
    public void setActiveCellsOnBoard(Set<Cell> activeCells) {
        this.activeCellsOnBoard = getActiveCells(activeCells);
    }
    public Set<Cell> filterDead() {
        Set<Cell> nextGenrationCell = getNextGenrationCell();

        return getActiveCells(nextGenrationCell);
    }
    private Set<Cell> getActiveCells(Set<Cell> cells) {
        Iterator<Cell> iterator = cells.iterator();
        while (iterator.hasNext()) {
            if (State.DEAD.equals(iterator.next().getState())) {
                iterator.remove();
            }
        }
        return cells;
    }

    public Board() {
        this.activeCellsOnBoard = new HashSet<>();
    }

    public Set<Cell> findNeighbours(Cell cell) {
        HashSet<Cell> neighbours = new HashSet<Cell>();
        int x = cell.getX();
        int y = cell.getY();
        Cell tempCell;
        for (int i = x - 1; i <= x + 1; i++) {
            if (i < 0) continue;

            for (int j = y - 1; j <= y + 1; j++) {
                if (j < 0) continue;

                tempCell = new Cell(i, j);

                //bug fix : self neighbour
                if (tempCell.equals(cell)) {
                    continue;
                }
                if (activeCellsOnBoard.contains(tempCell)) {
                    tempCell.setState(State.LIVE);
                }
                neighbours.add(tempCell);
            }
        }

        return neighbours;
    }
}
