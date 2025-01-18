import java.util.HashMap;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = players;
        HashMap<String, Integer> order = new HashMap<>();
        for(int i = 0; i < players.length; i++) {
            order.put(players[i], i);
        }

        for(int i = 0; i < callings.length; i++) {
            int idx = order.get(callings[i]);

            String prev_player = players[idx-1];
            players[idx-1] = callings[i];
            players[idx] = prev_player;
            order.replace(callings[i], idx-1);
            order.replace(prev_player, idx);
        }

        return answer;
    }
}