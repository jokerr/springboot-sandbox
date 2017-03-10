package io.jokerr.springboot.model;

/**
 * @author jokerr
 */
public class Recipe {
    private String id;
    private String name;

    public Recipe() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
