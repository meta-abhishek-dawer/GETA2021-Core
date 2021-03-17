package Assignment3;

import java.util.ArrayList;
import java.util.InputMismatchException;
/**
 * Class in which we are defining methods
 * @author abhishek.dawer_metac
 *
 */
public class VirtualCommandPrompt {
    Directory root, currentDirectory;
    
    public VirtualCommandPrompt() {
    	root = new Directory("root");
    	currentDirectory = root;
    }
    /**
     * Method to create directory
     * @param name containing directory name
     * @return result of String type 
     * throw exception if length of string is zero
     */
    public String createDirectory(String name) {
    	String result = "";
    	try {
    		if(name.length() == 0)
    			throw new InputMismatchException();
    		if(isDirectoryPresent(name, this.currentDirectory)==false) {
    			Directory newDirectory = new Directory(name);
    			newDirectory.parentDirectory = currentDirectory;
    			currentDirectory.subDirectory.add(newDirectory);
    			result= "Directory Created";
    		}
    		else {
    			result = "Directory already present!!";
    		}
    	}
    	catch(InputMismatchException e) {
    		System.out.println("Input Mismatched!!");
    	}
    	return result;
    }
    
    /**
     * Method to get list of Directory
     */
    public void listCurrentDirectory() {
    	for(Directory newDirectory : currentDirectory.subDirectory)
    		System.out.println(newDirectory.directoryName + " " + newDirectory.timeStamp);
    }
    
    /**
     * Method to change directory
     * @param changeName containing name of directory
     * @return value of type string
     */
    public String changeDirectory(String changeName) {
    	for(int i= 0; i< currentDirectory.subDirectory.size(); i++) {
    		String dirName =currentDirectory.subDirectory.get(i).directoryName;
    		if(dirName.equals(changeName)) {
    			currentDirectory = currentDirectory.subDirectory.get(i);
    			return "Directory Changed..";
    		}
    	}
    	return "No directory present!!";
    }
    
    /**
     * Method to check directory is present 
     * @param name containing name of directory
     * @param currentDirectory current directory
     * @return value of type boolean
     */
    public boolean isDirectoryPresent(String name, Directory currentDirectory) {
    	for(int i= 0; i< currentDirectory.subDirectory.size(); i++) {
    		String dirName =currentDirectory.subDirectory.get(i).directoryName; 
    		if(dirName.equals(name))
    			return true;
    	}
    	return false;
    }
    
    /**
     * Method to move parent directory
     */
    public void moveToParent() {
    	currentDirectory = currentDirectory.parentDirectory;
    }
    
    /**
     * Method to display directory
     */
    public void displayDirectory() {
    	displayStructure(root);
    }
    
    public void displayStructure(Directory newDirectory) {
        for(Directory directory : newDirectory.subDirectory) {
        	System.out.println(" " + directory.directoryName);
        	displayDirectory();
        }
    }
    
    /**
     * Method  to find directory
     * @param dirName name of directory
     * @return path of directory
     */
    public ArrayList<String> find(String dirName) {
    	ArrayList<String> directoryPaths = new ArrayList<>();
    	findPath(dirName, root, directoryPaths);
    	return directoryPaths;
    }
    /**
     * Method to find different paths
     * @param dirName name of directory
     * @param newDirectory new directory to check
     * @param directoryPaths  list for paths
     */
    public void findPath(String dirName, Directory newDirectory, ArrayList<String> directoryPaths) {
    	for(int i= 0; i< newDirectory.subDirectory.size(); i++) {
    		String currentName = newDirectory.subDirectory.get(i).directoryName;
    		if(currentName.equals(dirName)) {
    			String currentPath = "";
    			Directory folder = newDirectory.subDirectory.get(i).parentDirectory;
    			while(folder.parentDirectory!= null) {
    				currentPath = folder.directoryName + "\\" + currentPath;
    				folder = folder.parentDirectory;
    			}
    			directoryPaths.add("root\\" + currentPath);
    		}
    		else {
    			findPath(dirName, newDirectory.subDirectory.get(i), directoryPaths);
    		}
    	}
    }
}
