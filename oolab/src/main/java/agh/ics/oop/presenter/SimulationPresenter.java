package agh.ics.oop.presenter;

import agh.ics.oop.model.interfaces.MapChangeListener;
import agh.ics.oop.model.interfaces.WorldMap;
import javafx.fxml.FXML;

import java.awt.*;

public class SimulationPresenter implements MapChangeListener {
    @FXML
    private Label infoLabel;
    WorldMap map;

    public void setWorldMap(WorldMap map) {
        this.map = map;
    }

    public void drawMap() {
        System.out.println(map);
    }

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        infoLabel.setText(message);
        drawMap();
    }
}
