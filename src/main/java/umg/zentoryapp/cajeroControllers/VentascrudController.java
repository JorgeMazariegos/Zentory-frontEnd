package umg.zentoryapp.cajeroControllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Pagination;
import javafx.scene.layout.VBox;

public class VentascrudController{
 
    @FXML
    Pagination pagination;
    
    @FXML
    public void initialize(){
        pagination.setPageFactory(this::switchPages);
    }
    
    private Node switchPages(int pageIndex) {
        
        Node view = null;
        try {
            switch(pageIndex){
                case 0:{
                    view = FXMLLoader.load(getClass().getResource("ventapag2.fxml"));
                    break;
                }
                case 1:{
                    view = FXMLLoader.load(getClass().getResource("ventapag1.fxml"));
                    break;
                }
                case 2:{
                    view = FXMLLoader.load(getClass().getResource("confirmarVenta.fxml"));
                    break;
                }
            }            
        } catch (IOException ex) {
            System.getLogger(VentascrudController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return view;
    }
}
