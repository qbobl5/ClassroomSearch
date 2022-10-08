package com.example.hallymsmartapp;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Classroom { // 강의실 변수 클래스

    private String roomName; // 강의실 이름 변수 ex)1212, 10312
    public Classroom() {}
    public Classroom(String n) { // 강의실 변수 클래스 생성자
        this.roomName=n;
    }

    public void setRoomName(String n) {
        this.roomName=n;
    }

    public Object getRoomName() {
        return roomName;
    }

    public String building() { // 강의실 이름을 받아온 뒤 건물명 찾기
        if (roomName.charAt(0) == 'A') {
            // A로 시작하는 건물 표시
            return null;
        }

        for(int i=0;i<roomName.length();i++) { // 건물에 숫자 안 들어가는 경우 예외처리
            boolean error=true;
            for(int j=48;j<=57;j++) {
                if(roomName.charAt(i)==(char)j) error=false;
            }
            if(error==true) return "존재하지 않습니다.";
        }

        switch (Integer.parseInt(roomName) / 1000) {
            case 1:
                return "공학관";
            case 2:
                return "대학본부-인문1관";
            case 3:
                return "의학관";
            case 4:
                return "인문2관";
            case 5:
                return "대학본부별관";
            case 6:
                return "실험동물센터";
            case 7:
                return "자연과학관";
            case 8:
                return "생명과학관";
            case 9:
                return "CLC";
            case 10:
                return "사회경영1관";
            case 11:
                return "일송아트홀";
            case 12:
                return "창업보육센터";
            case 13:
                return "사회경영2관";
            case 14:
                return "국제관";
            case 15:
                return "국제회의관";
            case 16:
                return "기초교육관";
            case 17:
                return "일송기념도서관";
            case 18:
                return "한림레크레이션센터";
            case 19:
                return "학군단";
            case 20:
                return "실내테니스장";
            case 21:
                return "의료바이오융합연구원";
            case 22:
                // 산학협력관
                return null;
            case 23:
                return "도현글로벌스쿨";
            case 24:
                return "학생생활관 1관";
            case 25:
                return "학생생활관 2관";
            case 26:
                return "학생생활관 3관";
            case 27:
                return "학생생활관 4관";
            case 28:
                return "학생생활관 5관";
            case 29:
                return "학생생활관 6관";
            case 30:
                return "학생생활관 7관";
            case 31:
                return "학생생활관 8관";
            case 32:
                // 체육 기자재실
                return null;
            case 33:
                // H Stadium
                return null;
            case 34:
                // ILSONG Studium
                return null;
            case 35:
                // 씨름장
                return null;
            case 36:
                // 온실
                return null;
            default:
                return "존재하지 않습니다.";
        }
    }

    public int thisFloor() { // 층 수 구하기
        if(roomName.length()==4) return (int)roomName.charAt(1)-48;
        else return (int)roomName.charAt(2)-48;
    }

}