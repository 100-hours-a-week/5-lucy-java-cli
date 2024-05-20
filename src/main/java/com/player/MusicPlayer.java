package com.player;
import java.util.Scanner;

public class MusicPlayer {

    public void showIntro () {
        Scanner in = new Scanner(System.in);
        System.out.println(" ----------------------------");
        System.out.println("ㅣ Lucy's Music Player 입니다  ㅣ");
        System.out.println("ㅣ 노래를 재생하시겠습니까? (Y/N)  ㅣ");
        System.out.println(" ----------------------------");
        System.out.print("입력 : ");
        // 사용자의 입력을 받음
        String answer = in.next();
        if (answer.equals("Y") || answer.equals("y")) {
            // 방법을 보여주는 메소드로 이동
            showSelectMethod();
        } else if (answer.equals("N") || answer.equals("n")){
            // Player 종료화면 메소드로 이동
            showEnd();
        } else {
            // 인트로화면 재출력
            System.out.println("Y 또는 N을 입력해주세요");
            showIntro();
        }}

    public void showEnd() {
            System.out.println(" ----------------------------------");
            System.out.println("ㅣ Lucy's Music Player를 종료합니다.  ㅣ");
            System.out.println("ㅣ       이용해주셔서 감사합니다         ㅣ");
            System.out.println(" ----------------------------------");
    }


    public void showSelectMethod() {
        Scanner in = new Scanner(System.in);
        System.out.println("노래를 재생할 방법을 선택해주세요");
        System.out.println("  1. 플레이 리스트 전곡 재생하기");
        System.out.println("  2. 플레이 리스트 5곡 랜덤 재생하기");
        System.out.println("  3. 가수 선택하기");
        System.out.print("입력 : ");
        int answer = in.nextInt();

        if(answer <= 0 || answer > 3){
            System.out.println("1부터 3까지 중에 골라주세요.");
            showSelectMethod();
        } else if (answer == 1){
            System.out.println("플레이 리스트 전곡 재생하기를 선택하셨습니다.");
            System.out.println("리스트는 아래와 같습니다.");
            PlayList playAll = new PlayList();
            playAll.showPlayList();
            System.out.println("재생하시겠습니까 ? (Y / N)");
            System.out.print("입력 : ");
            String reallyPlay = in.next();
            System.out.println(reallyPlay + "를 선택하셨습니다.");
        }

        else if (answer == 2){
            System.out.println("플레이 리스트 5곡 랜덤 재생하기를 선택하셨습니다.");
            System.out.println("리스트는 아래와 같습니다.");
            PlayMethod random5play = new PlayMethod();
            random5play.showPlayList();
            System.out.println("재생하시겠습니까 ? (Y / N)");
            System.out.print("입력 : ");
            String reallyPlay = in.next();
            System.out.println(reallyPlay + "를 선택하셨습니다.");
        }
        else {
            System.out.println("가수를 선택해주세요.");
            PlayList artists = new PlayList();
            artists.showArtists();
        }
    }
    }
