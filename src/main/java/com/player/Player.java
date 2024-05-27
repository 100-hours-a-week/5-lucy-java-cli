package com.player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Player {
    public static void main(String[] args) throws IOException {
        // 1. 입력받은 파일이 있는지 검사
        if(args.length == 0){
            System.out.println("재생할 노래가 없어요!");
            // 시스템 종료
            System.exit(0);}

        // 2. 파일이 존재하는지 검사
        File file = new File(args[0]);
        if ( file.exists() ){

            // 3. 파일이 존재하면 , 텍스트 파일의 내용을 읽어서 출력
            BufferedReader br = new BufferedReader(new FileReader(file));
            // br.ready()로 파일 끝에 도달했는지 확인
            while (br.ready() ){
                // 출력할 내용이 있다면 한 줄 씩 읽어서 출력
                System.out.println(br.readLine());
            }
            br.close();

            }
        }
    }
