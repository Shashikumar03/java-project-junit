package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main {
    public static final int MATCH_ID = 0;
    public static final int SEASON = 1;
    public static final int CITY = 2;
    public static final int DATE = 3;
    public static final int TEAM1 = 4;
    public static final int TEAM2 = 5;
    public static final int TOSS_WINNER = 6;
    public static final int TOSS_DECISION = 7;
    public static final int RESULT = 8;
    public static final int DL_APPLIED = 9;
    public static final int WINNER = 10;
    public static final int WIN_BY_RUNS = 11;
    public static final int WIN_BY_WICKET = 12;
    public static final int PLAYER_OF_THE_MATCH = 13;
    public static final int VENUE = 14;
    //Delivery parts
    public static final int DEL_MATCH_ID = 0;
    public static final int INNINGS = 1;
    public static final int BATTING_TEAM = 2;
    public static final int BOWLING_TEAM = 3;
    public static final int OVER = 4;
    public static final int BALLS = 5;
    public static final int BATSMAN = 6;
    public static final int NON_STRIKER = 7;
    public static final int BOWLER = 8;
    public static final  int IS_SUPER_OVER=9;
    public static final  int WIDE_RUNS=10;
    public static final  int BYE_RUNS=11;
    public static final  int LEG_BYE_RUNS=12;
    public static final  int NO_BALL=13;
    public static final  int PENALTY_RUNS=14;
    public static final  int BATSMAN_RUNS=15;
    public static final int EXTRA_RUNS = 16;
    public static final int TOTAL_RUNS = 17;
    public static final int PLAYER_DISMISSED=18;
    public static final int DISMISSAL_KIND=19;
    public static final int FIELDER=20;




    public static void main(String[] args) {
        ArrayList<Match> matches = getTheDatafromMatch();
        ArrayList<Delivery> deliveries = getTheDatafromDeliveries();


//        HashMap<String, Integer> totalMatchesPlayedPerYear = numberOfMatchesPlayedPerYears(matches);
//        totalMatchesWonByATeamInIpl(matches);
//        extraRunsConcededPerTeamIn2016(matches,deliveries);
//        topEconomicalBowlerIn2015(matches,deliveries);
//        maxCaugthHolder(deliveries);
//        highestScoreByABatsManIn2010(matches,deliveries);
          maxCaughtHolderinIpl(deliveries);

    }

     public static HashMap<String,Integer> maxCaughtHolderinIpl(ArrayList<Delivery> deliveries) {
        HashMap<String,Integer>caughtHolder= new HashMap<>();
        for(Delivery delivery:deliveries){
            if(delivery.getDismissalKind()!=null && delivery.getDismissalKind().equals("caught") ){
                String fielder = delivery.getFielder();
                if(caughtHolder.containsKey(fielder)){
                    int count=caughtHolder.get(fielder);
                    caughtHolder.put(fielder,count+1);
                }else{
                    caughtHolder.put(fielder,1);
                }
            }
        }
        List<Map.Entry<String,Integer>>mapList= new ArrayList<>(caughtHolder.entrySet());
        mapList.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
         System.out.println(mapList);
         HashMap<String,Integer>answerMap= new HashMap<>();
         answerMap.put(mapList.get(0).getKey(),mapList.get(0).getValue());
          return  answerMap;
    }


    public static ArrayList<Match> getTheDatafromMatch() {
        String path = "/home/shashi/IdeaProjects/IPlProjectQA/src/data/matches.csv";
        String line = "";
        ArrayList<Match> matchList = new ArrayList<Match>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            br.readLine();
            while ((line = br.readLine()) != null) {
                Match match = new Match();
                String[] values = line.split(",");
                match.setMatchId(Integer.parseInt(values[MATCH_ID]));
                match.setSeason(values[SEASON]);
                match.setCity(values[CITY]);
                match.setDate(values[DATE]);
                match.setTeam1(values[TEAM1]);
                match.setTeam2(values[TEAM2]);
                match.setTossWinner(values[TOSS_WINNER]);
                match.setTossDecision(values[TOSS_DECISION]);
                match.setResult(values[RESULT]);
                match.setDlApplied(values[DL_APPLIED]);
                match.setWinner(values[WINNER]);
                match.setWinByRuns(values[WIN_BY_RUNS]);
                match.setWinByWickets(values[WIN_BY_WICKET]);
                match.setPlayerOfMatch(values[PLAYER_OF_THE_MATCH]);
                match.setVenue(values[VENUE]);

                matchList.add(match);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return matchList;
    }

    public static ArrayList<Delivery> getTheDatafromDeliveries() {
        String path1 = "/home/shashi/IdeaProjects/IPlProjectQA/src/data/deliveries.csv";
        String line = "";
        ArrayList<Delivery> deliveryDataList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path1));
            br.readLine();
            while ((line = br.readLine()) != null) {
                Delivery delivery = new Delivery();
                String[] values = line.split(",");
                delivery.setDelMatchId(Integer.parseInt(values[DEL_MATCH_ID]));
                delivery.setInnings(values[INNINGS]);
                delivery.setBattingTeams(values[BATTING_TEAM]);
                delivery.setBowlingTeams(values[BOWLING_TEAM]);
                delivery.setOver(values[OVER]);
                delivery.setBall(values[BALLS]);
                delivery.setBatsman(values[BATSMAN]);
                delivery.setNonStriker(values[NON_STRIKER]);
                delivery.setBowler(values[BOWLER]);
                delivery.setIsSuperOver(values[IS_SUPER_OVER]);
                delivery.setWideRuns(values[WIDE_RUNS]);
                delivery.setByeRuns(values[BYE_RUNS]);
                delivery.setLegByRuns(values[LEG_BYE_RUNS]);
                delivery.setNoBall(values[NO_BALL]);
                delivery.setPenaltyRuns(values[PENALTY_RUNS]);
                delivery.setBatsmanRuns(values[BATSMAN_RUNS]);
                delivery.setExtraRuns(values[EXTRA_RUNS]);
                delivery.setTotalRuns(values[TOTAL_RUNS]);

                if(values.length>18){
                    delivery.setPlayerDismissed(values[PLAYER_DISMISSED]);

                    delivery.setDismissalKind(values[DISMISSAL_KIND]);

                }
                if(values.length>20){
                    delivery.setFielder(values[FIELDER]);
                }
                deliveryDataList.add(delivery);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deliveryDataList;
    }

    public static HashMap<String,Integer> highestScoreByABatsManIn2010(ArrayList<Match> matches, ArrayList<Delivery> deliveries) {
         ArrayList<Integer> idOf2010= new ArrayList<>();
         for(Match match:matches){
             if(match.getSeason().equals("2010")){
                 idOf2010.add(match.getMatchId());
             }
         }
         HashMap<String,Integer> batsManRunMap= new HashMap<>();
         for(Delivery delivery:deliveries){
             if(idOf2010.contains(delivery.getDelMatchId())){
                 int runs=Integer.parseInt(delivery.getBatsmanRuns());
                 String batsman=delivery.getBatsman();
                 if(batsManRunMap.containsKey(delivery.getBatsman())){
                     int runsAlreadyMade=batsManRunMap.get(batsman);
                     batsManRunMap.put(batsman,runsAlreadyMade+runs);
                 }else{
                     batsManRunMap.put(batsman,runs);
                 }
             }
         }

         ArrayList<Map.Entry<String,Integer>>mapList= new ArrayList<>(batsManRunMap.entrySet());
         mapList.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
        HashMap<String,Integer>resultMap= new HashMap<>();
        resultMap.put(mapList.get(0).getKey(),mapList.get(0).getValue());
        return resultMap;
    }

    public static HashMap<String, Integer> maxCaugthHolder(ArrayList<Delivery> deliveries) {
        if(deliveries.size()<1){
            return null;
        }
        HashMap<String,Integer>caughtMap= new HashMap<>();
        for (Delivery del:deliveries){
            if(del.getDismissalKind()!=null && del.getDismissalKind().equals("caught")){
                  String fielder=del.getFielder();
                  if(caughtMap.containsKey(fielder)){
                      int count=caughtMap.get(fielder);
                      caughtMap.put(fielder,count+1);
                  }else{
                      caughtMap.put(fielder,1);
                  }
            }
        }
        List<Map.Entry<String,Integer>>mapList= new ArrayList<>(caughtMap.entrySet());
        mapList.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
        HashMap<String,Integer> answerMap= new HashMap<>();
        answerMap.put(mapList.get(0).getKey(),mapList.get(0).getValue());
        System.out.println(answerMap);
       return answerMap;
    }

    public static HashMap<String, Double> topEconomicalBowlerIn2015(ArrayList<Match> matches, ArrayList<Delivery> deliveries) {
        ArrayList<Integer> listOfId2015= new ArrayList<>();
        for(Match match:matches){
            if(match.getSeason().equals("2015")){
                listOfId2015.add(match.getMatchId());
            }
        }
        HashMap<String,Integer> totalRunsByBowlerMap=new HashMap<>();
        HashMap<String,Integer> totalBallByBowlerMap=new HashMap<>();

        for (Delivery delivery:deliveries){
            if(listOfId2015.contains(delivery.getDelMatchId())){
                int totalRuns=Integer.parseInt(delivery.getTotalRuns());
                int legByRuns=Integer.parseInt(delivery.getLegByRuns());
//                System.out.println(delivery.getLegByRuns());
                int runsByBowler=totalRuns-legByRuns;
                String bowler=delivery.getBowler();

                if(totalRunsByBowlerMap.containsKey(delivery.getBowler())){
                    int alreadyRunsGiven=totalRunsByBowlerMap.get(bowler);
                    totalRunsByBowlerMap.put(delivery.getBowler(),runsByBowler+alreadyRunsGiven);
                }else{
                   totalRunsByBowlerMap.put(bowler,runsByBowler);
                }

                if(delivery.getWideRuns().equals("0")){
                    if(totalBallByBowlerMap.containsKey(bowler)){

                        int totalBall= totalBallByBowlerMap.get(bowler);
                        totalBallByBowlerMap.put(bowler,totalBall+1);
                    }else{
                        totalBallByBowlerMap.put(bowler,1);
                    }
                }

            }
        }

        HashMap<String,Double> economyMap= new HashMap<>();

        for(String bowler:totalRunsByBowlerMap.keySet()){
            int runsGiven=totalRunsByBowlerMap.get(bowler);
            int totalBall= totalBallByBowlerMap.get(bowler);
            double eco=(double)runsGiven*6/totalBall;

            economyMap.put(bowler,eco);
        }
//        sorting the map in asc order
        List<Map.Entry<String,Double>>listMap= new ArrayList<>(economyMap.entrySet());
        listMap.sort(Map.Entry.comparingByValue());
        listMap.sort(Map.Entry.comparingByValue());
        System.out.println(listMap.get(0));

//        getting top bolwer name with his economy
       Double rate= listMap.get(0).getValue();
       String bowlerName=listMap.get(0).getKey();

       HashMap<String, Double> answerMap= new HashMap<>();
       answerMap.put(bowlerName,rate);

        return answerMap;


    }

    public static HashMap<String,Integer> extraRunsConcededPerTeamIn2016(ArrayList<Match> matches, ArrayList<Delivery> deliveries) {
            ArrayList<Integer>listOfId2016= new ArrayList<>();
            for(Match match:matches){

                if(match.getSeason().equals("2016")){
                    listOfId2016.add(match.getMatchId());
                }
            }
             HashMap<String,Integer>extraRunsMap=new HashMap<>();
            for(Delivery delivery:deliveries){
                if(listOfId2016.contains(delivery.getDelMatchId())){
                   if(extraRunsMap.containsKey(delivery.getBowlingTeams())){
                       int totalExtra=extraRunsMap.get(delivery.getBowlingTeams());
                       int runs=Integer.parseInt(delivery.getExtraRuns());
                       extraRunsMap.put(delivery.getBowlingTeams(),totalExtra+runs);
                   }else{
                       int runs=Integer.parseInt(delivery.getExtraRuns());
                       extraRunsMap.put(delivery.getBowlingTeams(),runs);
                   }
                }
            }

        System.out.println(extraRunsMap);
            return extraRunsMap;

    }

    public static HashMap<String,Integer> totalMatchesWonByATeamInIpl(ArrayList<Match> matches) {
        HashMap<String,Integer> winnerMap=new HashMap<>();

        for(Match match:matches){
            if(winnerMap.containsKey(match.getWinner())){
                int count=winnerMap.get(match.getWinner());
                winnerMap.put(match.getWinner(),count+1);
            }else{
                winnerMap.put(match.getWinner(),1);
            }
        }
        System.out.println(winnerMap);
        return winnerMap;
    }

    public static HashMap<String,Integer> numberOfMatchesPlayedPerYears(ArrayList<Match> matches) {
        HashMap<String,Integer>noOfMatches=new HashMap<>();

         for(Match match:matches){
             if(noOfMatches.containsKey(match.getSeason())){
                 int count=noOfMatches.get(match.getSeason());
                 noOfMatches.put(match.getSeason(),count+1);
             }else{
                 noOfMatches.put(match.getSeason(),1);
             }
         }
        System.out.println(noOfMatches);
         return noOfMatches;

    }



}