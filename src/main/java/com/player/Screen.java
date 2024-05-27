package com.player;

// 화면에 문자를 출력해주는 기능
public class Screen {

    public void showIntro () {
        System.out.println(
                " _                      _      ___  ___          _       ______ _                       \n" +
                        "| |                    ( )     |  \\/  |         (_)      | ___ \\ |                      \n" +
                        "| |    _   _  ___ _   _|/ ___  | .  . |_   _ ___ _  ___  | |_/ / | __ _ _   _  ___ _ __ \n" +
                        "| |   | | | |/ __| | | | / __| | |\\/| | | | / __| |/ __| |  __/| |/ _` | | | |/ _ \\ '__|\n" +
                        "| |___| |_| | (__| |_| | \\__ \\ | |  | | |_| \\__ \\ | (__  | |   | | (_| | |_| |  __/ |   \n" +
                        "\\_____/\\__,_|\\___|\\__, | |___/ \\_|  |_/\\__,_|___/_|\\___| \\_|   |_|\\__,_|\\__, |\\___|_|   \n" +
                        "                   __/ |                                                 __/ |          \n" +
                        "                  |___/                                                 |___/           "+"\n"+
                "==========================================================================================="+"\n");
//                "ㅣㅣ   Lucy's Play Maker 입니다   ㅣㅣ+"\n"+
        System.out.println("리스트를 생성하시겠습니까? (Y/N)");
//                "==================================");
        System.out.print("입력 : ");
        try{
            String answer = Main.in.next();
            if (answer.equals("Y") || answer.equals("y")) {
                // 방법 선택 클래스 호출
                WayToPlay selectWay = new WayToPlay();
                selectWay.SelectPlayWay();

            } else if (answer.equals("N") || answer.equals("n")){
                // Player 종료화면 메소드
                showEnd();

            } else {
                // 인트로화면 재출력
                System.out.println("Y 또는 N으로 입력해주세요");
                showIntro();
            }
        } catch (Exception e){
            System.out.println("헉, 예기치 못한 오류가 발생했어요");
            System.out.println("프로그램을 다시 시작해주세요.");
        }
    }

    public void showEnd() {
        System.out.println(
                "=================================="+"\n"+
                "ㅣㅣLucy's Play Maker를 종료합니다.ㅣㅣ"+"\n"+
                "ㅣㅣ      이용해주셔서 감사합니다     ㅣㅣ"+"\n"+
                "==================================");
    }
}
