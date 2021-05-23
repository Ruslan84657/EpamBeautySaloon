package net.epamproj.model;

public enum Services {
    MANICURE(1), MEN_HAIRCUTE(2), WOMEN_HAIRCUTE(3), HAIR_EXTENSION(4),
    STYLING_AND_HAIRSTYLE(5), HAIR_COLORING(6), SPA(7), MASSAGE(8);

    int id;

    Services(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}