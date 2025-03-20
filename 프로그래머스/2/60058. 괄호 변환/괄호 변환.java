import java.util.*;
class Solution {
    public String solution(String p) {
        //1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다. 
        if(p.length() == 0){
            return "";
        }
        
        //2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다.
        int left = 0, right = 0, index = 0;
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i) == '('){
                left++;
            }else{
                right++;
            }
            if(left == right){
                index = i;
                break;
            }
        }
        String u = p.substring(0, index+1);
        String v = p.substring(index+1);
        //3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        if(isCorrect(u)){
            //3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
            return u + solution(v);
        }else{
            StringBuilder sb = new StringBuilder();
            sb.append("(").append(solution(v)).append(")");
            if(u.length() > 2){
                sb.append(reverse(u));
            }
            return sb.toString();
        }
        // System.out.println(u + "/" + v);
    }
    
    public static String reverse(String s){
        String result = "";
        for(int i=1; i<s.length()-1; i++){
            if(s.charAt(i) == '('){
                result += ")";
            }else{
                result += "(";
            }
        }
        return result;
    }
    
    public static boolean isCorrect(String s){
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for(char c : arr){
            if(c == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    return false;
                }
            }else{
                stack.push(c);
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}