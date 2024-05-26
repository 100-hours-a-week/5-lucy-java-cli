package com.player;

import java.util.Scanner;

public class Main {
    // Scanner 전체 클래스에서 재활용
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args){
        // 시작 화면 띄우기
        Screen screen = new Screen();
        screen.showIntro();
    }
}
