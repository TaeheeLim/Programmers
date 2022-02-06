package com.example.codingtest.level1;

import java.util.*;

public class 신고결과 {
    public static void main(String[] args) {
        String[] idList = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        String[] idList2 = {"con", "ryan"};
        String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k2 = 3;

        System.out.println(solution(idList2, report2, k2));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};

        Map<String, Member> map = new HashMap<>();
        Loop:
        for(String single : report){
            String[] relation = single.split(" ");
            //이미 다른 사람을 신고한 경우
            if(map.containsKey(relation[0])){
                Member existMember = map.get(relation[0]);
                List<String> list = existMember.getReportList();
                for(int i = 0; i < list.size(); i++){
                    if (list.get(i).equals(relation[1])){
                        continue Loop;
                    }
                }


                Member member = map.get(relation[0]);
                List<String> reportList = member.getReportList();
                reportList.add(relation[1]);
                member.setReportList(reportList);
                map.put(relation[0], member);

                if(map.get(relation[1]) != null){
                    Member reportedMember = map.get(relation[1]);
                    List<String> beingReported = reportedMember.getBeingReported();
                    beingReported.add(relation[0]);
                    reportedMember.setBeingReported(beingReported);

                    int suited = reportedMember.getSuited();
                    suited += 1;
                    reportedMember.setSuited(suited);
                    map.put(relation[1], reportedMember);
                } else {
                    Member getMember = getMember(relation);
                    map.put(relation[1], getMember);
                }

                continue;
            }
            // 처음 신고를 하는 경우
            //신고 한사람------------------------------
            Member reportMember = new Member();
            reportMember.setName(relation[0]);
            List<String> reportList = reportMember.getReportList();
            reportList.add(relation[1]);
            reportMember.setReportList(reportList);

            map.put(relation[0], reportMember);

            //신고 당한사람---------------------------
            if(map.containsKey(relation[1])){
                Member member = map.get(relation[1]);
                List<String> beingReported = member.getBeingReported();
                beingReported.add(relation[0]);
                member.setBeingReported(beingReported);

                int suited = member.getSuited();
                suited++;
                member.setSuited(suited);
                continue;
            }

            Member member = getMember(relation);
            map.put(relation[1], member);
        }

        System.out.println(map.toString());

        List<String> badMember = new ArrayList<>();

        for(String member : id_list){
            Member memberInMap = map.get(member);
            if(memberInMap.getSuited() >= k){
                badMember.add(memberInMap.getName());
            }
        }

        for(String member : id_list){
            Member finalMember = map.get(member);
            int count = 0;
            List<String> reportList = finalMember.getReportList();
            Loop1:
            for(int i = 0;  i < reportList.size(); i++){
                for(int j = 0; j < badMember.size(); j++){
                    if(reportList.get(i).equals(badMember.get(j))){
                        count++;
                        if(count >= badMember.size()){
                            break Loop1;
                        }
                    }
                }
            } // for 끝
            answer = Arrays.copyOf(answer, answer.length + 1);
            answer[answer.length -1 ] = count;
        }
        System.out.println(Arrays.toString(answer));

        return answer;
    }

    public static Member getMember(String[] relation){
        Member beingReportedMember = new Member();
        beingReportedMember.setName(relation[1]);
        List<String> beingReported = beingReportedMember.getBeingReported();
        beingReported.add(relation[0]);
        beingReportedMember.setBeingReported(beingReported);
        int suited = beingReportedMember.getSuited();
        suited += 1;
        beingReportedMember.setSuited(suited);

        return beingReportedMember;
    }

}

class Member {
    String name;
    //신고 한 사람
    List<String> reportList = new ArrayList<>();
    //나를 신고 한 사람
    List<String> beingReported = new ArrayList<>();
    int suited = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getReportList() {
        return reportList;
    }

    public void setReportList(List<String> reportList) {
        this.reportList = reportList;
    }

    public List<String> getBeingReported() {
        return beingReported;
    }

    public void setBeingReported(List<String> beingReported) {
        this.beingReported = beingReported;
    }

    public int getSuited() {
        return suited;
    }

    public void setSuited(int suited) {
        this.suited = suited;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", reportList=" + reportList +
                ", beingReported=" + beingReported +
                ", suited=" + suited +
                '}';
    }
}
