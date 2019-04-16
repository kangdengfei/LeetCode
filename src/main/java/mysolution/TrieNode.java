package mysolution;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-04-16
 **/
public class TrieNode {
    public int end;
    public int path;
    public TrieNode[] trieNodes;
    public TrieNode(){
        trieNodes = new TrieNode[26];
    }
}



