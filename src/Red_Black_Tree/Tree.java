package Red_Black_Tree;

public class Tree 
{
	private static final boolean Black = true;
	private static final boolean Red = false;
	node root = null;
	void print(node t1) 
	{
		if(t1 == null) 
		{
			return;
		}
		print(t1.left);
		System.out.print(t1.data+" ");
		print(t1.right);
	}
	void insert1(node t1) 
	{
		if(t1.parent == null) 
		{
			t1.color = Black;
		}
		else 
		{
			insert2(t1);
		}
	}
	void insert2(node t1) 
	{
		if(node_color(t1.parent) == Black) 
		{
			return;
		}
		else 
		{
			insert3(t1);
		}
	}
	boolean node_color(node t1) 
	{
		if(t1 == null) 
		{
			return Black;
		}
		else 
		{
			return t1.color;
		}
	}
	void insert3(node t1) 
	{	
		if(node_color(uncle(t1))== Red) 
		{
			t1.parent.color=Black;
			uncle(t1).color=Black;
			before_parent(t1).color = Red;
			insert1(before_parent(t1));
		}
		else
			insert4(t1);
	}
	node uncle(node t1)
	{
		if(t1==null)
		{
			return null;
		}
		else
			return sibling(t1.parent);
	}
	node sibling (node t1)
	{
		if(t1 == null || t1.parent==null)
		{
			return null;
		}
		if(t1 == t1.parent.left)
		{
			return t1.parent.right;
		}
		else
			return t1.parent.left;
	}
	node  before_parent(node t1)
	{
		if(t1 == null || t1.parent==null)
		{
			return null;
		}
		else
			return t1.parent.parent;
	}
	void insert4(node t1) 
	{
		if(t1==t1.parent.right&&t1.parent==before_parent(t1).left)
		{
			left_rotate(t1.parent);
			t1=t1.left;
		}
		else if(t1==t1.parent.left&&t1.parent==before_parent(t1).right)
		{
			right_rotate(t1.parent);
			t1=t1.right;
		}
		insert5(t1);
	}
	void insert5(node t1) 
	{
		t1.parent.color=Black;
		before_parent(t1).color=Red;
		if(t1==t1.parent.left&&t1.parent==before_parent(t1).left)
		{
			right_rotate(before_parent(t1));
		}
		else
			left_rotate(before_parent(t1));
	}
	void insert(int data)
	{
		node new_node= new node();
		new_node.data=data;
		new_node.color=Red;
		if(root == null)
		{
			root=new_node;
			root.color=Black;
			return;
		}
		node t1 =root;
		while(t1!=null)
		{
			if(data<t1.data) 
			{
				if(t1.left==null) 
				{
					t1.left=new_node;
					break;
				}
				t1=t1.left;
			}
			else if(data>t1.data) 
			{
				if(t1.right==null) 
				{
					t1.right=new_node;
					break;
				}
				t1=t1.right;
			}
			else
				return;
		}
		new_node.parent=t1;
		insert1(new_node);
	}
	void delete1(node t1) 
	{
		if(t1.parent==null)
			return;
		delete2(t1);
	}
	void delete2(node t1) 
	{
		node t2 = sibling(t1);
		if(node_color(t2)==Red) 
		{
			t1.parent.color=Red;
			t2.color=Black;
			if(t1 ==t1.parent.left) 
			{
				left_rotate(t1.parent);
			}
			else
				right_rotate(t1.parent);
		}
		delete3(t1);
	}
	void delete3(node t1) 
	{
		node t2=sibling(t1);
		if((t1.parent.color==Black && t2.color==Black)&&(node_color(t2.left)==Black&&node_color(t2.right)==Black)) 
		{
			t2.color=Red;
			delete1(t1.parent);
		}
		else
			delete4(t1);
	}
	void delete4(node t1) 
	{
		node t2=sibling(t1);
		if((t1.parent.color==Red && t2.color==Black)&&(node_color(t2.left)==Black&&node_color(t2.right)==Black)) 
		{
			t2.color=Red;
			t1.parent.color=Black;
		}
		else
			delete5(t1);
	}
	void delete5(node t1) 
	{
		node t2 = sibling(t1);
		if(t2.color==Black) 
		{
			if((t1==t1.parent.left)&&(node_color(t2.right)==Black)&&(node_color(t2.left)==Red)) 
			{
				t2.color=Red;
				t2.left.color=Black;
				right_rotate(t2);
			}
			else if ((t1==t1.parent.right)&&(node_color(t2.left)==Black)&&(node_color(t2.right)==Red)) 
			{
				t2.color=Red;
				t2.right.color=Black;
				left_rotate(t2);
			}
		}
		delete6(t1);
	}
	void delete6(node t1) 
	{
		node t2 = sibling(t1);
		t2.color=t1.parent.color;
		t1.parent.color=Black;
		if(t1==t1.parent.left) 
		{
			t2.right.color=Black;
			left_rotate(t1.parent);
		}
		else
		{
			t2.left.color=Black;
			right_rotate(t1.parent);
		}
	}
	void right_rotate(node t2) 
	{
		if(t2==null||t2.left==null) 
		{
			return;
		}
		node t1 =t2.left;
		t2.left=t1.right;
		if(t1.right!=null) 
		{
			t1.right.parent=t2;
		}
		if(t2.parent==null) 
		{
			root=t1;
		}
		else if(t2==t2.parent.left) 
		{
			t2.parent.left=t1;
		}
		else
			t2.parent.right=t1;
		t1.parent=t2.parent;
		t1.right=t2;
		t2.parent=t1;
	}
	void left_rotate(node t1) 
	{
		if(t1==null||t1.right==null) 
		{
			return;
		}
		node t2 = t1.right;
		t1.right=t2.left;
		if(t2.left!=null) 
		{
			t2.left.parent=t1;
		}
		if(t1.parent==null) 
		{
			root=t2;
		}
		else if(t1 == t1.parent.left) 
		{
			t1.parent.left=t2;
		}
		else
			t1.parent.right=t2;
		t2.parent=t1.parent;
		t2.left=t1;
		t1.parent=t2;
	}
	void delete_child(node t1) 
	{
		if(t1 == null) 
		{
			return;
		}
		node child;
		if(t1.right==null) 
		{
			child=t1.left;
		}
		else
			child=t1.right;
		if(t1.parent==null) 
		{
			root=child;
		}
		else if(t1==t1.parent.left)
		{
			t1.parent.left=child;
		}
		else
			t1.parent.right=child;
		if(child !=null) 
		{
			child.parent=t1.parent;
		}
		if(node_color(t1)==Black) 
		{
			if(node_color(child)==Red) 
			{
				child.color=Black;
			}
			else
				delete1(t1);
		}
		t1=null;
	}
	void delete(node t1,int data) 
	{
		if(t1 == null) 
		{
			return;
		}
		if(data < t1.data) 
		{
			delete(t1.left,data);
		}
		else if(data>t1.data) 
		{
			delete(t1.right,data);
		}
		else 
		{
			if(t1.left == null || t1.right==null) 
			{
				delete_child(t1);
			}
			else
			{
				node temp = min_node(t1.right);
				t1.data=temp.data;
				delete(t1.right,temp.data);
			}
		}
		
	}
	node min_node(node t1)
	{
		node return1 = t1;
		while(return1.left != null) 
		{
			return1=return1.left;
		}
		return return1;
	}
	void delete_tree(node t1) 
	{
		if(t1==null) 
		{
			return;
		}
		delete_tree(t1.left);
		delete_tree(t1.right);
		t1=null;
		root=null;
	}
}
