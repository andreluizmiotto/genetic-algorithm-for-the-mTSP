package com.br.geneticAlgorithm.display;

import com.br.geneticAlgorithm.domain.Chromosome;
import com.br.geneticAlgorithm.domain.City;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DisplayWindow extends JFrame {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 600 / 16*9;
    private static final int OFFSET = 40;
    private static final int CITY_SIZE = 6;

    private Panel panel;
    private List<City> cities;
    private Chromosome chromosome;
    private double maxX, maxY;
    private double scaleX, scaleY;

    public DisplayWindow(List<City> cities) {
        this.cities = cities;
        setScale();
        panel = createPanel();
        setWindowProperties();
    }

    private void setScale () {
        for (City city : cities) {
            if (city.getLocation().getLatitude() > maxX) {
                maxX = city.getLocation().getLatitude();
            }
            if (city.getLocation().getLongitude() > maxY) {
                maxY = city.getLocation().getLongitude();
            }
        }
        scaleX = maxX / ((double) WIDTH - OFFSET);
        scaleY = maxY / ((double) HEIGHT - OFFSET);
    }

    private Panel createPanel () {
        Panel panel = new Panel();
        Container cp = getContentPane();
        cp.add(panel);
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        return panel;
    }

    private void setWindowProperties () {
        int sWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2;
        int sHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2;
        int x = sWidth - (WIDTH / 2);
        int y = sHeight - (HEIGHT / 2);
        setLocation(x, y);
        setResizable(false);
        pack();
        setTitle("Multiple Traveling Salesman Problem");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

}
