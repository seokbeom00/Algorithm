import java.util.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        for(int i=0; i<name.length(); i++){
            char target = name.charAt(i);
            int up = (int)target - (int)'A';
            int down = (int)'Z' - (int)target + 1;
            answer += Math.min(up, down);
        }
        if(answer == 0){
            return answer;
        }
        int start = 0;
        int end = 0;
        int max = 0;
        for(int i=0; i<name.length(); i++){
            if(name.charAt(i) == 'A'){
                int len = 1;
                int tmp = i;
                if(i != name.length() - 1){
                    for(int j=i+1; j<name.length(); j++){
                        if(name.charAt(j) != 'A'){
                            break;
                        }
                        len++;
                        tmp = j;
                    }
                }
                if(len > max){
                    max = len;
                    start = i;
                    end = tmp;
                }
            }
        }
        int min = 0;
        int front = 0;
        for(int i=0; i<name.length(); i++){
            if(name.charAt(i) != 'A'){
                front = i;
                break;
            }
        }
        for(int i=name.length()-1; i>=0; i--){
            if(name.charAt(i) != 'A'){
                min = i;
                break;
            }
        }
        if(max == 0){
            answer += name.length() - 1;
        }else{
            int tmp = Math.min(min, name.length() - front);
            if(start != 0){
                tmp = Math.min(tmp, (start - 1) * 2 + name.length() - 1 - end);
            }
            if(end != name.length()-1){
                tmp = Math.min(tmp, (name.length() - 2 - end) * 2 + 1 + start);
            }
            answer += tmp;
        }
        return answer;
    }
}