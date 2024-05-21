package com.player;
import java.util.Scanner;
// 화면에 문자를 출력해주는 기능
public class MusicPlayer {
    // static : 객체 없이 호출 가능
    public static void showIntro () {
        Scanner in = new Scanner(System.in);
        System.out.println(" --------------------------------");
        System.out.println("ㅣ   Lucy's Music Player 입니다   ㅣ");
        System.out.println("ㅣ   노래를 재생하시겠습니까? (Y/N)    ㅣ");
        System.out.println(" --------------------------------");
        System.out.print("입력 : ");
        // 사용자의 입력을 받음
        String answer = in.next();
        if (answer.equals("Y") || answer.equals("y")) {
            // 방법 선택 클래스 호출
            PlayMethod.SelectMethod();
        } else if (answer.equals("N") || answer.equals("n")){
            // Player 종료화면 메소드
            showEnd();
        } else {
            // 인트로화면 재출력
            System.out.println("Y 또는 N을 입력해주세요");
            showIntro();
        }}

    public static void showEnd() {
            System.out.println(" ----------------------------------");
            System.out.println("ㅣ Lucy's Music Player를 종료합니다.  ㅣ");
            System.out.println("ㅣ       이용해주셔서 감사합니다         ㅣ");
            System.out.println(" ----------------------------------");
    }
    }
