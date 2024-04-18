import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fighter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fighter extends Actor
{
    private int maxHealth = 10;
    private int Health;
    
    protected int moveSpeed = 1;
    
    protected int baseDamage = 1;
    
    public void act()
    {
        
    }
    
    private void changeHealth(int amount ){
        Health += amount;
        if(Health > maxHealth) {
            Health = maxHealth;
        }
        else if(Health <= 0){
            Health = 0;
            onDeath();
        }
        
    }
    public void onDamage(int damage){
        //Schild Abzüge berechen
        changeHealth(damage);
    }
    protected  void onDeath(){
        ObjectCreater.instance.removeObject(this);
    }
    
    
    private void Attack(){
        
    }
    
}
