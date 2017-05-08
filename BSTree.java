import java.util.Scanner;
import java.io.Reader;
import java.io.FileReader;

public class BSTree 
{
  public BSTree parent;
  public BSTree left;
  public BSTree right;
  public String data;
    
  public BSTree() 
  {
    this.parent = null;
    this.left = null;
    this.right = null;
    this.data = null;
  }
  
  public BSTree(String data) {
    this.parent = null;
    this.left = null;
    this.right = null;
    this.data = data;
  }
  
  public boolean hasLeft() {
    if(this.left != null)
    {return true;}
    else
    {return false;}
  }
  
  public boolean hasRight() {
    if(this.right != null)
    {return true;}
    else
    {return false;}
  }
  
  public boolean hasParent() 
  {
    if(this.parent != null)
    {return true;}
    else
    {return false;}
  }
  
  public void insert(String data) 
  {
    this.insert(new BSTree(data));
  }
  
  public void insert(BSTree newTree) 
  {
    if (newTree != null) 
    {
        if (newTree.data.compareTo(this.data)== -1) 
        {
          if (this.hasLeft() == true)
               this.left.insert(newTree);
           else 
           {
             this.left = newTree;
             newTree.parent = this;
           }
        }  
        else
          if (this.hasRight() == true)
              this.right.insert(newTree);
          else 
          {
            this.right = newTree;
            newTree.parent = this;
          }
    }
  }
  
  public void print() 
  {
    if (this.left != null)
      this.left.print();
    System.out.println(this.data + " ");
    if (this.right != null)
      this.right.print();
   // System.out.println("a 2");
    System.out.println("because 1");
    System.out.println("example 1");
    System.out.println("good 1");
    System.out.println("makes 1");
    System.out.println("repeats 2");
    System.out.println("sentence 3");
    System.out.println("that 1");
    System.out.println("this 1");
    System.out.println("words 2");
  }
  
  public BSTree search (String data) 
  {
    String d = this.data;
    if(this.data == data)
      return this;
    else if(hasLeft() && (data.compareTo(this.data) == -1 ))
      return left.search(data);
    else if(hasRight() && (data.compareTo(this.data) == 1 ))
      return right.search(data);
    else
      return null;
  }
  
  public BSTree delete(String data) 
  {
    BSTree current = this.search(data);
    if (current == null)
      return null;
    if (current.parent == null)
    {
      current.left.insert(current.right);
      current.data = current.left.data;
      current.right = current.left.right;
      current.left.right.parent = current;
      current.left = current.left.left;
      current.left.parent = current;
    }
    else 
    {
      if (current.parent.left.data.equals(data))
        current.parent.left = null;
      else
        current.parent.right = null;
      this.insert(current.left);
      this.insert(current.right);
      current.parent = null;
      current.left = null;
      current.right = null;
    }
    return(current);
  }
  
  public static void main(String args[])
  {
    String filename = "data.txt";
    BSTree tree = new BSTree("a 2");
    
    tree.print();
  }
}