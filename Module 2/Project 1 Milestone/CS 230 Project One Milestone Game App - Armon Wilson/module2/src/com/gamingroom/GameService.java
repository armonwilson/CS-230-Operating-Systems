package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
//ADDED CODE: Iterator utility 
import java.util.Iterator;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */

/*
 * Additions made by:
 * Armon Wilson
 * SNHU CS-230 Operating Systems
 * 1/20/2024
 */

/*
 * SINGLETON PATTERN EXPLANATION:
 * 
 * This design pattern revolves around a class that can create an object
 * while ensuring that only a single instance is instantiated. This class 
 * offers a method to access its exclusive object directly, eliminating the 
 * need to instantiate multiple instances of the class to access it.  * 
 *
 *
 * ITERATOR PATTERN EXPLANATION:
 * The Iterator pattern in the code simplifies the process of going through
 * the list of active games to find a game with a specific name. It abstracts
 * away the details of how the iteration is done, making the code more straightforward.
 * The loop checks each game's name, and when a match is found, the loop exits,
 * and the matching game is assigned to the game variable. 
 * This pattern improves code clarity and separates the iteration logic from the
 * main search functionality.
 */


public class GameService {

    /**
     * A list of the active games
     */
    private static List<Game> games = new ArrayList<Game>();

    
    private static long nextGameId = 1;
    private static long nextPlayerId = 1;
    private static long nextTeamId = 1;

    // Singleton instance
    private static GameService service;

    // Private constructor to prevent instantiation
    private GameService() {
    }

    // Method to get the instance of the singleton
    public static GameService getInstance() {
        if (service == null) {
            service = new GameService();
        }
        return service;
    }

    /**
     * Construct a new game instance
     * 
     * @param name the unique name of the game
     * @return the game instance (new or existing)
     */
    public Game addGame(String name) {
        Game game = null;

        // Use iterator to look for an existing game with the same name
        Iterator<Game> iterator = games.iterator();
        while (iterator.hasNext()) {
            Game existingGame = iterator.next();
            if (existingGame.getName().equals(name)) {
                game = existingGame;
                break;
            }
        }

        if (game == null) {
            game = new Game(nextGameId++, name);
            games.add(game);
        }

        // Return the new/existing game instance to the caller
        return game;
    }

    /**
     * Returns the game instance with the specified id.
     * 
     * @param id unique identifier of the game to search for
     * @return requested game instance
     */
    public Game getGame(long id) {
        Game game = null;

        // Use iterator to look for an existing game with the same id
        Iterator<Game> iterator = games.iterator();
        while (iterator.hasNext()) {
            Game existingGame = iterator.next();
            if (existingGame.getId() == id) {
                game = existingGame;
                break;
            }
        }
        return game;
    }

    /**
     * Returns the game instance with the specified name.
     * 
     * @param name unique name of the game to search for
     * @return requested game instance
     */
    public Game getGame(String name) {
        Game game = null;

        // Use iterator to look for an existing game with the same name
        Iterator<Game> iterator = games.iterator();
        while (iterator.hasNext()) {
            Game existingGame = iterator.next();
            if (existingGame.getName().equals(name)) {
                game = existingGame;
                break;
            }
        }

        return game;
    }

    /**
     * Returns the number of games currently active
     * 
     * @return the number of games currently active
     */
    public int getGameCount() {
        return games.size();
    }

    // Adds 1 to and returns nextPlayerId.
    public static long getNextPlayerId() { 	
        return nextPlayerId++;
    }
    
    // Adds 1 to and returns nextPlayerId.
    public static long getNextTeamId() {
        return nextTeamId++;
    }
}
