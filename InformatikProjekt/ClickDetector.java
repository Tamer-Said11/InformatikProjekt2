import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ClickDetector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClickDetector extends Actor
{
    private String _key;
    private ICallable _callback;
    
    public ClickDetector(String key, ICallable callback){
        _key = key;
        _callback = callback;
    }
    public void act()
    {
        if(Greenfoot.isKeyDown(_key)){
            _callback.apply();
        }
    }
}
