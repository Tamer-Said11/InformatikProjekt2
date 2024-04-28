import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class DamageArea here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DamageArea extends Actor
{
    public List<Fighter> getIntersectingObjects(){
        return getIntersectingObjects(Fighter.class);
    }
}
