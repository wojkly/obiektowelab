package agh.cs.lab6;

import java.util.*;

public class GrassField extends AbstractWorldMap{
    private final int grassNum;
    private Vector2d lowerLeft;
    private Vector2d upperRight;
    private Map<Vector2d,Grass> grassList = new HashMap<>();

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
            if(! grassList.containsKey(newGrass)){
                this.grassList.put(newGrass,new Grass(newGrass) );
                i += 1;
            }
        }
    }
    public void countLimit(){
        Animal[] animalPos = animals.values().toArray(new Animal[0]);
        Grass[] grassPos = grassList.values().toArray(new Grass[0]);

        Vector2d lowerLeftLimit = animalPos[0].getPosition();
        Vector2d upperRightLimit = animalPos[0].getPosition();

        for(int i = 1; i < animalPos.length; i+= 1){
            lowerLeftLimit = lowerLeftLimit.lowerLeft(animalPos[i].getPosition());
            upperRightLimit = upperRightLimit.upperRight(animalPos[i].getPosition());
        }
        for(int i = 0; i < grassPos.length; i+= 1){
            lowerLeftLimit = lowerLeftLimit.lowerLeft(grassPos[i].getPosition());
            upperRightLimit = upperRightLimit.upperRight(grassPos[i].getPosition());
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
            if(grassList.containsKey(position)) return true;
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        if(animals.containsKey(position)) return animals.get(position);
        if(grassList.containsKey(position)) return grassList.get(position);
        return null;
    }

}
