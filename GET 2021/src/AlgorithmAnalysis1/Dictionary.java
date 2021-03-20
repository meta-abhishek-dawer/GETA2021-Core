package AlgorithmAnalysis1;

import java.util.ArrayList;

import org.json.simple.JSONObject;

/**
 * Class Dictionary Implementing DictionaryInterface and its methods
 * @author abhishek.dawer_metac
 *
 */
public class Dictionary implements DictionaryInterface {
	TreeNode root;
	ArrayList<TreeNode> list;
	public JSONObject json;
    
	/**
	 * Constructor of class Dictionary
	 * @param json containing JSON values
	 */
	public Dictionary(JSONObject json ) {
    	this.json = json;
    	root = null;
    	list = new ArrayList<>();
    	for(Object key: json.keySet()) {
			insertValue(key.toString(), json.get(key).toString());
    	}
    }
	
	/**
	 * Method to insert value in Dictionary
	 * @param key containing key of type String
	 * @param value containing value of particular key
	 */
	public void insertValue(String key, String value) {
	    root = 	insertInTree(root, key, value);
	}
	
	/**
	 * Method to insert in tree
	 * @param root containing root of tree
	 * @param key containing value of key
	 * @param value containing value of particular key
	 * @return root of type TreeNode
	 */
	public TreeNode insertInTree(TreeNode root, String key, String value) {
		if(root == null) {
		    root = new TreeNode(key, value);
		    return root;
		}
		else {
			try {
				if(key.equals(root.key))
					throw new Exception();
				else if(compareKeys(root.key, key))
					root.right = insertInTree(root.right, key, value);
				else if(compareKeys(key, root.key))
					root.left = insertInTree(root.left, key, value);
				
				return root;
			}
			catch(Exception e) {
				System.out.println("Duplicate value!!");
			}
			return root;
		}
	}
	
	/**
	 * Method to compare two keys 
	 * @param key1 containing value of key1
	 * @param key2 containing value of key2
	 * @return return true if key1 is greater else false
	 */
	public boolean compareKeys(String key1, String key2) {
		if(key1.equals(key2))
			return false;
		int stringLength= 0;
		if(key1.length()> key2.length())
			stringLength = key1.length();
		else
			stringLength = key2.length();
		
		for(int i=0; i< stringLength; i++) {
			if(key1.charAt(i) > key2.charAt(i))
				return false;
		}
		return true;
	}
	
	/**
	 * Method to get list of keyValue pairs
	 * @return list of type ArrayList
	 */
	public ArrayList<TreeNode> getList() {
		inOrder(root);
		return this.list;
	}
	
	/**
	 * InOrder traversal which add value in sorted form
	 * @param node containing root node of tree
	 */
	public void inOrder(TreeNode node) {
		if(node!= null) {
		    inOrder(node.left);
		    this.list.add(node);
		    inOrder(node.right);
		}
	}
	
	/**
	 * Method to delete a KeyValue
	 * @param keyValue containing value of key
	 */
	public void deleteKeyValue(String keyValue) {
		root = deleteSpecificKey(root, keyValue);
	}
	
	/**
	 * Method to delete a key from tree
	 * @param node containing root of tree
	 * @param keyValue containing value of key
	 * @return node of type TreeNode
	 */
	public TreeNode deleteSpecificKey(TreeNode node, String keyValue) {
		if(node == null)
			return node;
		if(compareKeys(keyValue, node.key))
			node.left = deleteSpecificKey(node.left, keyValue);
		else if(compareKeys(node.key, keyValue))
			node.right = deleteSpecificKey(node.right, keyValue);
		else {
	        if(node.left == null)
	        	return node.right;
	        else if(node.right == null)
	        	return node.left;
		
		String keyMinimum = findMinimumKey(node.right);
		String valueOfKey = searchValue(keyMinimum);
		node.key = keyMinimum;
		node.value = valueOfKey;
		node.right = deleteSpecificKey(node.right, node.key);
		}
		return node;
	}
	
	/**
	 * Method to find minimum key
	 * @param node containing root of tree
	 * @return value of type string
	 */
	public String findMinimumKey(TreeNode node) {
		String minimumKey = node.key;
		while(node.left!= null) {
			minimumKey = node.left.key;
			node = node.left;
		}
		
		return minimumKey;
	}
	
	/**
	 * Method to search KeyValue 
	 * @param keyValue containing value of key
	 * @return value of type string
	 */
	public String searchValue(String keyValue) {
		TreeNode node = findValue(root, keyValue);
		if(node == null)
			return "No keyValue found..";
		
		return node.value;
	}
	
	/**
	 * Method to search value in tree
	 * @param node containing root of tree
	 * @param key containing value of key
	 * @return node of type TreeNode
	 */
	public TreeNode findValue(TreeNode node, String key) {
		if(node == null || node.key.equals(key))
			return node;
		if(compareKeys(key, node.key))
			return findValue(node.left, key);
		else {
			return findValue(node.right, key);
		}
	}
	
	/**
	 * Method to find keyvalue in range
	 * @param key1 containing value of key1
	 * @param key2 containing value of key2
	 * @return list of nodes
	 */
	public ArrayList<TreeNode> keyValueInRange(String key1, String key2) {
		list.clear();
		findInRange(root, key1, key2);
		return list;
	}
	
	/**
	 * Method to find range in tree
	 * @param node containing root of tree
	 * @param key1 value of key1
	 * @param key2 value of key2
	 */
	public void findInRange(TreeNode node, String key1, String key2) {
		if(node == null)
			return;
		if(compareKeys(key1, node.key))
			findInRange(node.left, key1, key2);
		else if(compareKeys(key1, node.key) || key1.equals(node.key) && compareKeys(node.key, key2) || key2.equals(node.key))				
			list.add(node);
		else if(compareKeys(node.key, key2)) {
			findInRange(node.right, key1, key2);
		}
	}
}
