import java.util.*;

public class Solution {


    public int[] solution(String[] genres, int[] plays) {


        Map<String, Integer> genresPlayCount = new HashMap<>();
        Map<String, List<Song>> songMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {

            if(plays[i]<0){
                throw new IllegalArgumentException("플레이수가 음수입니다.");
            }

            if(genres[i]!=null) {

                genresPlayCount.put(genres[i], genresPlayCount.getOrDefault(genres[i], 0) + plays[i]);

                List<Song> songList = songMap.getOrDefault(genres[i], new ArrayList<>());
                songList.add(new Song(i, plays[i]));
                songMap.put(genres[i], songList);
            }
        }


        List<String> sortedGenres = new ArrayList<>(genresPlayCount.keySet());
        sortedGenres.sort((a, b) -> {
            int playCountComparison = genresPlayCount.get(b) - genresPlayCount.get(a);
            if (playCountComparison == 0) {
                return a.compareTo(b); // 재생 횟수가 같을 때는 장르 이름의 사전순으로 정렬
            }
            return playCountComparison;
        });

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

    public class Song implements Comparable<Song> {

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
//테스트코드

  @Test
    void 정상작동(){
        //given
        String[] genres ={"classic", "pop", "classic", "k-pop", "pop", "classic", "classic"};
        int[] plays ={30, 10, 40, 70, 20, 30, 50};
        int[] expected = {6, 2, 3, 4, 1};

        //when
        int[] actual = solution(genres, plays);

        //then

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 정상작동_오답(){
        //given
        String[] genres ={"classic", "pop", "classic", "k-pop", "pop"};
        int[] plays ={30, 10, 40, 70, 20};
        int[] expected = {3, 0, 1, 5, 2};

        //when
        int[] actual = solution(genres, plays);

        //then

        Assertions.assertThat(actual).isNotEqualTo(expected);
    }

    @Test
    void 장르_한개(){
        //given
        String[] genres ={"classic", "classic", "classic", "classic", "classic"};
        int[] plays ={30, 10, 40, 70, 20};
        int[] expected = {3, 2};

        //when
        int[] actual = solution(genres, plays);

        //then

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 빈_배열(){
        //given
        String[] genres ={ };
        int[] plays ={ };
        int[] expected = { };

        //when
        int[] actual = solution(genres, plays);

        //then

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 장르별_곡한곡(){
        //given
        String[] genres ={"classic", "pop", "j-pop", "k-pop", "f-pop", "rock", "band"};
        int[] plays ={30, 10, 40, 70, 20, 30, 50};
        int[] expected = {3, 6, 2, 0, 5,4, 1};

        //when
        int[] actual = solution(genres, plays);

        //then

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 플레이수_음수(){
        //given
        String[] genres ={"classic", "pop", "j-pop","classic", "pop", "j-pop" };
        int[] plays ={-20, -10, 40, 30, 10, 40};

        IllegalArgumentException e = org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,
                () -> solution(genres, plays));

        Assertions.assertThat(e.getMessage()).isEqualTo("플레이수가 음수입니다.");
    }
    @Test
    void 곡플레이수동일(){
        //한 장르에서 곡마다 플레이수가 동일할 때 사전순으로 순서
        //given
        String[] genres ={"classic", "pop", "classic", "k-pop", "pop", "classic", "k-pop"};
        int[] plays ={30, 10, 30, 70, 20, 30, 50};
        int[] expected = {3, 6, 0, 2, 4, 1};

        //when
        int[] actual = solution(genres, plays);

        //then

        Assertions.assertThat(actual).isEqualTo(expected);
    }

}
