package com.player;
import java.util.Set;
import java.util.HashSet;

public class SongList{
    public SongList() {}
    // 배열 선언
    // 1. 클래스명 배열명 [] = new 클래스명 [배열 크기];
    // 2. 선언과 동시에 할당 및 초기화
    //    클래스명 [] 배열명  = { new 클래스명(), new 클래스명 (), ... }

    // 굳이 상속 안하고, 클래스 끌어다 쓰기가 된 걸까?
    protected Song [] playList = {
            new Song(1, "루시", "개화", "가사"),
            new Song(2, "데이식스", "Welcome to the Show", "가사2"),
            new Song(3, "루시", "히어로", "가사3"),
            new Song(4, "데이식스", "예뻤어", "가사4"),
            new Song(5, "루시", "떼굴떼굴", "가사5"),
            new Song(6, "데이식스", "Sweet Chaos", "가사6"),
            new Song(7, "루시", "결국 아무것도 알 수 없었지만", "가사7"),
            new Song(8, "터치드", "좋지 아니한가", "가사8"),
            new Song(9, "루시", "Boogie Man", "가사9"),
            new Song(10, "데이식스", "좋아합니다", "가사10"),
    };
}