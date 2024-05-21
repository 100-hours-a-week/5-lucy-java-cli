package com.player;
import java.util.Set;
import java.util.HashSet;

public class SongList{
    public SongList() {}
    // 배열 선언
    // 1. 클래스명 배열명 [] = new 클래스명 [배열 크기];
    // 2. 선언과 동시에 할당 및 초기화
    //    클래스명 [] 배열명  = { new 클래스명(), new 클래스명 (), ... }

    // 접근제어자 클래스 [] 배열명 = { }
    protected Song [] playList = {
            new Song(1, "루시", "개화"),
            new Song(2, "데이식스", "Welcome to the Show"),
            new Song(3, "루시", "히어로"),
            new Song(4, "데이식스", "예뻤어"),
            new Song(5, "루시", "떼굴떼굴"),
            new Song(6, "데이식스", "Sweet Chaos"),
            new Song(7, "루시", "결국 아무것도 알 수 없었지만"),
            new Song(8, "터치드", "좋지 아니한가"),
            new Song(9, "루시", "Boogie Man"),
            new Song(10, "데이식스", "좋아합니다"),
    };
}
