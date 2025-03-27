import java.io.*;
import java.util.*;

public class Main {
    static class TrieNode{
        Map<Character, TrieNode> children = new HashMap<>();
        List<Integer> indicated = new ArrayList<>();
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static TrieNode root = new TrieNode();
    static int index1 = 0, index2 = 0, maxDepth = 0;
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            words.add(word);
            insert(word, i);
        }
        dfs(root, 0);
        System.out.println(words.get(index1));
        System.out.println(words.get(index2));
    }

    public static void dfs(TrieNode node, int depth) {
        if (node.indicated.size() >= 2 && maxDepth < depth) {
            index1 = node.indicated.get(0);
            index2 = node.indicated.get(1);
            maxDepth = depth;
        }else if (depth == maxDepth && node.indicated.size() >= 2) {
            int cand1 = node.indicated.get(0);
            int cand2 = node.indicated.get(1);

            if (cand1 < index1 || (cand1 == index1 && cand2 < index2)) {
                index1 = cand1;
                index2 = cand2;
            }
        }
        for (TrieNode child : node.children.values()) {
            dfs(child, depth + 1);
        }
    }

    public static void insert(String word, int index) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.children.computeIfAbsent(c, k -> new TrieNode());
            node.indicated.add(index);
        }
    }
}
