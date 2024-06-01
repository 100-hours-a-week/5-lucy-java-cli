package com.player;

import java.util.InputMismatchException;
import java.util.List;

class ShowMenu implements Runnable {
    // 공유 객체
    private IsPlaying isPlaying;
    private List<String> printList;
    private int songIndex;

    // 생성자
    public ShowMenu(List<String> printList, IsPlaying isPlaying, int songIndex) {
        this.printList = printList;
        this.isPlaying = isPlaying;
        this.songIndex = songIndex;
    }

    public void run() {
        try {
            // 10초 대기
            Thread.sleep(5000);

            // volatile 변수를 false로 변경
            isPlaying.setPlay(false);
            // 안내문구 출력
            System.out.println("===============================");
            System.out.println("5초 미리듣기 서비스가 완료되었습니다.");
            System.out.println("이용권 결제 후 이용해주세요!");
            System.out.println("===============================");
        } catch (InterruptedException e) {
            System.out.println("오류 발생!" + e);
        }

            int answer;
            answer = selectMenu();

            switch (answer) {
                case 1:
                    // SongIndex-1 : 처음 곡 예외처리
                    if (songIndex > 0) {
                        songIndex--; // 이전 곡 인덱스로 변경
                        isPlaying.setPlay(true);
                        synchronized (isPlaying) {
                            isPlaying.notify();// `ShowLyric` 스레드 재개
                        }
                    } else {
                        System.out.println("첫 번째 곡입니다.");
                        Main.in.nextLine();
                        selectMenu();
                    }
                    break;
                case 2:
                    // SongIndex+1 : 마지막 곡 예외처리
                    if (songIndex < printList.size() - 1) {
                        songIndex++; // 다음 곡 인덱스로 변경

                        synchronized (isPlaying) {
                            isPlaying.setPlay(true);
                            isPlaying.notifyAll();
                            // `ShowLyric` 스레드 재개
                        }
                    } else {
                        System.out.println("마지막 곡입니다.");
                        Main.in.nextLine();
                        selectMenu();
                    }
                    break;
                case 3:
                    Screen screen = new Screen();
                    screen.showIntro();
                    break;
                default:
                    System.out.println("1부터 4 사이의 숫자를 입력해주세요!");
                    Main.in.nextLine();
                    selectMenu();
            }
    }

    public int selectMenu (){
        System.out.println("1. 이전 곡 재생하기");
        System.out.println("2. 다음 곡 재생하기");
        System.out.println("3. 메인화면으로 이동");
        System.out.print("입력 : ");
        int answer;
        try {
            answer = Main.in.nextInt();
            return answer;
            } catch (InputMismatchException e) {
                System.out.println("숫자로 입력해주세요!");
                Main.in.nextLine();
                return selectMenu();
            }
    }

}


        // 1분 미리 듣기
        // 메뉴 띄우기
        // 1. 계속 듣기 2. 다음 곡 3. 이전 곡 4. 메인 화면으로
