package ca.qc.vc.week6.lesson18;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BTMissionariesCannibals {

    static final int TOTAL_M = 3;
    static final int TOTAL_C = 3;

    // Possible passengers in the boat:
    // {missionaries, cannibals}
    static final int[][] MOVES = {
            {0, 2},   // 2 cannibals
            {0, 1},   // 1 cannibal
            {2, 0},   // 2 missionaries
            {1, 1},   // 1 missionary + 1 cannibal
            {1, 0}    // 1 missionary
    };

    static class State {
        int mLeft;
        int cLeft;
        boolean boatLeft;

        State(int mLeft, int cLeft, boolean boatLeft) {
            this.mLeft = mLeft;
            this.cLeft = cLeft;
            this.boatLeft = boatLeft;
        }

        @Override
        public String toString() {
            return "(" + mLeft + ", " + cLeft + ", "
                    + (boatLeft ? "Left" : "Right") + ")";
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof State)) {
                return false;
            }

            State other = (State) obj;

            return mLeft == other.mLeft
                    && cLeft == other.cLeft
                    && boatLeft == other.boatLeft;
        }

        @Override
        public int hashCode() {
            return mLeft * 100
                    + cLeft * 10
                    + (boatLeft ? 1 : 0);
        }
    }

    // Check whether a state is safe
    static boolean isValid(State state) {

        int mLeft = state.mLeft;
        int cLeft = state.cLeft;

        // Number of people must be within valid range
        if (mLeft < 0 || mLeft > TOTAL_M ||
                cLeft < 0 || cLeft > TOTAL_C) {
            return false;
        }

        int mRight = TOTAL_M - mLeft;
        int cRight = TOTAL_C - cLeft;

        // Left bank:
        // cannibals cannot outnumber missionaries
        if (mLeft > 0 && cLeft > mLeft) {
            return false;
        }

        // Right bank
        if (mRight > 0 && cRight > mRight) {
            return false;
        }

        return true;
    }

    static boolean isGoal(State state) {
        return state.mLeft == 0
                && state.cLeft == 0
                && !state.boatLeft;
    }

    static boolean solve(State current,
                         Set<State> onPath,
                         List<State> path) {

        // Base case
        if (isGoal(current)) {
            return true;
        }

        // Try every possible boat move
        for (int[] move : MOVES) {

            int missionaries = move[0];
            int cannibals = move[1];

            State next;

            // Boat moves from left to right
            if (current.boatLeft) {

                next = new State(
                        current.mLeft - missionaries,
                        current.cLeft - cannibals,
                        false
                );

            } else {

                // Boat moves from right to left
                next = new State(
                        current.mLeft + missionaries,
                        current.cLeft + cannibals,
                        true
                );
            }

            // Check whether this choice is allowed
            if (isValid(next) && !onPath.contains(next)) {

                // Choose
                onPath.add(next);
                path.add(next);

                // Explore
                if (solve(next, onPath, path)) {
                    return true;
                }

                // Backtrack
                path.remove(path.size() - 1);
                onPath.remove(next);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        State start = new State(3, 3, true);

        Set<State> onPath = new HashSet<>();
        List<State> path = new ArrayList<>();

        onPath.add(start);
        path.add(start);

        if (solve(start, onPath, path)) {

            System.out.println("Solution found:");

            for (State state : path) {
                System.out.println(state);
            }

        } else {
            System.out.println("No solution.");
        }
    }
}