import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage;

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{

     
   // private GreenfootImage button_1 = new GreenfootImage("button-blue");
   // private GreenfootImage button_2 = new GreenfootImage("button-green");
 
    private boolean mouseDown;
    
    private ICallable _callback;
    public Button() {
        //setImage(button_1);
        mouseDown = false;
    }
    public Button(ICallable callback) {
        //setImage(button_1);
        mouseDown = false;
        _callback = callback;
    }
 
    public void act() {
        if (!mouseDown && Greenfoot.mousePressed(this)) {  
            //setImage(button_2); 
            mouseDown = true;
        }  
        if (mouseDown && Greenfoot.mouseClicked(this)) {
            //setImage(button_1);
            mouseDown = false;
            Callback();
        }  
    }
    
    protected void Callback(){
        if(_callback != null){
            _callback.apply();
        }
        
            
        
        // Do Something
    }

}
