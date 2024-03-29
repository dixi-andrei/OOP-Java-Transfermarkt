package service;
import model.*;
import service.ClubService;
import java.util.*;

public class ClubServiceImpl implements ClubService{
    @Override
    public void addPlayerToClub(Player player, Club club) {
        if(!club.getPlayers().contains(player)){
            club.addPlayer(player);
            System.out.println("Player " + player.getFirstName() + " " + player.getLastName() + " has been successfully added to the team.");
        }else{
            System.out.println("Player " + player.getFirstName() + " " + player.getLastName() + " is already in the team!");
        }
    }

    @Override
    public void removePlayerFromClub(Player player, Club club) {
        if (!club.getPlayers().contains(player)) {
            System.out.println("Player " + player.getFirstName() + " " + player.getLastName() + " is not part of the team!");
        } else {
            club.removePlayer(player);
            System.out.println("Player " + player.getFirstName() + " " + player.getLastName() + " has been successfully removed from the team.");
        }
    }

    @Override
    public double calculateClubValue(Club club) {
        double sum = 0.0;
        for(Player player : club.getPlayers()){
            sum+= player.getValue();
        }
        club.setTeamValue(sum);
        return sum;
    }

    @Override
    public List<Player> getClubPlayers(Club club) {
        List<Player> players =  club.getPlayers();
        System.out.println(club.toString());
        for(Player player : players){
            System.out.println(player.toString());
        }
        return club.getPlayers();
    }

    @Override
    public List<Player> getClubPlayersSortedByValue(Club club,boolean ascending) {
        List<Player> players = club.getPlayers();

        if (ascending) {
            players.sort(Comparator.comparingDouble(Player::getValue));
        } else {
            players.sort(Comparator.comparingDouble(Player::getValue).reversed());
        }

        return players;
    }
}
