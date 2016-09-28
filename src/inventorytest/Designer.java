/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorytest;


public class Designer extends inventory
{
    private String designername;
    public Designer()
    {
    }
    public Designer(String a, String b, int c, double d,String n)
    {
        super(a,b,c,d);
        designername=n;
    }
    public void setDesignername(String a)
    {
        designername=a;
    }
    public String getDesignername()
    {
        return designername;
    }
    public double getrestock()
    {
        return super.getprice()*.05;
    }
    public double gettotalvalue()
     {
         double total=super.getstock()*super.getprice();
         total+=(total*.05);        
         return total;
     }
     public inventory[] inventorysort(Designer[] entire)//also changed to sort by designer name instead of brand
     {
         for(int i=0;i<entire.length;i++)
         {
             int min=i;
                for(int j=i+1;j<entire.length;j++)
                {
                    int compare=entire[j].getDesignername().compareTo(entire[min].getDesignername());
                    if(compare<0)//if object j comes before object min
                    {
                        min=j;
                    }
                }
            if(min!=i)
            {
             Designer temp=entire[i];
             entire[i]=entire[min];
             entire[min]=temp;
            }
         }
         return entire;
     }
}
