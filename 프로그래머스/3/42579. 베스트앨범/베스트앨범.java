import java.util.*;

public class Solution {


    public int[] solution(String[] genres, int[] plays) {


        Map<String, Integer> genresPlayCount = new HashMap<>();
        Map<String, List<Song>> songMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {

            genresPlayCount.put(genres[i], genresPlayCount.getOrDefault(genres[i], 0) + plays[i]);

            List<Song> songList = songMap.getOrDefault(genres[i], new ArrayList<>());
            songList.add(new Song(i, plays[i]));
            songMap.put(genres[i], songList);
        }


        List<String> sortedGenres = new ArrayList<>(genresPlayCount.keySet());
        sortedGenres.sort((a, b) -> genresPlayCount.get(b) - genresPlayCount.get(a));

        List<Integer> answerList = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<Song> songList = songMap.get(genre);
            Collections.sort(songList);
            answerList.add(songList.get(0).index);
            if (songList.size() > 1) {
                answerList.add(songList.get(1).index);
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    class Song implements Comparable<Song> {

        int index;
        int plays;

        Song(int index, int plays) {
            this.index = index;
            this.plays = plays;
        }

        @Override
        public int compareTo(Song other) {
            if (this.plays == other.plays) {
                return this.index - other.index; // 오름차순 (낮은 인덱스 우선)
            }
            return other.plays - this.plays; // 내림차순 (높은 재생 횟수 우선)
        }
    }
}