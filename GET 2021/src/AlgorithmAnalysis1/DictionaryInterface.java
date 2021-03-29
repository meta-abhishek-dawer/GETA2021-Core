package AlgorithmAnalysis1;

import java.util.ArrayList;

/**
 * Interface in which we declare different methods
 * @author abhishek.dawer_metac
 *
 */
public interface DictionaryInterface {
    public void insertValue(String key, String value);
    public ArrayList<TreeNode> getList();
    public void deleteKeyValue(String keyValue);
    public String searchValue(String keyValue);
    public ArrayList<TreeNode> keyValueInRange(String key1, String key2);
}
