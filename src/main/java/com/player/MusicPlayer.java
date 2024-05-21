package com.player;
import java.util.Scanner;
// 화면에 문자를 출력해주는 기능
public class MusicPlayer {
    // static : 객체 없이 호출 가능
    public static void showIntro () {
        Scanner in = new Scanner(System.in);
        System.out.println("==================================");
        System.out.println("ㅣㅣ   Lucy's Play Maker 입니다 ㅣㅣ");
        System.out.println("ㅣㅣ  리스트를 생성하시겠습니까? (Y/N) ㅣㅣ");
        System.out.println(" =================================");
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
            System.out.println("==================================");
            System.out.println("ㅣㅣLucy's Play Maker를 종료합니다.ㅣㅣ");
            System.out.println("ㅣㅣ      이용해주셔서 감사합니다       ㅣㅣ");
            System.out.println("==================================");
    }
    }
