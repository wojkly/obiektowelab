package agh.cs.lab7;

import java.util.*;

public class GrassField extends AbstractWorldMap{
    private final int grassNum;
    private Map<Vector2d,Grass> grassList = new HashMap<>();

    public GrassField(int grassNumber){
        this.grassNum = grassNumber;
        this.mapBoundary = new MapBoundary();
        placeGrass();
    }

    public void placeGrass(){
        Random rand = new Random();
        int maxRange = (int)Math.sqrt(this.grassNum * 10);

        int i = 0;
        while(i < this.grassNum){
            Vector2d newGrass = new Vector2d(rand.nextInt(maxRange),rand.nextInt(maxRange));
            if(! grassList.containsKey(newGrass)){
                Grass g = new Grass(newGrass);
                this.grassList.put(newGrass,g );
                mapBoundary.addElement(newGrass);
                i += 1;
            }
        }
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
