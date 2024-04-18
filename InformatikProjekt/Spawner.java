import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spawner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spawner extends Actor
{
    boolean shouldSpawn = false;
    int actuel = 0;
    int actualTime;
    int targetTime;
    Actor[] _actors;
    /**
     * Act - do whatever the Spawner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(!shouldSpawn)
            return; 
        actualTime--;
        if(actualTime <= 0){
            ObjectCreater.instance.createObject(_actors[actuel],this.getX() + actuel * 10,this.getY() + actuel * 10);
            actuel++;;
            if(actuel == _actors.length){
                shouldSpawn = false;
                return;
            }
            actualTime = targetTime;
                
        }
    }
    
    public void spawn(Actor[] actors, int dur){
        _actors = actors;
        targetTime = dur;
        actualTime = dur;
        shouldSpawn = true;
    }
}
