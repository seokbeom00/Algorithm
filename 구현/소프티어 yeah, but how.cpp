#include<iostream>
#include<vector>

using namespace std;

int main(int argc, char** argv)
{
    string s;
    cin >> s;
    vector<char> answer;
    bool flag = false;
    for(int i=0; i<s.size(); i++){
        if(s[i] == ')'){
            if(flag){
                answer.push_back('1');
                answer.push_back(')');
            }else{
                answer.push_back(')');
            }
            flag = false;
            if(i+1 < s.size() && s[i+1] == '('){
                answer.push_back('+');
            }
        }else{
            flag = true;
            answer.push_back('(');
        }
    }
    for(int i=0; i<answer.size(); i++){
        cout << answer[i];
    }
    return 0;
}
