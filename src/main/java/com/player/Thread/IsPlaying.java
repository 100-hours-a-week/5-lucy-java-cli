package com.player.Thread;

import com.player.MakeList;

import java.util.*;

public class IsPlaying {
    // 매개 변수로 받은 리스트 목록을 담을 빈 리스트
    private List<String> playingList;
    // true 일 때, 가사를 출력하고, false 일 때, 가사출력을 멈춘다. : flag 설정
    private boolean running = true;
    private int MusicIndex;

    // 생성자
    public IsPlaying(MakeList makeList) {
        // 빈 리스트에 업데이트
        this.playingList = new ArrayList<>(makeList.getNewPlayList());
    }

    // flag getter
    public boolean getRunning() {
        return running;
    }
    // flag setter
    public void setRunning(boolean running) {
        this.running = running;
    }

    // 노래 index getter
    public int getMusicIndex() {
        return MusicIndex;
    }
    // 노래 index setter
    public void setMusicIndex(int musicIndex) {
        MusicIndex = musicIndex;
    }

    // 재생하기 메서드
    public void printSong() {
        // 가사 출력 스레드 : 노래 플레이 리스트와, 공유 객체를 매개 변수로 받음
        PlayMusic playMusic = new PlayMusic(playingList, this);
        // 스레드 실행
        Thread lyric = new Thread(playMusic);
        lyric.start();

        try {
            lyric.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
