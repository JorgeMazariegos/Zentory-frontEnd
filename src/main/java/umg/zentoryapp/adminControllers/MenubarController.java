package umg.zentoryapp.adminControllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import umg.zentoryapp.App;

public class MenubarController {
    
    @FXML
    private AnchorPane contentArea;
    
    @FXML
    private ToggleButton dashboardBtn;
    
    @FXML
    private ToggleButton productsBtn;
    
    @FXML
    private ToggleButton ventasBtn;
    
    @FXML
    public void initialize() {
        loadView("dashboard.fxml");
        ToggleGroup group = new ToggleGroup();
        dashboardBtn.setToggleGroup(group);
        productsBtn.setToggleGroup(group);
        ventasBtn.setToggleGroup(group);
        
        dashboardBtn.setSelected(true);
        
        preventDeselectOnClick(dashboardBtn);
        preventDeselectOnClick(productsBtn);
        preventDeselectOnClick(ventasBtn);
    }
    
    @FXML
    private void showDashboard(){
        loadView("dashboard.fxml");
    }
    
    @FXML
    private void showProductos(){
        loadView("productos.fxml");
    }
    
    @FXML
    private void logOut() throws IOException{
        App.setRoot("login");
    }
        
    private void loadView(String fxmlFile){
        try{
            contentArea.getChildren().clear();
            Node view = FXMLLoader.load(getClass().getResource("/umg/zentoryapp/adminFXML/" + fxmlFile));
            contentArea.getChildren().add(view);            
        }catch(IOException e){
           
        }
    }
    
    private void preventDeselectOnClick(ToggleButton button) {
        button.addEventFilter(MouseEvent.MOUSE_RELEASED, event -> {
            if (button.isSelected()) {
                event.consume();  
            }
        });
    }
    
}
