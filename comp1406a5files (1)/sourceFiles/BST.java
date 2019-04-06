package sourceFiles;
import java.util.*;

public class BST extends BinaryTree{

	// You MUST have a zero argument constructor that
	// creates an empty binary search tree
	// You can can add code to this if you want (or leave it alone).
  // We will create all BSTs for testing using this constructor
  public BST(){}



  @Override
  public boolean contains(String s){
    Node source = this.getRoot();
    boolean go = false;
    if( source == null ){
      return go;
    }else{
      int counter =0;
      while(counter< this.getSize()){
        if(s.equals(source.getData())){
          go = true;
          break;
        }
        else if(source.getData().compareTo(s) >0){
          counter++;
          source = source.getLeft();
        }
        else if(source.getData().compareTo(s) < 0){
          counter++;
          source = source.getRight();
        }
      }
    }
    return go;
  }

  @Override
  public void add(String s){
    Node  main = root;
    Node temp = null;  

    if(root == null){
      root = new Node(s);
      main = null;
    }
    while(main != null){
      if(main.getData().compareTo(s)<0){
        temp = main;
        main = main.getRight();
        if(main == null){
          temp.setRight(new Node(s));
        }
      }
      else{
        temp = main;
        main = main.getLeft();
        if(main==null){
          temp.setLeft(new Node(s));
        }
      }
    }
    this.size = this.getSize()+1;
  }

  public boolean isValidBST(){
    if(this.getRoot()==null){
		  return true;
    }
    else{
      String[] newArray = makeArray().toArray(new String[makeArray().size()]);
      String tempArray = newArray[0];
		  for(int x = 0; x < newArray.length; x++){
			  if(newArray[x].compareTo(tempArray) <0){
          return false;
			  }
			  else{
				  tempArray = newArray[x];
			  }
      }
    }
    return true;
  }

  public ArrayList<String> makeArray() {
    ArrayList<String> resource = new ArrayList<String>();
    makeArrayHelper(root, resource);
    return resource;
}

public void makeArrayHelper(Node node, ArrayList<String> resource) {
    if (node == null) {
        return;
    }
    makeArrayHelper(node.getLeft() ,resource); 
    resource.add(node.getData()); 
    makeArrayHelper(node.getRight(), resource); 
}

  public BST makeBalanced(){
    BST searchTree = new BST();
    String[] balance = makeArray().toArray(new String[makeArray().size()]);
    
    root = searchTree.sortedArrayToBST(balance, 0, balance.length-1); 


    String[] quad = tofinal().toArray(new String[tofinal().size()]);
    System.out.println(Arrays.toString(quad));
    for(int x=0;x<quad.length;x++){
      searchTree.add(quad[x]);
    }
    return searchTree;
  }


  public Node sortedArrayToBST(String[] arr, int start, int end){
    if (start > end) { 
        return null; 
    } 
    Node newNode= root;

    int mid = (start + end) / 2; 
    newNode = new Node(arr[mid]); 
    newNode.left = sortedArrayToBST(arr, start, mid - 1); 
    newNode.right = sortedArrayToBST(arr, mid + 1, end); 
    return newNode; 
  }

	public ArrayList<String> tofinal() {
		ArrayList<String> resource = new ArrayList<String>();
		preOrder(root, resource);
		return resource;
	}
	
	public void preOrder(Node node, ArrayList<String> result) {
		if (node == null) {
			return;
		}
		result.add(node.getData()); 
		preOrder(node.getLeft() ,result); 
		preOrder(node.getRight(), result); 
	}

}
