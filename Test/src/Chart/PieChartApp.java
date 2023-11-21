//package Chart;
//
//import javax.swing.JFrame;
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.JFreeChart;
//import org.jfree.data.general.DefaultPieDataset;
//import org.jfree.chart.entity.PieSectionEntity;
//import org.jfree.chart.ChartMouseEvent;
//import org.jfree.chart.ChartMouseListener;
//
//public class PieChartApp extends JFrame {
//
//    public PieChartApp(String title) {
//        super(title);
//        DefaultPieDataset dataset = createDataset();
//        JFreeChart chart = createChart(dataset);
//        ChartPanel chartPanel = new ChartPanel(chart);
//        chartPanel.addChartMouseListener(new CustomMouseListener());
//        add(chartPanel);
//
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        pack();
//        setLocationRelativeTo(null);
//        setVisible(true);
//    }
//
//    private DefaultPieDataset createDataset() {
//        DefaultPieDataset dataset = new DefaultPieDataset();
//        dataset.setValue("Category 1", 5);
//        dataset.setValue("Category 2", 10);
//        dataset.setValue("Category 3", 15);
//        dataset.setValue("Category 4", 30);
//        dataset.setValue("Category 5", 40);
//        return dataset;
//    }
//
//    private JFreeChart createChart(DefaultPieDataset dataset) {
//        return ChartFactory.createPieChart(
//                "Sample Pie Chart", // chart title
//                dataset, // dataset
//                true, // include legend
//                true, // include tooltips
//                false // include URLs
//        );
//    }
//
//    // Custom ChartMouseListener implementation to handle click events
//    private class CustomMouseListener implements ChartMouseListener {
//        @Override
//        public void chartMouseClicked(ChartMouseEvent event) {
//            if (event.getEntity() instanceof PieSectionEntity) {
//                PieSectionEntity entity = (PieSectionEntity) event.getEntity();
//                Comparable key = entity.getSectionKey();
//                double value = entity.getDataset().getValue(key).doubleValue();
//                System.out.println("Clicked on: " + key + ", Value: " + value);
//            } else {
//            	System.out.println(1);
//            }
//        }
//
//        @Override
//        public void chartMouseMoved(ChartMouseEvent event) {
//            // Handle mouse moved event if needed
//        }
//    }
//
//    public static void main(String[] args) {
//        new PieChartApp("Pie Chart Example");
//    }
//}
