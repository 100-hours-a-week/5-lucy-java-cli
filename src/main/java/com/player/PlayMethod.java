package com.player;

import java.util.*;

public class PlayMethod extends PlayList{
    public PlayMethod() {}

    @Override
    // 랜덤 5곡 보여주기
    public void showPlayList(){
        // Collection.shuffle 을 사용하기 위해서 List 로 변환
        // playList 배열을 playLists 리스트로 생성
        List<Song> playLists = new ArrayList<>(Arrays.asList(playList));
        Collections.shuffle(playLists);

        for (int i = 0; i < 5; i++ ){
            // playLists 리스트에서 i번째 객체를 가져와 song 변수에 저장
            Song song = playLists.get(i);
            System.out.print(i+1);
            System.out.print(". ");
            System.out.print(song.getArtist());
            System.out.print(" - ");
            System.out.println(song.getTitle());
        }
    }
};
