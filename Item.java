
public class Item
{
    private String itemDescription = "";
    private String itemName = "";
    
    public Item(String name, String description)
    {
        itemDescription = description;
        itemName = name;
    }
    
    public String getItemDescription()
    {
        return itemDescription;
    }
    
    public String getItemName()
    {
        return itemName;
    }
    
    public String toString()
    {
        return itemName + '\n' + itemDescription;
    }
}
