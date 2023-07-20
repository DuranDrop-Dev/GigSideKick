package com.durandrop.gigsidekick;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.DoubleStream;

public class MainController {

    // Arraylists
    @FXML ArrayList<Double> ddEntry = new ArrayList<>();
    @FXML ArrayList<Double> ueEntry = new ArrayList<>();
    @FXML ArrayList<Double> ghEntry = new ArrayList<>();
    @FXML ArrayList<Double> csEntry = new ArrayList<>();
    @FXML ArrayList<Double> icEntry = new ArrayList<>();

    // TestField
    @FXML TextField inputField = new TextField();

    // Groups
    @FXML ToggleGroup mainToggleGroup = new ToggleGroup();

    // Radio Buttons
    @FXML RadioButton doorDash = new RadioButton("DoorDash");
    @FXML RadioButton uberEats = new RadioButton("UberEats");
    @FXML RadioButton grubHub = new RadioButton("GrubHub");
    @FXML RadioButton cornerShop = new RadioButton("CornerShop");
    @FXML RadioButton instaCart = new RadioButton("InstaCart");

    // Labels
    @FXML Label outputLabel = new Label();
    @FXML Label grandTotalLabel = new Label();
    @FXML Label totalLabel = new Label();

    @FXML RadioButton lightMode = new RadioButton("Light Mode");
    @FXML RadioButton darkMode = new RadioButton("Dark Mode");

    @FXML
    VBox mainContainer = new VBox();

    // CheckBoxes
    @FXML CheckBox ddTrue = new CheckBox("DoorDash");
    @FXML CheckBox ueTrue = new CheckBox("UberEats");
    @FXML CheckBox ghTrue = new CheckBox("GrubHub");
    @FXML CheckBox csTrue = new CheckBox("Cornershop");
    @FXML CheckBox icTrue = new CheckBox("Instacart");

    @FXML GridPane gridPane = new GridPane();

    @FXML ImageView logoFrame = new ImageView();
    @FXML ImageView logoFrame2 = new ImageView();

    private final Image darkLogo = new Image(Objects.requireNonNull(getClass().getResourceAsStream("dark-logo.png")));
    private final Image logo = new Image(Objects.requireNonNull(getClass().getResourceAsStream("logo.png")));

    @FXML TabPane rootPane = new TabPane();

    @FXML Tab homeTab = new Tab();
    @FXML Tab settingsTab = new Tab();

    public void initialize() {
        mainContainer.setStyle("-fx-background: #353535; -fx-text-fill: white;");
        logoFrame.setImage(logo);
        logoFrame2.setImage(logo);
    }

    // lightMode selected
    @FXML public void setLight() {
        if (lightMode.isSelected()){
            try {
                mainContainer.setStyle("-fx-background: #e8e8e8; -fx-text-fill: #353535;");
                logoFrame.setImage(darkLogo);
                logoFrame2.setImage(darkLogo);
            }
            catch (Exception e) {
                outputLabel.setText("ERROR! DON'T DO THAT!");
            }
        }
    }

    // darkMode selected
    @FXML public void setDark() {
        if (darkMode.isSelected()) {
            try {
                mainContainer.setStyle("-fx-background: #353535; -fx-text-fill: white;");
                logoFrame.setImage(logo);
                logoFrame2.setImage(logo);
            }
            catch (Exception e) {
                outputLabel.setText("ERROR! DON'T DO THAT!");
            }
        }
    }

    // Arraylists visible by user choice
    @FXML public void ddFalse() {
        try {
            if (!ddTrue.isSelected()) {
                ddEntry.clear();
                gridPane.getChildren().remove(doorDash);
                outputLabel.setText("");
                totalLabel.setText("");
                totalMethod();
            }
            else if (ddTrue.isSelected()){
                gridPane.add(doorDash,0,4);
            }
        }
        catch (Exception e) {
            System.out.println("Something is wrong!");
        }
    }
    @FXML public void ueFalse() {
        try {
            if (!ueTrue.isSelected()) {
                gridPane.getChildren().remove(uberEats);
                ueEntry.clear();
                outputLabel.setText("");
                totalLabel.setText("");
                totalMethod();
            }
            else if (ueTrue.isSelected()){
                gridPane.add(uberEats,0,5);
            }
        }
        catch (Exception e) {
            System.out.println("Something is wrong!!");
        }
    }
    @FXML public void ghFalse() {
        try {
            if (!ghTrue.isSelected()) {
                gridPane.getChildren().remove(grubHub);
                ghEntry.clear();
                outputLabel.setText("");
                totalLabel.setText("");
                totalMethod();
            }
            else if (ghTrue.isSelected()){
                gridPane.add(grubHub,0,6);
            }
        }
        catch (Exception e) {
            System.out.println("Something is wrong!!");
        }
    }
    @FXML public void csFalse() {
        try {
            if (!csTrue.isSelected()) {
                gridPane.getChildren().remove(cornerShop);
                csEntry.clear();
                outputLabel.setText("");
                totalLabel.setText("");
                totalMethod();
            }
            else if (csTrue.isSelected()){
                gridPane.add(cornerShop,0,7);
            }
        } catch (Exception e) {
            System.out.println("Something is wrong!!");
        }
    }
    @FXML public void icFalse() {
        try {
            if (!icTrue.isSelected()) {
                gridPane.getChildren().remove(instaCart);
                icEntry.clear();
                outputLabel.setText("");
                totalLabel.setText("");
                totalMethod();
            } else if (icTrue.isSelected()) {
                gridPane.add(instaCart,0,8);
            }
        }
        catch (Exception e) {
            System.out.println("Something is wrong!!");
        }
    }

