package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * Author: coce@snhu.edu
 *
 */
public class Team extends Entity {

    private List<Player> players = new ArrayList<>();

    /*
     * Constructor with an identifier and name
     */
    public Team(long id, String name) {
        super(id, name);
    }

    /**
     * Method to add a player to the team
     *
     * @param name the unique name of the player
     * @return the created Player instance
     */
    public Player addPlayer(String name) {
        Player player = null;
        
        Iterator<Player> iterator = players.iterator();
        while (iterator.hasNext()) {
            Player existingPlayer = iterator.next();
            if (existingPlayer.getName().equals(name)) {
                player = existingPlayer;
                break;
            } 
        }
        
        if (player == null) {
            long playerId = GameService.getNextPlayerId();
            player = new Player(playerId, name);
            players.add(player);
        }
        return player;
    }

    @Override
    public String toString() {
        return "Team [id=" + getId() + ", name=" + getName() + "]";
    }

}