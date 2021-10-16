package pl.adamd.movement;

public class Move {
    private int startingPoint;
    private int endPoint;
    private int lengthOfTheMovement;

    public int getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(int startingPoint) {
        this.startingPoint = startingPoint;
    }

    public int getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(int endPoint) {
        this.endPoint = endPoint;
    }

    public int getLengthOfTheMovement() {
        return lengthOfTheMovement;
    }

    public void setLengthOfTheMovement(int lengthOfTheMovement) {
        this.lengthOfTheMovement = lengthOfTheMovement;
    }

    public Move(int startingPoint, int endPoint, int lengthOfTheMovement) {
        this.startingPoint = startingPoint;
        this.endPoint = endPoint;
        this.lengthOfTheMovement = lengthOfTheMovement;
    }

    public int move(int startingPoint, int endPoint, int lengthOfTheMovement) {
        int distance = startingPoint + lengthOfTheMovement;
        int numOfMoves = 1;

        if (startingPoint == endPoint) {
            return 0;
        }
        while (distance < endPoint) {
            distance = distance + lengthOfTheMovement;
            numOfMoves += 1;
        }
        return numOfMoves;
    }
}
