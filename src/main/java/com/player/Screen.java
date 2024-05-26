package com.player;

// 화면에 문자를 출력해주는 기능
public class Screen {
//    public static String introText =
//            "=================================="+"\n"+
//            "ㅣㅣ   Lucy's Play Maker 입니다   ㅣㅣ"+"\n"+
//            "ㅣㅣ  리스트를 생성하시겠습니까? (Y/N) ㅣㅣ"+"\n"+
//            " =================================";
//    public static String endText =
//            "=================================="+"\n"+
//            "ㅣㅣLucy's Play Maker를 종료합니다.ㅣㅣ"+"\n"+
//            "ㅣㅣ      이용해주셔서 감사합니다     ㅣㅣ"+"\n"+
//            "==================================";

    public void showIntro () {
//        System.out.println(Screen.introText);
        System.out.println(
                "=================================="+"\n"+
                "ㅣㅣ   Lucy's Play Maker 입니다   ㅣㅣ"+"\n"+
                "ㅣㅣ  리스트를 생성하시겠습니까? (Y/N) ㅣㅣ"+"\n"+
                " =================================");
        // 사용자의 입력을 받음
        // Scanner 입력되는 위치가 줄바꿈 돼서 static 으로 넣지 않음
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
                System.out.println("Y 또는 N을 입력해주세요");
                showIntro();
            }
        } catch (Exception e){
            System.out.println("헉, 예기치 못한 오류가 발생했어요");
            System.out.println("프로그램을 다시 시작해주세요.");
        }

        }

    public void showEnd() {
//        System.out.println(Screen.endText);
        System.out.println(
                "=================================="+"\n"+
                "ㅣㅣLucy's Play Maker를 종료합니다.ㅣㅣ"+"\n"+
                "ㅣㅣ      이용해주셔서 감사합니다     ㅣㅣ"+"\n"+
                "==================================");
    }
}