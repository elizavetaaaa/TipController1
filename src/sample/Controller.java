package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import java.math.BigDecimal;
import java.text.NumberFormat;


public class Controller {
    private static final NumberFormat currency =
            NumberFormat.getCurrencyInstance();
    private static final NumberFormat persent =
            NumberFormat.getPercentInstance();
    private int tipPersentage = 0;



    @FXML
    private Button CalculateButton;

    @FXML
    private Label PriceLabel;

    @FXML
    private Label PercentLabel;

    @FXML
    private Label TipsLabel;

    @FXML
    private Label TotalLabel;

    @FXML
    private Slider PercentScroll;

    @FXML
    private TextField PriceEntry;

    @FXML
    private TextField TipsEntry;

    @FXML
    private TextField TotalEntry;

    @FXML
    private TextField PeopleEntry;

    @FXML
    private TextField PerpEntry;




    @FXML

    private void initialize() {
        TipsEntry.setDisable(true);
        TotalEntry.setDisable(true);
        PerpEntry.setDisable(true);
        PercentScroll.setMax(30);
        PercentScroll.valueProperty().addListener((object, oldValue,
                                                     newValue)-> {
            int value = newValue.intValue();
            tipPersentage = value - value % 5;
            PercentLabel.setText(tipPersentage + "%");

        });

    }






        @FXML
        void action(ActionEvent event) {

                try {
            Double people = new Double(PeopleEntry.getText());
            Double price = new Double(PriceEntry.getText());
            Double tip =( price* tipPersentage)/100;
            Double total = price +tip;
            Double perp = new Double(total/people);
            Double roundOff = new Double(Math.round(perp*100)/100);

            TipsEntry.setText(currency.format(tip));
            TotalEntry.setText(currency.format(total));
            PerpEntry.setText(Double.toString(roundOff));

        } catch (NumberFormatException ex) {
            PriceEntry.setText("Enter a number!");
            PriceEntry.selectAll();
            PriceEntry.requestFocus();
        }
    }

}


