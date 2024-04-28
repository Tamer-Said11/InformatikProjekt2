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
    private int range = 50;
    //Level
    private int[] level = new int[] {0,10,100,500,1000 };
    private int totalXp = 0;   
    private int currentLevel = 0;
    //Upgrade
    private int nextUpgrade;
    private int[] upgradeLevel = new int[] {2,5,10,15,20};
    
    private Design design;
    private IAmWeapon _weapon;
    public Player(){
        design = new Design();
        ObjectCreater.instance.createObject(design, 0, 0);
        _weapon = new BaseSword(this);
    }
    public void act()
    {
        detectInput();
        rotateToMouse();
        design.setLocation(getX(), getY());
        
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
    //Bug wenn mal Auswahl Ignoriert
    public void addXp(int amount){
        totalXp += amount;
        var newL = getLevel();
        if(newL != currentLevel){
            
            currentLevel = newL;
            newStats();
            if(currentLevel >= upgradeLevel[nextUpgrade]){
                UpgradeManager.newChoice(currentLevel);
                if(nextUpgrade  < upgradeLevel.length + 1){
                    nextUpgrade++;
                }
            }
        }
    }
    private void newStats(){
        
    }
    private int getLevel(){
        var a = totalXp;
        for(int i = 0; i < level.length;i++){
            a -= level[i];
            if(a < 0) {return i;}
            
        }
        return level.length;
    }
    private void detectInput(){
        if(Greenfoot.isKeyDown("Up")){
            move(moveSpeed);
        }
        if(Greenfoot.isKeyDown("Down")){
            move(-moveSpeed);
        }
        if(Greenfoot.isKeyDown("Space")){
            
          _weapon.Attack(baseDamage);
        }

        
    }
    
    protected void onDeath(){
        
    }
}
