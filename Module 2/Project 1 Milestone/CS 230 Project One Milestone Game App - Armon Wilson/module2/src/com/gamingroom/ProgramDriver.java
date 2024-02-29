package com.gamingroom;

/**
 * Application start-up program
 * 
 * @author coce@snhu.edu
 */
public class ProgramDriver {
	
	/**
	 * The one-and-only main() method
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
		// FIXED: obtain reference to the singleton instance
		
		//ADDED CODE
		// Null value replaced with a call to GameService.getInstance() method.
		// This verifies only single instance is created.
		GameService service = GameService.getInstance(); 
		
		System.out.println("\nAbout to test initializing game data...");
		
		// initialize with some game data
		Game game1 = service.addGame("Game #1");
		System.out.println(game1);
		Game game2 = service.addGame("Game #2");
		System.out.println(game2);
		
		// Added test cases for the additional Entities
		// Game 3 ID should be #2 to verify singleton. 
		System.out.println();
		System.out.println("Test Case for Game Singleton.");
		System.out.println("ID should be #2");
		Game game3 = service.addGame("Game #2");
		System.out.println(game3);
		
		System.out.println();
		Team team1 = game1.addTeam("Team #1");
		System.out.println(team1);
		Team team2 = game1.addTeam("Team #2");
		System.out.println(team2);
		
		// Team 3 ID should be #2 to verify singleton.
		System.out.println();
		System.out.println("Test Case for Team Singleton");
		System.out.println("ID should be #2");
		Team team3 = game1.addTeam("Team #2");
		System.out.println(team3);		
		
		System.out.println();
		Player player1 = team1.addPlayer("Player 1");
		System.out.println(player1);
		Player player2 = team1.addPlayer("Player 2");
		System.out.println(player2);
		System.out.println();
		
		// Player 3 ID should be #2 to verify singleton.
		System.out.println("Test Case for Player Singleton");
		System.out.println("ID should be #2");
		Player player3 = team1.addPlayer("Player 2");
		System.out.println(player3);
		
		// use another class to prove there is only one instance
		SingletonTester tester = new SingletonTester();
		tester.testSingleton();
		
	}
}
