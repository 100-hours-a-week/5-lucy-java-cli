package com.player.Thread;

import com.player.Main;
import com.player.Screen;

import java.util.InputMismatchException;
import java.util.List;

class ShowMenu implements Runnable {
    // 공유 객체
    private IsPlaying isPlaying;
    private List<String> printList;
    int musicIndex;

    // 생성자
    public ShowMenu(List<String> printList, IsPlaying isPlaying) {
        this.printList = printList;
        this.isPlaying = isPlaying;
    }

    public void run() {
        try {
            // 10초 대기
            Thread.sleep(5000);

            // flag를 false로 변경
            isPlaying.setRunning(false);
            // 안내문구 출력
            System.out.println("===============================");
            System.out.println("5초 미리듣기 서비스가 완료되었습니다.");
            System.out.println("이용권 결제 후 이용해주세요!");
            System.out.println("===============================");
        } catch (InterruptedException e) {
            System.out.println("오류 발생!" + e);
        }

        int answer = -1;
        boolean answerValid = false;

        System.out.println("1. 이전 곡 재생하기");
        System.out.println("2. 다음 곡 재생하기");
        System.out.println("3. 메인화면으로 이동");

        while (!answerValid){
            try {
                System.out.print("입력 : ");
                answer = Main.in.nextInt();
                musicIndex = isPlaying.getMusicIndex();
            switch (answer) {
                case 1:
                    // SongIndex-1 : 처음 곡 예외처리
                    if (musicIndex > 0) {
                        synchronized (isPlaying) {
                            isPlaying.setMusicIndex(musicIndex - 1);
                            isPlaying.setRunning(true);
                            isPlaying.notify(); // ShowLyric 스레드 재개
                        }
                        answerValid = true;
                        break;
                    } else {
                        System.out.println("첫 번째 곡입니다.");
                        Main.in.nextLine();
                    }
                    break;
                case 2:
                    // SongIndex+1 : 마지막 곡 예외처리
                    if (musicIndex < printList.size()-1) {
                        synchronized (isPlaying) {
                            isPlaying.setMusicIndex(musicIndex + 1);
                            isPlaying.setRunning(true);
                            isPlaying.notify(); //ShowLyric 스레드 재개
                        }
                        answerValid = true;
                        break;
                    } else {
                        System.out.println("마지막 곡입니다.");
                        Main.in.nextLine();
                    }
                    break;
                case 3:
                    Screen screen = new Screen();
                    screen.showIntro();
                    answerValid = true;
                    break;
                default:
                    System.out.println("1부터 4 사이의 숫자를 입력해주세요!");
                    Main.in.nextLine();

            }} catch (InputMismatchException e) {
                System.out.println("숫자로 입력해주세요!");
                Main.in.nextLine();
            }
        }
    }}