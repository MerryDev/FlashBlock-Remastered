package de.digitaldevs.flashblock.teams;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;

public class TeamManager {


    private static final HashMap<Team, List<Player>> teams = new HashMap<>();

    public void addToTeam(Team team, Player player) {
      final List<Player> playerList = teams.get(team);
      playerList.add(player);
      teams.put(team, playerList);
    }

    public void removeFromTeam(Team team, Player player) {
        final List<Player> playerList = teams.get(team);
        playerList.remove(player);
        teams.put(team, playerList);
    }

    public Team getTeamByPlayer() {

        return null;
    }

    public boolean isInTeam(Team team, Player player) {
        final List<Player> playerList = teams.get(team);
        if(playerList.contains(player)) {
            return true;
        } else {
            return false;
        }

    }

    public static void clearTeams() {
        if(!teams.isEmpty()) {
            teams.clear();
        }
    }
}
