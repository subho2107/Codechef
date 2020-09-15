import java.io.*;
import java.util.*;

class CoronavirusSpread2 {
    public static float meetingTime(int person1, int person2, int[] speed) {
        if (speed[person1] == speed[person2]) return -1;
        return (person1 - person2) / (float) (speed[person2] - speed[person1]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            String[] inp = buffer.readLine().split(" ");
            int[] speed = new int[n + 1];
            for (int pos = 1; pos <= n; pos++) {
                speed[pos] = Integer.parseInt(inp[pos - 1]);
            }
            int bestCase = n + 1, worstCase = 0;
            for (int firstInfected = 1; firstInfected <= n; firstInfected++) {
                boolean[] infected = new boolean[n + 1];
                float[] timeOfInfection = new float[n + 1];
                Arrays.fill(timeOfInfection, -1);
                infected[firstInfected] = true;
                timeOfInfection[firstInfected] = 0f;
                for (int times = 0; times < n; times++) {
                    for (int infGuy = 1; infGuy <= n; infGuy++) {
                        if (infected[infGuy]) {
                            for (int nextInfected = 1; nextInfected <= n; nextInfected++) {
                                if (!infected[nextInfected]) {
                                    float meetTime = meetingTime(infGuy, nextInfected, speed);
                                    if (meetTime >= timeOfInfection[infGuy])
                                    {
                                        if (timeOfInfection[nextInfected] == -1)
                                            timeOfInfection[nextInfected] = meetTime;
                                        else
                                            timeOfInfection[nextInfected] = Math.min(meetTime, timeOfInfection[nextInfected]);
                                    }
                                }
                            }
                        }
                    }
                    float minTime = Integer.MAX_VALUE;
                    int nextInfected = 0;
                    for (int person = 1; person <= n; person++) {
                        if (!infected[person] && timeOfInfection[person] != -1 && timeOfInfection[person] < minTime) {
                            minTime = timeOfInfection[person];
                            nextInfected = person;
                        }
                    }
                    infected[nextInfected] = true;
                    for (int person = 1; person <= n; person++) {
                        if (!infected[person])
                            timeOfInfection[person] = -1;
                    }
                }
                int cnt = 0;
                for (int person = 1; person <= n; person++) {
                    if (infected[person])cnt++;
                }
                bestCase = Math.min(cnt, bestCase);
                worstCase = Math.max(worstCase, cnt);
            }
            sb.append(bestCase + " " + worstCase + "\n");
        }
        System.out.println(sb);
    }
}
