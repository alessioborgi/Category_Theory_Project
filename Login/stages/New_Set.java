package Login.stages;
import Login.JavaFX;
import Set_Category.SetCat;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * This class works with the Set Category, it is the graphical interface of the class "Set_Cat.java".
 * This code opens a window from the button "New Set" in the Create menu from the main page.
 *  In this window, the user can find, first of all, a menuButton where the user can decide the operation to be performed 
 *  between sets.
 *  After that the user has to define the identity linked to the operation chosen.
 *  In the next line the user can porve if the operation can handle the associativity operation by pressing the button
 *  "Prove the associativity".
 *  Last but not least, in the last HBox there are two buttons: one to test identity inserted:"Test"; 
 *  and "Create" which draws, in the main page, the graphical representation of the chosen operation.
 */

public class New_Set extends Application {
    public void start(Stage set) {
        set.setTitle("Set Category");
        set.setWidth(700);
        set.setHeight(500);

        VBox setVBox = new VBox();
        setVBox.getStyleClass().add("background");

        Scene setScene = new Scene(setVBox);
        setScene.getStylesheets().add("Login/Styles.css");
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

        Label morphTextSet = new Label("    Morphism:  ");
        morphTextSet.setStyle("-fx-font-size: 30 px");
        Label sourceTextSet = new Label("Source  A   ");
        sourceTextSet.setStyle("-fx-font-size: 22 px");
        Label endMorphSet = new Label ("   Source B");
        endMorphSet.setStyle("-fx-font-size: 22 px");


        Label identityTextSet = new Label("    Identity:   ");
        identityTextSet.setStyle("-fx-font-size: 30 px");
        TextField inputTextSet = new TextField();
        inputTextSet.setPromptText("Type Identity"); //to set the hint text
        inputTextSet.setMinHeight(30);
        Label space = new Label("           ");

        Button prova = new Button("Test"); //test identity button
        prova.setStyle("-fx-font-size: 22 px");
        prova.getStyleClass().add("button-create");

        Label spazio = new Label("    ");
        Button prove = new Button("Prove associativity");
        prove.setStyle("-fx-font-size: 22 px");
        prove.getStyleClass().add("button-create");

        Label associativitySet1 = new Label("    A  ");
        associativitySet1.setStyle("-fx-font-size: 20 px");
        TextField associativityText1 = new TextField("");
        associativityText1.setMaxSize(30,30);
        associativityText1.setDisable(true);
        associativityText1.setEditable(false);

        Label associativitySet2 = new Label("   (B   ");
        associativitySet2.setStyle("-fx-font-size: 20 px");
        TextField associativityText2 = new TextField("");
        associativityText2.setMaxSize(30,30);
        associativityText2.setDisable(true);
        associativityText2.setEditable(false);

        Label associativitySet3 = new Label("   C)  ==  (A    ");
        associativitySet3.setStyle("-fx-font-size: 20 px");
        TextField associativityText3 = new TextField("");
        associativityText3.setMaxSize(30,30);
        associativityText3.setDisable(true);
        associativityText3.setEditable(false);

        Label associativitySet4 = new Label ("  B)  ");
        associativitySet4.setStyle("-fx-font-size: 20 px");
        TextField associativityText4 = new TextField("");
        associativityText4.setMaxSize(30,30);
        associativityText4.setDisable(true);
        associativityText4.setEditable(false);

        Label associativitySet5 = new Label ("   C  ");
        associativitySet5.setStyle("-fx-font-size: 20 px");

        MenuButton morphSet = new MenuButton("Choose the function");
        morphSet.setStyle("-fx-font-size: 22 px");
        morphSet.getStyleClass().add("button-create");

        Button createSet = new Button("Create");
        createSet.setStyle("-fx-font-size: 22 px");
        createSet.getStyleClass().add("button-create");

        MenuItem uni = new MenuItem("U");
        uni.getStyleClass().add("menu-create");
        MenuItem inter = new MenuItem ("∩");
        inter.getStyleClass().add("menu-create");
        MenuItem subt = new MenuItem("-");
        subt.getStyleClass().add("menu-create");
        MenuItem symsub = new MenuItem("Δ");
        symsub.getStyleClass().add("menu-create");

        Alert alertAssSet = new Alert(Alert.AlertType.INFORMATION);
        Alert alertidSet = new Alert(Alert.AlertType.INFORMATION);

        uni.setOnAction(e-> {
            morphSet.setText("U");
            associativityText1.setDisable(false);
            associativityText1.setText("U");
            associativityText2.setDisable(false);
            associativityText2.setText("U");
            associativityText3.setDisable(false);
            associativityText3.setText("U");
            associativityText4.setDisable(false);
            associativityText4.setText("U");

            SetCat.SetUnion obj = new SetCat.SetUnion();
            alertAssSet.setTitle("Prove Associativity");
            alertAssSet.setHeaderText("Associativity Checked");
            String x = obj.associativity();
            alertAssSet.setContentText(x);


        });

        inter.setOnAction(hh-> {
            morphSet.setText("∩");
            associativityText1.setDisable(false);
            associativityText1.setText("∩");
            associativityText2.setDisable(false);
            associativityText2.setText("∩");
            associativityText3.setDisable(false);
            associativityText3.setText("∩");
            associativityText4.setDisable(false);
            associativityText4.setText("∩");

            SetCat.SetIntersection gne = new SetCat.SetIntersection();
            alertAssSet.setTitle("Prove Associativity");
            alertAssSet.setHeaderText("Associativity Checked");
            String bb = gne.associativity();
            alertAssSet.setContentText(bb);
        });

        subt.setOnAction(fun->{
            morphSet.setText("-");
            associativityText1.setDisable(false);
            associativityText1.setText("-");
            associativityText2.setDisable(false);
            associativityText2.setText("-");
            associativityText3.setDisable(false);
            associativityText3.setText("-");
            associativityText4.setDisable(false);
            associativityText4.setText("-");


            SetCat.SetDifference ogg = new SetCat.SetDifference();
            alertAssSet.setTitle("Prove Associativity");
            alertAssSet.setHeaderText("Associativity Checked");
            String z = ogg.associativity();
            alertAssSet.setContentText(z);

        });

        symsub.setOnAction(f-> {

            morphSet.setText("Δ");
            associativityText1.setDisable(false);
            associativityText1.setText("Δ");
            associativityText2.setDisable(false);
            associativityText2.setText("Δ");
            associativityText3.setDisable(false);
            associativityText3.setText("Δ");
            associativityText4.setDisable(false);
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
                if (inputTextSet.getText().equals("set itself")) {
                    alertidSet.setTitle("Prove Identity");
                    alertidSet.setHeaderText("Identity Checked");
                    String s = k.tryIdentity();
                    alertidSet.setContentText(s);
                    alertidSet.show();
                } else {
                    String falso = "ERROR, the Identity should be an element that applied to the Set returns the set itself, be careful!";
                    alertidSet.setTitle("Prove Identity");
                    alertidSet.setHeaderText("Identity Checked");
                    alertidSet.setContentText(falso);
                    alertidSet.show();}
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

        ///////////////////
        createSet.setOnAction(e->{
            if (morphSet.getText().equals("U")){

                Label A = new Label("A");
                A.setTranslateX(330.0f);
                A.setTranslateY(225.0f);
                A.setStyle("-fx-font-size: 22 px");

                Label B = new Label("B");
                B.setTranslateX(455.0f);
                B.setTranslateY(225.0f);
                B.setStyle("-fx-font-size: 22 px");

                Circle circle1 = new Circle();

                //Setting the position of the circle
                circle1.setCenterX(350.0f);
                circle1.setCenterY(250.0f);

                //Setting the radius of the circle
                circle1.setRadius(100.0f);

                //Setting the color of the circle
                circle1.setFill(Color.DARKSLATEBLUE);

                //Drawing Circle2
                Circle circle2 = new Circle();


                //Setting the position of the circle
                circle2.setCenterX(450.0f);
                circle2.setCenterY(250.0f);

                //Setting the radius of the circle
                circle2.setRadius(100.0f);

                //Setting the color of the circle
                circle2.setFill(Color.BLUE);
                //Performing union operation on the circle
                Shape shape = Shape.union(circle1, circle2);

                //Setting the fill color to the result
                shape.setFill(Color.CORNFLOWERBLUE);

                Shape forma = Shape.intersect(circle1, circle2);
                forma.setStroke(Color.WHITE);
                forma.setFill(Color.CORNFLOWERBLUE);

                String x =
                        "Operation: " + morphSet.getText() +"\n"+
                                "Identity: " + inputTextSet.getText();

                Tooltip t = new Tooltip(x);
                Button info = new Button("i");
                info.setShape(new Circle(1.5));
                info.setTranslateX(500.0f);
                info.setTranslateY(100.0f);
                info.setStyle("-fx-font-size: 30 px");
                info.getStyleClass().add("button-create");
                t.setShowDelay(Duration.millis(0));
                t.setHideDelay(Duration.millis(0));
                info.setTooltip(t);

                info.setOnAction(f-> {
                    Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
                    alertInfo.setTitle("Info");
                    alertInfo.setHeaderText("Group Features");
                    String s = "Operation: " + morphSet.getText() + "\n" +
                            "Identity: " + inputTextSet.getText();
                    alertInfo.setContentText(s);
                    alertInfo.show();
                });

                JavaFX.draw.getChildren().clear();
                JavaFX.draw.getChildren().addAll( shape, forma,A, B, info);}


            if(morphSet.getText().equals("∩")){

                Label A = new Label("A");
                A.setTranslateX(330.0f);
                A.setTranslateY(225.0f);
                A.setStyle("-fx-font-size: 22 px");

                Label B = new Label("B");
                B.setTranslateX(455.0f);
                B.setTranslateY(225.0f);
                B.setStyle("-fx-font-size: 22 px");


                Circle circle1 = new Circle();

                //Setting the position of the circle
                circle1.setCenterX(350.0f);
                circle1.setCenterY(250.0f);

                //Setting the radius of the circle
                circle1.setRadius(100.0f);

                //Setting the color of the circle
                circle1.setFill(Color.DARKSLATEBLUE);

                //Drawing Circle2
                Circle circle2 = new Circle();

                //Setting the position of the circle
                circle2.setCenterX(450.0f);
                circle2.setCenterY(250.0f);

                //Setting the radius of the circle
                circle2.setRadius(100.0f);

                //Setting the color of the circle
                circle2.setFill(Color.BLUE);

                //Performing intersection operation on the circle
                Shape shape = Shape.intersect(circle1, circle2);

                //Setting the fill color to the result
                shape.setFill(Color.CORNFLOWERBLUE);

                Shape forma = Shape.union(circle1, circle2);
                forma.setFill(JavaFX.background);
                forma.setStroke(Color.WHITE);


                String x =
                        "Operation: " + morphSet.getText() +"\n"+
                                "Idetity: " + inputTextSet.getText();

                Tooltip t = new Tooltip(x);
                Button info = new Button("i");
                info.setShape(new Circle(1.5));
                info.setTranslateX(500.0f);
                info.setTranslateY(100.0f);
                info.setStyle("-fx-font-size: 30 px");
                info.getStyleClass().add("button-create");
                t.setShowDelay(Duration.millis(0));
                t.setHideDelay(Duration.millis(0));
                info.setTooltip(t);

                info.setOnAction(f-> {
                    Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
                    alertInfo.setTitle("Info");
                    alertInfo.setHeaderText("Group Features");
                    String s = "Operation: " + morphSet.getText() + "\n" +
                            "Identity: " + inputTextSet.getText();
                    alertInfo.setContentText(s);
                    alertInfo.show();
                });

                JavaFX.draw.getChildren().clear();
                JavaFX.draw.getChildren().addAll(forma,  shape, A, B, info);
            }

            if(morphSet.getText().equals("-")){

                Label A = new Label("A");
                A.setTranslateX(330.0f);
                A.setTranslateY(225.0f);
                A.setStyle("-fx-font-size: 22 px");

                Label B = new Label("B");
                B.setTranslateX(455.0f);
                B.setTranslateY(225.0f);
                B.setStyle("-fx-font-size: 22 px");


                //Drawing Circle1
                Circle circle1 = new Circle();

                //Setting the position of the circle
                circle1.setCenterX(350.0f);
                circle1.setCenterY(250.0f);

                //Setting the radius of the circle
                circle1.setRadius(100.0f);

                //Setting the color of the circle
                circle1.setFill(Color.DARKSLATEBLUE);

                //Drawing Circle2
                Circle circle2 = new Circle();

                //Setting the position of the circle
                circle2.setCenterX(450.0f);
                circle2.setCenterY(250.0f);

                //Setting the radius of the circle
                circle2.setRadius(100.0f);

                //Setting the color of the circle
                circle2.setFill(Color.BLUE);

                //Performing subtraction operation on the circle
                Shape shape = Shape.subtract(circle1, circle2);

                //Setting the fill color to the result
                shape.setFill(Color.CORNFLOWERBLUE);

                Shape cerchio = Shape.intersect(circle1, circle2);
                cerchio.setStroke(Color.WHITE);
                cerchio.setFill(JavaFX.background);


                Shape forma   = Shape.subtract(circle2, circle1);
                forma.setFill(JavaFX.background);
                forma.setStroke(Color.WHITE);

                String x =
                        "Operation: " + morphSet.getText() +"\n"+
                        "Identity: " + identityTextSet.getText();

                Tooltip t = new Tooltip(x);
                Button info = new Button("i");
                info.setShape(new Circle(1.5));
                info.setTranslateX(500.0f);
                info.setTranslateY(100.0f);
                info.setStyle("-fx-font-size: 30 px");
                info.getStyleClass().add("button-create");
                t.setShowDelay(Duration.millis(0));
                t.setHideDelay(Duration.millis(0));
                info.setTooltip(t);

                info.setOnAction(f-> {
                            Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
                            alertInfo.setTitle("Info");
                            alertInfo.setHeaderText("Group Features");
                            String s = "Operation: " + morphSet.getText() + "\n" +
                                    "Identity: " + inputTextSet.getText();
                            alertInfo.setContentText(s);
                            alertInfo.show();
                        });

                JavaFX.draw.getChildren().clear();
                JavaFX.draw.getChildren().addAll(shape, cerchio, forma, A, B, info);


            }
            if(morphSet.getText().equals("Δ")){

                Label A = new Label("A");
                A.setTranslateX(330.0f);
                A.setTranslateY(225.0f);
                A.setStyle("-fx-font-size: 22 px");

                Label B = new Label("B");
                B.setTranslateX(455.0f);
                B.setTranslateY(225.0f);
                B.setStyle("-fx-font-size: 22 px");


                Circle circle1 = new Circle();

                //Setting the position of the circle
                circle1.setCenterX(350.0f);
                circle1.setCenterY(250.0f);

                //Setting the radius of the circle
                circle1.setRadius(100.0f);

                //Setting the color of the circle
                circle1.setFill(Color.DARKSLATEBLUE);

                //Drawing Circle2
                Circle circle2 = new Circle();

                //Setting the position of the circle
                circle2.setCenterX(450.0f);
                circle2.setCenterY(250.0f);

                //Setting the radius of the circle
                circle2.setRadius(100.0f);

                //Setting the color of the circle
                circle2.setFill(Color.BLUE);

                //Performing subtraction operation on the circle
                Shape shape = Shape.subtract(circle1, circle2);

                //Setting the fill color to the result
                shape.setFill(Color.CORNFLOWERBLUE);

                Shape forma = Shape.subtract(circle2, circle1);
                forma.setFill(Color.CORNFLOWERBLUE);

                Shape cerchio = Shape.intersect(circle1, circle2);
                cerchio.setStroke(Color.WHITE);
                cerchio.setFill(JavaFX.background);

                String x =
                        "Operation: " + morphSet.getText() +"\n"+
                                "Identity: " + inputTextSet.getText();

                Tooltip t = new Tooltip(x);
                Button info = new Button("i");
                info.setShape(new Circle(1.5));
                info.setTranslateX(500.0f);
                info.setTranslateY(100.0f);
                info.setStyle("-fx-font-size: 30 px");
                info.getStyleClass().add("button-create");
                t.setShowDelay(Duration.millis(0));
                t.setHideDelay(Duration.millis(0));
                info.setTooltip(t);

                info.setOnAction(f-> {
                    Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
                    alertInfo.setTitle("Info");
                    alertInfo.setHeaderText("Group Features");
                    String s = "Operation: " + morphSet.getText() + "\n" +
                            "Identity: " + inputTextSet.getText();
                    alertInfo.setContentText(s);
                    alertInfo.show();
                });

                JavaFX.draw.getChildren().clear();
                JavaFX.draw.getChildren().addAll(shape, cerchio, forma, A, B, info);

            }
        });
    }}










