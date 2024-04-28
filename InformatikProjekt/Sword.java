/**
 * Write a description of class Sword here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Sword implements IAmWeapon 
{
     private DamageArea damageArea;
    private SimpleTimer timer;
    
    private int swordDamage = 3;
    private int range = 50;
    private float cooldown = 1.5f;
    
    private Fighter _owner;
    
    public Sword(Fighter owner){
        _owner = owner;
        damageArea = new DamageArea();
        ObjectCreater.instance.createObject(damageArea,0,0);
        timer = new SimpleTimer();
        timer.mark();
    }
    public void Attack(int baseDamage){
        if(timer.millisElapsed() < cooldown * 1000)
            return;
            
            timer.mark();
            damageArea.setLocation(_owner.getX(),_owner.getY());
            damageArea.move(range);
            var inter = damageArea.getIntersectingObjects();
            if(!inter.isEmpty()){
                dealDamage(inter, baseDamage);
            }
            damageArea.move(-range);
    }
    private void dealDamage(Iterable<Fighter> fighters, int baseDamage){
        for(Fighter f : fighters){
            if(f == _owner) {continue;}
            f.onDamage(-(baseDamage + swordDamage) );
        }
    }
}