    @FXML public void enterMethod() {
        try {
            // DoorDash Entry
            if (doorDash.isSelected()){
                double ddInput = Double.parseDouble(inputField.getText());
                ddEntry.add(ddInput);
                ddEntryLoop();
            }

            // UberEats Entry
            else if (uberEats.isSelected()){
                double ddInput = Double.parseDouble(inputField.getText());
                ueEntry.add(ddInput);
                ueEntryLoop();
            }

            // GrubHub Entry
            else if (grubHub.isSelected()){
                double ddInput = Double.parseDouble(inputField.getText());
                ghEntry.add(ddInput);
                ghEntryLoop();
            }

            // Cornershop Entry
            else if (cornerShop.isSelected()){
                double ddInput = Double.parseDouble(inputField.getText());
                csEntry.add(ddInput);
                csEntryLoop();
            }

            // InstaCart Entry
            else if (instaCart.isSelected()){
                double ddInput = Double.parseDouble(inputField.getText());
                icEntry.add(ddInput);
                icEntryLoop();
            }
        }
        // Catching exceptions
        catch (NumberFormatException e) {
            outputLabel.setText("ERROR! Please use a number!");
        }

        catch (Exception e) {
            outputLabel.setText("ERROR! Please try again!");
        }
        finally {
            totalMethod();
            inputField.clear();
        }
    }
    @FXML public void totalMethod() {
        // finally initializers
        double sum1 = 0;
        double sum2 = 0;
        double sum3 = 0;
        double sum4 = 0;
        double sum5 = 0;

        // add each arrays total
        for (double a : ddEntry) {
            sum1 += a;
        }
        for (double b : ueEntry) {
            sum2 += b;
        }
        for (double c : ghEntry) {
            sum3 += c;
        }
        for (double d : csEntry) {
            sum4 += d;
        }
        for (double e : icEntry) {
            sum5 += e;
        }

        // adding all to get grandTotal and printing
        DoubleStream stream = DoubleStream.of(sum1, sum2, sum3, sum4, sum5);
        double finalSum = stream.sum();
        System.out.println("TOTAL: $" + finalSum);
        String grandFinale = String.format("%.2f", finalSum);
        grandTotalLabel.setText("TOTAL: $" + grandFinale);
    }

