package umg.zentoryapp.adminControllers;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import umg.zentoryapp.App;

public class DashboardController {

    
    @FXML
    private Label ventasDiariasLbl;
    
    @FXML
    private Label totalLbl;
    
    @FXML
    private Label usuariosLbl;
    
    @FXML
    private Label ventasLbl;
    
    @FXML
    private BarChart barChart;
    
    @FXML
    private LineChart lineChart;
    
    @FXML
    private PieChart pieChart;
    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("login");
    }
    
    @FXML
    public void initialize() {
    /*    ToggleGroup menuGroup = new ToggleGroup();
        dashboardBtn.setToggleGroup(menuGroup);
        ventasBtn.setToggleGroup(menuGroup);
        logOffBtn.setToggleGroup(menuGroup);
        
        dashboardBtn.setSelected(true);*/
        
        crearDatosDummy();
        crearDatosCharts();
    }
    
    private void crearDatosDummy(){
        double min = 100.00;
        double max = 100000.00;
        
        int randomCents = (int) (Math.random() * (max*100 - min*100 + 1)) + (int)(min*100);
        double result = randomCents/100;
        
        int randomCentsTotal = (int) (Math.random() * (max*100 - min*100 + 1)) + (int)(min*100);
        double resultTotal = (randomCentsTotal/100) + result  ;
        
        ventasDiariasLbl.setText("Q. " + abreviarDinero(result));
        totalLbl.setText("Q. " + abreviarDinero(resultTotal));
        
        
        Random random = new Random();
        int randomValue = random.nextInt(100);
        int randomUsuarios = random.nextInt(85);
        ventasLbl.setText(String.valueOf(randomValue));
        usuariosLbl.setText(String.valueOf(randomUsuarios));        
    }
    
private void crearDatosCharts(){
    barChart.getData().clear();
    XYChart.Series<String, Number> manzanas = new XYChart.Series<>();
        manzanas.setName("Manzanas");
        manzanas.getData().add(new XYChart.Data<>("Manzanas", 30));

        XYChart.Series<String, Number> bananas = new XYChart.Series<>();
        bananas.setName("Bananas");
        bananas.getData().add(new XYChart.Data<>("Bananas", 20));

        XYChart.Series<String, Number> naranjas = new XYChart.Series<>();
        naranjas.setName("Naranjas");
        naranjas.getData().add(new XYChart.Data<>("Naranjas", 15));

        XYChart.Series<String, Number> uvas = new XYChart.Series<>();
        uvas.setName("Uvas");
        uvas.getData().add(new XYChart.Data<>("Uvas", 25));

        XYChart.Series<String, Number> fresas = new XYChart.Series<>();
        fresas.setName("Fresas");
        fresas.getData().add(new XYChart.Data<>("Fresas", 10));

        barChart.setBarGap(0);    
        barChart.setCategoryGap(0);
        
        // Add all series to the chart
        barChart.getData().addAll(manzanas, bananas, naranjas, uvas, fresas);
               
    XYChart.Series<Number, Number> series1 = createRandomSeries("Series A", 50.0, 5.0);
        
    lineChart.getData().addAll(series1);
    
    ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
            new PieChart.Data("Manzanas", 30), 
            new PieChart.Data("Bananas", 20),
            new PieChart.Data("Naranjas", 15)
        );
        
        pieChart.setData(pieChartData);
        double total = pieChart.getData().stream()
                               .mapToDouble(PieChart.Data::getPieValue)
                               .sum();

        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        percentFormat.setMinimumFractionDigits(1);

        for (PieChart.Data slice : pieChart.getData()) {
            double percentage = slice.getPieValue() / total;
            String label = slice.getName() + " " + percentFormat.format(percentage);
            slice.setName(label);
        }
}
    
    private XYChart.Series<Number, Number> createRandomSeries(String name, double amplitude, double frequency) {
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName(name);
        int DATA_POINTS = 50;
        double NOISE_AMPLITUDE = 20.0;
        Random RANDOM = new Random();
        
        for (int x = 0; x < DATA_POINTS; x++) {
            // Sinusoidal base with random noise
            double trend = amplitude * Math.sin(frequency * x / 10.0);
            double noise = (RANDOM.nextDouble() - 0.5) * NOISE_AMPLITUDE;
            double y = trend + noise;

            series.getData().add(new XYChart.Data<>(x, y));
        }
        return series;
    }
    
private String abreviarDinero(double cantidad){
    String suffix = "";
    double cantidadAbreviada;
    if(cantidad >= 1000000000){
        cantidadAbreviada = cantidad / 1000000000;
        suffix = "B";
    }else if(cantidad >= 1000000){
        cantidadAbreviada = cantidad / 1000000;
        suffix = "M";
    }else if(cantidad >= 1000){
        cantidadAbreviada = cantidad / 1000;
        suffix = "k";
    }else{
        cantidadAbreviada = cantidad;
        suffix = "";
    }
    
    DecimalFormat formatter = new DecimalFormat("#,##0");
    String resultadoAbreviado = formatter.format(cantidadAbreviada);
    
    return resultadoAbreviado + suffix;
}
}