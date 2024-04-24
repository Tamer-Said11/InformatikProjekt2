import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Fighter
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        detectInput();
        rotateToMouse();
    }
    int mx;
    int my;
    private void rotateToMouse(){
        MouseInfo mouse = Greenfoot.getMouseInfo();

        //var px = 0;
        //var py = 0;
        //var time = 0;
        if(mouse!=null){
            mx = mouse.getX();
            my = mouse.getY();
           //px = getX();
           //py = getY();
           //time = 0;
        }
        
            
            //time++;
            //int x = (int)lerp(px, mx,time,200);
            //int y = (int)lerp(py, my,time,200);
            
            //check the absolute distance betwenn the player and the mouse, so it doesnt come to bugs if the miouse int the player!!!
            if(Math.hypot(mx - getX(), my - getY()) < 10){
                return;
            }
            turnTowards(mx, my);
    
        
        
    }
    private float lerp(int start, int end, float time, float targetTime){
        if(time >= targetTime) { 
            return end;
        }
        return start + time/targetTime * (end - start);
    }
    
    private void detectInput(){
        if(Greenfoot.isKeyDown("Up")){
            move(moveSpeed);
        }
        if(Greenfoot.isKeyDown("Down")){
            move(-moveSpeed);
        }

        
    }
    
    protected void onDeath(){
        
    }
}
