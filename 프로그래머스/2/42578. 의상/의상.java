import java.util.*;
class Solution {
    static Map<String, List<String>> map;
    public int solution(String[][] clothes) {
        map = new HashMap<>();
        for(String[] clothe : clothes){
            String key = clothe[1];
            String name = clothe[0];
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(name);
        }
        int answer = 1;
        for(String key : map.keySet()){
            answer *= map.get(key).size() + 1;
        }
        return answer - 1;
    }
}