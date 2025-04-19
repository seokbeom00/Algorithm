import java.util.*;
class Solution {
    static class Trie{
        Map<Character, Trie> child = new HashMap<>();
        int cnt = 0;
        void insert(String word){
            Trie node = this;
            node.cnt++;
            for(char c : word.toCharArray()){
                node = node.child.computeIfAbsent(c, k -> new Trie());
                node.cnt++;
            }
        }
        int search(String findWord){
            Trie node = this;
            for(char c : findWord.toCharArray()){
                if(c == '?'){
                    break;
                }
                node = node.child.get(c);
                if(node == null){
                    return 0;
                }
            }
            return node.cnt;
        }
    }
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        Map<Integer, Trie> tMap = new HashMap<>();
        Map<Integer, Trie> reverse_tMap = new HashMap<>();
        for(String word : words){
            int len = word.length();
            tMap.putIfAbsent(len, new Trie());
            tMap.get(len).insert(word);
            String reverse_word = new StringBuilder(word).reverse().toString();
            reverse_tMap.putIfAbsent(len, new Trie());
            reverse_tMap.get(len).insert(reverse_word);
        }
        
        for(int i = 0; i<queries.length; i++){
            String query = queries[i];
            int len = query.length();
            if(query.charAt(0) != '?'){
                if(tMap.containsKey(len)){
                    answer[i] = tMap.get(len).search(query);
                }else{
                    answer[i] = 0;
                }
            }else{
                if(reverse_tMap.containsKey(len)){
                    answer[i] = reverse_tMap.get(len).search(new StringBuilder(query).reverse().toString());
                }else{
                    answer[i] = 0;
                }
            }
        }
        return answer;
    }
}