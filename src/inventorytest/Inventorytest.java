/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorytest;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;

public class Inventorytest extends JFrame implements ActionListener
{
    //private JTextArea display;
    private JPanel pane;
    private JButton first,previous,next,last,image1;
    private JTextField itemid,brand,stock,price,designer,value,totalvalue,restock;
    public int i;//counter for sorting through array of shoes, public so it can be changed
    public Designer[] shoe;
    public NumberFormat currency;
    public Inventorytest()
    {
        setBounds(500, 500, 500, 1000);
        currency=NumberFormat.getCurrencyInstance();
        shoe=new Designer[4];
        shoe[0]=new Designer("001","Adidas",12,80.00,"Myron Kwan");
        shoe[1]=new Designer("002","Nike",10,100.00,"Stefan Janoski");
        shoe[2]=new Designer("003","Vans",9,60.00,"Bill");
        shoe[3]=new Designer("004","Sperry",20,90.00,"Joe");
        
        i=0;
        
        pane=new JPanel();
        pane.setLayout(new GridBagLayout());
        setTitle("Inventory of Shoes");
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        first=new JButton("First");
        first.addActionListener(this);
        previous=new JButton("Previous");
        previous.addActionListener(this);
        next=new JButton("Next");
        next.addActionListener(this);
        last=new JButton("Last");
        last.addActionListener(this);
        ImageIcon image=new ImageIcon(this.getClass().getResource("/resources/imgres.jpg"));
        Image img=image.getImage();
        Image newimg=img.getScaledInstance(160,120,java.awt.Image.SCALE_SMOOTH);
        image=new ImageIcon(newimg);
        
        image1=new JButton(image);
       
        
        itemid=new JTextField(shoe[i].getproductnumber(),30);
        itemid.setEditable(false);
        brand=new JTextField(shoe[i].getproductname(),30);
        brand.setEditable(false);
        stock=new JTextField(String.valueOf(shoe[i].getstock()),30);
        stock.setEditable(false);
        price=new JTextField(currency.format(shoe[i].getprice()),30);
        price.setEditable(false);
        designer=new JTextField(shoe[i].getDesignername(),30);
        designer.setEditable(false);
        value=new JTextField(currency.format(shoe[i].gettotalvalue()),30);
        value.setEditable(false);
        totalvalue=new JTextField(currency.format(shoe[0].calculateInventory(shoe)), 30);
        totalvalue.setEditable(false);
        restock=new JTextField(currency.format(shoe[i].getrestock()),30);
        restock.setEditable(false);
        
        JLabel ditemid=new JLabel("Product Number:",SwingConstants.LEFT);
        JLabel dbrand=new JLabel("Shoe Brand:",SwingConstants.LEFT);
        JLabel dstock=new JLabel("Number in Stock:",SwingConstants.LEFT);
        JLabel dprice=new JLabel("Price:",SwingConstants.LEFT);
        JLabel ddesigner=new JLabel("Designer:",SwingConstants.LEFT);
        JLabel dvalue=new JLabel("Inventory Value:",SwingConstants.LEFT);
        JLabel dtotalvalue=new JLabel("Total Inventory Value", SwingConstants.LEFT);
        JLabel drestock=new JLabel("Restocking Fee(5%):",SwingConstants.LEFT);
        
        
        
       GridBagConstraints c=new GridBagConstraints();
       c.gridx=0;
       c.gridy=0;
       c.ipadx=0;
       c.gridwidth=3;
       c.gridheight=1;
       c.fill=GridBagConstraints.HORIZONTAL;
       c.anchor=GridBagConstraints.CENTER;
       c.insets=new Insets(4,4,4,4);
     
       pane.add(ddesigner,c);
       c.gridx=3;
       c.gridy=0;
       
       pane.add(designer,c);
       c.gridx=0;
       c.gridy=1;
       pane.add(dbrand,c);
       c.gridx=3;
       pane.add(brand,c);
       c.gridx=0;
       c.gridy=2;
       pane.add(ditemid,c);
       c.gridx=3;
       pane.add(itemid,c);
       c.gridx=0;
       c.gridy=3;
       pane.add(dstock,c);
       c.gridx=3;
       pane.add(stock,c);
       c.gridx=0;
       c.gridy=4;
       pane.add(dprice,c);
       c.gridx=3;
       pane.add(price,c);
       c.gridx=0;
       c.gridy=5;
       pane.add(drestock,c);
       c.gridx=3;
       pane.add(restock,c);
       c.gridx=0;
       c.gridy=6;
       pane.add(dvalue,c);
       c.gridx=3;
       pane.add(value,c);
       c.gridx=0;
       c.gridy=7;
       pane.add(dtotalvalue,c);
       c.gridx=3;
       pane.add(totalvalue,c);
       c.gridx=2;
       c.gridy=9;
       c.gridwidth=1;
       
       
      
       pane.add(first,c);
       c.gridx=3;
      
       pane.add(previous,c);
       c.gridx=4;
       pane.add(next,c);
       c.gridx=5;
       c.insets=new Insets(4,4,4,100);
       pane.add(last,c);
       c.gridy=8;
       c.gridx=0;
       c.gridwidth=2;
       c.gridheight=2;
       c.ipady=50;
       c.ipadx=50;
       c.insets=new Insets(15,15,15,10);
       pane.add(image1,c);
       
       
       this.add(pane);
       this.pack();//reize window
        
        
        
        
        
        
        
        
        
        
        /*
        display=new JTextArea(29,2);
        display.setLineWrap(false);
        display.setWrapStyleWord(true);
        setTitle("Shoe Inventory");
        setBounds(500, 500, 500, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        display.append("UNSORTED INVENTORY OF SHOES: \n\n");
        for(int i=0;i<shoe.length;i++)
        {
        String first="Designer: "+shoe[i].getDesignername()+"\n";
        String second="Shoe brand: "+ shoe[i].getproductname()+"\n";
        String third="Product Number: "+shoe[i].getproductnumber()+"\n";
        String fourth="Number in stock: "+ shoe[i].getstock()+"\n";
        String fifth="Price: "+currency.format(shoe[i].getprice())+"\n";
        String sixth="Inventory Value: "+currency.format(shoe[i].gettotalvalue())+"\n";
        String seventh="Restocking Fee(5%): "+currency.format(shoe[i].getrestock())+"\n";
        display.append(second);
        display.append(third);
        display.append(fourth);
        display.append(fifth);
        display.append(seventh);
        display.append(sixth);
        display.append("***********************\n");
        }
         shoe[0].inventorysort(shoe);//calling sort function
         display.append("SORTED INVENTORY OF SHOES: \n\n");
          for(int i=0;i<shoe.length;i++)
        {
        String first="Designer: "+shoe[i].getDesignername()+"\n";
        String second="Shoe brand: "+ shoe[i].getproductname()+"\n";
        String third="Product Number: "+shoe[i].getproductnumber()+"\n";
        String fourth="Number in stock: "+ shoe[i].getstock()+"\n";
        String fifth="Price: "+currency.format(shoe[i].getprice())+"\n";
        String sixth="Inventory Value: "+currency.format(shoe[i].gettotalvalue())+"\n";
        String seventh="Restocking Fee(5%): "+currency.format(shoe[i].getrestock())+"\n";
                
        display.append(second);
        display.append(third);
        display.append(fourth);
        display.append(fifth);
        display.append(seventh);
        display.append(sixth);
        display.append("***********************\n");
        
        }
          String last="ENTIRE INVENTORY VALUE: "+currency.format(shoe[0].calculateInventory(shoe))+"\n";
        display.append(last);
        JScrollPane scroll=new JScrollPane(display);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scroll,BorderLayout.CENTER);
        */
        
    }
    public void actionPerformed(ActionEvent e)
    {
        Object source=e.getSource();
        if(source==first)
        {
        i=0;

        itemid.setText(shoe[i].getproductnumber());
        brand.setText(shoe[i].getproductname());
        stock.setText(String.valueOf(shoe[i].getstock()));
        price.setText(currency.format(shoe[i].getprice()));
        designer.setText(shoe[i].getDesignername());
        value.setText(currency.format(shoe[i].gettotalvalue()));
        restock.setText(currency.format(shoe[i].getrestock()));
        }
        else if(source==last)
        {
        i=shoe.length-1;
        itemid.setText(shoe[i].getproductnumber());
        brand.setText(shoe[i].getproductname());
        stock.setText(String.valueOf(shoe[i].getstock()));
        price.setText(currency.format(shoe[i].getprice()));
        designer.setText(shoe[i].getDesignername());
        value.setText(currency.format(shoe[i].gettotalvalue()));
        restock.setText(currency.format(shoe[i].getrestock()));
        
        }
        else if(source==next)
        {
        i++;
        if(i==shoe.length)//if you reach end of array, loop back to beginning
        {
            i=0;
        }
        itemid.setText(shoe[i].getproductnumber());
        brand.setText(shoe[i].getproductname());
        stock.setText(String.valueOf(shoe[i].getstock()));
        price.setText(currency.format(shoe[i].getprice()));
        designer.setText(shoe[i].getDesignername());
        value.setText(currency.format(shoe[i].gettotalvalue()));
        restock.setText(currency.format(shoe[i].getrestock()));
        }
        else if(source==previous)
        {
            i--;
            if(i<0)//loop back to end
            {
                i=shoe.length-1;
            }
            itemid.setText(shoe[i].getproductnumber());
            brand.setText(shoe[i].getproductname());
            stock.setText(String.valueOf(shoe[i].getstock()));
            price.setText(currency.format(shoe[i].getprice()));
            designer.setText(shoe[i].getDesignername());
            value.setText(currency.format(shoe[i].gettotalvalue()));
            restock.setText(currency.format(shoe[i].getrestock()));
        }
    
    }
    public static void main(String[] args)
    {
        Inventorytest newframe= new Inventorytest();
        newframe.setVisible(true);
        
        
        
        
        /*
        NumberFormat currency=NumberFormat.getCurrencyInstance();
        Designer[] shoe=new Designer[4];
        shoe[0]=new Designer("001","Adidas",12,80.00,"Myron Kwan");
        shoe[1]=new Designer("002","Nike",10,100.00,"Stefan Janoski");
        shoe[2]=new Designer("003","Vans",9,60.00,"Bill");
        shoe[3]=new Designer("004","Sperry",20,90.00,"Joe");
        System.out.print("Unsorted Inventory of shoes: \n\n");
        for(int i=0;i<shoe.length;i++)
        {
        System.out.printf("Designer: %s %n",shoe[i].getDesignername());   
        System.out.printf("Shoe brand: %s %n",shoe[i].getproductname());
        System.out.printf("Product Number: %s %n",shoe[i].getproductnumber());
        System.out.printf("Number in stock: %d %n",shoe[i].getstock());
        System.out.printf("Price: %s %n",currency.format(shoe[i].getprice()));//although price is a double, must be outputted as string
        System.out.printf("Restocking fee: %s %n",currency.format(shoe[i].getrestock()));
        System.out.printf("Inventory Value: %s %n%n",currency.format(shoe[i].gettotalvalue()));
        }
       
        shoe[0].inventorysort(shoe);//calling sort function
        System.out.print("Sorting inventory..... \n\n");
        System.out.print("Sorted Inventory of shoes: \n");
        for(int i=0;i<shoe.length;i++)
        {
        System.out.printf("Designer: %s %n",shoe[i].getDesignername());  
        System.out.printf("Shoe brand: %s %n",shoe[i].getproductname());
        System.out.printf("Product Number: %s %n",shoe[i].getproductnumber());
        System.out.printf("Number in stock: %d %n",shoe[i].getstock());
        System.out.printf("Price: %s %n",currency.format(shoe[i].getprice()));//although price is a double, must be outputted as string
        System.out.printf("Restocking fee: %s %n",currency.format(shoe[i].getrestock()));
        System.out.printf("Inventory Value: %s %n%n",currency.format(shoe[i].gettotalvalue()));
        }
        
        
        System.out.printf("Entire Inventory Value: %s %n%n",currency.format(shoe[0].calculateInventory(shoe)));//entire inventory value function
        
        
        */
    }
    
}
