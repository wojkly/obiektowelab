package agh.cs.lab5;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap{
    private Vector2d lowerLeft = new Vector2d(0,0);
    private Vector2d upperRight;

    public RectangularMap(int width, int height){
        this.upperRight = new Vector2d(width,height);
    }

    @Override
    public Vector2d getURlimit(){
        return this.upperRight;
    }
    @Override
    public Vector2d getLLlimit(){
        return this.lowerLeft;
    }
    @Override
    public boolean canMoveTo(Vector2d position){
        if(!isOccupied(position) && position.follows(this.lowerLeft) && position.precedes(this.upperRight)) return true;
        return false;
    }


    @Override
    public Object objectAt(Vector2d position) {
        for(Animal animal: this.animals){
            if(position.equals(animal.getPosition())) return animal;
        }
        return null;
    }

}
