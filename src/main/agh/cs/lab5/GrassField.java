package agh.cs.lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrassField extends AbstractWorldMap{
    private final int grassNum;
    private Vector2d lowerLeft;
    private Vector2d upperRight;
    private List<Grass> grassList = new ArrayList<>();

    public GrassField(int grassNumber){
        this.grassNum = grassNumber;
        placeGrass();
    }

    @Override
    public Vector2d getLLlimit(){
        countLimit();
        return this.lowerLeft;
    }
    @Override
    public Vector2d getURlimit(){
        return this.upperRight;
    }
    public void placeGrass(){
        Random rand = new Random();
        int maxRange = (int)Math.sqrt(this.grassNum * 10);
        int i = 0;
        while(i < this.grassNum){
            Vector2d newGrass = new Vector2d(rand.nextInt(maxRange),rand.nextInt(maxRange));
            if(! grassOccupied(newGrass)){
                this.grassList.add(new Grass(newGrass));
                i += 1;
            }
        }
    }
    public void countLimit(){
        Vector2d lowerLeftLimit = ((Animal)(this.animals.get(0))).getPosition();
        Vector2d upperRightLimit = ((Animal)(this.animals.get(0))).getPosition();
        for(Animal animal: this.animals){
            lowerLeftLimit = lowerLeftLimit.lowerLeft(animal.getPosition());
            upperRightLimit = upperRightLimit.upperRight(animal.getPosition());
        }
        for(Grass grass: this.grassList){
            lowerLeftLimit = lowerLeftLimit.lowerLeft(grass.getPosition());
            upperRightLimit = upperRightLimit.upperRight(grass.getPosition());
        }
        this.upperRight = upperRightLimit;
        this.lowerLeft = lowerLeftLimit;
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        if(animalOccupied(position)) return false;
        return true;
    }

    public boolean grassOccupied(Vector2d position) {
        for(Grass grass: this.grassList){
            if(position.equals(grass.getPosition())) return true;
        }
        return false;
    }


    @Override
    public Object objectAt(Vector2d position) {
        for(Animal animal: this.animals){
            if(position.equals(animal.getPosition())) return animal;
        }
        for(Grass grass: this.grassList){
            if(position.equals(grass.getPosition())) return grass;
        }
        return null;
    }



}
