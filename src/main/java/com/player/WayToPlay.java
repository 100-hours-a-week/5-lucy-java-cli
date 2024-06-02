package com.player;

import com.player.Thread.IsPlaying;

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

    // 생성 방법 목록
    static WayToPlay method1 = new WayToPlay(1, "플레이 리스트 전곡 생성하기");
    static WayToPlay method2 = new WayToPlay(2, "플레이 리스트 5곡 랜덤 생성하기");
    static WayToPlay method3 = new WayToPlay(3, "가수별 리스트 생성하기");

    public void AskPlayThis(MakeList makeList){
        System.out.println("플레이리스트를 재생하시겠습니까 ? (Y / N)");
        boolean answerValid = false;
        try {
            while (!answerValid){
            System.out.print("입력 : ");
            String answer = Main.in.next();
            switch (answer) {
                case "Y", "y":
                    // 노래 가사를 출력할 스레드를 실행하는 공유 객체
                    IsPlaying isPlaying = new IsPlaying(makeList);
                    isPlaying.printSong();
                    answerValid = true;
                    break;
                case "N", "n":
                    // 새로운 리스트 생성 여부 확인
                    AskNewPlayList();
                    answerValid = true;
                    break;
                default:
                    System.out.println("Y 또는 N을 입력해주세요");
            }
        }} catch (Exception e) {
            System.out.println("플레이 재생 여부를 확인하는 과정에서 오류가 발생했어요");
            System.out.println("프로그램을 다시 시작해주세요.");
        }
    }

    // 플레이 재생에 "N" 응답을 한 경우, 새로운 리스트 생성 여부 확인
    public void AskNewPlayList(){
        System.out.println("새로운 리스트를 생성하시겠습니까 ? (Y / N)");
        boolean answerValid = false;
        try {
            while (!answerValid){
            System.out.print("입력 : ");
            String answer = Main.in.next();
            switch (answer) {
                case "Y", "y":
                    // 방법 고르기로 돌아가기
                    SelectPlayWay();
                    answerValid = true;
                    break;
                case "N", "n":
                    // 종료화면으로
                    Screen screen = new Screen();
                    screen.showEnd();
                    answerValid = true;
                    break;
                default:
                    System.out.println("Y 또는 N을 입력해주세요");
                    Main.in.nextLine();
            }
        }} catch (Exception e) {
            System.out.println("리스트 재생성 확인 과정에서 오류가 발생했어요");
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

        boolean answerValid = false;
        while (!answerValid){
        try {
            System.out.print("입력 : ");
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
                    AskPlayThis(playAll);
                    answerValid = true;
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
                    AskPlayThis(random5play);
                    answerValid = true;
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
                    AskPlayThis(artistSong);
                    answerValid = true;
                    break;
                default:
                    // 플레이 방법 선택번호 범위
                    System.out.println("1,2,3번 중에 선택해주세요");
            }
        } catch (InputMismatchException e) {
            System.out.println("숫자를 입력해주세요");
            // 버퍼 비우기 : 비우지 않으면 계속 오류 값 그대로 처리돼서 무한 루프
            Main.in.nextLine();
        } catch (Exception e) {
            System.out.println("플레이 리스트 출력 과정에서 오류가 발생했어요");
            System.out.println("프로그램을 다시 시작해주세요.");
        }}
    }


    public int SelectAritst () {
        boolean answerValid = false;
        // 유효하지 않은 값으로 초기화
        int artistAnswer = -1;

        while (!answerValid){
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
            artistAnswer = Main.in.nextInt();
            answerValid = true;
        } catch (InputMismatchException e) {
            System.out.println("숫자를 입력해주세요!");
            Main.in.nextLine();
        }
    }  return artistAnswer;
}}
