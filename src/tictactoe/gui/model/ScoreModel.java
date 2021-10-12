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

    public void setNextWinner(String winner) {
        String output = "";


        if(Objects.equals(winner, "-1")){
            output = "Draw";
        }
        if (Objects.equals(winner, "0")){
            output = "Player 0 wins";
        }
        if (Objects.equals(winner, "1")){
           output = "Player 1 wins";
        }

        winners.add(output);
    }
}