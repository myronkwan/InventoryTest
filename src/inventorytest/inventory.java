
package inventorytest;

public class inventory 
{
    private String productnumber;
    private String productname;
    private int stock;
    private double price;
    
    
    public inventory()
    {
        productnumber="";
        productname="";
        stock=0;
        price=0.00;
    }
     public inventory(String a, String b, int c, double d)
    {
        productnumber=a;
        productname=b;
        stock=c;
        price=d;
    }
     public void setproductnumber(String a)
     {
         productnumber=a;
     }
     public String getproductnumber()
     {
         return productnumber;
     }
     public void setproductname(String a)
     {
         productname=a;
     }
     public String getproductname()
     {
         return productname;
     }
     public void setstock(int a)
     {
         stock=a;
     }
     public int getstock()
     {
         return stock;
     }
     public void setprice(double a)
     {
         price=a;
     }
     public double getprice()
     {
         return price;
     }
     public double gettotalvalue()
     {
         return stock*price;
     }
     public double calculateInventory(inventory[] entire)
     {
         double entiretotal=0;
         for(int i=0;i<entire.length;i++)
         {
             entiretotal+=entire[i].gettotalvalue();
         }
         return entiretotal;
     }
     public inventory[] inventorysort(inventory[] entire)
     {
         for(int i=0;i<entire.length;i++)
         {
             int min=i;
                for(int j=i+1;j<entire.length;j++)
                {
                    int compare=entire[j].getproductname().compareTo(entire[min].getproductname());
                    if(compare<0)//if object j comes before object min
                    {
                        min=j;
                    }
                }
            if(min!=i)
            {
             inventory temp=entire[i];
             entire[i]=entire[min];
             entire[min]=temp;
            }
         }
         return entire;
     }
}

