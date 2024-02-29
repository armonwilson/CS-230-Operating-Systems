package com.gamingroom;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity {

    private List<Team> teams = new ArrayList<>();

    /**
     * Constructor with an identifier and name
     */
    public Game(long id, String name) {
    	
    	super(id, name);
      
    }

    /**
     * Method to add a team to the game
     * 
     * @param name the unique name of the team
     * @return the created Team instance
     */
    public Team addTeam(String name) {
        Team team = null;
        
        Iterator<Team> iterator = teams.iterator();
        while (iterator.hasNext()) {
            Team existingTeam = iterator.next();
            if (existingTeam.getName().equals(name)) {
                team = existingTeam;
                break;
            } 
        }
        if (team == null) {
        	long id = GameService.getNextTeamId();
            team = new Team(id, name);
            teams.add(team);
        }
       return team;
    }

    @Override
    public String toString() {
        return "Game [id=" + getId() + ", name=" + getName() + "]";
    }
}
