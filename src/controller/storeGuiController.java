package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import application.FileHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import mru.tsc.model.Item;

public class storeGuiController implements Initializable {
	@FXML
	private ListView<String> lvResults;
	@FXML
	private RadioButton selectedSN;
	@FXML
	private RadioButton selectedName;
	@FXML
	private RadioButton selectedType;
	@FXML
	private TextField targetSN;
	@FXML
	private TextField targetName;
	@FXML
	private ChoiceBox<?> targetType;
	@FXML
	private Button btnSearch;
	@FXML
	private Button btnReset;
	@FXML
	private Button btnClearList;
	@FXML
	private Button btnPurchase;

	FileHandler fileHandler = new FileHandler();
	ArrayList<Item> itemsList;
	final ObservableList<String> resultsList = FXCollections.observableArrayList();

	// to load up the items file
	public storeGuiController() throws SecurityException, IOException {

		fileHandler = new FileHandler();
		itemsList = fileHandler.masterItemList();
	}

	// Event Listener on Button[#btnSearch].onAction
	@FXML
	public void search(ActionEvent event) {
		// TODO Autogenerated
		boolean SNisSelected = selectedSN.isSelected();
		boolean nameIsSelected = selectedName.isSelected();
		boolean typeIsSelected = selectedType.isSelected();

		if (SNisSelected) {
			ArrayList<Item> result = serialNumberSearch(targetSN.getText());
			resultsList.clear();

			for (Item it : result) {
				resultsList.add(it.toString());
			}
		} else if (nameIsSelected) {
			System.out.println("name");
		} else if (typeIsSelected) {
			System.out.println("type");
		}
	}

	private ArrayList<Item> serialNumberSearch(String targetSN) {

		ArrayList<Item> resultList = new ArrayList<>();

		try {
			for (Item currentItem : itemsList) {
				if (currentItem.getSN().equals(targetSN)) {
					resultList.add(currentItem);
				}

			}

		} catch (NumberFormatException e) {
			System.out.println("Wrong Serial Number ");
		}
		return resultList;

	}

	// Event Listener on Button[#btnReset].onAction
	@FXML
	public void resetOptions(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button[#btnClearList].onAction
	@FXML
	public void clearItemResultsList(ActionEvent event) {
		// TODO Autogenerated
	}

	// Event Listener on Button[#btnPurchase].onAction
	@FXML
	public void purchaseItem(ActionEvent event) {

		String chosenItem = lvResults.getSelectionModel().getSelectedItem();

		String[] splitLine = chosenItem.split(";");
		String snum = splitLine[0];

		ArrayList<Item> matchingItems = serialNumberSearch(snum);

		Item toPurchase = matchingItems.get(0);

		int currentCount = toPurchase.getAvailableCount();

		toPurchase.setAvailableCount(currentCount - 1);

		resultsList.clear();

		resultsList.add(toPurchase.toString());
		// place in results list

		JOptionPane.showMessageDialog(null, "Item Purchased!" + targetName.getText());

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		lvResults.setItems(resultsList);
	}
}
