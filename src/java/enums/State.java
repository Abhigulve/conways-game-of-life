package enums;

public enum State implements StateI {
    LIVE() {
        @Override
        public State getNextState(int liveNeighbours) {
            if (liveNeighbours == 2 || liveNeighbours == 3) {
                return State.LIVE;
            } else return State.DEAD;
        }
    },
    DEAD() {
        @Override
        public State getNextState(int liveNeighbours) {
            if (liveNeighbours == 3) {
                return State.LIVE;
            }
            return this;
        }
    }
}
