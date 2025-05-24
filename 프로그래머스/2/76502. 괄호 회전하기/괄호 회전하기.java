import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length; i++){
            if(check(arr, i)){
                answer++;
            }
        }
        return answer;
    }
    public static boolean check(char[] arr, int start){
        Stack<Character> stack = new Stack<>();
        for(int i=start; i<start + arr.length; i++){
            int idx = i % arr.length;
            if(arr[idx] == '(' || arr[idx] == '{' || arr[idx] == '['){
                stack.push(arr[idx]);
            }else{
                stack.push(arr[idx]);
                bomb(stack);
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    public static void bomb(Stack<Character> stack){
        char target = 'a';
        while(true){
            if(stack.isEmpty()){
                break;
            }
            if(stack.peek() == ')' || stack.peek() == '}' || stack.peek() == ']'){
                target = stack.pop();
            }else{
                break;
            }
            if(target == ')'){
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else{
                    stack.push(target);
                    break;
                }
            }else if(target == '}'){
                if(!stack.isEmpty() && stack.peek() == '{'){
                    stack.pop();
                }else{
                    stack.push(target);
                    break;
                }
            }else if(target == ']'){
                if(!stack.isEmpty() && stack.peek() == '['){
                    stack.pop();
                }else{
                    stack.push(target);
                    break;
                }
            }
        }
    }
}