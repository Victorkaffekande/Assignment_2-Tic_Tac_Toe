package tictactoe.gui.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Objects;

public class ScoreModel {

    private final ObservableList<String> winners;

    public ScoreModel() {
        winners = FXCollections.observableArrayList();
    }

    public ObservableList<String> getWinners() {
        return winners;
    }

    /**
     * If the winner has the value of 0, 1 or -1 it will display, which player has won or if its a draw.
     *
     * @param winner
     */
    public void setNextWinner(String winner) {
        String output = switch (winner) {
            case "-1" -> "Draw";
            case "0" -> "Player 0 wins";
            case "1" -> "Player 1 wins";
            case "2" -> "Human wins";
            case "3" -> "Computer Wins";
            default -> "";
        };
        winners.add(output);
    }
}