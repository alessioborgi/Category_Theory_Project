package Login;

import Set_Category.SetCat;
import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.*;


public class New_Set extends Application {

    public void start(Stage set) {
        set.setTitle("Set Category");
        set.setWidth(700);
        set.setHeight(500);

        VBox setVBox = new VBox();

        Scene setScene = new Scene(setVBox);

        set.setScene(setScene);


        HBox morphHBoxSet = new HBox();
        morphHBoxSet.setMinHeight(100);
        morphHBoxSet.setMinWidth(700);
        morphHBoxSet.setAlignment(Pos.CENTER_LEFT);
        HBox identityHBoxSet = new HBox();
        identityHBoxSet.setMinHeight(100);
        identityHBoxSet.setMinWidth(700);
        identityHBoxSet.setAlignment(Pos.CENTER_LEFT);
        HBox associativityHBoxSet = new HBox();
        associativityHBoxSet.setMinHeight(100);
        associativityHBoxSet.setMinWidth(700);
        associativityHBoxSet.setAlignment(Pos.CENTER_LEFT);
        HBox endHBoxSet = new HBox();
        endHBoxSet.setMinHeight(100);
        endHBoxSet.setMinWidth(700);
        endHBoxSet.setAlignment(Pos.CENTER);



        Label morphTextSet = new Label("    Function:  ");
        morphTextSet.setStyle("-fx-font-size: 30 px");
        Label sourceTextSet = new Label("Source  A   ");
        sourceTextSet.setStyle("-fx-font-size: 22 px");
        Label endMorphSet = new Label ("   Source B");
        endMorphSet.setStyle("-fx-font-size: 22 px");


        Label identityTextSet = new Label("    Identity:   ");
        identityTextSet.setStyle("-fx-font-size: 30 px");
        TextField inputTextSet = new TextField("");
        inputTextSet.setMinHeight(30);
        Label space = new Label("           ");

        Button prova = new Button("Test"); //test identity button
        prova.setStyle("-fx-font-size: 22 px");



        Label spazio = new Label("    ");
        Button prove = new Button("Prove associativity");
        prove.setStyle("-fx-font-size: 22 px");

        Label associativitySet1 = new Label("    A  ");
        associativitySet1.setStyle("-fx-font-size: 20 px");
        TextField associativityText1 = new TextField("");
        associativityText1.setMaxSize(30,30);

        Label associativitySet2 = new Label("   (B   ");
        associativitySet2.setStyle("-fx-font-size: 20 px");
        TextField associativityText2 = new TextField("");
        associativityText2.setMaxSize(30,30);

        Label associativitySet3 = new Label("   C)  ==  (A    ");
        associativitySet3.setStyle("-fx-font-size: 20 px");
        TextField associativityText3 = new TextField("");
        associativityText3.setMaxSize(30,30);

        Label associativitySet4 = new Label ("  B)  ");
        associativitySet4.setStyle("-fx-font-size: 20 px");
        TextField associativityText4 = new TextField("");
        associativityText4.setMaxSize(30,30);

        Label associativitySet5 = new Label ("   C  ");
        associativitySet5.setStyle("-fx-font-size: 20 px");



        MenuButton morphSet = new MenuButton("Choose the function");
        morphSet.setStyle("-fx-font-size: 22 px");

        Button createSet = new Button("Create");
        createSet.setStyle("-fx-font-size: 22 px");

        ////////////////

        MenuItem uni = new MenuItem("U");
        MenuItem inter = new MenuItem ("∩");
        MenuItem subt = new MenuItem("-");
        MenuItem symsub = new MenuItem("Δ");

        ///////////////////////////

        Alert alertAssSet = new Alert(Alert.AlertType.INFORMATION);
        Alert alertidSet = new Alert(Alert.AlertType.INFORMATION);
        ////////////////

        uni.setOnAction(e-> {
            morphSet.setText("U");
            associativityText1.setText("U");
            associativityText2.setText("U");
            associativityText3.setText("U");
            associativityText4.setText("U");

            SetCat.SetUnion obj = new SetCat.SetUnion();
            alertAssSet.setTitle("Prove Associativity");
            alertAssSet.setHeaderText("Associativity Checked");
            String x = obj.associativity();
            alertAssSet.setContentText(x);


        });

        inter.setOnAction(hh-> {
            morphSet.setText("∩");
            associativityText1.setText("∩");
            associativityText2.setText("∩");
            associativityText3.setText("∩");
            associativityText4.setText("∩");

            SetCat.SetIntersection gne = new SetCat.SetIntersection();
            alertAssSet.setTitle("Prove Associativity");
            alertAssSet.setHeaderText("Associativity Checked");
            String bb = gne.associativity();
            alertAssSet.setContentText(bb);
        });

        subt.setOnAction(fun->{
            morphSet.setText("-");
            associativityText1.setText("-");
            associativityText2.setText("-");
            associativityText3.setText("-");
            associativityText4.setText("-");

            SetCat.SetDifference ogg = new SetCat.SetDifference();
            alertAssSet.setTitle("Prove Associativity");
            alertAssSet.setHeaderText("Associativity Checked");
            String z = ogg.associativity();
            alertAssSet.setContentText(z);

        });

        symsub.setOnAction(f-> {

            morphSet.setText("Δ");
            associativityText1.setText("Δ");
            associativityText2.setText("Δ");
            associativityText3.setText("Δ");
            associativityText4.setText("Δ");

            SetCat.SetSymmetricDifference object = new SetCat.SetSymmetricDifference();

            alertAssSet.setTitle("Prove Associativity");
            alertAssSet.setHeaderText("Associativity Checked");
            String y = object.associativity();
            alertAssSet.setContentText(y);


        });


        ///////////////////////
        prove.setOnAction(g->{
            alertAssSet.show();

        });



        prova.setOnAction(h->{
            if (morphSet.getText().equals("U")) {
                SetCat.SetUnion w = new SetCat.SetUnion();
                if (inputTextSet.getText().equals("[]")) {
                    alertidSet.setTitle("Prove Identity");
                    alertidSet.setHeaderText("Identity Checked");
                    String s = w.tryIdentity();
                    alertidSet.setContentText(s);
                    alertidSet.show();
                } else {
                    String falso = "ERROR, the Identity should be an element that applied to the Set returns the set itself, be careful!";
                    alertidSet.setTitle("Prove Identity");
                    alertidSet.setHeaderText("Identity Checked");
                    alertidSet.setContentText(falso);
                    alertidSet.show();
                }
            }

            if(morphSet.getText().equals("-")){
                SetCat.SetDifference ogg = new SetCat.SetDifference();
                if (inputTextSet.getText() .equals("[]")){
                    alertidSet.setTitle("Prove Identity");
                    alertidSet.setHeaderText("Identity Checked");
                    String s = ogg.tryIdentity();
                    alertidSet.setContentText(s);

                }else{
                    String falso = "ERROR, the Identity should be an element that applied to the Set returns the set itself, be careful!";
                    alertidSet.setTitle("Prove Identity");
                    alertidSet.setHeaderText("Identity Checked");
                    alertidSet.setContentText(falso);
                    alertidSet.show();
                }
            }

            if(morphSet.getText().equals("Δ")){
                SetCat.SetSymmetricDifference m = new SetCat.SetSymmetricDifference();
                if (inputTextSet.getText().equals("[]")) {
                    alertidSet.setTitle("Prove Identity");
                    alertidSet.setHeaderText("Identity Checked");
                    String s = m.tryIdentity();
                    alertidSet.setContentText(s);
                    alertidSet.show();
                } else {
                    String falso = "ERROR, the Identity should be an element that applied to the Set returns the set itself, be careful!";
                    alertidSet.setTitle("Prove Identity");
                    alertidSet.setHeaderText("Identity Checked");
                    alertidSet.setContentText(falso);
                    alertidSet.show();

                }
            }

            if( morphSet.getText().equals("∩")){
                SetCat.SetIntersection k = new SetCat.SetIntersection();
                alertidSet.setTitle("Prove Identity");
                alertidSet.setHeaderText("Identity Checked");
                String s = k.tryIdentity();
                alertidSet.setContentText(s);
                alertidSet.show();
            }

        });

        ////////////////////////////////////////

        morphSet.getItems().addAll(uni, inter, subt, symsub);
        morphHBoxSet.getChildren().addAll(morphTextSet, sourceTextSet, morphSet, endMorphSet);
        identityHBoxSet.getChildren().addAll(identityTextSet, inputTextSet, space,  prova);
        associativityHBoxSet.getChildren().addAll(spazio, prove, associativitySet1, associativityText1,associativitySet2, associativityText2,
                associativitySet3, associativityText3, associativitySet4, associativityText4, associativitySet5);
        endHBoxSet.getChildren().addAll(createSet);
        setVBox.getChildren().addAll(morphHBoxSet, identityHBoxSet, associativityHBoxSet, endHBoxSet);

        set.show();




    }
}