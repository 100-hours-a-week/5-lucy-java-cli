package com.player;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class IsPlaying extends MakeList {
    // 매개 변수로 받은 리스트 목록을 담을 빈 리스트 생성
    private List<String> playingList;

    public IsPlaying(MakeList makeList) {
        // 빈 리스트에 업데이트
        this.playingList = new ArrayList<>(makeList.getNewPlayList());
    }

    public void printSong() {
//        // 리스트 잘 담기는지 확인
//        for (String song : playingList) {
//            System.out.println(song);
//        }

        // 배열의 첫 번째 노래의 가사부터 출력
        String fileName = playingList.getFirst()+".txt";
        Path filePath = Paths.get("src", "main", "resources", "Text", fileName);

        try {
            List<String> lyrics = Files.readAllLines(filePath);

            System.out.println("[현재곡] " + playingList.getFirst() + " 재생 중...");
            System.out.println("메뉴를 확인하시려면 [메뉴]를 입력해주세요");
            // 가사 한줄씩 출력...하는 스레드 추가... 어케함
            for(String line : lyrics) {
                System.out.println(line);

            }
        } catch (FileNotFoundException e) {
            System.out.println("파일이 없어요!");
        } catch (IOException e){
            System.out.println("파일을 읽는 중 오류가 발생했습니다.");
        }

    }


}
