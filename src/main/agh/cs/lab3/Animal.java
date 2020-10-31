package agh.cs.lab2;

public class Animal {
    static final int MIN_X = 0;
    static final int MAX_X = 4;
    static final int MIN_Y = 0;
    static final int MAX_Y = 4;

    private MapDirection orientation;
    private Vector2d position;

    public Animal(){
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
    }
    public String toString(){
        return "pos_x: " + this.position.x + " pos_y: " + this.position.y + " orientation: " + orientation;
    }
    public boolean possibleMove(boolean forward){
        Vector2d v1 = new Vector2d(this.position.x, this.position.y);
        if (forward){
            v1 = v1.add(orientation.toUnitVector());
        } else{
            v1 = v1.add(orientation.toUnitVector().opposite());
        }
        if(v1.follows(new Vector2d(0,0)) && v1.precedes(new Vector2d(4,4)))
            return true;
        return false;

    }

    public void move(MoveDirection direction){
        switch(direction){
            case RIGHT:
                orientation = orientation.next();
                break;
            case LEFT:
                orientation = orientation.previous();
                break;
            case FORWARD:
//                Vector2d v1 = new Vector2d(this.position.x, this.position.y);
//                v1 = v1.add(orientation.toUnitVector());
//                if(v1.follows(new Vector2d(0,0)) && v1.precedes(new Vector2d(4,4)))
//                    position = position.add(orientation.toUnitVector());
                if (possibleMove(true))
                    position = position.add(orientation.toUnitVector());
                break;
            case BACKWARD:
//                Vector2d v2 = new Vector2d(this.position.x, this.position.y);
//                v2 = v2.add(orientation.toUnitVector().opposite());
//                if(v2.follows(new Vector2d(0,0)) && v2.precedes(new Vector2d(4,4)))
//                    position = position.add(orientation.toUnitVector().opposite());
                if (possibleMove(false))
                    position = position.add(orientation.toUnitVector().opposite());
                break;
        }
    }
}
