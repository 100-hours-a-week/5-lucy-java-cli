package com.player.Thread;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.Semaphore;

class PlayMusic implements Runnable {
    private IsPlaying isPlaying;
    private List<String> musicList;

    int musicIndex;

    // 생성자
    public PlayMusic(List<String> printList, IsPlaying isPlaying) {
        this.musicList = printList;
        this.isPlaying = isPlaying;
    }

    public void run(){
        // musicList 있는 노래를 다 출력할 때까지 반복
        while (musicIndex < musicList.size()){

            // 공유 객체에 하나의 스레드만 접근 가능하도록 synchronized 블록 생성
            synchronized (isPlaying){
                // 공유 객체에 있는 노래 index 값 가져오기
                musicIndex = isPlaying.getMusicIndex();
                // flag가 true라면 노래 가사 출력
                if(isPlaying.getRunning()){
                String fileName = musicList.get(musicIndex)+".txt";
                Path filePath = Paths.get("src", "main", "resources", "Text", fileName);
                try {
                    // 가사 배열 생성
                    List<String> lyrics = Files.readAllLines(filePath);
                    System.out.println("[현재곡] " + musicList.get(musicIndex) + " 재생 중...");

                    // 노래 가사를 출력할 때마다, 메뉴 쓰레드 실행 : 5초 후 메뉴 보이게 하기
                    ShowMenu showMenu = new ShowMenu(musicList, this.isPlaying);
                    Thread menu = new Thread(showMenu);
                    menu.start();

                    // 가사 출력 쓰레드 : 한 줄씩 가사 출력하기
                    ShowLyrics showLyrics = new ShowLyrics(lyrics, this.isPlaying);
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
                // flag 가 false 이면 현재 스레드 대기 상태로
                } else {
                    try {
                        // 현재 쓰레드(PlayMusic)는 isPlaying에 대한 락을 해제
                        // -> 다른 쓰레드가 접근 가능하도록 한다.
                        isPlaying.wait();
                    } catch (InterruptedException e) {
                        System.out.println("interruptedException!");
                    }
                }
            }
        }
    }
}

