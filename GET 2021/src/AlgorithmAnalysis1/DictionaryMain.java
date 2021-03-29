package AlgorithmAnalysis1;

import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * class to implement methods of Dictionary
 * @author abhishek.dawer_metac
 *
 */
public class DictionaryMain {

	public static void main(String[] args) throws Exception {
		String jsonFilePath = "C:/Users/abhishek.dawer_metac/git/GETA2021-Core/GET 2021/JsonFile/Dictionary.json";
		JSONParser  newParser = new JSONParser();
		JSONObject jsonObject = (JSONObject) newParser.parse(new FileReader(jsonFilePath));
		
		Dictionary dictionaryObject = new Dictionary(jsonObject);
		ArrayList<TreeNode> resultList = dictionaryObject.getList();
		
		for(int i= 0; i < resultList.size(); i++) {
			System.out.println(resultList.get(i).key + " " + resultList.get(i).value);
		}
		
		System.out.println("Search value with key A:- " + dictionaryObject.searchValue("A"));
		
		System.out.println("Delete specified key..");
		dictionaryObject.deleteKeyValue("D");
		ArrayList<TreeNode> resultList2= dictionaryObject.getList();
		
		for(int i= 0; i < resultList2.size(); i++) {
			System.out.println(resultList2.get(i).key + " " + resultList2.get(i).value);
		}
	}

}
