package com.player;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class ShowLyric implements Runnable {
    private IsPlaying isPlaying;
    private List<String> printList;
    private int songIndex = 0;

    // 생성자
    public ShowLyric(List<String> printList, IsPlaying isPlaying) {
        this.printList = printList;
        this.isPlaying = isPlaying;
    }

    public void run(){
        // printList에 있는 노래를 다 출력할 때까지 반복
        while (songIndex < printList.size()){
            // sychronized 블록
            synchronized (isPlaying){
                // isPlay가 true라면 실행
                if(isPlaying.getPlay()){
                // 배열의 첫 번째 노래의 가사부터 출력
                String fileName = printList.get(songIndex)+".txt";
                Path filePath = Paths.get("src", "main", "resources", "Text", fileName);

                try {
                    // 가사를 리스트에 담고, 가사 출력 스레드로 넘김
                    List<String> lyrics = Files.readAllLines(filePath);
                    System.out.println("[현재곡] " + printList.get(songIndex) + " 재생 중...");

                    // 노래 가사를 출력할 때마다, 10초 후 메뉴 보이게 하기
                    // 메뉴 띄우기 스레드
                    ShowMenu showMenu = new ShowMenu(printList, this.isPlaying, this.songIndex);
                    Thread menu = new Thread(showMenu);
                    menu.start();

                    // 한줄씩 가사 출력하는 스레드
                    PrintLyrics printLyrics = new PrintLyrics(lyrics, this.isPlaying);
                    Thread print = new Thread(printLyrics);
                    print.start();

                    try {
//                        menu.join();
                        print.join();
                    } catch (InterruptedException e){
                        System.out.println("interruptedException!");
                    }
                } catch (IOException e) {
                    System.out.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
                }
                //isPlay의 값이 false이면 스레드 대기
                }
                else {
                    try {
                        isPlaying.wait();
                    } catch (InterruptedException e) {
                        System.out.println("interruptedException!");
                    }
                    songIndex++;
                }
            }
        }
    }
}

