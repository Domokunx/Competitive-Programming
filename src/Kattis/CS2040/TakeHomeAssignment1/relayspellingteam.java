package Kattis.CS2040.TakeHomeAssignment1;

import java.util.Scanner;

public class relayspellingteam {
    static class Runner {
        public String name;
        public float firstLeg;
        public float secondLeg;

        public Runner(String name, float firstLeg, float secondLeg) {
            this.name = name;
            this.firstLeg = firstLeg;
            this.secondLeg = secondLeg;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Runner[] team = new Runner[4];

        short runners = scanner.nextShort();
        // Establish benchmark team
        float secondLegTotal = 0;
        for (int i = 0; i < 4; i++) {
            var currentRunner = new Runner(scanner.next(), scanner.nextFloat(), scanner.nextFloat());
            team[i] = currentRunner;
            secondLegTotal += currentRunner.secondLeg;
        }
        // Best arrangement
        float worstSecondLeg = 0;
        float totalTime = Float.MAX_VALUE;
        totalTime = rearrangeTeam(team, secondLegTotal, worstSecondLeg, totalTime);

        // Sub in player if better time
        for (int i = 4; i < runners; i++) {
            var currentRunner = new Runner(scanner.next(), scanner.nextFloat(), scanner.nextFloat());
            // If better time for both 1st and 2nd leg
            if (team[0].firstLeg > currentRunner.firstLeg && team[3].secondLeg > currentRunner.secondLeg) {
                float firstLegDiff = team[0].firstLeg - currentRunner.firstLeg;
                float secondLegDiff = team[3].secondLeg - currentRunner.secondLeg;
                if (firstLegDiff > secondLegDiff) {
                    totalTime = firstToSub(team, totalTime, currentRunner);
                    worstSecondLeg = getWorstSecondLeg(team, worstSecondLeg);

                }
                else {
                    totalTime = subToFirst(team, totalTime, currentRunner);
                    worstSecondLeg = getWorstSecondLeg(team, worstSecondLeg);

                }
            }
            else if (currentRunner.firstLeg < team[0].firstLeg) {
                totalTime = firstToSub(team, totalTime, currentRunner);
                worstSecondLeg = getWorstSecondLeg(team, worstSecondLeg);

            }
            else if (currentRunner.secondLeg < team[3].secondLeg) {
                totalTime = subToFirst(team, totalTime, currentRunner);
                worstSecondLeg = getWorstSecondLeg(team, worstSecondLeg);
            }
        }
        secondLegTotal = 0;
        for (var runner : team) {
            secondLegTotal += runner.secondLeg;
        }
        // Best arrangement
        worstSecondLeg = 0;
        totalTime = Float.MAX_VALUE;
        totalTime = rearrangeTeam(team, secondLegTotal, worstSecondLeg, totalTime);
        System.out.println(totalTime);
        for (Runner runner : team) {
            System.out.println(runner.name);
        }
    }

    private static float rearrangeTeam(Runner[] team, float secondLegTotal, float worstSecondLeg, float totalTime) {
        for (int i = 0; i < team.length; i++) {
            float currentTotalTime = team[i].firstLeg + (secondLegTotal - team[i].secondLeg);
            if (currentTotalTime < totalTime) {
                totalTime = currentTotalTime;
                Runner temp = team[0];
                team[0] = team[i];
                team[i] = temp;
                worstSecondLeg = getWorstSecondLeg(team, worstSecondLeg);
            }
        }
        return totalTime;
    }

    private static float getWorstSecondLeg(Runner[] team, float worstSecondLeg) {
        for (int j = 1; j < team.length; j++) {
            if (worstSecondLeg < team[j].secondLeg) {
                worstSecondLeg = team[j].secondLeg;
                Runner temp2 = team[3];
                team[3] = team[j];
                team[j] = temp2;
            }
        }
        return worstSecondLeg;
    }

    private static float subToFirst(Runner[] team, float totalTime, Runner currentRunner) {
        if (team[3].firstLeg < team[0].firstLeg) {
            totalTime = totalTime - team[0].firstLeg + team[3].firstLeg - team[3].secondLeg + currentRunner.secondLeg;
            team[0] = team[3];
        }
        else {
            totalTime = totalTime - team[3].secondLeg + currentRunner.secondLeg;
        }
        team[3] = currentRunner;
        return totalTime;
    }

    private static float firstToSub(Runner[] team, float totalTime, Runner currentRunner) {
        if (team[0].secondLeg < team[3].secondLeg) {
            totalTime = totalTime - team[3].secondLeg + team[0].secondLeg - team[0].firstLeg + currentRunner.firstLeg;
            team[3] = team[0];
        }
        else {
            totalTime = totalTime - team[0].firstLeg + currentRunner.firstLeg;
        }
        team[0] = currentRunner;
        return totalTime;
    }
}