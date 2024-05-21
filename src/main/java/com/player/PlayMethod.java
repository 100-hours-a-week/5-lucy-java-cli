package com.player;

import java.util.*;


// 리스트 생성 방법을 선택하는 클래스
public class PlayMethod{
    private int id;
    private String methodName;

    public PlayMethod(int id, String methodName) {
        this.id = id;
        this.methodName = methodName;
    }

    public static void AskNewPlayList(){
            Scanner in = new Scanner(System.in);
            System.out.println("새로운 리스트를 생성하시겠습니까 ? (Y / N)");
            System.out.print("입력 : ");
            String newPlayList = in.next();
            switch (newPlayList) {
                case "Y","y" :
                    // 방법 고르기로 돌아가기
                    SelectMethod();
                    break;
                case "N","n" :
                    // 인트로화면으로 돌아가기
                    MusicPlayer.showIntro();
                    break;
                default:
                    System.out.println("Y 또는 N을 입력해주세요.");
                    SelectMethod();
            }
    }

    public static void SelectMethod() {
        Scanner in = new Scanner(System.in);

        PlayMethod method1 = new PlayMethod(1, "플레이 리스트 전곡 생성하기");
        PlayMethod method2 = new PlayMethod(2, "플레이 리스트 5곡 랜덤 생성하기");
        PlayMethod method3 = new PlayMethod(3, "가수별 리스트 생성하기");

        System.out.println("리스트를 생성할 방법을 선택해주세요");
        System.out.println("=========================");
        System.out.println(method1.id + ". " +method1.methodName);
        System.out.println(method2.id + ". " +method2.methodName);
        System.out.println(method3.id + ". " +method3.methodName);
        System.out.println("=========================");
        System.out.print("입력 : ");
        int answer = in.nextInt();

        switch (answer) {
            case 1:
                System.out.println(method1.methodName+ "를 선택하셨습니다.");
                System.out.println("리스트는 아래와 같습니다.");
                System.out.println("=========================");
                // 모든 노래 리스트 출력
                MakeList playAll = new MakeList();
                playAll.makePlayListAll();
                System.out.println("=========================");
                AskNewPlayList();
                break;
            case 2:
                System.out.println(method2.methodName+ "를 선택하셨습니다.");
                System.out.println("리스트는 아래와 같습니다.");
                System.out.println("=========================");
                // 랜덤 5곡 리스트 출력
                MakeList random5play = new MakeList();
                random5play.makePlayListRandom();
                System.out.println("=========================");
                AskNewPlayList();
                break;
            case 3:
                System.out.println(method3.methodName+ "를 선택하셨습니다.");
                System.out.println("가수를 선택해주세요.");
                System.out.println("=========================");
                // 가수 리스트 출력
                MakeList artists = new MakeList();
                artists.showArtists();
                System.out.println("=========================");
                System.out.print("입력 : ");
                int artistAnswer = in.nextInt();
                // 입력한 가수의 리스트 출력
                MakeList artistSong = new MakeList();
                artistSong.makePlayListByArtist(artistAnswer);
                AskNewPlayList();
                break;
            default:
                System.out.println("1,2,3번 중에 선택해주세요");
                SelectMethod();
        }
    }
}
