package pl.adamd.movement;

public class Move {
    private int startingPoint;
    private int endPoint;
    private int lengthOfTheMovement;
    private int numOfMoves = 1;

    public int getStartingPoint() {
        return startingPoint;
    }

    public int getEndPoint() {
        return endPoint;
    }


    public int getLengthOfTheMovement() {
        return lengthOfTheMovement;
    }


    public Move(int startingPoint, int endPoint, int lengthOfTheMovement) {
        this.startingPoint = startingPoint;
        this.endPoint = endPoint;
        this.lengthOfTheMovement = lengthOfTheMovement;
    }

    public int moveForward(int startingPoint, int endPoint, int lengthOfTheMovement) {
        int distance = startingPoint + lengthOfTheMovement;

        if (startingPoint >= endPoint || lengthOfTheMovement == 0) {
            return 0;
        }
        while (distance < endPoint) {
            distance = distance + lengthOfTheMovement;
            numOfMoves += 1;
        }
        return numOfMoves;
    }
}