    // for loops for Arraylist entries
    @FXML public void ddEntryLoop() {
        double sum = 0;
        for (double i : ddEntry) {
            sum += i;
        }
        for (int i = ddEntry.size()-1; i >= 0 ; i--) {
            if(ddEntry.get(i).equals(0.0)){
                ddEntry.remove(i);
            }}
        System.out.println("The DoorDash sum is " + sum + ddEntry);
        String results = String.format("%.2f", sum);
        outputLabel.setText("DoorDash total: $" + results);
        totalLabel.setText("DoorDash entries: " + ddEntry);
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("ddEntry.txt"));
            out.write(String.valueOf(ddEntry));
            out.flush();
            out.close();
            System.out.println("Write on!");
        }
        catch (IOException e){
            System.out.println("ERROR!");
        }
    }
    @FXML public void ueEntryLoop() {
        double sum = 0;
        for (double i : ueEntry) {
            sum += i;
        }
        for (int i = ueEntry.size()-1; i >= 0 ; i--) {
            if(ueEntry.get(i).equals(0.0)){
                ueEntry.remove(i);
            }}
        System.out.println("The UberEats sum is " + sum);
        String results = String.format("%.2f", sum);
        outputLabel.setText("UberEats total: $" + results);
        totalLabel.setText("UberEats entries: " + ueEntry);
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("ueEntry.txt"));
            out.write(String.valueOf(ddEntry));
            out.flush();
            out.close();
            System.out.println("Write on!");
        }
        catch (IOException e){
            System.out.println("ERROR!");
        }
    }
    @FXML public void ghEntryLoop() {
        double sum = 0;
        for (double i : ghEntry) {
            sum += i;
        }
        for (int i = ghEntry.size()-1; i >= 0 ; i--) {
            if(ghEntry.get(i).equals(0.0)){
                ghEntry.remove(i);
            }}
        System.out.println("The GrubHub sum is " + sum);
        String results = String.format("%.2f", sum);
        outputLabel.setText("GrubHub total: $" + results);
        totalLabel.setText("GrubHub entries: " + ghEntry);
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("ghEntry.txt"));
            out.write(String.valueOf(ddEntry));
            out.flush();
            out.close();
            System.out.println("Write on!");
        }
        catch (IOException e){
            System.out.println("ERROR!");
        }
    }
    @FXML public void csEntryLoop() {
        double sum = 0;
        for (double i : csEntry) {
            sum += i;
        }
        for (int i = csEntry.size()-1; i >= 0 ; i--) {
            if(csEntry.get(i).equals(0.0)){
                csEntry.remove(i);
            }}
        System.out.println("The Cornershop sum is " + sum);
        String results = String.format("%.2f", sum);
        outputLabel.setText("Cornershop total: $" + results);
        totalLabel.setText("Cornershop entries: " + csEntry);
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("csEntry.txt"));
            out.write(String.valueOf(ddEntry));
            out.flush();
            out.close();
            System.out.println("Write on!");
        }
        catch (IOException e){
            System.out.println("ERROR!");
        }
    }
    @FXML public void icEntryLoop() {
        double sum = 0;
        for (double i : icEntry) {
            sum += i;
        }
        for (int i = icEntry.size()-1; i >= 0 ; i--) {
            if(icEntry.get(i).equals(0.0)){
                icEntry.remove(i);
            }}
        System.out.println("The Instacart sum is " + sum);
        String results = String.format("%.2f", sum);
        outputLabel.setText("Instacart total: $" + results);
        totalLabel.setText("Instacart entries: " + icEntry);
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("icEntry.txt"));
            out.write(String.valueOf(ddEntry));
            out.flush();
            out.close();
            System.out.println("Write on!");
        }
        catch (IOException e){
            System.out.println("ERROR!");
        }
    }

    @FXML public void setFlush() {
        ddEntry.clear();
        ueEntry.clear();
        ghEntry.clear();
        csEntry.clear();
        icEntry.clear();
        outputLabel.setText("Earnings have been cleared!");
        totalLabel.setText("");
        grandTotalLabel.setText("");
    }
    @FXML public void setUndo() {
        // Clear last arraylist entry
        try {
            if (doorDash.isSelected()) {
                ddEntry.remove(ddEntry.size() - 1);
                ddEntryLoop();
            } else if (uberEats.isSelected()) {
                ueEntry.remove(ueEntry.size() - 1);
                ueEntryLoop();
            } else if (grubHub.isSelected()) {
                ghEntry.remove(ghEntry.size() - 1);
                ghEntryLoop();
            } else if (cornerShop.isSelected()) {
                csEntry.remove(csEntry.size() - 1);
                csEntryLoop();
            } else if (instaCart.isSelected()) {
                icEntry.remove(icEntry.size() - 1);
                icEntryLoop();
            }
        }
        catch (Exception e) {
            outputLabel.setText("ERROR! Please try again!");
        }
        finally {
            totalMethod();
        }
    }

    // Toggle Group
    @FXML public void setDoorDash() {
        try {
            ddEntryLoop();
        }
        catch (Exception e) {
            outputLabel.setText("ERROR! Please try again!");
        }
        finally {
            totalMethod();
        }
    }
    @FXML public void setUberEats() {
        try {
            ueEntryLoop();
        }
        catch (Exception e) {
            outputLabel.setText("ERROR! Please try again!");
        }
        finally {
            totalMethod();
        }
    }
    @FXML public void setGrubHub() {
        try {
            ghEntryLoop();
        }
        catch (Exception e) {
            outputLabel.setText("ERROR! Please try again!");
        }
        finally {
            totalMethod();
        }
    }
    @FXML public void setCornerShop() {
        try {
            csEntryLoop();
        }
        catch (Exception e) {
            outputLabel.setText("ERROR! Please try again!");
        }
        finally {
            totalMethod();
        }
    }
    @FXML public void setInstaCart() {
        try {
            icEntryLoop();
        }
        catch (Exception e) {
            outputLabel.setText("ERROR! Please try again!");
        }
        finally {
            totalMethod();
        }
    }
}