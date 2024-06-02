package com.player.Thread;

import com.player.MakeList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class IsPlaying {
    // 매개 변수로 받은 리스트 목록을 담을 빈 리스트
    private List<String> playingList;
    // true 일 때, 가사를 출력하고, false 일 때, 가사출력을 멈춘다. : flag 설정
    private boolean running = true;
    private int musicIndex;

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
        return musicIndex;
    }
    // 노래 index setter
    public void setMusicIndex(int musicIndex) {
        this.musicIndex = musicIndex;
    }

    // 노래 재생하기 메서드
    public void printMusic(){
        // musicList 있는 노래를 다 출력할 때까지 반복
        while (musicIndex < playingList.size()){
            // 공유 객체에 하나의 스레드만 접근 가능하도록 synchronized 블록 생성
            synchronized (this){
                // flag가 true라면 노래 가사 출력
                if(getRunning()){
                    String fileName = playingList.get(musicIndex)+".txt";
                    Path filePath = Paths.get("src", "main", "resources", "Text", fileName);
                    try {
                        // 가사 배열 생성
                        List<String> lyrics = Files.readAllLines(filePath);
                        System.out.println("[현재곡] " + playingList.get(musicIndex) + " 재생 중...");

                        // 노래 가사를 출력할 때마다, 메뉴 쓰레드 실행 : 5초 후 메뉴 보이게 하기
                        ShowMenu showMenu = new ShowMenu(playingList, this);
                        Thread menu = new Thread(showMenu);
                        menu.start();

                        // 가사 출력 쓰레드 : 한 줄씩 가사 출력하기
                        ShowLyrics showLyrics = new ShowLyrics(lyrics, this);
                        Thread print = new Thread(showLyrics);
                        print.start();

                        try {
                            // menu.join 하면, 데드락 된다.
                            // menu.join();
                            // print.join 하지 않으면, 리스트에 있는 모든 곡이 한 번에 출력된다.
                            print.join();
                        } catch (InterruptedException e){
                            System.out.println("interruptedException!");
                        }
                    } catch (IOException e) {
                        System.out.println("노래 가사 파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
                    }
                    // flag 가 false 이면 현재 스레드 대기
                } else {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        System.out.println("interruptedException!");
                    }
                }
            }
        }
    }
}
