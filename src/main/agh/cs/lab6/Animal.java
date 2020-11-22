package agh.cs.lab6;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private IWorldMap map;
    private Vector2d initialPosition;
    private MapDirection orientation;
    private Vector2d position;
    private ArrayList<IPositionChangeObserver> observers = new ArrayList<>();

    public Animal(IWorldMap map){
        this.map = map;
        this.initialPosition = (new Vector2d(0,0));
        this.orientation = MapDirection.NORTH;
        this.position = initialPosition;
    }
    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.initialPosition = initialPosition;
        this.orientation = MapDirection.NORTH;
        this.position = initialPosition;
    }

    public String toString(){
        switch(this.orientation){
            case SOUTH: return "S";
            case NORTH: return "N";
            case WEST: return "W";
            case EAST: return "E";
            default: return null;
        }
    }
    //observers
    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }
    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for(IPositionChangeObserver observer: observers){
            observer.positionChanged(oldPosition,newPosition);
        }
    }
    //
    public void move(MoveDirection direction){
        Vector2d oldPosition = new Vector2d(position.x, position.y);
        if(direction.equals(MoveDirection.RIGHT)) {
            orientation = orientation.next();
        }else if(direction.equals(MoveDirection.LEFT)) {
            orientation = orientation.previous();
        }
        else if(direction.equals(MoveDirection.FORWARD) || direction.equals(MoveDirection.BACKWARD)) {

            Vector2d nextPosition = new Vector2d(position.x, position.y);
            if (direction.equals(MoveDirection.FORWARD)) {
                nextPosition = nextPosition.add(orientation.toUnitVector());
            } else {
                nextPosition = nextPosition.add(orientation.toUnitVector().opposite());
            }
            if (this.map.canMoveTo(nextPosition))
                position = nextPosition;
                positionChanged(oldPosition,position);
        }
    }

    public Vector2d getPosition() {
        return position;
    }
}
