import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SettingWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SettingWorld extends World
{

    /**
     * Constructor for objects of class SettingWorld.
     * 
     */
    public SettingWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
                addObject(
        new Button(
            () -> {
                Greenfoot.setWorld(new GameWorld(Data.Difficulties.EASY));    
            })
        ,140 , 200);
        
        addObject(
            new Button(
            () -> {
                Greenfoot.setWorld(new GameWorld(Data.Difficulties.NORMAL));    
            })
        ,300 , 200);
        
        addObject(
            new Button(
            () -> {
                Greenfoot.setWorld(new GameWorld(Data.Difficulties.HARD));    
            })
        ,460 , 200);
    }
}
