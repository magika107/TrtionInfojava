package mft.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.extern.log4j.Log4j2;
import mft.model.Transaction;
import mft.model.TransactionType;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Log4j2
public class TransactionInfoViewControler implements Initializable {

    @FXML
    private TextField idTxt, timeTxt, amountTxt, amountSearchTxt, trtionSearchTxt;
    @FXML
    private DatePicker date;
    @FXML
    private Button saveBtn, editBtn, removeBtn;
    @FXML
    private TableView<Transaction> transactionTab;
    @FXML
    private ComboBox<TransactionType> transactionCombo;
    private List<Transaction> transactionsList = new ArrayList<>();
    @FXML
    private TableColumn<String, Transaction> timeCol, amountCol, tratypeCol, idCol;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (TransactionType transactionType : TransactionType.values()) {
            transactionCombo.getItems().add(transactionType);

        }

        resetForm();

        saveBtn.setOnAction((event) -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime time = LocalTime.parse(timeTxt.getText(), formatter);
            Transaction person =
                    Transaction
                            .builder()
                            .id(Integer.parseInt(idTxt.getText()))

                            .time(time)
                            .date(date.getValue())
                            .amount(amountTxt.getText())
                            .transactionType(transactionCombo.getSelectionModel().getSelectedItem())
                            .build();
            System.out.println(person);
            transactionsList.add(person);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Person Created Successfully", ButtonType.OK);
            alert.show();
            resetForm();
            showTransactionOnTable(transactionsList);
        });

    }

    public void resetForm() {
        idTxt.setText(String.valueOf(transactionsList.size() + 1));
        timeTxt.clear();
        amountTxt.clear();
        date.setValue(LocalDate.now());

        transactionCombo.getSelectionModel().select(TransactionType.receipt);

        date.setValue(LocalDate.now());
    }

    public void showTransactionOnTable(List<Transaction> personList) {
        ObservableList<Transaction> personObservableList = FXCollections.observableArrayList(personList);

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
        amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        tratypeCol.setCellValueFactory(new PropertyValueFactory<>("transactionType"));
        transactionTab.setItems(personObservableList);
    }
}

