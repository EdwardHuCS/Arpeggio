import java.util.*;


public class Inventory
{
    public ArrayList<Weapon> weaps;
    public ArrayList<Armor> armors;
    public ArrayList<Item>items;
    public ArrayList<Item> keyItems;
    public Inventory()
    {
        weaps = new ArrayList<Weapon>(100);
        armors=new ArrayList<Armor>(100);
//        int i =0;
//        while (i<10)
//        for (String key : Game.weapList.keySet())
//        {
//            System.out.println(Game.weapList.get( key ).getWeaponName());
//            weaps.add( Game.weapList.get( key ) );
//            i++;
//        }
    }
    
    /**
     * 
     * Gets an arraylist of all the protagonist's weapons.
     * @return arrayList of all weapons.
     */
    public ArrayList<Weapon> getWeapons()
    {
        return weaps;
    }
    
    /**
     * 
     * Gets an arraylist of all the protagonist's items.
     * @return arrayList of all items
     * .
     */
    public ArrayList<Item> getItems()
    {
        return items;
    }
    
    /**
     * 
     * Gets an arraylist of all the protagonist's armors.
     * @return arrayList of all armors.
     */
    public ArrayList<Armor> getArmor()
    {
        return armors;
    }
    
    /**
     * 
     * Gets an arraylist of all the protagonist's key items.
     * @return arrayList of all key items.
     */
    public ArrayList<Item> getkeyItems()
    {
        return keyItems;
    }
    

    
    
    /**
     * UNUSED
     * 
     * Returns a string with all the weapons the player has.
     * @return String of all weapons
     */
    public String browseWeapons()
    {
        String weapons = "You have these weapons: ";
        for (Weapon weap : weaps)
        {
            weapons += weap.toString() + '\n';
        }
        return weapons;
    }
    
    /**
     * UNUSED
     * 
     * Returns a string with all the armors the player has.
     * @return String of all armors
     */
    public String browseArmor()
    {
        String armor = "You have these claddings: ";
        for (Armor arm : armors)
        {
            armor += arm.toString() + '\n' + '\n';
        }
        return armor;
    }
    
    /**
     * UNUSED
     * 
     * Returns a string with all the items the player has.
     * @return String of all items
     */
    public String browseItems()
    {
        String ite = "You have these unnecessary objects: ";
        for (Item i : items)
        {
            ite += i.toString() + '\n' + '\n' ;
        }
        return ite;
    }
    
    /**
     * UNUSED
     * 
     * Returns a string with all the key items the player has.
     * @return String of all key items
     */
    public String browseKeyItems()
    {
        String ite = "You have these necessary objects: ";
        for (Item i : keyItems)
        {
            ite += i.toString() + '\n' + '\n' ;
        }
        return ite;
    }
    
    /**
     * UNUSED
     * 
     * Finds a weapon from the designated arrayList of weapons.
     * @param desiredWeaponName the name of the weapon the player wants to fetch.
     * @return the Weapon which was to be found.
     */
    public Weapon findWeapon(String desiredWeaponName)
    {
        for (Weapon weap: weaps)
        {
            if (desiredWeaponName.trim().equalsIgnoreCase( weap.getWeaponName() ))
            {
                return weap;
            }
        }
        return null;
    }
    
    /**
     * UNUSED
     * 
     * Finds an armor from the designated arrayList of armors.
     * @param desiredArmorName the name of the armor the player wants to fetch.
     * @return the Armor which was to be found.
     */
    public Armor findArmor(String desiredArmorName)
    {
        for (Armor arm : armors)
        {
            if(desiredArmorName.trim().equalsIgnoreCase(arm.getArmorName()))
            {
                return arm;
            }
        }
        return null;
    }
    
}
