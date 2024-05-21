package com.player;

import java.util.*;

// 재생 방법을 선택하는 클래스
public class PlayMethod{
    int id;
    String methodName;

    public PlayMethod(int id, String methodName) {
        this.id = id;
        this.methodName = methodName;
    }

    public static void AskReallyPlay(){
            Scanner in = new Scanner(System.in);

            System.out.println("재생하시겠습니까 ? (Y / N)");
            System.out.print("입력 : ");
            String reallyPlay = in.next();
            switch (reallyPlay) {
                case "Y","y" :
                    System.out.println("오케이 재생");
                    break;
                case "N","n" :
                    SelectMethod();
                    break;
                default:
                    System.out.println("Y 또는 N을 입력해주세요.");
            }
    }

    public static void SelectMethod() {
        Scanner in = new Scanner(System.in);
        PlayMethod method1 = new PlayMethod(1, "플레이 리스트 전곡 재생하기");
        PlayMethod method2 = new PlayMethod(2, "플레이 리스트 5곡 랜덤 재생하기");
        PlayMethod method3 = new PlayMethod(3, "가수 선택하기");

        System.out.println("노래를 재생할 방법을 선택해주세요");
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
                playAll.showPlayListAll();
                System.out.println("=========================");
                // 재생 여부 재확인
                AskReallyPlay();
                break;
            case 2:
                System.out.println(method2.methodName+ "를 선택하셨습니다.");
                System.out.println("리스트는 아래와 같습니다.");
                System.out.println("=========================");
                // 랜덤 5곡 리스트 출력
                MakeList random5play = new MakeList();
                random5play.showPlayListRandom();
                System.out.println("=========================");
                // 재생 여부 재확인
                AskReallyPlay();
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
                artistSong.showPlayListByArtist(artistAnswer);
                // 재생 여부 재확인
                AskReallyPlay();
                break;
            default:
                System.out.println("1,2,3번 중에 선택해주세요");
        }

//        if(answer <= 0 || answer > 3){
//            System.out.println("1부터 3까지 중에 골라주세요.");
//            SelectMethod();
//        } else if (answer == 1){
//            System.out.println("플레이 리스트 전곡 재생하기를 선택하셨습니다.");
//            System.out.println("리스트는 아래와 같습니다.");
//            MakeList playAll = new MakeList();
//            playAll.showPlayListAll();
//            System.out.println("재생하시겠습니까 ? (Y / N)");
//            System.out.print("입력 : ");
//            String reallyPlay = in.next();
//            if(reallyPlay.equals("Y") || reallyPlay.equals("y")){
//                // 1번 부터 가사 재생 => 새로운 클래스로 만들기 ? 메소드로 만들기 ?
//                System.out.println("가수 - 제목 ... 가사 ... 재생중");
//            } else if(reallyPlay.equals("N") || reallyPlay.equals("n")){
//                SelectMethod();
//            } else {
//                System.out.println("Y 또는 N을 입력해주세요");
//                // [ ] 이 단계까지 가기 전으로 돌아가는 법 생각해보기
//                SelectMethod();
//            }
//        }
//
//        else if (answer == 2){
//            System.out.println("플레이 리스트 5곡 랜덤 재생하기를 선택하셨습니다.");
//            System.out.println("리스트는 아래와 같습니다.");
//            MakeList random5play = new MakeList();
//            random5play.showPlayListRandom();
//            System.out.println("재생하시겠습니까 ? (Y / N)");
//            System.out.print("입력 : ");
//            String reallyPlay = in.next();
//            if(reallyPlay.equals("Y") || reallyPlay.equals("y")){
//                System.out.println("가수 - 제목 ... 가사 ... 재생중");
//            } else if(reallyPlay.equals("N") || reallyPlay.equals("n")){
//                SelectMethod();
//            } else {
//                System.out.println("Y 또는 N을 입력해주세요");
//                // [ ] 이 단계까지 가기 전으로 돌아가는 법 생각해보기
//                SelectMethod();
//            }
//        }
//        else {
//            System.out.println("가수를 선택해주세요.");
//            MakeList artists = new MakeList();
//            artists.showArtists();
//            System.out.print("입력 : ");
//            int artistAnswer = in.nextInt();
//            System.out.println(artistAnswer + "번 가수를 선택하셨습니다.");
//        }
    }
};
