package com.player;

// 화면에 문자를 출력해주는 기능
public class Screen {

    public void showIntro () {
        boolean answerValid = false;
        System.out.println(
                "=================================="+"\n"+
                "ㅣㅣ   Lucy's Play Maker 입니다    ㅣㅣ"+"\n"+
                "==================================");
        System.out.println("리스트를 생성하시겠습니까? (Y/N)");
        while (!answerValid){
        try{
            System.out.print("입력 : ");
            String answer = Main.in.next();
            if (answer.equals("Y") || answer.equals("y")) {
                // 방법 선택 클래스 호출
                WayToPlay selectWay = new WayToPlay();
                selectWay.SelectPlayWay();
                break;
            } else if (answer.equals("N") || answer.equals("n")){
                // Player 종료화면 메소드
                showEnd();
                break;
            } else {
                // 인트로화면 재출력
                System.out.println("Y 또는 N으로 입력해주세요");
            }
        } catch (Exception e){
            System.out.println("리스트 생성 여부 확인 중 오류가 발생했어요");
            System.out.println("프로그램을 다시 시작해주세요.");
        }}
    }

    public void showEnd() {
        System.out.println(
                "=================================="+"\n"+
                "ㅣㅣLucy's Play Maker를 종료합니다.ㅣㅣ"+"\n"+
                "ㅣㅣ      이용해주셔서 감사합니다     ㅣㅣ"+"\n"+
                "==================================");
        System.exit(0);
    }
}
