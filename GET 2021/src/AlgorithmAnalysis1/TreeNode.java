package AlgorithmAnalysis1;

/**
 * class TreeNode having key, value of Node 
 * @author abhishek.dawer_metac
 *
 */
public class TreeNode {
    public String key, value;
    TreeNode left,right;
    
    /**
     * Constructor for setting values
     * @param key containing key 
     * @param value containing value
     */
    public TreeNode(String key, String value) {
    	this.key = key;
    	this.value = value;
    	left = null;
    	right = null;
    }
    
    /**
     * Method to get value of key
     * @return value of type String
     */
    public String getKey() {
    	return this.key;
    }
    
    /**
     * Method to get value of particular key
     * @return value of type String
     */
    public String getValue() {
    	return this.value;
    }
}
