package leetcode.Lyft;

/**
 * Created by cc on 2017/6/26.
 */
public class PlanetHits {

    public class Planet{
        int mass, direction;
        public Planet(int mass, int direction){
            this.mass = mass;
            this.direction = direction;
        }
    }

    public boolean solution(Planet[] plantes){
        int leftMaxMass = Integer.MIN_VALUE;
        for(int i = plantes.length - 1; i >= 0; i--){
            /**
             * if move right and mass is greater than left direction max mass, return true;
             * */
            if(plantes[i].direction == 1 && plantes[i].mass > leftMaxMass) return true;
            //if move left, update max left mass.
            if(plantes[i].direction == 0){
                leftMaxMass = Math.max(leftMaxMass, plantes[i].mass);
            }
        }
        return false;
    }

}
