package umg.zentoryapp.cajeroControllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import umg.zentoryapp.App;

public class MenubarCajeroController {

    @FXML
    private AnchorPane contentArea;
    
    @FXML
    private ToggleButton ventasBtn;
    
    @FXML
    private ToggleButton tareasBtn;
    
    @FXML
    private ToggleButton metasBtn;
    
    @FXML
    public void initialize() {
        loadView("ventascrud.fxml");
        ToggleGroup group = new ToggleGroup();
        tareasBtn.setToggleGroup(group);
        metasBtn.setToggleGroup(group);
        ventasBtn.setToggleGroup(group);
        
        ventasBtn.setSelected(true);
        
        preventDeselectOnClick(tareasBtn);
        preventDeselectOnClick(metasBtn);
        preventDeselectOnClick(ventasBtn);
    }
    
    @FXML
    private void showVentas(){
        loadView("ventascrud.fxml");
    }
    
    @FXML
    private void showTareas(){
        
    }
    
    @FXML
    private void logOut() throws IOException{
        App.setRoot("login");
    }
        
    private void loadView(String fxmlFile){
        try{
            contentArea.getChildren().clear();
            Node view = FXMLLoader.load(getClass().getResource(fxmlFile));
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
