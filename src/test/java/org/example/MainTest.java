package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void numberOfMatchesPlayedPerYears() {

        ArrayList<Match> list= new ArrayList<>();
         Match match1= new Match();
         match1.setSeason("2015");

        Match match2= new Match();
        match2.setSeason("2016");

        Match match3= new Match();
        match3.setSeason("2017");

        list.add(match1);
        list.add(match1);
        list.add(match1);

        list.add(match2);
        list.add(match2);
        list.add(match2);

        list.add(match3);

        HashMap<String,Integer> result= new HashMap<>();
        result.put("2015",3);
        result.put("2016",3);
        result.put("2017",1);

        assertEquals(result,Main.numberOfMatchesPlayedPerYears(list),"errror in first method");


//        TestCase for Empty ArrayList

      ArrayList<Match> emptyList= new ArrayList<>();
      HashMap<String,Integer> expectedInEmpty= new HashMap<>();
      assertEquals(expectedInEmpty,Main.numberOfMatchesPlayedPerYears(emptyList));

    }

    @Test
    void totalMatchesWonByATeamInIpl() {
        Match match1= new Match();
        match1.setWinner("Royal Challengers Bangalore");

        Match match2= new Match();
        match2.setWinner("Royal Challengers Bangalore");

        Match match3= new Match();
        match3.setWinner("Mumbai Indians");

        ArrayList<Match> matches= new ArrayList<>();
        matches.add(match1);
        matches.add(match2);
        matches.add(match3);

        HashMap<String,Integer> expected= new HashMap<>();
        expected.put("Mumbai Indians",1);
        expected.put("Royal Challengers Bangalore",2);

        assertEquals(expected,Main.totalMatchesWonByATeamInIpl(matches));

    }

    @Test
    void extraRunsConcededPerTeamIn2016() {
        ArrayList<Match> matches= new ArrayList<>();
        Match match1= new Match();
        match1.setMatchId(1);
        match1.setSeason("2016");

        Match match2= new Match();
        match2.setMatchId(2);
        match2.setSeason("2015");

        matches.add(match1);
        matches.add(match2);

  ArrayList<Delivery> deliveries= new ArrayList<>();

//        id 1= seaon=2015
        Delivery delivery1= new Delivery();
        delivery1.setDelMatchId(1);
        delivery1.setExtraRuns("1");
        delivery1.setBowlingTeams("rcb");

        Delivery delivery2= new Delivery();
        delivery2.setExtraRuns("2");
        delivery2.setDelMatchId(1);
        delivery2.setBowlingTeams("srh");

        Delivery delivery3= new Delivery();
        delivery3.setDelMatchId(1);
        delivery3.setExtraRuns("4");
        delivery3.setBowlingTeams("rcb");


         deliveries.add(delivery1);
         deliveries.add(delivery2);
         deliveries.add(delivery3);

//         id=2,season=2015
        Delivery delivery4= new Delivery();
        delivery4.setDelMatchId(1);
        delivery4.setExtraRuns("1");
        delivery4.setBowlingTeams("delhi");

        Delivery delivery5= new Delivery();
        delivery5.setDelMatchId(2);
        delivery5.setBowlingTeams("up");
        delivery5.setExtraRuns("1");

        deliveries.add(delivery4);
        deliveries.add(delivery5);

    HashMap<String,Integer> expected= new HashMap<>();
    expected.put("rcb",5);
    expected.put("srh",2);
    expected.put("delhi",1);



    assertEquals(expected,Main.extraRunsConcededPerTeamIn2016(matches,deliveries));


    }

    @Test
    void topEconomicalBowlerIn2015() {
        Match match1= new Match();
        match1.setSeason("2015");
        match1.setMatchId(1);

        Match match2= new Match();
        match2.setSeason("2015");
        match2.setMatchId(2);

        Match match3= new Match();
        match3.setMatchId(3);
        match3.setSeason("2016");

        ArrayList<Match> matches= new ArrayList<>();
        matches.add(match1);
        matches.add(match2);
        matches.add(match3);
//   id=1,2, season=2015
        Delivery delivery1= new Delivery();
        delivery1.setDelMatchId(1);
        delivery1.setBowler("shashi");
        delivery1.setTotalRuns("1");
        delivery1.setLegByRuns("1");

        Delivery delivery2= new Delivery();
        delivery2.setDelMatchId(1);
        delivery2.setBowler("shashi");
        delivery2.setTotalRuns("3");
        delivery2.setLegByRuns("1");

        Delivery delivery3= new Delivery();
        delivery3.setDelMatchId(1);
        delivery3.setBowler("amit");
        delivery3.setTotalRuns("2");
        delivery3.setLegByRuns("0");

        Delivery delivery4= new Delivery();
        delivery4.setDelMatchId(1);
        delivery4.setBowler("amit");
        delivery4.setTotalRuns("6");
        delivery4.setLegByRuns("0");


        Delivery delivery5= new Delivery();
        delivery5.setBowler("amit");
        delivery5.setTotalRuns("4");
        delivery5.setLegByRuns("0");
        delivery5.setDelMatchId(1);

//     matchId=2 and season = 2015
        Delivery delivery6= new Delivery();
        delivery6.setDelMatchId(2);
        delivery6.setBowler("amirul");
        delivery6.setTotalRuns("4");
        delivery6.setLegByRuns("0");

        Delivery delivery7= new Delivery();
        delivery7.setDelMatchId(2);
        delivery7.setBowler("amirul");
        delivery7.setTotalRuns("3");
        delivery7.setLegByRuns("0");

        Delivery delivery8= new Delivery();
        delivery8.setDelMatchId(2);
        delivery8.setBowler("amirul");
        delivery8.setTotalRuns("0");
        delivery8.setLegByRuns("0");

        Delivery delivery9= new Delivery();
        delivery9.setDelMatchId(2);
        delivery9.setBowler("shashi");
        delivery9.setTotalRuns("1");
        delivery9.setLegByRuns("0");

        Delivery delivery10= new Delivery();
        delivery10.setDelMatchId(2);
        delivery10.setBowler("raj");
        delivery10.setTotalRuns("1");
        delivery10.setLegByRuns("0");

        Delivery delivery11= new Delivery();
        delivery11.setDelMatchId(2);
        delivery11.setBowler("raj");
        delivery11.setTotalRuns("0");
        delivery11.setLegByRuns("0");

        Delivery delivery12= new Delivery();
        delivery12.setDelMatchId(2);
        delivery12.setBowler("dev");
        delivery12.setTotalRuns("15");
        delivery12.setLegByRuns("0");

       ArrayList<Delivery> deliveries = new ArrayList<>();
       deliveries.add(delivery1);
       deliveries.add(delivery2);
       deliveries.add(delivery3);
       deliveries.add(delivery4);
       deliveries.add(delivery5);
       deliveries.add(delivery6);
       deliveries.add(delivery8);
       deliveries.add(delivery9);
//       repeating same value;
        deliveries.add(delivery8);
        deliveries.add(delivery10);
        deliveries.add(delivery11);
        deliveries.add(delivery12);

// other  season= 2016 because id=3;
        Delivery delivery13= new Delivery();
        delivery13.setDelMatchId(3);
        delivery13.setBowler("rahul");
        delivery13.setTotalRuns("0");
        delivery13.setLegByRuns("0");

        deliveries.add(delivery13);
        deliveries.add(delivery13);
       HashMap<String,Double> expectedMap= new HashMap<>();
       expectedMap.put("raj",3.0);


       assertEquals(expectedMap,Main.topEconomicalBowlerIn2015(matches,deliveries));





    }

    @Test
    void maxCaugthHolder() {
       Delivery delivery1= new Delivery();
       delivery1.setDismissalKind("caught");
       delivery1.setFielder("shashi");

        Delivery delivery2= new Delivery();
        delivery2.setDismissalKind("caught");
        delivery2.setFielder("amit");

        Delivery delivery3= new Delivery();
        delivery3.setDismissalKind("caught");
        delivery3.setFielder("dina");

        Delivery delivery4= new Delivery();
        delivery4.setFielder("rahul");
        delivery4.setDismissalKind("bowled");

       ArrayList<Delivery> deliveries= new ArrayList<>();
        deliveries.add(delivery1);
        deliveries.add(delivery1);
        deliveries.add(delivery1);
        deliveries.add(delivery2);
        deliveries.add(delivery3);
        deliveries.add(delivery3);
        deliveries.add(delivery3);
        deliveries.add(delivery4);
        deliveries.add(delivery4);
        deliveries.add(delivery4);
        deliveries.add(delivery4);
        deliveries.add(delivery4);


       HashMap<String,Integer> expected= new HashMap<>();
       expected.put("dina",3);
       assertEquals(expected,Main.maxCaugthHolder(deliveries));

       ArrayList<Delivery> emptyMap= new ArrayList<>();

       assertEquals(null,Main.maxCaugthHolder(emptyMap));
    }

    @Test
   void highestScoreByABatsManIn2010() {
        Match match1= new Match();
        match1.setSeason("2010");
        match1.setMatchId(1);

        Match match2= new Match();
        match2.setMatchId(2);
        match2.setSeason("2010");


        ArrayList<Match> matches= new ArrayList<>();
        matches.add(match1);
        matches.add(match2);

        Match match3= new Match();
        match3.setSeason("2011");
        match3.setMatchId(3);
        matches.add(match3);

        Match match4= new Match();
        match4.setSeason("2010");
        match4.setMatchId(4);
        matches.add(match4);

        matches.add(match4);

        Delivery delivery1= new Delivery();
        delivery1.setDelMatchId(1);
        delivery1.setBatsmanRuns("6");
        delivery1.setBatsman("shashi");

        Delivery delivery2= new Delivery();
        delivery2.setBatsman("amit");
        delivery2.setDelMatchId(1);
        delivery2.setBatsmanRuns("4");

        Delivery delivery3= new Delivery();
        delivery3.setDelMatchId(2);
        delivery3.setBatsman("shashi");
        delivery3.setBatsmanRuns("4");

        Delivery delivery4= new Delivery();
        delivery4.setBatsmanRuns("2");
        delivery4.setBatsman("amit");
        delivery4.setDelMatchId(2);

        ArrayList<Delivery> deliveries= new ArrayList<>();
        deliveries.add(delivery1);
        deliveries.add(delivery2);
        deliveries.add(delivery3);
        deliveries.add(delivery4);

        Delivery delivery5= new Delivery();
        delivery5.setDelMatchId(3);
        delivery5.setBatsman("shashi");
        delivery5.setBatsmanRuns("5");

        deliveries.add(delivery5);

        Delivery delivery6= new Delivery();
        delivery6.setDelMatchId(4);
        delivery6.setBatsman("lalu");
        delivery6.setBatsmanRuns("50");


        deliveries.add(delivery6);


        HashMap<String,Integer> expected= new HashMap<>();
        expected.put("lalu",50);


        assertEquals(expected,Main.highestScoreByABatsManIn2010(matches,deliveries));



    }

    @Test
    void testMaxCaugthHolder() {
        Delivery delivery1= new Delivery();
        delivery1.setDismissalKind("bowled");


        Delivery delivery2= new Delivery();
        delivery2.setDismissalKind("caught");
        delivery2.setFielder("shashi");

        Delivery delivery3= new Delivery();
        delivery3.setBatsman("mb");

        ArrayList<Delivery> deliveries= new ArrayList<>();
        deliveries.add(delivery1);
        deliveries.add(delivery2);
        deliveries.add(delivery3);
        HashMap<String,Integer> expectedMap= new HashMap<>();
        expectedMap.put("shashi",1);

        assertEquals(expectedMap,Main.maxCaugthHolder(deliveries));
    }
}