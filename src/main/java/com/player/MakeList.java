package com.player;
// SongList 데이터를 가지고 와서 리스트를 생성&출력하는 클래스
// 1. 전곡 리스트
// 2. 랜덤 리스트
// 3. 가수 리스트
// 4. 가수 노래 리스트

import java.util.*;

public class MakeList extends SongList {
    public MakeList() {
    }

    public void showPlayListAll (){
        for (int i = 0; i < playList.length; i++){
            System.out.print(playList[i].getId());
            System.out.print(". ");
            System.out.print(playList[i].getArtist());
            System.out.print(" - ");
            System.out.println(playList[i].getTitle());
        }
    }

    public void showPlayListRandom(){
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

    public void showArtists (){
        // 중복 제거를 위한 Set 생성
        Set<String> uniqueArtists = new HashSet<>();
        // playList 배열에서 가수 정보만 추출해서 Set에 저장하기
        for (Song artist : playList ){
            uniqueArtists.add(artist.getArtist());
        }
        // set 자료구조에 있는 artist 들을 모두 출력 ?
        int index = 1;
        for (String artist : uniqueArtists){
            System.out.print(index+". ");
            System.out.println(artist);
            index++;
        }
    }

    public void showPlayListByArtist (int number){
        // 입력받은 번호의 가수명을 가져와서
        // 가수명이 일치하는 노래의 리스트를 생성
        System.out.println(number + "가수를 선택하셨습니다.");
        System.out.println("=========================");
        System.out.println(number + "가수의 노래 리스트");
        System.out.println("=========================");

    }
}
