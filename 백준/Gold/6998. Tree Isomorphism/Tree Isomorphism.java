import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static class Node{
        Node parent;
        String name;
        List<Node> child;

        Node(Node parent, String name) {
            this.parent = parent;
            this.name = name;
            this.child = new ArrayList<>();
        }

        void addChild(Node child) {
            this.child.add(child);
        }
    }
    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String[] tree1 = br.readLine().split(" ");
            List<Set<Integer>> countMap1 = making(tree1);
            String[] tree2 = br.readLine().split(" ");
            List<Set<Integer>> countMap2 = making(tree2);
            if (countMap1.equals(countMap2)) {
                System.out.println("The two trees are isomorphic.");
            }else{
                System.out.println("The two trees are not isomorphic.");
            }
        }
    }

    public static List<Set<Integer>> making(String[] tree) {
        int tmp = 1;
        int depth = 1;
        Node root = new Node(null, tree[0]);
        Node current = root;
        for (int i = 1; i < tree.length; i++) {
            if (tree[i].equals("#")) {
                current = current.parent;
                tmp--;
            } else {
                Node newNode = new Node(current, tree[i]);
                current.addChild(newNode);
                current = newNode;
                tmp++;
                depth = Math.max(tmp, depth);
            }
        }
        List<Set<Integer>> countMap = new ArrayList<>();
        for (int i = 0; i < depth; i++) {
            countMap.add(new HashSet<>());
        }
        dfs(countMap, 0, root);
        return countMap;
    }

    public static void dfs(List<Set<Integer>> countMap, int depth, Node node) {
        countMap.get(depth).add(node.child.size());
        if (node.child.size() != 0) {
            for (Node child : node.child) {
                dfs(countMap, depth + 1, child);
            }
        }
    }
}
