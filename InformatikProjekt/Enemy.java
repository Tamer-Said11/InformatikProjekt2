import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Fighter
{
    private Player target;
    private int xpValue;
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {

        if(target == null){
            target = getWorld().getObjects(Player.class).get(0);
        }
        turnTowards(target.getX(), target.getY());
        move(0.5);
        if(intersects(target)){
            target.onDamage(-baseDamage);
        }
    }
    
    protected void onDeath(){
        
        ObjectCreater.instance.createObject(new Experience(xpValue, target),getX(),getY());
        ObjectCreater.instance.removeObject(this);
    }
}
