package solutions.week6.lesson18;

public class Lab2DiceRollEnumeration {

    public static int enumerateDiceRolls(
            int numberOfDice, int numberOfSides) {

        if (numberOfDice <= 0 || numberOfSides <= 0) {
            throw new IllegalArgumentException(
                    "The number of dice and sides must be positive."
            );
        }

        int[] currentOutcome = new int[numberOfDice];

        return backtrack(
                currentOutcome,
                0,
                numberOfSides
        );
    }

    private static int backtrack(
            int[] currentOutcome,
            int diceIndex,
            int numberOfSides) {

        // Base case: all dice have been assigned
        if (diceIndex == currentOutcome.length) {
            printOutcome(currentOutcome);
            return 1;
        }

        int outcomeCount = 0;

        for (int face = 1; face <= numberOfSides; face++) {
            // Choose
            currentOutcome[diceIndex] = face;

            // Explore
            outcomeCount += backtrack(
                    currentOutcome,
                    diceIndex + 1,
                    numberOfSides
            );

            // Undo the choice
            currentOutcome[diceIndex] = 0;
        }

        return outcomeCount;
    }

    private static void printOutcome(int[] outcome) {
        for (int value : outcome) {
            System.out.print(value + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int numberOfDice = 2;
        int numberOfSides = 6;

        int totalOutcomes = enumerateDiceRolls(
                numberOfDice,
                numberOfSides
        );

        System.out.println(
                "Total outcomes: " + totalOutcomes
        );
    }
}