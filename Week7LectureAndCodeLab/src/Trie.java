/**
 * Created by liukx08 on 5/4/2017.
 */
public class Trie {
    TrieNode root;

    class TrieNode {
        char letter;
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            int idx = c - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode tail = match(root, word.toCharArray(), 0);
        return tail != null && tail.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode tail = match(root, prefix.toCharArray(), 0);
        return tail != null;
    }

    private TrieNode match(TrieNode root, char[] word, int depth) {
        if(root == null || depth == word.length) {
            return root;
        }
        return match(root.children[word[depth] - 'a'], word, depth + 1);
    }
}
