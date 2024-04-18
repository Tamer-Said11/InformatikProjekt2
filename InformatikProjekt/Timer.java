import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Timer extends Actor
{
    int _time;
    ICallable _callback;
    public Timer(int time,ICallable callback ){
        _time = time;
        _callback = callback;
    }
     
    public void act()
    {
        _time--;
        if (_time <= 0)
        {
            _callback.apply();
            ObjectCreater.instance.removeObject(this);

        }
    }
}
