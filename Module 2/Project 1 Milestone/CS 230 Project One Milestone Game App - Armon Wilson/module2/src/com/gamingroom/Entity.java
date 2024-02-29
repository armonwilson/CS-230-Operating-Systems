package com.gamingroom;

public class Entity {

    private long id;
    private String name;

    // Private constructor to prevent instantiation
    private Entity() {
    }

    // Constructor with an identifier and name
    public Entity(long id, String name) {
        
    	this.id = id;
        this.name = name;
    }
    
    // Retrieves object ID
    public long getId() {
        return this.id;
    }
    
    // Retrieves object name
    public String getName() {
        return this.name;
    }

    public String toString() {
        return "Entity [id=" + id + ", name=" + name + "]";
    }
}


