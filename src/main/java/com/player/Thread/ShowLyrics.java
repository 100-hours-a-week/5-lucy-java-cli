package com.player.Thread;

import java.util.List;

public class ShowLyrics implements Runnable{
    private IsPlaying isPlaying;
    private  List<String> lyrics;

    // 생성자
    public ShowLyrics(List<String> lyrics, IsPlaying isPlaying) {
        this.lyrics = lyrics;
        this.isPlaying = isPlaying;
    }

    public void run(){
        // 가사 리스트의 인덱스 (가사 파일의 한 줄)
        int lyricIndex = 0;
        // flag 가 true 일 때 실행
        while (isPlaying.getRunning()){
            // 마지막 가사까지 출력
            if (lyricIndex < lyrics.size()) {
                // 한줄 출력하고
                System.out.println(lyrics.get(lyricIndex));
                // 1초 쉬고
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    System.out.println("오류2");
                }
                // index 값 더해주기
                lyricIndex++;
            }
            // 남은 가사가 없다면 "재생 완료" 출력
            else {
                System.out.println(" ");
                System.out.println("재생이 완료 되었습니다.");
                break;
        }
        }
    }
}
