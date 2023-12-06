package Red_Black_Tree;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Main 
{ 
	public static void main(String[] args)
	{
		
		Tree RBC= new Tree();
		for(int i=10;i<=100;i+=10)
		{
			RBC.insert(i);
		}
	}
}
