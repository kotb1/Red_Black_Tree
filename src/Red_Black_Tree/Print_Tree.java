package Red_Black_Tree;
import javax.swing.*;
import java.awt.*;
public class Print_Tree
{ 
    private class BTreeDisplay extends JPanel
    {   
        BTreeDisplay(node tree)
        {           
           setBorder(BorderFactory.createEtchedBorder());
           setLayout(new BorderLayout());
           if (tree != null) 
           {          
               String value = String.valueOf(tree.data);
               String value2="";
               if(tree.color) 
               {
            	   value2 = "Black";
               }
               else
            	   value2="Red";
               int pos = SwingConstants.CENTER;
               JLabel rootLabel = new JLabel(value+"  "+"("+value2+")", pos);                         
               add(rootLabel, BorderLayout.NORTH);
               JPanel panel = new JPanel(new GridLayout(1, 2));
               panel.add(new BTreeDisplay(tree.left));
               panel.add(new BTreeDisplay(tree.right));    
               add(panel);
           }       
        }   
    }
   
    private node root;
    public Print_Tree(Tree r)
    {
    	root=r.root;
    }
    public JPanel getView()
    {
       return new BTreeDisplay(root);       
    }
}