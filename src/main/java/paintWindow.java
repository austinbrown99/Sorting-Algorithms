import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class paintWindow {
    /**
     * Creates the window and the objects inside of it including the graph
     */
    paintWindow() {
        List<Integer> sortedArr = new ArrayList<>();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        CategoryAxis categoryAxis = new CategoryAxis("");
        categoryAxis.setLowerMargin(.01);
        categoryAxis.setCategoryMargin(.01);
        categoryAxis.setUpperMargin(.01);
        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);

        ValueAxis valueAxis = new NumberAxis("");

        StackedBarRenderer renderer = new StackedBarRenderer();
        renderer.setBarPainter(new StandardBarPainter());
        renderer.setDrawBarOutline(false);
        renderer.setShadowVisible(false);
        //Bar labels
        renderer.setBaseItemLabelsVisible(false);
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());

        CategoryPlot plot = new CategoryPlot(dataset,
                categoryAxis,
                valueAxis,
                renderer);

        plot.setOrientation(PlotOrientation.VERTICAL);

        JFreeChart chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, plot, false);

        JFrame frame = new JFrame("Sorting Algorithm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(900, 1000));

        JPanel panel = (JPanel) frame.getContentPane();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(900, 750));

        JPanel optionsPanel = (JPanel) frame.getContentPane();
        optionsPanel.setLayout(null);

        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);
        chartPanel.setBounds(0, 0, 900, 750);

        JLabel sizeofSetLabel = new JLabel("Size of Set");
        optionsPanel.add(sizeofSetLabel);
        sizeofSetLabel.setBounds(50, 775, sizeofSetLabel.getPreferredSize().width, sizeofSetLabel.getPreferredSize().height);

        JTextField sizeOfSet = new JTextField();
        optionsPanel.add(sizeOfSet);
        sizeOfSet.setBounds(50, 790, 100, 50);

        JLabel rangeOfSetLabel = new JLabel("Range of Set");
        optionsPanel.add(rangeOfSetLabel);
        rangeOfSetLabel.setBounds(50, 860, rangeOfSetLabel.getPreferredSize().width, rangeOfSetLabel.getPreferredSize().height);

        JTextField rangeOfSet = new JTextField();
        optionsPanel.add(rangeOfSet);
        rangeOfSet.setBounds(50, 875, 100, 50);

        String[] algorithmChoices = {"Bubble", "None"};
        JComboBox<String> algorithmChoice = new JComboBox<>(algorithmChoices);
        optionsPanel.add(algorithmChoice);
        algorithmChoice.setBounds(200, 800, 100, 50);

        JButton go = new JButton("Go!");
        optionsPanel.add(go);
        go.setBounds(350, 800, 100, 50);
        go.addActionListener(e -> {
            List<Integer> arr = new ArrayList<>();

            //Adds random numbers to the array list
            for (int i = 0; i < Integer.parseInt(sizeOfSet.getText()) + 1; i++) {
                arr.add(ThreadLocalRandom.current().nextInt(0, Integer.parseInt(rangeOfSet.getText())));
            }

            //sorts the array list based on which algorithm they have chosen
            Object selectedItem = algorithmChoice.getSelectedItem();
            if ("Bubble".equals(selectedItem)) {
                sortedArr.clear();
                sortedArr.addAll(Bubble.bubble(arr));
            } else if ("None".equals(selectedItem)) {
                sortedArr.clear();
                sortedArr.addAll(arr);
            }

            //Converts the array list to a dataset that is usable by the chart api
            //dataset.setValue(data, y-axis group, x-axis group)
            for (int i = 0; i < sortedArr.size(); i++) {
                dataset.setValue(arr.get(i), String.valueOf(i), String.valueOf(i));
            }
        });

        JButton close = new JButton("Close");
        optionsPanel.add(close);
        close.setBounds(500, 800, 100, 50);
        close.addActionListener(e -> frame.dispose());

        frame.pack();
        frame.setVisible(true);
    }
}
