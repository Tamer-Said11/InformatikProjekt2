import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Experience here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Experience extends Actor
{
        private Player target;
        private SimpleTimer timer;
        
    private int amount;
    private int range = 100;
    private int cooldown = 10;
    public Experience(int amount, Player _target){
        amount = amount;
        target = _target;
        timer = new SimpleTimer();
        timer.mark();
    }
    
    public void act(){
        if(timer.millisElapsed() > cooldown * 1000){
            ObjectCreater.instance.removeObject(this);
            return;
        }
            
            
        if(Math.hypot(target.getX() - getX(), getY() - target.getY()) < range){
            turnTowards(target.getX(), target.getY());
            move(2);
            if(intersects(target)){
                target.addXp(amount);
                ObjectCreater.instance.removeObject(this);
                return;
            }
        }
        
        
    }
}
