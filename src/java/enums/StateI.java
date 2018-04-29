package enums;

interface StateI {
    State getNextState(int liveNeighbours);
}