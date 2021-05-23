package net.epamproj.model;

public enum Role {
    GUEST(1), CLIENT(2), MASTER(3), ADMIN(4);

    int id;

    Role(int id) {
        this.id = id;
    }

    public int getRoleId(){
        int num = id;
        return num;
    }
}
