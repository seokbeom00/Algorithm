import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        char[] arr = number.toCharArray();
        Deque<Character> right = new ArrayDeque<>();
        Deque<Character> left = new ArrayDeque<>();
        for(char c : arr){
            right.addLast(c);
        }
        while(k > 0){
            if(left.isEmpty()){
                left.addLast(right.removeFirst());
            }else{
                if(!right.isEmpty() && left.peekLast() >= right.peekFirst()){
                    left.addLast(right.removeFirst());
                }else{
                    left.removeLast();
                    k--;
                }
            }
        }
        while(!left.isEmpty()){
            answer.append(left.removeFirst());
        }
        while(!right.isEmpty()){
            answer.append(right.removeFirst());
        }
        return answer.toString();
    }
}