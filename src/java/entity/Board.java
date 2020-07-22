package entity;


import enums.State;
import rules.Rule;
import strategy.GameStrategy;

import java.util.HashSet;
import java.util.Set;

public class Board {

    private Set<Cell> activeCellsOnBoard;
    private Set<Cell> nextGenerationCell;
    private final GameStrategy gameStrategy;

    public Set<Cell> getNextGenerationCell() {
        if (nextGenerationCell == null) {
            nextGenerationCell = new HashSet<>();
        }
        return nextGenerationCell;
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
        Set<Cell> nextGenerationCell = getNextGenerationCell();
        return getActiveCells(nextGenerationCell);
    }

    private Set<Cell> getActiveCells(Set<Cell> cells) {
        cells.removeIf(cell -> State.DEAD.equals(cell.getState()));
        return cells;
    }

    public Board(GameStrategy gameStrategy) {
        this.activeCellsOnBoard = new HashSet<>();
        this.gameStrategy = gameStrategy;
    }

    public Set<Cell> findNeighbours(Cell cell) {
        HashSet<Cell> neighbours = new HashSet<>();
        int x = cell.getX();
        int y = cell.getY();
        Cell tempCell;
        for (int i = x - 1; i <= x + 1; i++) {
            if (i < 0) continue;
            for (int j = y - 1; j <= y + 1; j++) {
                if (j < 0) continue;
                tempCell = new Cell(i, j);
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

    public void processCell(Cell cell) {
        if (getNextGenerationCell().contains(cell))
            return;
        cell = cell.createCopy();
        cell.setState(getState(cell));
        getNextGenerationCell().add(cell);
    }

    private State getState(Cell cell) {
        State nextState = null;
        for (Rule rule : gameStrategy.getRules()) {
            nextState = rule.nextState(cell.getState(), findLiveNeighbourCount(cell));
            if (!cell.getState().equals(nextState)) {
                break;
            }
        }
        return nextState;
    }

    public int findLiveNeighbourCount(Cell cell) {
        int count = 0;
        for (Cell c : findNeighbours(cell)) {
            if (State.LIVE.equals(c.getState())) count++;
        }
        return count;
    }


    public Set<Cell> applyGameRules() {
        Set<Cell> neighbouringCells;
        for (Cell cellFromCurrentGeneration : activeCellsOnBoard) {
            processCell(cellFromCurrentGeneration);
            neighbouringCells = findNeighbours(cellFromCurrentGeneration);
            for (Cell neighbouringCell : neighbouringCells) {
                processCell(neighbouringCell);
            }
        }
        return filterDead();
    }
}
