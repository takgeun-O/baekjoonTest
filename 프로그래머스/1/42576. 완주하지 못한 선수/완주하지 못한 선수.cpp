#include <string>
#include <vector>
#include <algorithm>
#include <unordered_map>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    string answer = "";
    unordered_map<string, int> map;
    
    for(auto player : participant) {
        // map에서 데이터를 찾을 때 iterator를 사용
        // iterator가 데이터를 끝까지 찾지 못하면 map.end() 반환
        if(map.find(player)==map.end())
            map.insert(make_pair(player, 1));
        else
            map[player]++;
    }
    
    for(auto player : completion) {
        map[player]--;
    }
    
    for(auto player: participant) {
        if(map[player]>0) {
            answer = player;
            break;
        }
    }
    
    
    return answer;
}