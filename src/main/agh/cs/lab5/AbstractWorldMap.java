package agh.cs.lab5;

import java.util.ArrayList;
import java.util.List;

abstract public class AbstractWorldMap implements IWorldMap {
    protected List<Animal> animals = new ArrayList<>();

    public String toString() {
        return new MapVisualizer(this).draw( getLLlimit(), getURlimit() );
    }

    abstract public Vector2d getLLlimit();
    abstract public Vector2d getURlimit();


    @Override
    abstract public boolean canMoveTo(Vector2d position);

    @Override
    public boolean place(Animal animal) {
        if(!animalOccupied(animal.getPosition())){
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

    public boolean animalOccupied(Vector2d position) {
        for(Animal animal: this.animals){
            if(position.equals(animal.getPosition())) return true;
        }
        return false;
    }
    @Override
    abstract public Object objectAt(Vector2d position);

    public int getNumAnimals(){
        return this.animals.size();
    }

    public Animal getAnimalatIdx(int index){
        return this.animals.get(index);
    }

}
