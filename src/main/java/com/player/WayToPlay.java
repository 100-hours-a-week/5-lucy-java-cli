package com.player;

import java.util.*;

// 리스트 생성 방법을 선택하는 클래스
public class WayToPlay {
    protected int id;
    protected String name;

    public WayToPlay() {
    }

    public WayToPlay(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // [TODO] static 리스트로 변경하기
    static WayToPlay method1 = new WayToPlay(1, "플레이 리스트 전곡 생성하기");
    static WayToPlay method2 = new WayToPlay(2, "플레이 리스트 5곡 랜덤 생성하기");
    static WayToPlay method3 = new WayToPlay(3, "가수별 리스트 생성하기");

    // 객체 생성 없이 사용하기 위해 static 을 붙였었음. [수정 완료]
    public void AskNewPlayList(){
        System.out.println("새로운 리스트를 생성하시겠습니까 ? (Y / N)");
        try {
            String answer = Main.in.next();
            switch (answer) {
                case "Y", "y":
                    // 방법 고르기로 돌아가기
                    SelectPlayWay();
                    break;
                case "N", "n":
                    // 종료화면으로
                    Screen screen = new Screen();
                    screen.showEnd();
                    break;
                default:
                    System.out.println("Y 또는 N을 입력해주세요");
                    AskNewPlayList();
            }
        } catch (Exception e) {
            System.out.println("헉, 예기치 못한 오류가 발생했어요");
            System.out.println("프로그램을 다시 시작해주세요.");
        }
    }

    public void SelectPlayWay() {
        System.out.println("리스트를 생성할 방법을 선택해주세요");
        System.out.println("=========================");
        System.out.println(method1.id + ". " +method1.name);
        System.out.println(method2.id + ". " +method2.name);
        System.out.println(method3.id + ". " +method3.name);
        System.out.println("=========================");
        System.out.print("입력 : ");

        try {
            int answer = Main.in.nextInt();

            switch (answer) {
                case 1:
                    System.out.println(method1.name+ "를 선택하셨습니다.");
                    System.out.println("리스트는 아래와 같습니다.");
                    System.out.println("=========================");
                    // 모든 노래 리스트 출력
                    MakeList playAll = new MakeList();
                    playAll.makePlayListAll();
                    playAll.showPlayList();
                    System.out.println("=========================");
                    AskNewPlayList();
                    break;
                case 2:
                    System.out.println(method2.name+ "를 선택하셨습니다.");
                    System.out.println("리스트는 아래와 같습니다.");
                    System.out.println("=========================");
                    // 랜덤 5곡 리스트 출력
                    MakeList random5play = new MakeList();
                    random5play.makePlayListRandom();
                    random5play.showPlayList();
                    System.out.println("=========================");
                    AskNewPlayList();
                    break;
                case 3:
                    System.out.println(method3.name+ "를 선택하셨습니다.");

                    // 가수를 선택해주세요 -> input 값을 리턴 -> artistAnswer 값
                    int artistAnswer = SelectAritst();
                    // 입력한 가수의 노래 리스트 출력
                    MakeList artistSong = new MakeList();
                    artistSong.makePlayListByArtist(artistAnswer);
                    artistSong.showPlayList();
                    System.out.println("=========================");
                    AskNewPlayList();
                    break;
                default:
                    // 플레이 방법 선택번호 범위
                    System.out.println("1,2,3번 중에 선택해주세요");
                    SelectPlayWay();
            }
        } catch (InputMismatchException e) {
            System.out.println("숫자를 입력해주세요");
            // 버퍼 비우기 : 비우지 않으면 계속 오류 값 그대로 처리돼서 무한 루프
            Main.in.nextLine();
            SelectPlayWay();
        } catch (Exception e) {
            System.out.println("헉, 예기치 못한 오류가 발생했어요");
            System.out.println("프로그램을 다시 시작해주세요.");
        }
        }

    public int SelectAritst () {

        System.out.println("가수를 선택해주세요.");
        System.out.println("=========================");
        // 가수 리스트 출력
        MakeList artists = new MakeList();
        artists.makeArtistList();
        artists.showArtistList();
        System.out.println("=========================");
        System.out.print("입력 : ");

        try {
            // 가수 번호 입력
            int artistAnswer = Main.in.nextInt();
            return artistAnswer;
        } catch (InputMismatchException e) {
            System.out.println("숫자를 입력해주세요!");
            Main.in.nextLine();
            return SelectAritst();
        }
    }
}
