package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Arrays;

import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        
        Arrays.sort(players, (a,b) -> b.getScore() - a.getScore());

        System.out.format("%30s %5s %5s %5s %5s", "Name", "Team", "Goals", "Assists", "Score \n");
        System.out.println("-----------------------------------------------------------------");

        for (Player player : players) {
            System.out.format("%30s %5s %5s %5s %5d",
                player.getName(),
                player.getTeam(),
                player.getGoals(),
                player.getAssists(),
                player.getScore());

            System.out.println();
        }   
    }
}