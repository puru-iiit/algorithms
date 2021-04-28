package com.puru.random;

import java.util.*;

public class TopKFrequent {

    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(new Solution2().topKFrequent(words,2));
    }

}
class Solution2 {
    public List<String> topKFrequent(String[] words, int k) {

        List<String> list = new ArrayList<>();

        findKfrequentWords(words, k,list);
        return list;
    }

    class Node implements Comparable{
        String key;
        int count;
        // constructor
        Node(String key, int count) {
            this.key = key;
            this.count = count;
        }
        @Override
        public int compareTo(Object o) {
            Node node = (Node)o;

            if(count - node.count==0){
                return  node.key.compareTo(key);
            }
            return count - node.count;
        }
    }


    class Trie{
        // count and key will be set only for leaf nodes
        // key stores the string and count stores its frequency so far
        int count = 0;
        String key = null;
        // each node stores a map to its child nodes
        Map<Character, Trie> character = new HashMap<>();
    }

    // Iterative function to insert a string in Trie.
    public void insert(Trie head, String str) {
        // start from root node
        Trie curr = head;
        for (int i = 0; i < str.length(); i++)  {
            // create a new node if path doesn't exists
            if (!curr.character.containsKey(str.charAt(i))) {
                curr.character.put(str.charAt(i), new Trie());
            }
            // go to next node
            curr = curr.character.get(str.charAt(i));
        }
        // store key and its count in leaf nodes
        curr.key = str;
        curr.count += 1;
    }
    // Function to perform pre-order traversal of Trie and insert
    // each distinct key along with its count in max-heap
    public void preorder(Trie curr, PriorityQueue<Node> pq, int k) {
        // base condition
        if (curr == null) {
            return;
        }
        for (Map.Entry<Character, Trie> entry: curr.character.entrySet()) {
            // if leaf node is reached (leaf node have non-zero count),
            // push key with its frequency in max-heap
            if (entry.getValue().count != 0) {
                if(pq.size()==k){
                    //System.out.println("DUdue");
                    if(pq.peek().count<entry.getValue().count) {
                        pq.poll();
                    } if(pq.peek().count==entry.getValue().count){
                        k =k++;
                    }else{
                        continue;
                    }
                }
                pq.add(new Node(entry.getValue().key, entry.getValue().count));
            }
            // recurse for current node children
            preorder(entry.getValue(), pq,k);
        }
    }
    // Function to find first k-maximum occurring words in given list of strings
    public void findKfrequentWords(String[] dict, int k,  List<String> list) {
        Trie head = new Trie();
        // insert all keys into trie and maintain each key frequency in trie leaf nodes
        for (String word: dict) {
            insert(head, word);
        }
        // create an empty max-heap
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // perform pre-order traversal of given Trie and push each
        // unique key with its frequency in max-heap
        preorder(head, pq,k);
        // do till max-heap is not empty or k keys are not printed
        Stack<String> s = new Stack<>();
        while (k-- > 0 && !pq.isEmpty()) {
            // extract the maximum node from the max-heap
            Node max = pq.poll();
            // print the maximum occurring element with its count
            s.push(max.key);
        }
        while(!s.isEmpty()){
            list.add(s.pop());
        }
    }


}
