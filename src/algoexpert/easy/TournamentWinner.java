package algoexpert.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TournamentWinner {

    public static String tournamentWinnerSolutionOne(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {

        HashMap<String, Integer> teamsScore = new HashMap<>();

        int largestValue = 0;
        String bestTeam = "";

        for (int i = 0; i < results.size(); i++) {
            ArrayList<String> matches = competitions.get(i);

            Integer teamCurrentValue;
            String teamName;

            if (results.get(i) == 1) {
                teamCurrentValue = teamsScore.get(matches.get(0));
                if (teamCurrentValue == null) teamCurrentValue = 0;
                teamName = matches.get(0);
                teamsScore.put(teamName, ++teamCurrentValue);

            } else {
                teamCurrentValue = teamsScore.get(matches.get(1));
                if (teamCurrentValue == null) teamCurrentValue = 0;
                teamName = matches.get(1);
                teamsScore.put(teamName, ++teamCurrentValue);
            }

            if (teamCurrentValue > largestValue) {
                largestValue = teamCurrentValue;
                bestTeam = teamName;
            }
        }

        return bestTeam;
    }


    public static String tournamentWinnerSolutionTwo(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {

        HashMap<String, Integer> teamsScore = new HashMap<>();

        int largestValue = 0;
        String bestTeam = "";

        for (int i = 0; i < results.size(); i++) {
            ArrayList<String> matches = competitions.get(i);

            String currentTeamName = (results.get(i) == 1) ? matches.get(0) : matches.get(1);

            Integer currentTeamValue = teamsScore.get(currentTeamName);
            if (currentTeamValue == null) currentTeamValue = 0;
            teamsScore.put(currentTeamName, ++currentTeamValue);

            if (currentTeamValue > largestValue) {
                largestValue = currentTeamValue;
                bestTeam = currentTeamName;
            }
        }

        return bestTeam;
    }

    public static String tournamentWinnerSolutionThree(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {

        HashMap<String, Integer> teamsScore = new HashMap<>();

        int largestValue = 0;
        String bestTeam = "";

        for (int i = 0; i < results.size(); i++) {
            ArrayList<String> matches = competitions.get(i);

            String currentTeamName = (results.get(i) == 1) ? matches.get(0) : matches.get(1);

            Integer currentTeamValue = teamsScore.get(currentTeamName);

            if (currentTeamValue == null) currentTeamValue = 0;
            teamsScore.put(currentTeamName, ++currentTeamValue);

            if (currentTeamValue > largestValue) {
                largestValue = currentTeamValue;
                bestTeam = currentTeamName;
            }
        }

        return bestTeam;
    }

    public static void main(String[] args) {

        ArrayList<String> matchOne = new ArrayList<>(Arrays.asList("HTML", "C#"));
        ArrayList<String> matchTwo = new ArrayList<>(Arrays.asList("C#", "Python"));
        ArrayList<String> matchThree = new ArrayList<>(Arrays.asList("Python", "HTML"));

        ArrayList<ArrayList<String>> competitions = new ArrayList<>(Arrays.asList(matchOne, matchTwo, matchThree));

        ArrayList<Integer> results = new ArrayList<>(Arrays.asList(0, 0, 1));

        System.out.println(tournamentWinnerSolutionTwo(competitions, results));

    }


}
