import greenfoot.*;
/**
 * Write a description of class ObjectCreater here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ObjectCreater extends Actor
{
    public static ObjectCreater instance;
    private World _world;

    // Da nur Klassen die von Actor erben die Methode "getWorld()" aufrufen können, erstellten
    // wir diese Klasse um nicht von Actor erbenen Klassen das Spawnen von Objekten zu ermöglichen
    // Darüberhinaus soll das Erstellen von Objekten nur von einer KJlasse auskommen
    public ObjectCreater(World world)
    {
        //Erstellung eines Singletons
        _world = world;
        if(instance != null)
        {
            _world.removeObject(this);
        }
        instance = this;
    }
    
    // Erstellt Objekte
    public void createObject(Actor obj, int x , int y){
        _world.addObject(obj, x, y);
    }
    
    public void removeObject(Actor obj){
        _world.removeObject(obj);
    }


}
