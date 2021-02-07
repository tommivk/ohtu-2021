package ohtuesimerkki;

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


import java.util.ArrayList;
import java.util.List;

public class StatisticsTest {

    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
    
    Statistics statistics;

    @Before
    public void setup() {
        statistics = new Statistics(readerStub);
    }

    @Test
    public void searchReturnsPlayer() {
        Player player = statistics.search("Semenko");
        assertEquals(player.getName(), "Semenko");
    }

    @Test
    public void searchReturnsNullWhenNoMatch() {
        assertEquals(statistics.search("Selanne"), null);
    }

    @Test
    public void teamReturnsCorrectData() {
        List<Player> edm = new ArrayList<>();
        edm.add(new Player("Semenko", "EDM", 4, 12));
        edm.add(new Player("Kurri",   "EDM", 37, 53));
        edm.add(new Player("Gretzky", "EDM", 35, 89));

        List<Player> res = statistics.team("EDM");

        for(int i = 0; i<edm.size(); i++) {
            assertEquals(edm.get(i).getName(), res.get(i).getName());
            assertEquals(edm.get(i).getPoints(), res.get(i).getPoints());
            assertEquals(edm.get(i).getTeam(), res.get(i).getTeam());
        }
    }

    @Test
    public void top3ScoresIsCorrect() {
        List<Player> topScorers = statistics.topScorers(3);
        assertEquals(topScorers.get(0).getName(), "Gretzky");
        assertEquals(topScorers.get(1).getName(), "Lemieux");
        assertEquals(topScorers.get(2).getName(), "Yzerman");
    }
}