package org.academiadecodigo;


import org.academiadecodigo.movement.Controller;

public class Main {

    public static void main(String[] args) {

        Game game = new Game(80,50);
        new Controller(game);

    }
}
