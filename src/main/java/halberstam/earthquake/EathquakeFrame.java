package halberstam.earthquake;

import javax.swing.*;
import java.awt.*;

public class EathquakeFrame {

    public EathquakeFrame(FeatureCollection featureCollection) {
        JFrame mainFrame = new JFrame();

        JPanel mainPanel = new JPanel();

        JPanel questionPanel = new JPanel();

        questionPanel.setSize(300, 200);
        JLabel prompt = new JLabel("Enter a number to get the desired Earthquake information");
        questionPanel.add(prompt);
        JTextField requestedEarthquake = new JTextField("                   ");
        requestedEarthquake.setSize(20,20);
        requestedEarthquake.setBorder(BorderFactory.createLineBorder(Color.black));
        questionPanel.add(requestedEarthquake);
        JButton getQuakeInfo = new JButton("Get EarthQuake Information");
        questionPanel.add(getQuakeInfo);

        JPanel quakeDisplay = new JPanel(new FlowLayout());

        quakeDisplay.setVisible(false);
        JLabel quake = new JLabel("" );
        JLabel magnitude = new JLabel("");
        JLabel place = new JLabel("");
        JLabel time = new JLabel("");
        JLabel tsunami = new JLabel("");
        JLabel coordinates = new JLabel("");
        quakeDisplay.add(quake);

        quakeDisplay.add(magnitude);
        quakeDisplay.add(place);
        quakeDisplay.add(time);
        quakeDisplay.add(tsunami);
        quakeDisplay.add(coordinates);

        quakeDisplay.setSize(300, 400);
        quakeDisplay.setBorder(BorderFactory.createLineBorder(Color.black));

        getQuakeInfo.addActionListener(e -> {
            String request = requestedEarthquake.getText();
            int quakeNumber = Integer.parseInt(request);
            quake.setText("Earthquake #" +quakeNumber);
            Feature earthquake = featureCollection.features[quakeNumber];

            magnitude.setText("Magnitude: " +String.valueOf(earthquake.properties.mag));
            place.setText("Place: " +earthquake.properties.place);
            time.setText("Time: " +String.valueOf(earthquake.properties.time));
            tsunami.setText("Tsunami: " +String.valueOf(earthquake.properties.tsunami));
            coordinates.setText("Coordinates:" +earthquake.geometry.coordinates[0] +" " +earthquake.geometry.coordinates[1]);

            quakeDisplay.setVisible(true);
        });

        mainPanel.setSize(400,600);
        mainPanel.add(questionPanel);
        mainPanel.add(quakeDisplay);

        mainFrame.add(mainPanel);
        mainFrame.setSize(10000,600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

}
