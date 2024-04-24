import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    //Später sollen sich alle daten hier ändern lassen
    public GameWorld(Data.Difficulties diff)
    {    

        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        Greenfoot.setSpeed(50);
        addObject(new ObjectCreater(this), 0, 0);
        
        addObject(new Player(), 300, 200);
        new WaveManager();
    }
        public GameWorld()
    {    

        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        Greenfoot.setSpeed(50);
        addObject(new ObjectCreater(this), 0, 0);
        
        addObject(new Player(), 300, 200);
        new WaveManager();
    }
}
