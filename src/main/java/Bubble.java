import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Bubble {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            arr.add(ThreadLocalRandom.current().nextInt(0, 11));
        }

        System.out.println("Input Array: " + arr);
        System.out.println("Sorted Array" + bubble(arr));
        long endTime = System.currentTimeMillis();
        System.out.println("Took " + (endTime - startTime) + " ms");
        createWindow(arr);
    }

    private static void createWindow(List<Integer> arr) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i < arr.size(); i++) {
            dataset.setValue(arr.get(i), String.valueOf(i), String.valueOf(i));
        }

        JFreeChart chart = ChartFactory.createBarChart("Student Grades", "Student Name", "Marks", dataset, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.black);

        JFrame frame = new JFrame("Sorting Algorithm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(900, 1000));

        ChartPanel chartPanel = new ChartPanel(chart);
        frame.add(chartPanel);
        chartPanel.setBounds(0,0,900,100);

        frame.pack();
        frame.setVisible(true);
    }

    private static List<Integer> bubble(List<Integer> arr) {
        boolean makingChanges = true;
        while (makingChanges) {
            makingChanges = false;
            for (int i = 0; i < (arr.size() - 1); i++) {
                int first = arr.get(i);
                int second = arr.get(i + 1);
                if (arr.get(i) > arr.get(i + 1)) {
                    arr.set(i, second);
                    arr.set(i + 1, first);
                    makingChanges = true;
                }
            }
        }
        return arr;
    }
}
