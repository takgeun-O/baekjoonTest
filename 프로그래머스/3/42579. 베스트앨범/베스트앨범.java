import java.util.*;
import java.io.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, ArrayList<int[]>> genreMap = new HashMap<>();
        HashMap<String, Integer> playMap = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i=0;i<genres.length;i++) {
            String genre = genres[i];
            int play = plays[i];
            
            if(!genreMap.containsKey(genre)) {
                genreMap.put(genre, new ArrayList<>());
                playMap.put(genre, 0);
            }
            
            genreMap.get(genre).add(new int[]{i, play});
            playMap.put(genre, playMap.get(genre) + play);
        }
        
        // for(Map.Entry<String, ArrayList<int[]>> entry : genreMap.entrySet()) {
        //     System.out.print(entry.getKey() + " ");
        //     for(int[] song : entry.getValue()) {
        //         System.out.print(Arrays.toString(song));
        //     }
        //     System.out.println();
        // }
        
        for(Map.Entry<String, Integer> entry : playMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        
        // playMap : 장르별 총 재생횟수 -> pop 3100 // classic 1450
        // genreMap : 고유번호별 재생횟수
        Stream<Map.Entry<String, Integer>> sortedGenre = playMap.entrySet().stream()
            .sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        
        sortedGenre.forEach(entry -> {
            Stream<int[]> sortedSongs = genreMap.get(entry.getKey()).stream()
                .sorted((o1, o2) -> Integer.compare(o2[1], o1[1]))
                .limit(2);
            
            sortedSongs.forEach(song -> answer.add(song[0]));
        });
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}