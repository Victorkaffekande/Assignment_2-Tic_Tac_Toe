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
        String output = "";


        if(Objects.equals(winner, "-1")){
            output = "Draw";
        }
        if (Objects.equals(winner, "0")){
            output = "Player 0 Wins";
        }
        if (Objects.equals(winner, "1")){
           output = "Player 1 Wins";
        }

        winners.add(output);
    }
}