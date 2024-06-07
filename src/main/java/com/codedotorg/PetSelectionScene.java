package com.codedotorg;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PetSelectionScene extends PetApp {

    /** The name of the pet provided by the user */
    private String petName;

    /** The type of pet chosen by the user */
    private String petType;

    /**
     * This class represents a scene for selecting a pet. It extends the Scene class and
     * provides a constructor for initializing the pet name and type.
     */
    public PetSelectionScene(Stage window, int width, int height) {
        super(window, width, height);

        petName = "";
        petType = "";
    }

    /**
     * This method starts the application by creating a VBox layout for pet selection
     * and setting it as the scene to be displayed.
     */
    public void startApp() {
        VBox petSelectionLayout = createPetSelectionLayout();
        setAndShowScene(petSelectionLayout);
    }

    private Button createSubmitButton(ToggleGroup group, TextField petNameField) {
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            if (group.getSelectedToggle() != null) {
                String petType = ((RadioButton) group.getSelectedToggle()).getText();
                setPetType(petType); // Use the setPetType method

                String petName = petNameField.getText();
                if (!petName.isEmpty()) {
                    setPetName(petName); // Use the setPetName method with parameter
                } else {
                    System.out.println("Please enter a name for your pet.");
                }
            } else {
                System.out.println("Please select a pet type.");
            }
        });

        return submitButton;
    }

    /**
     * Sets petName to the name entered by the user
     */
    private void setPetName(String name) {
        this.petName = name;
    }

    /**
     * Sets petType to the type of pet chosen by the user
     */
    public void setPetType(String type) {
        this.petType = type;
    }

    /**
     * Creates the main layout for the PetSelection scene
     *
     * @return the VBox layout for the PetSelection scene
     */
    public VBox createPetSelectionLayout() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        // Create a label
        Label label = new Label("Choose a pet:");

        // Create radio buttons for cat and dog
        RadioButton catButton = new RadioButton("Cat");
        RadioButton dogButton = new RadioButton("Dog");

        // Create a toggle group and add the radio buttons to it
        ToggleGroup group = new ToggleGroup();
        catButton.setToggleGroup(group);
        dogButton.setToggleGroup(group);

        // Create a text field for the pet's name
        TextField petNameField = new TextField();
        petNameField.setPromptText("Enter your pet's name");

        // Create a submit button
        Button submitButton = createSubmitButton(group, petNameField);

        // Add the label, radio buttons, text field, and submit button to the layout
        layout.getChildren().addAll(label, catButton, dogButton, petNameField, submitButton);

        return layout;
    }
}
