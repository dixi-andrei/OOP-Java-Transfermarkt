package service;
import model.*;
import java.util.*;

public interface ClubService {
    void addPlayerToClub(Player player, Club club);
    void removePlayerFromClub(Player player, Club club);
    double calculateClubValue(Club club);
    List<Player> getClubPlayers(Club club);
    List<Player> getClubPlayersSortedByValue(Club club,boolean ascending);
}
