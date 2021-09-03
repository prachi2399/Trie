public class trie{
    public static class Trie {

        private class Node{
            Node[] childs;
            boolean isEnd;
            Node(){
                childs = new Node[26];
                isEnd = false;
            }
        }
        final private Node root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new Node();
        }
    
        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node curr = root;
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                
                if(curr.childs[ch-'a']==null){
                    curr.childs[ch-'a'] = new Node();
                }
                curr = curr.childs[ch-'a'];
            }
            curr.isEnd= true;
        }
    
        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                
                if(curr.childs[ch-'a']==null) return false;
                curr = curr.childs[ch-'a'];
            }
            return curr.isEnd;
        }
    
        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            for(int i=0;i<prefix.length();i++){
                char ch = prefix.charAt(i);
                
                if(curr.childs[ch-'a']==null) return false;
                curr = curr.childs[ch-'a'];
            }
            return true;
        }
    }

    // xor of 2 numbers
    public static class Trie {

        public class Node {
          Node left, right;
        }
    
        Node root;
        Trie() {
          root = new Node();
        }
    
        public void insert(int val) {
          int bitIndex = 30;
          Node curr = root;
    
          while (bitIndex >= 0) {
            int mask = 1 << bitIndex;
            int bit = (mask & val) > 0 ? 1 : 0;
    
            if (bit == 0) {
              if (curr.left == null) {
                curr.left = new Node();
              }
              curr = curr.left;
            } else {
              if (curr.right == null) {
                curr.right = new Node();
              }
              curr = curr.right;
            }
    
            bitIndex--;
          }
    
        }
    
        public int query(int find) {
          int bitIndex = 30;
          Node curr = root;
          int ans = 0;
    
          while (bitIndex >= 0) {
            int mask = 1 << bitIndex;
            int bit = (find & mask) > 0 ? 1 : 0;
    
            if (bit == 0) {
              if (curr.left != null) {
                curr = curr.left;
              } else {
                curr = curr.right;
                ans |= mask;
              }
            } else {
              if (curr.right != null) {
                curr = curr.right;
                ans |= mask;
              } else {
                curr = curr.left;
              }
            }
    
    
            bitIndex--;
          }
    
          return ans;
        }
      }
      public static int findMaximumXOR(int[] nums) {
        // write your code here
        Trie trie = new Trie();
    
            for(int val:nums){
                trie.insert(val);
            }
    
            int max = 0;
            for(int a:nums){
                int find =  Integer.MAX_VALUE ^ a;
                int b = trie.query(find);
                max = Math.max(max,a^b);
            }
            return max;
    }
    
    
    public static void main() {
        
    }
}