import greenfoot.*;
import  java.util.*;
/**
 * Write a description of class WaveManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaveManager
{
    //Settings
        //Spawner Position
        private int[] spawnerPosition= new int[] {300,0 };
        //Spawntime
        private int dur = 200;
    // instance variables - replace the example below with your own
    public Wave[] waves = new Wave[3];
    private int currentWave = 0;
    private int remainingEnemies;
    private float duration;
    private Spawner spawner;

    /**
     * Constructor for objects of class WaveManager
     */
    public WaveManager()
    {
        //waves = Data.WAVES_NORMAL;
        spawner = new Spawner();
        ObjectCreater.instance.createObject(spawner, spawnerPosition[0] ,spawnerPosition[1]);
        var wave1 = new Wave(new Enemy[] {new Enemy(),new Enemy(),new Enemy(),new Enemy() });
        waves[0] =  wave1;
            spawnEnemies(waves[currentWave].enemies);
            
    }
    
    @FunctionalInterface
    public interface MyFunction {
        void apply();
    }
    private void spawnEnemies(Enemy[] enemies){
        
        /*for(int i = 0; i < enemies.length; i++){
            actuelEnemy = enemies[i];
            var x = 20 * i;
            var y = 20 * i;
            var time = 200 * i;
            Thread newThread = new Thread(() -> {
                
            ObjectCreater.instance.createObject(new Timer(time,() ->  ObjectCreater.instance.createObject(actuelEnemy, x, y)),0,0);
            });
            newThread.start();
            
        }*/
         spawner.spawn(enemies, dur);
        
        //Spawn
        //Add event to it 
        remainingEnemies = enemies.length;
        
    }

    private void onEnemyDeath(){
        remainingEnemies--;
        if(remainingEnemies == 0){
            nextWave();
        }
    }
    
    private void nextWave() {
        currentWave++;
        spawnEnemies(waves[currentWave].enemies);
    }


}
