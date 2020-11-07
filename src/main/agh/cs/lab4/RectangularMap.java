package agh.cs.lab4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RectangularMap implements IWorldMap{
    public Vector2d lowerLeft = new Vector2d(0,0);
    public Vector2d upperRight;
    public List<Animal> animals = new ArrayList<>();;

    public RectangularMap(int width, int height){
        this.upperRight = new Vector2d(width,height);
    }

    @Override
    public String toString() {
        return new MapVisualizer(this).draw(this.lowerLeft,this.upperRight);
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        if(!isOccupied(position) && position.follows(this.lowerLeft) && position.precedes(this.upperRight)) return true;
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        if(!isOccupied(animal.getPosition())){
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if(objectAt(position) != null) return true;
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal animal: this.animals){
            if(position.equals(animal.getPosition())) return animal;
        }
        return null;
    }

    public int getNumAnimals(){
        return this.animals.size();
    }

    public Animal getAnimalatIdx(int index){
        return this.animals.get(index);
    }

}
