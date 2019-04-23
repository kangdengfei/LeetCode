package mysolution;

/**
 * @program: Code
 * @author: KDF
 * @create: 2019-04-16
 **/
/*
字典树
 */
public class Trie {
    public TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    public void insert(String string){
        if (string == null)
            return;
        TrieNode node = root;//这步重要，不能污染root
        for (int i = 0;i<string.length();i++){
            int index = string.charAt(i) - 'a';
            if (node.trieNodes[index] == null){
                node.trieNodes[index] = new TrieNode();
            }
            node = node.trieNodes[index];
            node.path++;

        }
        node.end++;

    }
    public boolean search(String string){
        if (string == null)
            return false;
        TrieNode node = root;
        for (int i = 0;i<string.length();i++){
            int index = string.charAt(i) - 'a';
            if (node.trieNodes[index] != null){
                node = node.trieNodes[index];
            }else
                return false;
        }
        return node.end != 0;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("qwrqrq");
        System.out.println(trie.search("qwrqrqz"));
    }
}



