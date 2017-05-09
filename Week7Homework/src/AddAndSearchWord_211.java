/**
 * Created by liukx08 on 5/8/2017.
 */
public class AddAndSearchWord_211 {

    TrieNode root;

    class TrieNode {
        boolean isWord;
        TrieNode[] next;
        public TrieNode() {
            next = new TrieNode[26];
            isWord = false;
        }
    }

    /** Initialize your data structure here. */
    public AddAndSearchWord_211() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(word == null || word.isEmpty()) {
            return;
        }
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            int idx = c - 'a';
            if(curr.next[idx] == null) {
                curr.next[idx] = new TrieNode();
            }
            curr = curr.next[idx];
        }
        curr.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(word == null || word.isEmpty()) {
            return false;
        }
        return match(root, word.toCharArray(), 0);
    }

    private boolean match(TrieNode root, char[] word, int idx) {
        if(root == null) {
            return false;
        }
        if(idx == word.length) {
            return root.isWord;
        }
        if(word[idx] != '.') {
            return match(root.next[word[idx] - 'a'], word, idx + 1);
        } else {
            for(TrieNode next : root.next) {
                if(match(next, word, idx + 1)) {
                    return true;
                }
            }
            return false;
        }
    }
}
