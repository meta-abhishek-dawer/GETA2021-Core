package Assignment3;

import java.util.ArrayList;
import java.util.Date;

/*
 * Class directory consisting directory name, time
 */
public class Directory {
    String directoryName, timeStamp;
    ArrayList<Directory> subDirectory = new ArrayList<Directory>();
    Directory parentDirectory = null;
    
    public Directory(String name) {
    	this.directoryName = name;
    	this.timeStamp = new Date().toString();
    }
}
