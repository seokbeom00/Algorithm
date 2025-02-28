import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        String[] line = today.split("\\.");
        int todayYear = Integer.parseInt(line[0]);
        int todayMonth = Integer.parseInt(line[1]);
        int todayDay = Integer.parseInt(line[2]);
        
        Map<String, Integer> term = new HashMap<>();
        for(String s : terms){
            line = s.split(" ");
            term.put(line[0], Integer.parseInt(line[1]));
        }
        int index = 0;
        List<Integer> ans = new ArrayList<>();
        for(String p : privacies){
            index += 1;
            line = p.split(" ");
            String day = line[0];
            int dayTerm = term.get(line[1]);
            line = day.split("\\.");
            int dayYear = Integer.parseInt(line[0]);
            int dayMonth = Integer.parseInt(line[1]);
            int dayDay = Integer.parseInt(line[2]);
            dayMonth += dayTerm;
            if(dayMonth <= 12){
                dayDay -= 1;
                if(dayDay == 0){
                    dayDay = 28;
                    dayMonth -= 1;
                }
            }else{
                if(dayMonth % 12 == 0){
                    dayYear += dayMonth/12 - 1;
                    dayMonth = 12;
                }else{
                    dayYear += dayMonth / 12;
                    dayMonth %= 12;
                }
                dayDay -= 1;
                if(dayDay == 0){
                    dayDay = 28;
                    dayMonth -= 1;
                }
            }
            
            if(dayYear < todayYear){
                ans.add(index);
            }else if(dayYear == todayYear){
                if(dayMonth < todayMonth){
                    ans.add(index);
                }else if(dayMonth == todayMonth){
                    if(dayDay < todayDay){
                        ans.add(index);
                    }
                }
            }
        }
        int[] answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}