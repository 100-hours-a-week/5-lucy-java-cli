package com.player;
// SongList 데이터를 가지고 와서 리스트를 생성&출력하는 클래스
// 1. 전곡 리스트
// 2. 랜덤 리스트
// 3. 가수 리스트
// 4. 가수 노래 리스트

import java.util.*;
import java.util.stream.Collectors;

// playList 를 사용하기 위해 상속
public class MakeList extends SongList {
    // 중복 없이 가수정보를 담을 Set 자료구조 생성
    protected Set<String> uniqueArtists = new HashSet<>();
    // 플레이리스트를 담을 빈 리스트 생성
    protected List<String> newPlayList = new ArrayList<>();

    public MakeList() {

    }

    // 플레이리스트 출력
    public void showPlayList(){
        // newPlayList의 song 요소들을 반복 출력
        for (String song : newPlayList) {
            System.out.println(song);
        }
    }

    public void showArtistList(){
        // set 자료구조에 있는 artist 들을 모두 출력
        int index = 1;
        for (String artist : uniqueArtists){
            System.out.print(index+". ");
            System.out.println(artist);
            index++;
        }
    }

    // ------------------ 리스트 만들기 메소드들 -------------------------

    public void makePlayListAll (){
        // newPlayList 에 전곡 담기
        newPlayList = Arrays.stream(playList)
                .map(song -> song.getId() + ". " + song.getArtist() + " - " + song.getTitle())
                .collect(Collectors.toList());
        // PlayList 출력
        showPlayList();
    }

    public void makePlayListRandom(){

        // Collection.shuffle 을 사용하기 위해서 새 List 생성
        List<Song> playLists = new ArrayList<>(Arrays.asList(playList));
        Collections.shuffle(playLists);

        newPlayList = playLists.stream()
                .limit(5)
                .map(song -> song.getId() + ". " + song.getArtist() + " - " + song.getTitle())
                .collect(Collectors.toList());

        showPlayList();
    }

    // 가수 리스트 생성하기
    public void makeArtistList (){
        // playList 배열에서 가수 정보만 추출해서 Set에 저장하기
        for (Song artist : playList ){
            uniqueArtists.add(artist.getArtist());
        }
    }

    // 가수별 노래 리스트 생성하기
    public void makePlayListByArtist (int number){
        // uniqueArtists 가 빈 Set 로 반환되므로 makeArtists(); 를 호출해서 업데이트
        makeArtistList();
        // 가수명 찾기위해서 Set 을 List 로 변환 -> get 을 사용하기 위해서
        List<String> artistList = new ArrayList<>(uniqueArtists);

        // 번호와 일치하는 가수명 찾기
        String selectedArtist;
        // 매개변수로 받은 숫자 입력값이 범위 안에 있으면 selectedArtist값 할당
        if (number > 0 && number <= artistList.size()) {
            selectedArtist = artistList.get(number-1);

        } else {
            System.out.println(number+"는 유효하지 않은 번호입니다.");
            System.out.println("1부터 "+artistList.size()+"사이의 숫자 중 입력해주세요.");

            // 가수 선택부터 다시 출력
            // WayToPlay 클래스의 SelectPlayWay()의 case3으로 돌아가기
            // SelectArtist() 메서드로 분리해서 리팩토링
//            System.out.println("가수를 선택해주세요: ");
//            System.out.println("=========================");
//            MakeList artists = new MakeList();
//            artists.makeArtistList();
//            artists.showArtistList();
//            System.out.println("=========================");
//            System.out.print("입력 : ");

//            // 초기화
////            Main.in.nextLine();
//            int newNumber = 0;
//
//            try {
//                newNumber = Main.in.nextInt();
//            } catch (InputMismatchException e){
//                System.out.println("숫자로 입력해주세요");
////                Main.in.nextLine();
//            } catch (Exception e) {
//                System.out.println("헉, 예기치 못한 오류가 발생했어요");
//                System.out.println("프로그램을 다시 시작해주세요.");
//            }

//            // 재귀의 이유 ?
            WayToPlay reSelect = new WayToPlay();
            int newNumber = reSelect.SelectAritst();
            makePlayListByArtist(newNumber);
            return;
        }

        // 가수의 노래 리스트를 생성
        System.out.println(selectedArtist + "를 선택하셨습니다.");
        System.out.println(selectedArtist + "의 플레이리스트는 아래와 같습니다.");
        System.out.println("=========================");
        newPlayList = Arrays.stream(playList)
                .filter(song -> song.getArtist().equals(selectedArtist))
                .map(song ->  song.getId() + ". " + song.getArtist() + " - " + song.getTitle())
                .collect(Collectors.toList());
}}

