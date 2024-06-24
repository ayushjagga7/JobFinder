package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

import javax.swing.*;
import javax.xml.transform.Result;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

//import javax.swing.*;
//import java.awt.FlowLayout;
//import javax.swing.JtextArea;



public class Main extends Application {
    static Scene sc, scene1, scene2, scene3, scene4, scene5,Finalscene,comScene,comRegister,complogin;
    static Stage window;
    static Scene mainScene;
    static Scene login, signup;
    static String username;
    static int U_id;
    static int C_id;
    private static database myserver = new database();
    private static final Connection conn = myserver.main();
    Rectangle2D r = Screen.getPrimary().getBounds();


    public static void main(String[] args) {
        launch(args);
    }

    public static void OptionPaneExample(String warningMsg){
        JFrame f=new JFrame();
        JOptionPane.showMessageDialog(f,warningMsg,"Alert",JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // login Page for user-----------------------------------------------------------------------------------------------------------------------------------
        BorderPane loginpane1=new BorderPane();
        GridPane pane1 = new GridPane();
        HBox cPane1 = new HBox();
        HBox hb11 = new HBox();
        VBox hb12 = new VBox();

        Label heading1 = new Label("Login Page");
        heading1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 38));
        heading1.setPadding(new Insets(10));
        heading1.setTextFill(Color.ANTIQUEWHITE);
        pane1.setAlignment(Pos.CENTER);

        Image image1 = new Image(new FileInputStream("Resources/iamge.png"));
        ImageView imageView1 = new ImageView(image1);
        imageView1.setPreserveRatio(true);


        Label luser = new Label("Email");luser.setFont(Font.font("Times New Roman",FontWeight.BOLD,15));
        TextField username = new TextField();
        username.setPromptText("email");
        Label lpass = new Label("Password");lpass.setFont(Font.font("Times New Roman",FontWeight.BOLD,15));
        PasswordField password = new PasswordField();
        password.setPromptText("Password");
        Label Lmsg = new Label("");
        Lmsg.setTextFill(Color.RED);

        Button bLogin = new Button("Login");bLogin.setStyle("-fx-text-fill: white;-fx-font-family:Arial Narrow;-fx-font-weight: bold;-fx-background-color: linear-gradient(#61a2b1, #2A5058);-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );-fx-font-size:1.55em;");
        Button bSignUp = new Button("SignUp");bSignUp.setStyle("-fx-text-fill: white;-fx-font-family:Arial Narrow;-fx-font-weight: bold;-fx-background-color: linear-gradient(#61a2b1, #2A5058);-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );-fx-font-size:1.55em;");
        HBox h13 = new HBox();
        h13.getChildren().addAll(bLogin, bSignUp);
        h13.setSpacing(17);
        h13.setAlignment(Pos.CENTER);

        hb12.setAlignment(Pos.CENTER);
        hb11.getChildren().addAll(imageView1);
        hb12.getChildren().addAll(heading1, luser, username, lpass, password, Lmsg, h13);
        hb12.setSpacing(2.5);
        cPane1.getChildren().addAll(hb11, hb12);
        pane1.getChildren().addAll(cPane1);

        cPane1.setPadding(new Insets(50));
        BackgroundFill b_fill1 = new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY, Insets.EMPTY);
        Background bground1 = new Background(b_fill1);
        cPane1.setBackground(bground1);

        FileInputStream inputlogout1 = new FileInputStream("Resources/logout.png");
        Image log1 = new Image(inputlogout1);
        ImageView logout1 = new ImageView(log1);
        logout1.setFitWidth(25);
        logout1.setFitHeight(25);
        Button l1 = new Button();
        l1.setOnAction(e->{primaryStage.setScene(Finalscene);});
        l1.setGraphic(logout1);
        l1.setStyle("-fx-background-color: white;");


        BackgroundFill background_fill1 = new BackgroundFill(Color.rgb(48, 71, 94), CornerRadii.EMPTY, Insets.EMPTY);
        Background background1 = new Background(background_fill1);
        loginpane1.setBackground(background1);
        loginpane1.setCenter(pane1);
        loginpane1.setRight(l1);
        login = new Scene(loginpane1, 0.9 * r.getWidth(), 0.9 * r.getHeight());



        //signUP Page for user--------------------------------------------------------------------------------------------------------------------------------------------------
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        GridPane pane2 = new GridPane();
        HBox cPane2 = new HBox();
        HBox hb21 = new HBox();
        VBox hb22 = new VBox();


        Label heading2 = new Label("Register");
        heading2.setFont(Font.font("Times New Roman", FontWeight.BOLD, 32));
        heading2.setPadding(new Insets(10));
        heading2.setTextFill(Color.RED);
        pane2.setAlignment(Pos.CENTER);


        Image image2 = new Image(new FileInputStream("Resources/iamge.png"));
        ImageView imageView2 = new ImageView(image2);
        imageView2.setPreserveRatio(true);


        Label Lemail = new Label("Email");Lemail.setFont(Font.font("Times New Roman",FontWeight.BOLD,15));
        TextField Temail = new TextField();
        Temail.setPromptText("Email");
        Label LPassword = new Label("Password");LPassword.setFont(Font.font("Times New Roman",FontWeight.BOLD,15));
        PasswordField pass1 = new PasswordField();
        pass1.setPromptText("Password");
        Label LcPassword = new Label(" Confirm Password");LcPassword.setFont(Font.font("Times New Roman",FontWeight.BOLD,15));
        PasswordField pass2 = new PasswordField();
        pass2.setPromptText("Confirm Password");
        Button bRegister = new Button("Register");bRegister.setStyle("-fx-text-fill: white;-fx-font-family:Arial Narrow;-fx-font-weight: bold;-fx-background-color: linear-gradient(#61a2b1, #2A5058);-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );-fx-font-size:1.15em;");
        Button bback = new Button("Back to SignIn");bback.setStyle("-fx-text-fill: white;-fx-font-family:Arial Narrow;-fx-font-weight: bold;-fx-background-color: linear-gradient(#61a2b1, #2A5058);-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );-fx-font-size:1.15em;");
        bback.setOnAction(e -> {
            primaryStage.setScene(login);
        });
        HBox h23 = new HBox();
        h23.getChildren().addAll(bRegister, bback);
        h23.setSpacing(10);
        h23.setAlignment(Pos.CENTER);
        Label Smsg = new Label("");
        Smsg.setTextFill(Color.RED);

        hb22.setAlignment(Pos.CENTER);
        hb21.getChildren().addAll(imageView2);
        hb22.getChildren().addAll(heading2, Lemail, Temail, LPassword, pass1, LcPassword, pass2, Smsg, h23);
        hb22.setSpacing(2.5);
        cPane2.getChildren().addAll(hb21, hb22);
        pane2.getChildren().addAll(cPane2);

        cPane2.setPadding(new Insets(50));
        BackgroundFill b_fill2 = new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY, Insets.EMPTY);
        Background bground2 = new Background(b_fill2);
        cPane2.setBackground(bground2);

        BackgroundFill background_fill2 = new BackgroundFill(Color.rgb(48, 71, 94), CornerRadii.EMPTY, Insets.EMPTY);
        Background background2 = new Background(background_fill2);
        pane2.setBackground(background2);

        signup = new Scene(pane2, 0.9 * r.getWidth(), 0.9 * r.getHeight());





        //login page for company---------------------------------------------------------------------------------------------------------
        BorderPane comploginpane=new BorderPane();
        GridPane comppane1 = new GridPane();
        HBox compcPane1 = new HBox();
        HBox comphb11 = new HBox();
        VBox comphb12 = new VBox();

        Label compheading1 = new Label("Login Page");
        compheading1.setFont(Font.font("Times New Roman", FontWeight.BOLD, 38));
        compheading1.setPadding(new Insets(10));
        compheading1.setTextFill(Color.ANTIQUEWHITE);
        comppane1.setAlignment(Pos.CENTER);

        Image compimage1 = new Image(new FileInputStream("Resources/iamge.png"));
        ImageView compimageView1 = new ImageView(compimage1);
        compimageView1.setPreserveRatio(true);


        Label compluser = new Label("Email");compluser.setFont(Font.font("Times New Roman",FontWeight.BOLD,15));
        TextField compusername = new TextField();
        compusername.setPromptText("email");
        Label complpass = new Label("Password");complpass.setFont(Font.font("Times New Roman",FontWeight.BOLD,15));
        PasswordField comppassword = new PasswordField();
        comppassword.setPromptText("Password");

        Label compLmsg = new Label("");
        compLmsg.setTextFill(Color.RED);

        Button compbLogin = new Button("Login");compbLogin.setStyle("-fx-text-fill: white;-fx-font-family:Arial Narrow;-fx-font-weight: bold;-fx-background-color: linear-gradient(#61a2b1, #2A5058);-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );-fx-font-size:1.55em;");
        Button compbSignUp = new Button("SignUp");compbSignUp.setStyle("-fx-text-fill: white;-fx-font-family:Arial Narrow;-fx-font-weight: bold;-fx-background-color: linear-gradient(#61a2b1, #2A5058);-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );-fx-font-size:1.55em;");
        compbSignUp.setOnAction(e->{primaryStage.setScene(comRegister);});
        HBox comph13 = new HBox();
        comph13.getChildren().addAll(compbLogin, compbSignUp);
        comph13.setSpacing(17);
        comph13.setAlignment(Pos.CENTER);

        comphb12.setAlignment(Pos.CENTER);
        comphb11.getChildren().addAll(compimageView1);
        comphb12.getChildren().addAll(compheading1, compluser, compusername, complpass, comppassword, compLmsg, comph13);
        comphb12.setSpacing(2.5);
        compcPane1.getChildren().addAll(comphb11, comphb12);
        comppane1.getChildren().addAll(compcPane1);

        compcPane1.setPadding(new Insets(50));
        BackgroundFill compb_fill1 = new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY, Insets.EMPTY);
        Background compbground1 = new Background(compb_fill1);
        compcPane1.setBackground(compbground1);

        FileInputStream compinputlogout1 = new FileInputStream("Resources/logout.png");
        Image complog1 = new Image(compinputlogout1);
        ImageView complogout1 = new ImageView(complog1);
        complogout1.setFitWidth(25);
        complogout1.setFitHeight(25);
        Button compl1 = new Button();
        compl1.setOnAction(e->{
            compusername.setText("");
            comppassword.setText("");
            primaryStage.setScene(Finalscene);});
        compl1.setGraphic(logout1);
        compl1.setStyle("-fx-background-color: white;");


        BackgroundFill compbackground_fill1 = new BackgroundFill(Color.rgb(48, 71, 94), CornerRadii.EMPTY, Insets.EMPTY);
        Background compbackground1 = new Background(compbackground_fill1);
        comploginpane.setBackground(compbackground1);
        comploginpane.setCenter(comppane1);
        comploginpane.setRight(compl1);
        //activePanee = login();
        complogin = new Scene(comploginpane, 0.9 * r.getWidth(), 0.9 * r.getHeight());






        //Sign up page for company--------------------------------------------------------------------------------------------------------
        GridPane pane3 = new GridPane();
        HBox cPane3 = new HBox();
        HBox hb31 = new HBox();
        VBox hb32 = new VBox();


        Label heading3 = new Label("Register");
        heading3.setFont(Font.font("Times New Roman", FontWeight.BOLD, 32));
        heading3.setPadding(new Insets(10));
        heading3.setTextFill(Color.RED);
        pane3.setAlignment(Pos.CENTER);


        Image image3 = new Image(new FileInputStream("Resources/iamge.png"));
        ImageView imageView3 = new ImageView(image3);
        imageView3.setPreserveRatio(true);


        Label CRname = new Label("Name of Company");CRname.setFont(Font.font("Times New Roman",FontWeight.BOLD,15));;
        TextField CRnameinput = new TextField();
        Label CRfield=new Label("Field");CRfield.setFont(Font.font("Times New Roman",FontWeight.BOLD,15));
        TextField CRfeildinput = new TextField();
        Label CRType = new Label("Type(Private/Public)");CRType.setFont(Font.font("Times New Roman",FontWeight.BOLD,15));
        TextField CRtypeinput = new TextField();
        Label CREmail = new Label("Email");CREmail.setFont(Font.font("Times New Roman",FontWeight.BOLD,15));
        TextField CRemailinput = new TextField();
        Label CRPassword1 = new Label("Password");CRPassword1.setFont(Font.font("Times New Roman",FontWeight.BOLD,15));
        PasswordField CRpass1 = new PasswordField();
        Label CRPassword2 = new Label(" Confirm Password");CRPassword2.setFont(Font.font("Times New Roman",FontWeight.BOLD,15));
        PasswordField CRpass2 = new PasswordField();
        pass2.setPromptText("Confirm Password");
        Label Cmsg = new Label("");
        Button CRRegister = new Button("Register");CRRegister.setStyle("-fx-text-fill: white;-fx-font-family:Arial Narrow;-fx-font-weight: bold;-fx-background-color: linear-gradient(#61a2b1, #2A5058);-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );-fx-font-size:1.55em;");
        Button CRback = new Button(" Back ");CRback.setStyle("-fx-text-fill: white;-fx-font-family:Arial Narrow;-fx-font-weight: bold;-fx-background-color: linear-gradient(#61a2b1, #2A5058);-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );-fx-font-size:1.55em;");
        CRRegister.setOnAction(e -> {
            try{
                if(CRnameinput.getText().length()>0 && CRfeildinput.getText().length()>0 && CRtypeinput.getText().length()>0 && CRemailinput.getText().length()>0 && CRpass1.getText().length()>0 && CRpass2.getText().length()>0){
                    String cName = CRnameinput.getText().trim();
                    String cType = CRtypeinput.getText().trim();
                    String cField = CRfeildinput.getText().trim();
                    String cEmail = CRemailinput.getText().trim();
                    String p1 = CRpass1.getText().trim();
                    String p2 = CRpass2.getText().trim();

                    if (CRemailinput.getText().contains(".co.in")) {
                        cEmail = cEmail.trim();
                        if (p1.length() > 0 && p2.length() > 0) {

                            if (p1.equals(p2)) {
                                String sql2 = "select cName,cEmail from companycred";
                                ResultSet rs = stmt.executeQuery(sql2);
                                boolean profileCheck = TRUE;

                                //while to check if user already registered
                                while (profileCheck && rs.next()) {
                                    if (rs.getString("cEmail").equals(cEmail) )
                                        profileCheck = FALSE;
                                }

                                //if not registered then
                                if (profileCheck) {
                                    String sql1 = "Insert into companycred(cName,cType,cField,cEmail,cpassword) values(?,?,?,?,?)";
                                    PreparedStatement pStmt = conn.prepareStatement(sql1);
                                    pStmt.setString(1,cName);
                                    pStmt.setString(2,cType);
                                    pStmt.setString(3,cField);
                                    pStmt.setString(4,cEmail);
                                    pStmt.setString(5,p1);
                                    pStmt.executeUpdate();
                                    primaryStage.setScene(complogin);
                                    Cmsg.setText("");
                                } else {
                                    Cmsg.setText("email already registered");
                                    System.out.println("company already registered");
                                }

                            } else {
                                Cmsg.setText("password confirmation failed");
                                System.out.println("Check password");
                            }
                        } else {
                            Cmsg.setText("enter a paassword");
                            System.out.println("Enter a valid password");
                        }
                    } else {
                        Cmsg.setText("invalid email");
                        System.out.println("Please enter a valid email");
                    }

                }else Cmsg.setText("Incomplete Details");
            }catch(Exception exe){
                exe.printStackTrace();
            }
        });
        CRback.setOnAction(e->{primaryStage.setScene(complogin);});
        HBox h33 = new HBox();
        h33.getChildren().addAll(CRRegister, CRback);
        h33.setSpacing(10);
        h33.setAlignment(Pos.CENTER);
        Label CRmsg = new Label("");
        CRmsg.setTextFill(Color.RED);

        hb32.setAlignment(Pos.CENTER);
        hb31.getChildren().addAll(imageView3);
        hb32.getChildren().addAll(heading3,CRname, CRnameinput, CRfield, CRfeildinput, CRType, CRtypeinput,CREmail,CRemailinput,CRPassword1,CRpass1,CRPassword2,CRpass2,Cmsg, h33);
        hb32.setSpacing(2.5);
        cPane3.getChildren().addAll(hb31, hb32);
        pane3.getChildren().addAll(cPane3);

        cPane3.setPadding(new Insets(50));
        BackgroundFill b_fill3 = new BackgroundFill(Color.rgb(255, 255, 255), CornerRadii.EMPTY, Insets.EMPTY);
        Background bground3 = new Background(b_fill3);
        cPane3.setBackground(bground3);

        BackgroundFill background_fill3 = new BackgroundFill(Color.rgb(48, 71, 94), CornerRadii.EMPTY, Insets.EMPTY);
        Background background3 = new Background(background_fill3);
        pane3.setBackground(background3);

        comRegister = new Scene(pane3, 0.9 * r.getWidth(), 0.9 * r.getHeight());






        //OnLOGin
        BorderPane root = new BorderPane();

//background image
        FileInputStream input = new FileInputStream("Resources/snu6.jpg");
        Image image = new Image(input);
        BackgroundImage backgroundimage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100,100,true,true,true,false));
        Background background = new Background(backgroundimage);
        root.setBackground(background);
        //root.setStyle("-fx-background-size:100% 100%");
        //root.setStyle("-fx-background-image:"+image";");

//logout button
        FileInputStream inputlogout = new FileInputStream("Resources/logout.png");
        Image ilo = new Image(inputlogout);
        ImageView imlo = new ImageView(ilo);
        imlo.setFitWidth(25);
        imlo.setFitHeight(25);
        Button logout = new Button();
        logout.setGraphic(imlo);
        logout.setStyle("-fx-background-color:transparent;");
        root.setRight(logout);


        GridPane info = new GridPane();
        info.setMaxHeight(r.getHeight() * 0.4);
        info.setMaxWidth(r.getWidth() * 0.50);
        info.setPadding(new Insets(20,20,20,20));
        //info.setStyle("-fx-background-color: transparent;");
        info.setAlignment(Pos.CENTER);
        info.setHgap(7.5);
        info.setVgap(10);
        //info.setGridLinesVisible(TRUE);


//personal information
        FileInputStream input1 = new FileInputStream("Resources/personal.png");
        Image i1 = new Image(input1);
        ImageView im1 = new ImageView(i1);
        im1.setFitWidth(150);
        im1.setFitHeight(150);
        Button B1 = new Button();
        B1.setText("Personal Informtion");
        B1.setStyle("-fx-background-color:linear-gradient(#ffd65b, #e68400), linear-gradient(#ffef84, #f2ba44), linear-gradient(#ffea6a, #efaa22), linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%), linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0)); -fx-background-radius: 30;-fx-background-insets: 0,1,2,3,0;-fx-text-fill: #654b00;-fx-font-weight: bold;-fx-font-size: 12px;-fx-padding: 5 7 5 7;");
        B1.setMinSize(140,45);
        VBox v1 = new VBox();
        v1.getChildren().addAll(im1, B1);

//education experience
        FileInputStream input2 = new FileInputStream("Resources/education.png");
        Image i2 = new Image(input2);
        ImageView im2 = new ImageView(i2);
        im2.setFitWidth(150);
        im2.setFitHeight(150);
        Button B2 = new Button();
        B2.setText("Education");
        B2.setStyle("-fx-background-color:linear-gradient(#ffd65b, #e68400), linear-gradient(#ffef84, #f2ba44), linear-gradient(#ffea6a, #efaa22), linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%), linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0)); -fx-background-radius: 30;-fx-background-insets: 0,1,2,3,0;-fx-text-fill: #654b00;-fx-font-weight: bold;-fx-font-size: 12px;-fx-padding: 5 7 5 7;");
        B2.setMinSize(140,45);
        VBox v2 = new VBox();
        v2.getChildren().addAll(im2, B2);
//experience
        FileInputStream input3 = new FileInputStream("Resources/experience.png");
        Image i3 = new Image(input3);
        ImageView im3 = new ImageView(i3);
        im3.setFitWidth(150);
        im3.setFitHeight(150);
        Button B3 = new Button();
        B3.setStyle("-fx-background-color:linear-gradient(#ffd65b, #e68400), linear-gradient(#ffef84, #f2ba44), linear-gradient(#ffea6a, #efaa22), linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%), linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0)); -fx-background-radius: 30;-fx-background-insets: 0,1,2,3,0;-fx-text-fill: #654b00;-fx-font-weight: bold;-fx-font-size: 12px;-fx-padding: 5 7 5 7;");
        B3.setText("Work experience");
        B3.setMinSize(140,45);
        VBox v3 = new VBox();
        v3.getChildren().addAll(im3, B3);

//Projects and PR
        FileInputStream input4 = new FileInputStream("Resources/businessman.png");
        Image i4 = new Image(input4);
        ImageView im4 = new ImageView(i4);
        im4.setFitWidth(150);
        im4.setFitHeight(150);
        Button B4 = new Button();
        B4.setStyle("-fx-background-color:linear-gradient(#ffd65b, #e68400), linear-gradient(#ffef84, #f2ba44), linear-gradient(#ffea6a, #efaa22), linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%), linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0)); -fx-background-radius: 30;-fx-background-insets: 0,1,2,3,0;-fx-text-fill: #654b00;-fx-font-weight: bold;-fx-font-size: 12px;-fx-padding: 5 7 5 7;");
        B4.setText("Projects and Positions\n    of Responsibilities");
        B4.setMinSize(140,45);
        VBox v4 = new VBox();
        v4.getChildren().addAll(im4, B4);


//skills and ECA
        FileInputStream input5 = new FileInputStream("Resources/football-player.png");
        Image i5 = new Image(input5);
        ImageView im5 = new ImageView(i5);
        im5.setFitWidth(150);
        im5.setFitHeight(150);
        Button B5 = new Button();
        B5.setStyle("-fx-background-color:linear-gradient(#ffd65b, #e68400), linear-gradient(#ffef84, #f2ba44), linear-gradient(#ffea6a, #efaa22), linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%), linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0)); -fx-background-radius: 30;-fx-background-insets: 0,1,2,3,0;-fx-text-fill: #654b00;-fx-font-weight: bold;-fx-font-size: 12px;-fx-padding: 5 7 5 7;");
        B5.setText("   Skills and Extra\nCurricular Activities");
        B5.setMinSize(140,45);
        VBox v5 = new VBox();
        v5.getChildren().addAll(im5, B5);


        v1.setAlignment(Pos.CENTER);v1.setSpacing(7.5);
        v2.setAlignment(Pos.CENTER);v2.setSpacing(7.5);
        v3.setAlignment(Pos.CENTER);v3.setSpacing(7.5);
        v4.setAlignment(Pos.CENTER);v4.setSpacing(7.5);
        v5.setAlignment(Pos.CENTER);v5.setSpacing(7.5);
        info.add(v1, 0, 0);
        info.add(v2, 1, 0);
        info.add(v3, 2, 0);
        info.add(v4, 3, 0);
        info.add(v5, 4, 0);
        info.setStyle("-fx-background-color:transparent;-fx-background-radius: 100;");
        root.setCenter(info);
        sc = new Scene(root, 0.90 * r.getWidth(), 0.90 * r.getHeight());


//Scene of personal information
        //About
        VBox about = new VBox();
        about.setSpacing(8);
        Label Alabel = new Label("About");
        Alabel.setFont(Font.font("Times New Roman",FontWeight.BOLD,32));
        GridPane Ainfo = new GridPane();Ainfo.setHgap(5);Ainfo.setVgap(5);

        Label AFname = new Label("First Name: ");
        TextField AFnameinput = new TextField();
        AFnameinput.setPromptText("FirstName");
        Label ALname = new Label("Last Name: ");
        TextField ALnameinput = new TextField();
        ALnameinput.setPromptText("LastName");
        Label ADOB = new Label("Date of birth");
        TextField ADOBinput = new TextField();
        ADOBinput.setPromptText("YYYY-MM-DD");
        Label Agender = new Label("Gender");
        TextField Agenderinput = new TextField();
        Label Acategory = new Label("Category");
        TextField Acategoryinput = new TextField();

        Ainfo.add(AFname, 0, 0);
        Ainfo.add(AFnameinput, 1, 0);
        Ainfo.add(ALname, 0, 1);
        Ainfo.add(ALnameinput, 1, 1);
        Ainfo.add(ADOB, 0, 2);
        Ainfo.add(ADOBinput, 1, 2);
        Ainfo.add(Agender, 0, 3);
        Ainfo.add(Agenderinput, 1, 3);
        Ainfo.add(Acategory, 0, 4);
        Ainfo.add(Acategoryinput, 1, 4);

        about.getChildren().addAll(Alabel, Ainfo);


        //Contact Details
        VBox contact = new VBox();
        Label CDlabel = new Label("Contact Details");
        GridPane CDinfo = new GridPane();
        contact.setSpacing(8);
        CDlabel.setFont(Font.font("Times New Roman",FontWeight.BOLD,32));
        CDinfo.setHgap(5);CDinfo.setVgap(5);


        Label CDmobile = new Label("Mobile No.");
        TextField CDmobileinput = new TextField();
        Label CDemail = new Label("Email: ");
        TextField CDemailinput = new TextField();


        CDinfo.add(CDmobile, 0, 0);
        CDinfo.add(CDmobileinput, 1, 0);
        CDinfo.add(CDemail, 0, 1);
        CDinfo.add(CDemailinput, 1, 1);
        contact.getChildren().addAll(CDlabel, CDinfo);

        //Location
        VBox location = new VBox();
        Label Llabel = new Label("Address");
        GridPane Linfo = new GridPane();
        location.setSpacing(8);
        Llabel.setFont(Font.font("Times New Roman",FontWeight.BOLD,32));
        Linfo.setHgap(5);Linfo.setVgap(5);


        Label Lhouse = new Label("H.No: ");
        TextField Lhouseinput = new TextField();
        Label LStreet = new Label("Street: ");
        TextField LStreetInput = new TextField();
        Label LCity = new Label("City: ");
        TextField LCityInput = new TextField();
        Label Lpincode = new Label("Pin code: ");
        TextField Lpincodeinput = new TextField();
        Label LCountry = new Label("Country: ");
        TextField LCountryinput = new TextField();

        Linfo.add(Lhouse, 0, 0);
        Linfo.add(Lhouseinput, 1, 0);
        Linfo.add(LStreet, 0, 1);
        Linfo.add(LStreetInput, 1, 1);
        Linfo.add(LCity, 0, 2);
        Linfo.add(LCityInput, 1, 2);
        Linfo.add(Lpincode, 0, 3);
        Linfo.add(Lpincodeinput, 1, 3);
        Linfo.add(LCountry, 0, 4);
        Linfo.add(LCountryinput, 1, 4);
        location.getChildren().addAll(Llabel, Linfo);


        //Guardian Details
        VBox guardian = new VBox();
        Label Glabel = new Label("Guardian Details");
        GridPane Ginfo = new GridPane();
        guardian.setSpacing(8);
        Glabel.setFont(Font.font("Times New Roman",FontWeight.BOLD,32));
        Ginfo.setHgap(5);Ginfo.setVgap(5);


        Label Gfname = new Label("Father's Name");
        TextField Gfnameinput = new TextField();
        Label Gmname = new Label("Mother's Name");
        TextField Gmnameinput = new TextField();
        Label Gfnumber = new Label("Father's number");
        TextField Gfnumberinput = new TextField();
        Label Gmnumber = new Label("Mother's number");
        TextField Gmnumberinput = new TextField();
        Label Gfoccupation = new Label("Father's Occupation");
        TextField Gfoccupationinput = new TextField();
        Label Gmoccupation = new Label("Mother's Occupation");
        TextField Gmoccupationinput = new TextField();

        Ginfo.add(Gfname, 0, 0);
        Ginfo.add(Gfnameinput, 1, 0);
        Ginfo.add(Gmname, 0, 1);
        Ginfo.add(Gmnameinput, 1, 1);
        Ginfo.add(Gfnumber, 0, 2);
        Ginfo.add(Gfnumberinput, 1, 2);
        Ginfo.add(Gmnumber, 0, 3);
        Ginfo.add(Gmnumberinput, 1, 3);
        Ginfo.add(Gfoccupation, 0, 4);
        Ginfo.add(Gfoccupationinput, 1, 4);
        Ginfo.add(Gmoccupation, 0, 5);
        Ginfo.add(Gmoccupationinput, 1, 5);
        guardian.getChildren().addAll(Glabel, Ginfo);


        VBox PIleft = new VBox();
        PIleft.getChildren().addAll(about, contact, location);
        PIleft.setSpacing(12);PIleft.setPadding(new Insets(25,25,25,25));

        VBox PIright = new VBox();
        PIright.getChildren().addAll(guardian);
        PIright.setSpacing(12);PIright.setPadding(new Insets(25,25,25,25));

        HBox PI = new HBox(PIleft, PIright);
        PI.setAlignment(Pos.CENTER);PI.setSpacing(r.getWidth()*0.2);
        //PI.setAlignment(Pos.TOP_LEFT);
        PI.setStyle("-fx-background-color:linear-gradient(to right, #77a1d3, #79cbca, #e684ae);");
        //B1.setStyle("-fx-background-color:linear-gradient(#ffd65b, #e68400), linear-gradient(#ffef84, #f2ba44), linear-gradient(#ffea6a, #efaa22), linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%), linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0)); -fx-background-radius: 30;-fx-background-insets: 0,1,2,3,0;-fx-text-fill: #654b00;-fx-font-weight: bold;-fx-font-size: 12px;-fx-padding: 5 7 5 7;");
        /* fallback for old browsers */
//        background: -webkit-linear-gradient(to right, #E5E5BE, #003973);  /* Chrome 10-25, Safari 5.1-6 */
//        background: linear-gradient(to right, #E5E5BE, #003973); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */


        PI.setMinSize(r.getWidth()*0.9,r.getHeight()*0.9);
        ScrollPane SPI=new ScrollPane(PI);
        BorderPane PIfinal = new BorderPane();


        HBox PIbottom = new HBox();
        Button PInext = new Button("Next");PInext.setStyle("-fx-background-color:rgba(0,0,0,0.08), linear-gradient(#9a9a9a, #909090), linear-gradient(white 0%, #f3f3f3 50%, #ececec 51%, #f2f2f2 100%); -fx-background-insets: 0 0 -1 0,0,1;-fx-background-radius: 5,5,4;-fx-padding: 3 30 3 30;-fx-text-fill: #242d35;-fx-font-size: 14px;");
        Button PIback = new Button("Back");PIback.setStyle("-fx-background-color:rgba(0,0,0,0.08), linear-gradient(#9a9a9a, #909090), linear-gradient(white 0%, #f3f3f3 50%, #ececec 51%, #f2f2f2 100%); -fx-background-insets: 0 0 -1 0,0,1;-fx-background-radius: 5,5,4;-fx-padding: 3 30 3 30;-fx-text-fill: #242d35;-fx-font-size: 14px;");
        Button PIsave = new Button("Save changes");PIsave.setStyle("-fx-background-color:rgba(0,0,0,0.08), linear-gradient(#9a9a9a, #909090), linear-gradient(white 0%, #f3f3f3 50%, #ececec 51%, #f2f2f2 100%); -fx-background-insets: 0 0 -1 0,0,1;-fx-background-radius: 5,5,4;-fx-padding: 3 30 3 30;-fx-text-fill: #242d35;-fx-font-size: 14px;");



        PIbottom.getChildren().addAll(PIback, PIsave, PInext);
        PIbottom.setAlignment(Pos.CENTER);PIbottom.setSpacing(r.getWidth()*0.02);
        PIbottom.setStyle("-fx-background-color: black");
        PIbottom.setPadding(new Insets(10,10,10,10));

        PIfinal.setCenter(SPI);
        PIfinal.setBottom(PIbottom);
        scene1 = new Scene(PIfinal, 0.90 * r.getWidth(), 0.90 * r.getHeight());


//Scene of Education
        //College
        VBox university = new VBox();
        Label Ulabel = new Label("Professional degrees");
        Button addcompany = new Button("+");
        HBox Uhead = new HBox(Ulabel, addcompany);
        GridPane Uinfo = new GridPane();
        university.setSpacing(8);
        Ulabel.setFont(Font.font("Times New Roman",FontWeight.BOLD,32));
        Uinfo.setHgap(5);Uinfo.setVgap(5);



        ArrayList<Label> Ularray1 = new ArrayList<>();
        ArrayList<TextField> Utarray1 = new ArrayList<>();
        ArrayList<Label> Ularray2 = new ArrayList<>();
        ArrayList<TextField> Utarray2 = new ArrayList<>();
        ArrayList<Label> Ularray3 = new ArrayList<>();
        ArrayList<TextField> Utarray3 = new ArrayList<>();
        ArrayList<Label> Ularray4 = new ArrayList<>();
        ArrayList<TextField> Utarray4 = new ArrayList<>();
        ArrayList<Label> Ularray5 = new ArrayList<>();
        ArrayList<TextField> Utarray5 = new ArrayList<>();

        addcompany.setOnAction(e -> {
            Ularray1.add(new Label("Degree"));
            Utarray1.add(new TextField());
            Ularray2.add(new Label("Instituion "));
            Utarray2.add(new TextField());
            Ularray3.add(new Label("Board"));
            Utarray3.add(new TextField());
            Ularray4.add(new Label("CGPA/Percentage"));
            Utarray4.add(new TextField());
            Ularray5.add(new Label("Year Passed:"));
            Utarray5.add(new TextField());


            Uinfo.add(Ularray1.get(Ularray1.size() - 1), 0, (Ularray1.size() - 1) * 5);
            Uinfo.add(Utarray1.get(Utarray1.size() - 1), 1, (Utarray1.size() - 1) * 5);
            Uinfo.add(Ularray2.get(Ularray2.size() - 1), 0, (Ularray2.size() - 1) * 5 + 1);
            Uinfo.add(Utarray2.get(Utarray2.size() - 1), 1, (Utarray2.size() - 1) * 5 + 1);
            Uinfo.add(Ularray3.get(Ularray3.size() - 1), 0, (Ularray3.size() - 1) * 5 + 2);
            Uinfo.add(Utarray3.get(Utarray3.size() - 1), 1, (Utarray3.size() - 1) * 5 + 2);
            Uinfo.add(Ularray4.get(Ularray4.size() - 1), 0, (Ularray4.size() - 1) * 5 + 3);
            Uinfo.add(Utarray4.get(Utarray4.size() - 1), 1, (Utarray4.size() - 1) * 5 + 3);
            Uinfo.add(Ularray5.get(Ularray5.size() - 1), 0, (Ularray5.size() - 1) * 5 + 4);
            Uinfo.add(Utarray5.get(Utarray5.size() - 1), 1, (Utarray5.size() - 1) * 5 + 4);

        });


        university.getChildren().addAll(Uhead, Uinfo);


        //Twelvth
        VBox twelvth = new VBox();
        Label TWlabel = new Label("12th class");
        GridPane TWinfo = new GridPane();
        twelvth.setSpacing(8);
        TWlabel.setFont(Font.font("Times New Roman",FontWeight.BOLD,32));
        TWinfo.setHgap(5);TWinfo.setVgap(5);


        Label TWschool = new Label("School Name:");
        TextField TWschoolinput = new TextField();
        Label TWboard = new Label("Board Name");
        TextField TWboardinput = new TextField();
        Label TWyear = new Label("Year Passed");
        TextField TWyearinput = new TextField();
        Label TWpercentage = new Label("Percentage");
        TextField TWpercentageinput = new TextField();

        TWinfo.add(TWschool, 0, 0);
        TWinfo.add(TWschoolinput, 1, 0);
        TWinfo.add(TWboard, 0, 1);
        TWinfo.add(TWboardinput, 1, 1);
        TWinfo.add(TWpercentage, 0, 2);
        TWinfo.add(TWpercentageinput, 1, 2);
        TWinfo.add(TWyear, 0, 3);
        TWinfo.add(TWyearinput, 1, 3);
        twelvth.getChildren().addAll(TWlabel, TWinfo);


        //Tenth
        VBox tenth = new VBox();
        Label TElabel = new Label("10th class");
        GridPane TEinfo = new GridPane();
        tenth.setSpacing(8);
        TElabel.setFont(Font.font("Times New Roman",FontWeight.BOLD,32));
        TEinfo.setHgap(5);TEinfo.setVgap(5);


        Label TEschool = new Label("School Name:");
        TextField TEschoolinput = new TextField();
        Label TEboard = new Label("Board Name");
        TextField TEboardinput = new TextField();
        Label TEyear = new Label("Year Passed");
        TextField TEyearinput = new TextField();
        Label TEpercentage = new Label("Percentage");
        TextField TEpercentageinput = new TextField();

        TEinfo.add(TEschool, 0, 0);
        TEinfo.add(TEschoolinput, 1, 0);
        TEinfo.add(TEboard, 0, 1);
        TEinfo.add(TEboardinput, 1, 1);
        TEinfo.add(TEpercentage, 0, 2);
        TEinfo.add(TEpercentageinput, 1, 2);
        TEinfo.add(TEyear, 0, 3);
        TEinfo.add(TEyearinput, 1, 3);
        tenth.getChildren().addAll(TElabel, TEinfo);


        VBox EEleft = new VBox();
        EEleft.getChildren().addAll(twelvth, tenth);EEleft.setSpacing(12);EEleft.setPadding(new Insets(25,25,25,25));
        VBox EEright = new VBox();
        EEright.getChildren().addAll(university);EEright.setSpacing(12);EEright.setPadding(new Insets(25,25,25,25));
        HBox EE = new HBox(EEleft, EEright);
        EE.setAlignment(Pos.CENTER);
        EE.setSpacing(r.getWidth()*0.2);
        EE.setMinSize(r.getWidth()*0.9,r.getHeight()*0.9);
        EE.setStyle("-fx-background-color:linear-gradient(to right, #77a1d3, #79cbca, #e684ae);");
        ScrollPane SEE=new ScrollPane(EE);

        BorderPane EEfinal = new BorderPane();
        HBox EEbottom = new HBox();
        Button EEnext = new Button("Next");EEnext.setStyle("-fx-background-color:rgba(0,0,0,0.08), linear-gradient(#9a9a9a, #909090), linear-gradient(white 0%, #f3f3f3 50%, #ececec 51%, #f2f2f2 100%); -fx-background-insets: 0 0 -1 0,0,1;-fx-background-radius: 5,5,4;-fx-padding: 3 30 3 30;-fx-text-fill: #242d35;-fx-font-size: 14px;");
        Button EEback = new Button("Back");EEback.setStyle("-fx-background-color:rgba(0,0,0,0.08), linear-gradient(#9a9a9a, #909090), linear-gradient(white 0%, #f3f3f3 50%, #ececec 51%, #f2f2f2 100%); -fx-background-insets: 0 0 -1 0,0,1;-fx-background-radius: 5,5,4;-fx-padding: 3 30 3 30;-fx-text-fill: #242d35;-fx-font-size: 14px;");
        Button EEsave = new Button("Save changes");EEsave.setStyle("-fx-background-color:rgba(0,0,0,0.08), linear-gradient(#9a9a9a, #909090), linear-gradient(white 0%, #f3f3f3 50%, #ececec 51%, #f2f2f2 100%); -fx-background-insets: 0 0 -1 0,0,1;-fx-background-radius: 5,5,4;-fx-padding: 3 30 3 30;-fx-text-fill: #242d35;-fx-font-size: 14px;");


        EEbottom.getChildren().addAll(EEback, EEsave, EEnext);
        EEbottom.setAlignment(Pos.CENTER);EEbottom.setSpacing(r.getWidth()*0.02);
        EEbottom.setStyle("-fx-background-color: black");
        EEbottom.setPadding(new Insets(10,10,10,10));

        EEfinal.setCenter(SEE);
        EEfinal.setBottom(EEbottom);


        scene2 = new Scene(EEfinal, 0.90 * r.getWidth(), 0.90 * r.getHeight());


        //Scene of Experience information
        //Company
        VBox company = new VBox();
        Label Clabel = new Label("Company");
        Button addcompanies = new Button("+");
        HBox Chead = new HBox(Clabel, addcompanies);
        GridPane Cinfo = new GridPane();
        company.setSpacing(8);
        Clabel.setFont(Font.font("Times New Roman",FontWeight.BOLD,32));
        Cinfo.setHgap(5);Cinfo.setVgap(5);



        ArrayList<Label> Clarray1 = new ArrayList<>();
        ArrayList<TextField> Ctarray1 = new ArrayList<>();
        ArrayList<Label> Clarray2 = new ArrayList<>();
        ArrayList<TextField> Ctarray2 = new ArrayList<>();
        ArrayList<Label> Clarray3 = new ArrayList<>();
        ArrayList<TextField> Ctarray3 = new ArrayList<>();
        ArrayList<Label> Clarray4 = new ArrayList<>();
        ArrayList<TextField> Ctarray4 = new ArrayList<>();
        ArrayList<Label> Clarray5 = new ArrayList<>();
        ArrayList<TextArea> Ctarray5 = new ArrayList<>();


        addcompanies.setOnAction(e -> {
            Clarray1.add(new Label("Company Name"));
            Ctarray1.add(new TextField());
            Clarray2.add(new Label("Position"));
            Ctarray2.add(new TextField());
            Clarray3.add(new Label("Period (in years)"));
            Ctarray3.add(new TextField());
            Clarray4.add(new Label("Salary"));
            Ctarray4.add(new TextField());
            Clarray5.add(new Label("Description :"));
            Ctarray5.add(new TextArea());

            Ctarray5.get(Ctarray5.size() - 1).setPrefWidth(200);
            Ctarray5.get(Ctarray5.size() - 1).setPrefHeight(75);


            Cinfo.add(Clarray1.get(Clarray1.size() - 1), 0, (Clarray1.size() - 1) * 5);
            Cinfo.add(Ctarray1.get(Ctarray1.size() - 1), 1, (Ctarray1.size() - 1) * 5);
            Cinfo.add(Clarray2.get(Clarray2.size() - 1), 0, (Clarray2.size() - 1) * 5 + 1);
            Cinfo.add(Ctarray2.get(Ctarray2.size() - 1), 1, (Ctarray2.size() - 1) * 5 + 1);
            Cinfo.add(Clarray3.get(Clarray3.size() - 1), 0, (Clarray3.size() - 1) * 5 + 2);
            Cinfo.add(Ctarray3.get(Ctarray3.size() - 1), 1, (Ctarray3.size() - 1) * 5 + 2);
            Cinfo.add(Clarray4.get(Clarray4.size() - 1), 0, (Clarray4.size() - 1) * 5 + 3);
            Cinfo.add(Ctarray4.get(Ctarray4.size() - 1), 1, (Ctarray4.size() - 1) * 5 + 3);
            Cinfo.add(Clarray5.get(Clarray5.size() - 1), 0, (Clarray5.size() - 1) * 5 + 4);
            Cinfo.add(Ctarray5.get(Ctarray5.size() - 1), 1, (Ctarray5.size() - 1) * 5 + 4);

        });

        company.getChildren().addAll(Chead, Cinfo);


        //Internship
        VBox internship = new VBox();
        Label Ilabel = new Label("Internship");
        Button addinternship = new Button("+");
        GridPane Iinfo = new GridPane();
        HBox Ihead = new HBox(Ilabel, addinternship);
        internship.setSpacing(8);
        Ilabel.setFont(Font.font("Times New Roman",FontWeight.BOLD,32));
        Iinfo.setHgap(5);Iinfo.setVgap(5);



        ArrayList<Label> Ilarray1 = new ArrayList<>();
        ArrayList<TextField> Itarray1 = new ArrayList<>();
        ArrayList<Label> Ilarray2 = new ArrayList<>();
        ArrayList<TextField> Itarray2 = new ArrayList<>();
        ArrayList<Label> Ilarray3 = new ArrayList<>();
        ArrayList<TextField> Itarray3 = new ArrayList<>();
        ArrayList<Label> Ilarray4 = new ArrayList<>();
        ArrayList<TextField> Itarray4 = new ArrayList<>();
        ArrayList<Label> Ilarray5 = new ArrayList<>();
        ArrayList<TextArea> Itarray5 = new ArrayList<>();


        addinternship.setOnAction(e -> {
            Ilarray1.add(new Label("Company Name"));
            Itarray1.add(new TextField());
            Ilarray2.add(new Label("Position"));
            Itarray2.add(new TextField());
            Ilarray3.add(new Label("Period"));
            Itarray3.add(new TextField());
            Ilarray4.add(new Label("Stipend"));
            Itarray4.add(new TextField());
            Ilarray5.add(new Label("Description :"));
            Itarray5.add(new TextArea());

            Itarray5.get(Itarray5.size() - 1).setPrefWidth(200);
            Itarray5.get(Itarray5.size() - 1).setPrefHeight(75);


            Iinfo.add(Ilarray1.get(Ilarray1.size() - 1), 0, (Ilarray1.size() - 1) * 5);
            Iinfo.add(Itarray1.get(Itarray1.size() - 1), 1, (Itarray1.size() - 1) * 5);
            Iinfo.add(Ilarray2.get(Ilarray2.size() - 1), 0, (Ilarray2.size() - 1) * 5 + 1);
            Iinfo.add(Itarray2.get(Itarray2.size() - 1), 1, (Itarray2.size() - 1) * 5 + 1);
            Iinfo.add(Ilarray3.get(Ilarray3.size() - 1), 0, (Ilarray3.size() - 1) * 5 + 2);
            Iinfo.add(Itarray3.get(Itarray3.size() - 1), 1, (Itarray3.size() - 1) * 5 + 2);
            Iinfo.add(Ilarray4.get(Ilarray4.size() - 1), 0, (Ilarray4.size() - 1) * 5 + 3);
            Iinfo.add(Itarray4.get(Itarray4.size() - 1), 1, (Itarray4.size() - 1) * 5 + 3);
            Iinfo.add(Ilarray5.get(Ilarray5.size() - 1), 0, (Ilarray5.size() - 1) * 5 + 4);
            Iinfo.add(Itarray5.get(Itarray5.size() - 1), 1, (Itarray5.size() - 1) * 5 + 4);

        });

        internship.getChildren().addAll(Ihead, Iinfo);


        VBox EXleft = new VBox();
        EXleft.getChildren().addAll(company);EXleft.setSpacing(12);EXleft.setPadding(new Insets(25,25,25,25));
        VBox EXright = new VBox();
        EXright.getChildren().addAll(internship);EXright.setSpacing(12);EXright.setPadding(new Insets(25,25,25,25));
        HBox EX = new HBox(EXleft, EXright);
        EX.setAlignment(Pos.CENTER);
        EX.setSpacing(r.getWidth()*0.2);
        EX.setMinSize(r.getWidth()*0.9,r.getHeight()*0.9);
        EX.setStyle("-fx-background-color:linear-gradient(to right, #77a1d3, #79cbca, #e684ae);");
        ScrollPane SEX=new ScrollPane(EX);
        BorderPane EXfinal = new BorderPane();
        HBox EXbottom = new HBox();
        Button EXnext = new Button("Next");EXnext.setStyle("-fx-background-color:rgba(0,0,0,0.08), linear-gradient(#9a9a9a, #909090), linear-gradient(white 0%, #f3f3f3 50%, #ececec 51%, #f2f2f2 100%); -fx-background-insets: 0 0 -1 0,0,1;-fx-background-radius: 5,5,4;-fx-padding: 3 30 3 30;-fx-text-fill: #242d35;-fx-font-size: 14px;");
        Button EXback = new Button("Back");EXback.setStyle("-fx-background-color:rgba(0,0,0,0.08), linear-gradient(#9a9a9a, #909090), linear-gradient(white 0%, #f3f3f3 50%, #ececec 51%, #f2f2f2 100%); -fx-background-insets: 0 0 -1 0,0,1;-fx-background-radius: 5,5,4;-fx-padding: 3 30 3 30;-fx-text-fill: #242d35;-fx-font-size: 14px;");
        Button EXsave = new Button("Save changes");EXsave.setStyle("-fx-background-color:rgba(0,0,0,0.08), linear-gradient(#9a9a9a, #909090), linear-gradient(white 0%, #f3f3f3 50%, #ececec 51%, #f2f2f2 100%); -fx-background-insets: 0 0 -1 0,0,1;-fx-background-radius: 5,5,4;-fx-padding: 3 30 3 30;-fx-text-fill: #242d35;-fx-font-size: 14px;");
        EXbottom.getChildren().addAll(EXback, EXsave, EXnext);
        EXbottom.setAlignment(Pos.CENTER);EXbottom.setSpacing(r.getWidth()*0.02);
        EXbottom.setStyle("-fx-background-color: black");
        EXbottom.setPadding(new Insets(10,10,10,10));


        EXfinal.setCenter(SEX);
        EXfinal.setBottom(EXbottom);


        scene3 = new Scene(EXfinal, 0.90 * r.getWidth(), 0.90 * r.getHeight());


//Projects and positions of responsibility
        //project
        VBox project = new VBox();
        Label Plabel = new Label("Projects");
        Button addproject = new Button("+");
        GridPane Pinfo = new GridPane();
        HBox Phead = new HBox(Plabel, addproject);
        project.setSpacing(8);
        Plabel.setFont(Font.font("Times New Roman",FontWeight.BOLD,32));
        Pinfo.setHgap(5);Pinfo.setVgap(5);


        ArrayList<Label> Plarray1 = new ArrayList<>();
        ArrayList<TextField> Ptarray1 = new ArrayList<>();
        ArrayList<Label> Plarray2 = new ArrayList<>();
        ArrayList<TextField> Ptarray2 = new ArrayList<>();
        ArrayList<Label> Plarray3 = new ArrayList<>();
        ArrayList<TextField> Ptarray3 = new ArrayList<>();
        ArrayList<Label> Plarray4 = new ArrayList<>();
        ArrayList<TextArea> Ptarray4 = new ArrayList<>();


        addproject.setOnAction(e -> {
            Plarray1.add(new Label("Project name"));
            Ptarray1.add(new TextField());
            Plarray2.add(new Label("Project Domain "));
            Ptarray2.add(new TextField());
            Plarray3.add(new Label("Company/Institution"));
            Ptarray3.add(new TextField());
            Plarray4.add(new Label("Description"));
            Ptarray4.add(new TextArea());

            Ptarray4.get(Ptarray4.size() - 1).setPrefWidth(200);
            Ptarray4.get(Ptarray4.size() - 1).setPrefHeight(75);


            Pinfo.add(Plarray1.get(Plarray1.size() - 1), 0, (Plarray1.size() - 1) * 4);
            Pinfo.add(Ptarray1.get(Ptarray1.size() - 1), 1, (Ptarray1.size() - 1) * 4);
            Pinfo.add(Plarray2.get(Plarray2.size() - 1), 0, (Plarray2.size() - 1) * 4 + 1);
            Pinfo.add(Ptarray2.get(Ptarray2.size() - 1), 1, (Ptarray2.size() - 1) * 4 + 1);
            Pinfo.add(Plarray3.get(Plarray3.size() - 1), 0, (Plarray3.size() - 1) * 4 + 2);
            Pinfo.add(Ptarray3.get(Ptarray3.size() - 1), 1, (Ptarray3.size() - 1) * 4 + 2);
            Pinfo.add(Plarray4.get(Plarray4.size() - 1), 0, (Plarray4.size() - 1) * 4 + 3);
            Pinfo.add(Ptarray4.get(Ptarray4.size() - 1), 1, (Ptarray4.size() - 1) * 4 + 3);
        });


        project.getChildren().addAll(Phead, Pinfo);


        //Position and resposibilities
        VBox positionandresponsibilities = new VBox();
        Label PRlabel = new Label("Positions and responsibilities");
        GridPane PRinfo = new GridPane();
        Button addresponsibilities = new Button("+");
        HBox PRhead = new HBox(PRlabel, addresponsibilities);
        positionandresponsibilities.setSpacing(8);
        PRlabel.setFont(Font.font("Times New Roman",FontWeight.BOLD,32));
        PRinfo.setHgap(5);PRinfo.setVgap(5);


        ArrayList<Label> PRlarray1 = new ArrayList<>();
        ArrayList<TextField> PRtarray1 = new ArrayList<>();
        ArrayList<Label> PRlarray2 = new ArrayList<>();
        ArrayList<TextField> PRtarray2 = new ArrayList<>();
        ArrayList<Label> PRlarray3 = new ArrayList<>();
        ArrayList<TextArea> PRtarray3 = new ArrayList<>();


        addresponsibilities.setOnAction(e -> {
            PRlarray1.add(new Label("Position name "));
            PRtarray1.add(new TextField());
            PRlarray2.add(new Label("Position held at "));
            PRtarray2.add(new TextField());
            PRlarray3.add(new Label("Position description"));
            PRtarray3.add(new TextArea());

            PRtarray3.get(PRtarray3.size() - 1).setPrefWidth(200);
            PRtarray3.get(PRtarray3.size() - 1).setPrefHeight(75);


            PRinfo.add(PRlarray1.get(PRlarray1.size() - 1), 0, (PRlarray1.size() - 1) * 3);
            PRinfo.add(PRtarray1.get(PRtarray1.size() - 1), 1, (PRtarray1.size() - 1) * 3);
            PRinfo.add(PRlarray2.get(PRlarray2.size() - 1), 0, (PRlarray2.size() - 1) * 3 + 1);
            PRinfo.add(PRtarray2.get(PRtarray2.size() - 1), 1, (PRtarray2.size() - 1) * 3 + 1);
            PRinfo.add(PRlarray3.get(PRlarray3.size() - 1), 0, (PRlarray3.size() - 1) * 3 + 2);
            PRinfo.add(PRtarray3.get(PRtarray3.size() - 1), 1, (PRtarray3.size() - 1) * 3 + 2);
        });


        positionandresponsibilities.getChildren().addAll(PRhead, PRinfo);

        VBox PPRleft = new VBox();
        PPRleft.getChildren().addAll(project);PPRleft.setSpacing(12);PPRleft.setPadding(new Insets(25,25,25,25));
        VBox PPRright = new VBox();
        PPRright.getChildren().addAll(positionandresponsibilities);PPRright.setSpacing(12);PPRright.setPadding(new Insets(25,25,25,25));
        HBox PPR = new HBox(PPRleft, PPRright);
        PPR.setAlignment(Pos.CENTER);
        PPR.setSpacing(r.getWidth()*0.2);
        PPR.setMinSize(r.getWidth()*0.9,r.getHeight()*0.9);
        PPR.setStyle("-fx-background-color:linear-gradient(to right, #77a1d3, #79cbca, #e684ae);");
        ScrollPane SPPR=new ScrollPane(PPR);
        BorderPane PPRfinal = new BorderPane();
        HBox PPRbottom = new HBox();
        Button PPRnext = new Button("Next");PPRnext.setStyle("-fx-background-color:rgba(0,0,0,0.08), linear-gradient(#9a9a9a, #909090), linear-gradient(white 0%, #f3f3f3 50%, #ececec 51%, #f2f2f2 100%); -fx-background-insets: 0 0 -1 0,0,1;-fx-background-radius: 5,5,4;-fx-padding: 3 30 3 30;-fx-text-fill: #242d35;-fx-font-size: 14px;");
        Button PPRback = new Button("Back");PPRback.setStyle("-fx-background-color:rgba(0,0,0,0.08), linear-gradient(#9a9a9a, #909090), linear-gradient(white 0%, #f3f3f3 50%, #ececec 51%, #f2f2f2 100%); -fx-background-insets: 0 0 -1 0,0,1;-fx-background-radius: 5,5,4;-fx-padding: 3 30 3 30;-fx-text-fill: #242d35;-fx-font-size: 14px;");
        Button PPRsave = new Button("Save changes");PPRsave.setStyle("-fx-background-color:rgba(0,0,0,0.08), linear-gradient(#9a9a9a, #909090), linear-gradient(white 0%, #f3f3f3 50%, #ececec 51%, #f2f2f2 100%); -fx-background-insets: 0 0 -1 0,0,1;-fx-background-radius: 5,5,4;-fx-padding: 3 30 3 30;-fx-text-fill: #242d35;-fx-font-size: 14px;");
        PPRbottom.getChildren().addAll(PPRback, PPRsave, PPRnext);
        PPRbottom.setAlignment(Pos.CENTER);PPRbottom.setSpacing(r.getWidth()*0.02);
        PPRbottom.setStyle("-fx-background-color: black");
        PPRbottom.setPadding(new Insets(10,10,10,10));

        PPRfinal.setCenter(SPPR);
        PPRfinal.setBottom(PPRbottom);


        scene4 = new Scene(PPRfinal, 0.90 * r.getWidth(), 0.90 * r.getHeight());
        //Skills and Extra curricular
        //Skills
        VBox skills = new VBox();
        Label Slabel = new Label("Skills ");
        GridPane Sinfo = new GridPane();
        Button addskill = new Button("+");
        HBox Shead = new HBox(Slabel, addskill);
        skills.setSpacing(8);
        Slabel.setFont(Font.font("Times New Roman",FontWeight.BOLD,32));
        Sinfo.setHgap(5);Sinfo.setVgap(5);



        ArrayList<Label> Slarray1 = new ArrayList<>();
        ArrayList<TextField> Starray1 = new ArrayList<>();
        ArrayList<Label> Slarray2 = new ArrayList<>();
        ArrayList<TextField> Starray2 = new ArrayList<>();


        addskill.setOnAction(e -> {
            Slarray1.add(new Label("Skill name"));
            Starray1.add(new TextField());
            Slarray2.add(new Label("Proficiency(0-10)"));
            Starray2.add(new TextField());
            Sinfo.add(Slarray1.get(Slarray1.size() - 1), 0, (Slarray1.size() - 1) * 2);
            Sinfo.add(Starray1.get(Starray1.size() - 1), 1, (Starray1.size() - 1) * 2);
            Sinfo.add(Slarray2.get(Slarray2.size() - 1), 0, (Slarray2.size() - 1) * 2 + 1);
            Sinfo.add(Starray2.get(Starray2.size() - 1), 1, (Starray2.size() - 1) * 2 + 1);
        });

        skills.getChildren().addAll(Shead, Sinfo);

        //Extracurricular
        VBox extracurricular = new VBox();
        Label ECAlabel = new Label("Extra Curricular Activities");
        GridPane ECAinfo = new GridPane();
        Button addECA = new Button("+");
        HBox ECAhead = new HBox(ECAlabel, addECA);
        extracurricular.setSpacing(8);
        ECAlabel.setFont(Font.font("Times New Roman",FontWeight.BOLD,32));
        ECAinfo.setHgap(5);ECAinfo.setVgap(5);



        ArrayList<Label> ECAlarray1 = new ArrayList<>();
        ArrayList<TextField> ECAtarray1 = new ArrayList<>();
        ArrayList<Label> ECAlarray2 = new ArrayList<>();
        ArrayList<TextArea> ECAtarray2 = new ArrayList<>();


        addECA.setOnAction(e -> {
            ECAlarray1.add(new Label("ECA name"));
            ECAtarray1.add(new TextField());
            ECAlarray2.add(new Label("ECA decription"));
            ECAtarray2.add(new TextArea());

            ECAtarray2.get(ECAtarray2.size() - 1).setPrefWidth(200);
            ECAtarray2.get(ECAtarray2.size() - 1).setPrefHeight(75);

            ECAinfo.add(ECAlarray1.get(ECAlarray1.size() - 1), 0, (ECAlarray1.size() - 1) * 2);
            ECAinfo.add(ECAtarray1.get(ECAtarray1.size() - 1), 1, (ECAtarray1.size() - 1) * 2);
            ECAinfo.add(ECAlarray2.get(ECAlarray2.size() - 1), 0, (ECAlarray2.size() - 1) * 2 + 1);
            ECAinfo.add(ECAtarray2.get(ECAtarray2.size() - 1), 1, (ECAtarray2.size() - 1) * 2 + 1);
        });


        extracurricular.getChildren().addAll(ECAhead, ECAinfo);

        VBox SECAleft = new VBox();
        SECAleft.getChildren().addAll(skills);SECAleft.setSpacing(12);SECAleft.setPadding(new Insets(25,25,25,25));
        VBox SECAright = new VBox();
        SECAright.getChildren().addAll(extracurricular);SECAright.setSpacing(12);SECAright.setPadding(new Insets(25,25,25,25));
        HBox SECA = new HBox(SECAleft, SECAright);
        SECA.setAlignment(Pos.CENTER);
        SECA.setSpacing(r.getWidth()*0.2);
        SECA.setMinSize(r.getWidth()*0.9,r.getHeight()*0.9);
        SECA.setStyle("-fx-background-color:linear-gradient(to right, #77a1d3, #79cbca, #e684ae);");
        ScrollPane SSECA=new ScrollPane(SECA);
        BorderPane SECAfinal = new BorderPane();
        HBox SECAbottom = new HBox();
        Button SECAnext = new Button("Next");SECAnext.setStyle("-fx-background-color:rgba(0,0,0,0.08), linear-gradient(#9a9a9a, #909090), linear-gradient(white 0%, #f3f3f3 50%, #ececec 51%, #f2f2f2 100%); -fx-background-insets: 0 0 -1 0,0,1;-fx-background-radius: 5,5,4;-fx-padding: 3 30 3 30;-fx-text-fill: #242d35;-fx-font-size: 14px;");
        Button SECAback = new Button("Back");SECAback.setStyle("-fx-background-color:rgba(0,0,0,0.08), linear-gradient(#9a9a9a, #909090), linear-gradient(white 0%, #f3f3f3 50%, #ececec 51%, #f2f2f2 100%); -fx-background-insets: 0 0 -1 0,0,1;-fx-background-radius: 5,5,4;-fx-padding: 3 30 3 30;-fx-text-fill: #242d35;-fx-font-size: 14px;");
        Button SECAsave = new Button("Save changes");SECAsave.setStyle("-fx-background-color:rgba(0,0,0,0.08), linear-gradient(#9a9a9a, #909090), linear-gradient(white 0%, #f3f3f3 50%, #ececec 51%, #f2f2f2 100%); -fx-background-insets: 0 0 -1 0,0,1;-fx-background-radius: 5,5,4;-fx-padding: 3 30 3 30;-fx-text-fill: #242d35;-fx-font-size: 14px;");
        SECAbottom.getChildren().addAll(SECAback, SECAsave, SECAnext);
        SECAbottom.setAlignment(Pos.CENTER);SECAbottom.setSpacing(r.getWidth()*0.02);
        SECAbottom.setStyle("-fx-background-color: black");
        SECAbottom.setPadding(new Insets(10,10,10,10));
        SECAfinal.setCenter(SSECA);
        SECAfinal.setBottom(SECAbottom);


        scene5 = new Scene(SECAfinal, 0.90 * r.getWidth(), 0.90 * r.getHeight());


//Button Actions on Onlogin Page
        B1.setOnAction(e -> {
            primaryStage.setScene(scene1);
        });
        B2.setOnAction(e -> {
            primaryStage.setScene(scene2);
        });
        B3.setOnAction(e -> {
            primaryStage.setScene(scene3);
        });
        B4.setOnAction(e -> {
            primaryStage.setScene(scene4);
        });
        B5.setOnAction(e -> {
            primaryStage.setScene(scene5);
        });


        bSignUp.setOnAction(e -> {
            Temail.setText("");
            pass1.setText("");
            pass2.setText("");
            username.setText("");
            password.setText("");
            Lmsg.setText("");
            primaryStage.setScene(signup);
        });


        bRegister.setOnAction(e -> {
            String email = Temail.getText();
            String p1 = pass1.getText();
            String p2 = pass2.getText();

            try {
                if (email.contains("@gmail.com")) {
                    if (p1.length() > 0 && p2.length() > 0) {

                        if (p1.equals(p2)) {
                            String sql2 = "select username from credentials";
                            ResultSet rs = stmt.executeQuery(sql2);
                            boolean profileCheck = TRUE;

                            //while to check if user already registered
                            while (profileCheck && rs.next()) {
                                if (rs.getString("username").equals(email))
                                    profileCheck = FALSE;
                            }

                            //if not registered then
                            if (profileCheck) {
                                String sql1 = "Insert into credentials(username,password) values('" + email + "','" + p1 + "')";
                                System.out.println(sql1);
                                stmt.executeUpdate(sql1);
                                primaryStage.setScene(login);
                                Smsg.setText("");
                            } else {
                                Smsg.setText("email already registered");
                                System.out.println("user already registered");
                            }

                        } else {
                            Smsg.setText("password confirmation failed");
                            System.out.println("Check password");
                        }
                    } else {
                        Smsg.setText("enter a paassword");
                        System.out.println("Enter a valid password");
                    }
                } else {
                    Smsg.setText("invalid email");
                    System.out.println("Please enter a valid email");
                }
            } catch (SQLException a) {
                a.printStackTrace();
            }

        });

        bLogin.setOnAction(e -> {
            if(username.getText().contains("@gmail.com")){
                boolean checkuser = FALSE;
                try {
                    String email = username.getText();
                    String pass = password.getText();
                    ResultSet rs = stmt.executeQuery("select * from credentials where username = '" + email + "'");

                    while (rs.next()) {
                        if (rs.getString("username").equals(email)) {
                            U_id = rs.getInt(1);
                            System.out.println("userID: " + U_id);
                            checkuser = TRUE;
                            break;
                        }
                    }
                    rs.absolute(1);
                    if (checkuser && rs.getString("password").equals(pass)) {
                        primaryStage.setScene(sc);
                        Lmsg.setText("");
                    } else if (checkuser && !rs.getString("password").equals(pass)) {
                        Lmsg.setText("Incorrect password");
                        System.out.println("Incorrect password");
                    } else {
                        Lmsg.setText("Signup first!");
                        System.out.println("User not registered");
                    }

                } catch (SQLException exception) {
                    exception.printStackTrace();
                }

                if (checkuser) {
                    try {
                        String fetchSQL = "Select * from personaldetails where UID = " + U_id;
                        ResultSet rs = stmt.executeQuery(fetchSQL);

                        if (rs.next()) {
                            AFnameinput.setText(rs.getString(2));
                            ALnameinput.setText(rs.getString(3));
                            ADOBinput.setText(rs.getString("DOB"));
                            Agenderinput.setText(rs.getString("gender"));
                            Acategoryinput.setText(rs.getString("category"));
                            CDemailinput.setText(rs.getString("email"));
                            CDmobileinput.setText(rs.getString("mobile"));
                            Lhouseinput.setText(rs.getString("HNO"));
                            LStreetInput.setText(rs.getString("Street"));
                            LCityInput.setText(rs.getString("city"));
                            LCountryinput.setText(rs.getString("country"));
                            Lpincodeinput.setText(rs.getString("pincode"));
                        }

                        fetchSQL = "Select * from guardiandetails where UID = " + U_id;
                        rs = stmt.executeQuery(fetchSQL);
                        if (rs.next()) {
                            Gfnameinput.setText(rs.getString(2));
                            Gmnameinput.setText(rs.getString(3));
                            Gfnumberinput.setText(rs.getString(4));
                            Gmnumberinput.setText(rs.getString(5));
                            Gfoccupationinput.setText(rs.getString(6));
                            Gmoccupationinput.setText(rs.getString(7));
                        }

                    } catch (SQLException exception) {
                        exception.getStackTrace();
                    }
                    try {
                        String HSsql = "select * from education where UID = " + U_id + " and degree = '10th'";
                        String ICsql = "select * from education where UID = " + U_id + " and degree = '12th'";
                        String pdSQL = "select * from education where UID = " + U_id + " and degree not in ('12th','10th')";

                        ResultSet HSrs = stmt.executeQuery(HSsql);
                        if (HSrs.next()) {
                            TEschoolinput.setText(HSrs.getString("institution"));
                            TEboardinput.setText(HSrs.getString("board"));
                            TEpercentageinput.setText(HSrs.getString("percentage"));
                            TEyearinput.setText(HSrs.getString("passyear"));
                        }

                        HSrs = stmt.executeQuery(ICsql);
                        if (HSrs.next()) {
                            TWschoolinput.setText(HSrs.getString("institution"));
                            TWboardinput.setText(HSrs.getString("board"));
                            TWpercentageinput.setText(HSrs.getString("percentage"));
                            TWyearinput.setText((HSrs.getString("passyear")));
                        }
                        HSrs = stmt.executeQuery(pdSQL);
                        int count = 0;
                        while (HSrs.next()) {
                            if(HSrs.getString("percentage")!=null){
                                Ularray1.add(new Label("Degree"));
                                Utarray1.add(new TextField());
                                Ularray2.add(new Label("Instituion "));
                                Utarray2.add(new TextField());
                                Ularray3.add(new Label("Board"));
                                Utarray3.add(new TextField());
                                Ularray4.add(new Label("CGPA/Percentage"));
                                Utarray4.add(new TextField());
                                Ularray5.add(new Label("Year Passed:"));
                                Utarray5.add(new TextField());


                                Uinfo.add(Ularray1.get(Ularray1.size() - 1), 0, (Ularray1.size() - 1) * 5);
                                Uinfo.add(Utarray1.get(Utarray1.size() - 1), 1, (Utarray1.size() - 1) * 5);
                                Uinfo.add(Ularray2.get(Ularray2.size() - 1), 0, (Ularray2.size() - 1) * 5 + 1);
                                Uinfo.add(Utarray2.get(Utarray2.size() - 1), 1, (Utarray2.size() - 1) * 5 + 1);
                                Uinfo.add(Ularray3.get(Ularray3.size() - 1), 0, (Ularray3.size() - 1) * 5 + 2);
                                Uinfo.add(Utarray3.get(Utarray3.size() - 1), 1, (Utarray3.size() - 1) * 5 + 2);
                                Uinfo.add(Ularray4.get(Ularray4.size() - 1), 0, (Ularray4.size() - 1) * 5 + 3);
                                Uinfo.add(Utarray4.get(Utarray4.size() - 1), 1, (Utarray4.size() - 1) * 5 + 3);
                                Uinfo.add(Ularray5.get(Ularray5.size() - 1), 0, (Ularray5.size() - 1) * 5 + 4);
                                Uinfo.add(Utarray5.get(Utarray5.size() - 1), 1, (Utarray5.size() - 1) * 5 + 4);

                                Utarray2.get(count).setText(HSrs.getString(2));
                                Utarray1.get(count).setText(HSrs.getString(3));
                                Utarray3.get(count).setText(HSrs.getString(4));
                                Utarray4.get(count).setText(HSrs.getString(5));
                                String date = HSrs.getString("passyear");
                                String[] year = date.split("-", 0);
                                Utarray5.get(count).setText(year[0]);
                            }
                            count++;
                        }


                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    try {
                        String sqlCom = "select * from experience where jType = 'Regular' and UID="+U_id;
                        String sqlInt = "select * from experience where jType = 'Internship' and UID="+U_id;

                        ResultSet rs = stmt.executeQuery(sqlCom);
                        int countCom = 0;
                        while (rs.next()) {
                            Clarray1.add(new Label("Company Name"));
                            Ctarray1.add(new TextField());
                            Clarray2.add(new Label("Position"));
                            Ctarray2.add(new TextField());
                            Clarray3.add(new Label("Period"));
                            Ctarray3.add(new TextField());
                            Clarray4.add(new Label("Salary"));
                            Ctarray4.add(new TextField());
                            Clarray5.add(new Label("Description :"));
                            Ctarray5.add(new TextArea());

                            Ctarray5.get(Ctarray5.size() - 1).setPrefWidth(200);
                            Ctarray5.get(Ctarray5.size() - 1).setPrefHeight(75);

                            Cinfo.add(Clarray1.get(Clarray1.size() - 1), 0, (Clarray1.size() - 1) * 5);
                            Cinfo.add(Ctarray1.get(Ctarray1.size() - 1), 1, (Ctarray1.size() - 1) * 5);
                            Cinfo.add(Clarray2.get(Clarray2.size() - 1), 0, (Clarray2.size() - 1) * 5 + 1);
                            Cinfo.add(Ctarray2.get(Ctarray2.size() - 1), 1, (Ctarray2.size() - 1) * 5 + 1);
                            Cinfo.add(Clarray3.get(Clarray3.size() - 1), 0, (Clarray3.size() - 1) * 5 + 2);
                            Cinfo.add(Ctarray3.get(Ctarray3.size() - 1), 1, (Ctarray3.size() - 1) * 5 + 2);
                            Cinfo.add(Clarray4.get(Clarray4.size() - 1), 0, (Clarray4.size() - 1) * 5 + 3);
                            Cinfo.add(Ctarray4.get(Ctarray4.size() - 1), 1, (Ctarray4.size() - 1) * 5 + 3);
                            Cinfo.add(Clarray5.get(Clarray5.size() - 1), 0, (Clarray5.size() - 1) * 5 + 4);
                            Cinfo.add(Ctarray5.get(Ctarray5.size() - 1), 1, (Ctarray5.size() - 1) * 5 + 4);

                            Ctarray1.get(countCom).setText(rs.getString(2));
                            Ctarray2.get(countCom).setText(rs.getString(3));
                            Ctarray3.get(countCom).setText(rs.getString(4));
                            Ctarray4.get(countCom).setText(rs.getString(6));
                            Ctarray5.get(countCom).setText(rs.getString(7));
                            countCom++;
                        }

                        rs = stmt.executeQuery(sqlInt);
                        int countInt = 0;
                        while (rs.next()) {
                            Ilarray1.add(new Label("Company Name"));
                            Itarray1.add(new TextField());
                            Ilarray2.add(new Label("Position"));
                            Itarray2.add(new TextField());
                            Ilarray3.add(new Label("Period"));
                            Itarray3.add(new TextField());
                            Ilarray4.add(new Label("Stipend"));
                            Itarray4.add(new TextField());
                            Ilarray5.add(new Label("Description :"));
                            Itarray5.add(new TextArea());

                            Itarray5.get(Itarray5.size() - 1).setPrefWidth(200);
                            Itarray5.get(Itarray5.size() - 1).setPrefHeight(75);


                            Iinfo.add(Ilarray1.get(Ilarray1.size() - 1), 0, (Ilarray1.size() - 1) * 5);
                            Iinfo.add(Itarray1.get(Itarray1.size() - 1), 1, (Itarray1.size() - 1) * 5);
                            Iinfo.add(Ilarray2.get(Ilarray2.size() - 1), 0, (Ilarray2.size() - 1) * 5 + 1);
                            Iinfo.add(Itarray2.get(Itarray2.size() - 1), 1, (Itarray2.size() - 1) * 5 + 1);
                            Iinfo.add(Ilarray3.get(Ilarray3.size() - 1), 0, (Ilarray3.size() - 1) * 5 + 2);
                            Iinfo.add(Itarray3.get(Itarray3.size() - 1), 1, (Itarray3.size() - 1) * 5 + 2);
                            Iinfo.add(Ilarray4.get(Ilarray4.size() - 1), 0, (Ilarray4.size() - 1) * 5 + 3);
                            Iinfo.add(Itarray4.get(Itarray4.size() - 1), 1, (Itarray4.size() - 1) * 5 + 3);
                            Iinfo.add(Ilarray5.get(Ilarray5.size() - 1), 0, (Ilarray5.size() - 1) * 5 + 4);
                            Iinfo.add(Itarray5.get(Itarray5.size() - 1), 1, (Itarray5.size() - 1) * 5 + 4);

                            Itarray1.get(countInt).setText(rs.getString(2));
                            Itarray2.get(countInt).setText(rs.getString(3));
                            Itarray3.get(countInt).setText(rs.getString(4));
                            Itarray4.get(countInt).setText(rs.getString(6));
                            Itarray5.get(countInt).setText(rs.getString(7));
                            countInt++;
                        }

                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    try {
                        String sqlProj = "select * from projects where UID="+U_id;
                        String sqlPR = "select * from pos_resp where UID="+U_id;

                        ResultSet rs = stmt.executeQuery(sqlProj);
                        int countProj = 0;
                        while (rs.next()) {
                            Plarray1.add(new Label("Project name"));
                            Ptarray1.add(new TextField());
                            Plarray2.add(new Label("Project Domain "));
                            Ptarray2.add(new TextField());
                            Plarray3.add(new Label("Company/Institution"));
                            Ptarray3.add(new TextField());
                            Plarray4.add(new Label("Description"));
                            Ptarray4.add(new TextArea());

                            Ptarray4.get(Ptarray4.size() - 1).setPrefWidth(200);
                            Ptarray4.get(Ptarray4.size() - 1).setPrefHeight(75);

                            Pinfo.add(Plarray1.get(Plarray1.size() - 1), 0, (Plarray1.size() - 1) * 4);
                            Pinfo.add(Ptarray1.get(Ptarray1.size() - 1), 1, (Ptarray1.size() - 1) * 4);
                            Pinfo.add(Plarray2.get(Plarray2.size() - 1), 0, (Plarray2.size() - 1) * 4 + 1);
                            Pinfo.add(Ptarray2.get(Ptarray2.size() - 1), 1, (Ptarray2.size() - 1) * 4 + 1);
                            Pinfo.add(Plarray3.get(Plarray3.size() - 1), 0, (Plarray3.size() - 1) * 4 + 2);
                            Pinfo.add(Ptarray3.get(Ptarray3.size() - 1), 1, (Ptarray3.size() - 1) * 4 + 2);
                            Pinfo.add(Plarray4.get(Plarray4.size() - 1), 0, (Plarray4.size() - 1) * 4 + 3);
                            Pinfo.add(Ptarray4.get(Ptarray4.size() - 1), 1, (Ptarray4.size() - 1) * 4 + 3);

                            Ptarray1.get(countProj).setText(rs.getString(2));
                            Ptarray2.get(countProj).setText(rs.getString(3));
                            Ptarray3.get(countProj).setText(rs.getString(4));
                            Ptarray4.get(countProj).setText(rs.getString(5));
                            countProj++;
                        }

                        rs = stmt.executeQuery(sqlPR);
                        int countPR = 0;
                        while (rs.next()) {
                            PRlarray1.add(new Label("Position name "));
                            PRtarray1.add(new TextField());
                            PRlarray2.add(new Label("Position held at "));
                            PRtarray2.add(new TextField());
                            PRlarray3.add(new Label("Position description"));
                            PRtarray3.add(new TextArea());

                            PRtarray3.get(PRtarray3.size() - 1).setPrefWidth(200);
                            PRtarray3.get(PRtarray3.size() - 1).setPrefHeight(75);

                            PRinfo.add(PRlarray1.get(PRlarray1.size() - 1), 0, (PRlarray1.size() - 1) * 3);
                            PRinfo.add(PRtarray1.get(PRtarray1.size() - 1), 1, (PRtarray1.size() - 1) * 3);
                            PRinfo.add(PRlarray2.get(PRlarray2.size() - 1), 0, (PRlarray2.size() - 1) * 3 + 1);
                            PRinfo.add(PRtarray2.get(PRtarray2.size() - 1), 1, (PRtarray2.size() - 1) * 3 + 1);
                            PRinfo.add(PRlarray3.get(PRlarray3.size() - 1), 0, (PRlarray3.size() - 1) * 3 + 2);
                            PRinfo.add(PRtarray3.get(PRtarray3.size() - 1), 1, (PRtarray3.size() - 1) * 3 + 2);

                            PRtarray1.get(countPR).setText(rs.getString(2));
                            PRtarray2.get(countPR).setText(rs.getString(3));
                            PRtarray3.get(countPR).setText(rs.getString(4));
                            countPR++;
                        }

                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }

                    try {
                        String sqlSkills = "select * from skills where UID="+U_id;
                        String sqlECA = "Select * from extracurr where UID="+U_id;
                        ResultSet rs = stmt.executeQuery(sqlSkills);
                        int countSkill = 0;
                        while (rs.next()) {
                            Slarray1.add(new Label("skill"));
                            Starray1.add(new TextField());
                            Slarray2.add(new Label("Proficiency"));
                            Starray2.add(new TextField());
                            Sinfo.add(Slarray1.get(Slarray1.size() - 1), 0, (Slarray1.size() - 1) * 2);
                            Sinfo.add(Starray1.get(Starray1.size() - 1), 1, (Starray1.size() - 1) * 2);
                            Sinfo.add(Slarray2.get(Slarray2.size() - 1), 0, (Slarray2.size() - 1) * 2 + 1);
                            Sinfo.add(Starray2.get(Starray2.size() - 1), 1, (Starray2.size() - 1) * 2 + 1);

                            Starray1.get(countSkill).setText(rs.getString(2));
                            Starray2.get(countSkill).setText(rs.getString(3));
                            countSkill++;

                        }

                        rs = stmt.executeQuery(sqlECA);
                        int countECA = 0;
                        while (rs.next()) {
                            ECAlarray1.add(new Label("ECA name"));
                            ECAtarray1.add(new TextField());
                            ECAlarray2.add(new Label("ECA decription"));
                            ECAtarray2.add(new TextArea());

                            ECAtarray2.get(ECAtarray2.size() - 1).setPrefWidth(200);
                            ECAtarray2.get(ECAtarray2.size() - 1).setPrefHeight(75);

                            ECAinfo.add(ECAlarray1.get(ECAlarray1.size() - 1), 0, (ECAlarray1.size() - 1) * 2);
                            ECAinfo.add(ECAtarray1.get(ECAtarray1.size() - 1), 1, (ECAtarray1.size() - 1) * 2);
                            ECAinfo.add(ECAlarray2.get(ECAlarray2.size() - 1), 0, (ECAlarray2.size() - 1) * 2 + 1);
                            ECAinfo.add(ECAtarray2.get(ECAtarray2.size() - 1), 1, (ECAtarray2.size() - 1) * 2 + 1);

                            ECAtarray1.get(countECA).setText(rs.getString(2));
                            ECAtarray2.get(countECA).setText(rs.getString(3));
                            countECA++;
                        }
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
        });

        compbLogin.setOnAction(e->{
            if(compusername.getText().length()>0 && comppassword.getText().length()>0){
                if (compusername.getText().contains(".co.in")) {
                    try {
                        boolean checkuser1 = FALSE;
                        String email = compusername.getText().trim();
                        String pass = comppassword.getText().trim();
                        ResultSet rs = stmt.executeQuery("select * from companycred where cEmail = '" + email + "'");

                        while (rs.next()) {
                            if (rs.getString("cEmail").equals(email)) {
                                checkuser1 = TRUE;
                                break;
                            }
                        }

                        rs.absolute(1);
                        if (checkuser1 && rs.getString("cpassword").equals(pass)) {
                            C_id = rs.getInt("CID");
                            System.out.println("company ID: " + C_id);
                            primaryStage.setScene(comScene);
                            compLmsg.setText("");
                        } else if (checkuser1 && !rs.getString("cpassword").equals(pass)) {
                            compLmsg.setText("Incorrect password");
                            System.out.println("Incorrect password");
                        } else {
                            compLmsg.setText("Register first!");
                            System.out.println("User not registered");
                        }

                    } catch (SQLException exception) {
                        exception.printStackTrace();
                    }
                } else {
                    compLmsg.setText("Invalid company username");
                    System.out.println("User not registered");
                }
            }else{
                compLmsg.setText("Incomplete Credentials");
            }
        });

        PIsave.setOnAction(e -> {
            if (AFnameinput.getText() != null && ALnameinput.getText() != null && ADOBinput.getText() != null && CDemailinput.getText() != null
                    && Acategoryinput.getText() != null && Agenderinput != null && CDmobileinput.getText() != null && Lhouseinput.getText() != null
                    && LStreetInput.getText() != null && LCityInput.getText() != null && Lpincodeinput.getText() != null
                    && LCountryinput.getText() != null && Gfnameinput.getText() != null && Gmnameinput.getText() != null && Gfnumberinput.getText() != null
                    && Gmnumberinput.getText() != null && Gfoccupationinput.getText() != null && Gmoccupationinput.getText() != null) {
                try {
                    String UAsql = "Update personaldetails set fName = '"
                            + AFnameinput.getText() + "' ,lName= '"
                            + ALnameinput.getText() + "' ,DOB='"
                            + ADOBinput.getText() + "' ,email= '"
                            + CDemailinput.getText() + "' ,category = '"
                            + Acategoryinput.getText() + "' ,gender = '"
                            + Agenderinput.getText() + "' ,mobile="
                            + CDmobileinput.getText() + ", HNO ="
                            + Lhouseinput.getText() + " ,Street='"
                            + LStreetInput.getText() + "' ,city='"
                            + LCityInput.getText() + "', pincode = "
                            + Lpincodeinput.getText() + ", country = '"
                            + LCountryinput.getText() + "' where UID = " + U_id;

                    String UGsql = "Update guardiandetails set fatherName = '"
                            + Gfnameinput.getText() + "', motherName ='"
                            + Gmnameinput.getText() + "', fatherNumber ="
                            + Gfnumberinput.getText() + ", motherNumber = "
                            + Gmnumberinput.getText() + ", fatherOcc = '"
                            + Gfoccupationinput.getText() + "', motherOcc = '"
                            + Gmoccupationinput.getText() + "' where UID = " + U_id;

                    stmt.executeUpdate(UAsql);
//                    new JoptionPane("Changes saved");
                    System.out.println("Changes saved");
                    stmt.executeUpdate(UGsql);
                    new JoptionPane("Changes saved");
                    System.out.println("Changes saved");

                } catch (SQLException exception) {
                    new JoptionPane("Failed to update Personal Information");
                }
            }else  new JoptionPane("Incomplete Details");
        });

        PIback.setOnAction(e -> { primaryStage.setScene(sc);});
        PInext.setOnAction(e -> { primaryStage.setScene(scene2); });
        EEnext.setOnAction(e -> { primaryStage.setScene(scene3); });
        EEback.setOnAction(e -> { primaryStage.setScene(scene1); });
        EXback.setOnAction(e -> { primaryStage.setScene(scene2); });
        EXnext.setOnAction(e -> { primaryStage.setScene(scene4); });
        SECAback.setOnAction(e -> { primaryStage.setScene(scene4); });
        SECAnext.setOnAction(e->{primaryStage.setScene(sc);});
        PPRback.setOnAction(e -> { primaryStage.setScene(scene3); });
        PPRnext.setOnAction(e -> { primaryStage.setScene(scene5); });

        EEsave.setOnAction(e -> {
            try {

                String TEsql = "select * from education where UID = "+ U_id + " and degree = '10th'";
                ResultSet TErs = stmt.executeQuery(TEsql);
                if(TErs.next()){
                    if(TEschoolinput.getText()!=null && TEboardinput.getText()!=null && TEpercentageinput.getText()!=null && TEyearinput.getText()!=null){
                        if(TEschoolinput.getText().length() > 0 && TEboardinput.getText().length() > 0 && TEpercentageinput.getText().length() > 0 && TEyearinput.getText().length() > 0 ){
                            String upTEsql = "update education set institution = ?, board = ?, percentage = ?, passyear = ? where UID = " + U_id + " and degree = '10th'";
                            PreparedStatement pstmt = conn.prepareStatement(upTEsql);
                            pstmt.setString(1, TEschoolinput.getText());
                            pstmt.setString(2, TEboardinput.getText());
                            pstmt.setString(3, TEpercentageinput.getText());
                            pstmt.setString(4, TEyearinput.getText());
                            pstmt.executeUpdate();
                            new JoptionPane("Changes saved");
                        }else new JoptionPane("Incomplete details");
                    }else{
                        new JoptionPane("Incomplete Details");
                    }
                }else{
                    new JoptionPane("Database Error");
                }

                String TWsql = "select * from education where UID = "+ U_id + " and degree = '12th'";
                ResultSet TWrs = stmt.executeQuery(TWsql);
                if(TWrs.next()){
                    if(TWschoolinput.getText()!=null && TWboardinput.getText()!=null && TWpercentageinput.getText()!=null && TWyearinput.getText()!=null){
                        if(TWschoolinput.getText().length() > 0 && TWboardinput.getText().length() > 0 && TWpercentageinput.getText().length() > 0 && TWyearinput.getText().length() > 0 ){
                            String upTWsql = "update education set institution = ?, board = ?, percentage = ?, passyear = ? where UID = " + U_id + " and degree = '12th'";
                            PreparedStatement pstmt = conn.prepareStatement(upTWsql);
                            pstmt.setString(1, TWschoolinput.getText());
                            pstmt.setString(2, TWboardinput.getText());
                            pstmt.setString(3, TWpercentageinput.getText());
                            pstmt.setString(4, TWyearinput.getText());
                            pstmt.executeUpdate();
                            new JoptionPane("Changes saved");
                        }else {
                            new JoptionPane("Incomplete details");
                            System.out.println("textfield empty");
                        }
                    }else {
                        new JoptionPane("Imcomplete Details");
                        System.out.println("Textfield error");
                    }
                }else {
                    new JoptionPane("Database Error");
                    System.out.println("Database error");
                }


                int ndegree = Ularray1.size();
                for (int i = 0; i < ndegree; i++) {
                    String Ins = Utarray2.get(i).getText().trim();
                    String degree = Utarray1.get(i).getText().trim();
                    String board = Utarray3.get(i).getText().trim();
                    String perc = Utarray4.get(i).getText().trim();
                    String year = Utarray5.get(i).getText().trim();

                    String fRS = "Select * from education where UID = " + U_id + " and degree = '" + degree + "'";
                    ResultSet rs = stmt.executeQuery(fRS);

                    System.out.println(degree);
                    if(perc.length() > 0 && degree.length()>0 && Ins.length()>0 && board.length()>0 && year.length()>0){
                        Boolean status = FALSE;//new entry
                        while (rs.next()){
                            if(rs.getString(3).equals(degree)){
                                status = TRUE;
                            }
                        }

                        if (!status) {
                            String Insql = "insert into education values("
                                    + U_id + ",'"
                                    + Ins+ "','"
                                    + degree + "','"
                                    + board+ "',"
                                    + perc + ",'"
                                    + year+ "')";
                            try{
                                stmt.executeUpdate(Insql);
                                new JoptionPane("Changes saved");
                                System.out.println("Inserted Successfully");
                            }catch(SQLException exception){
                                new JoptionPane("Changes saved");
                                System.out.println("Already added");
                            }
                            //System.out.println(Insql);
                        }

                        else if (status) {
                            String pdSQL = "update education set degree = '"
                                    + degree + "' ,institution = '"
                                    + Ins + "' ,Board = '"
                                    + board + "' ,percentage = "
                                    + perc + ", passyear = '"
                                    + year + "' where UID = " + U_id + " and degree not in ('12th' , '10th')";
                            //System.out.println(pdSQL);
                            try{
                                stmt.executeUpdate(pdSQL);
                                new JoptionPane("Changes saved");
                                System.out.println("Updated");
                            }catch(SQLException exception){
                                new JoptionPane("Changes saved");
                                System.out.println("No Update required");
                            }
                            //System.out.println(pdSQL);

                        }
                    }else{
                        new JoptionPane("Incomplete Details");
                        System.out.println("Incomplete details");
                    }
                }

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });// end EEsave


        EXsave.setOnAction(e->{
            int countComp = Ctarray1.size();
            try{
                for (int i = 0; i < countComp; i++) {
                    if(Ctarray1.get(i).getText()!= null && Ctarray2.get(i).getText()!=null && Ctarray3.get(i).getText()!=null &&  Ctarray4.get(i).getText()!=null && Ctarray5.get(i).getText()!=null){
                        if(Ctarray1.get(i).getText().length()>0 && Ctarray2.get(i).getText().length()>0 && Ctarray3.get(i).getText().length()>0 &&  Ctarray4.get(i).getText().length()>0 && Ctarray5.get(i).getText().length()>0){
                            String sqlCom = "select * from experience where UID =" + U_id + " and jType = 'Regular' and company = '" + Ctarray1.get(i).getText() + "'";
                            ResultSet rs = stmt.executeQuery(sqlCom);
                            Boolean status = FALSE;

                            while (rs.next()) {
                                if (rs.getString(2).trim().equals(Ctarray1.get(i).getText().trim()) && rs.getString(3).trim().equals(Ctarray2.get(i).getText().trim())) {
                                    status = TRUE;
                                    System.out.println("Row Exist");
                                    break;
                                }
                            }
                            if (status) {
                                try {
                                    String getRow = "select * from experience where UID = "
                                            + U_id + " and company = '"
                                            + Ctarray1.get(i).getText().trim()
                                            + "' and position = '"
                                            + Ctarray2.get(i).getText().trim()
                                            + "' and jType = 'Regular' ";

                                    System.out.println("updated");
                                    ResultSet updateResultSet = stmt.executeQuery(getRow);
                                    System.out.println(updateResultSet.isClosed());


                                    while (updateResultSet.next()) {
                                        try {
                                            PreparedStatement pStmt = conn.prepareStatement("update experience set company = ? , position = ? , period = ? , salary = ? , details =? where company = ? and position = ? and UID= ? and jType = ?");
                                            pStmt.setString(1, Ctarray1.get(i).getText().trim());
                                            pStmt.setString(2, Ctarray2.get(i).getText().trim());
                                            pStmt.setInt(3, Integer.parseInt(Ctarray3.get(i).getText().trim()));
                                            pStmt.setInt(4, Integer.parseInt(Ctarray4.get(i).getText().trim()));
                                            pStmt.setString(5, Ctarray5.get(i).getText().trim());
                                            pStmt.setString(6, updateResultSet.getString(2));
                                            pStmt.setString(7, updateResultSet.getString(3));
                                            pStmt.setInt(8, Integer.parseInt(updateResultSet.getString(1)));
                                            pStmt.setString(9, "Regular");
                                            System.out.println(pStmt.executeUpdate());
                                            new JoptionPane("Changes saved");
                                        } catch (SQLException exception) {
                                            System.out.println("Could not update");
                                        }
                                    }


                                } catch (Exception same) {
                                    same.printStackTrace();
                                }

                            } else if (!status) {
                                try {
                                    String insertSQL = "insert into experience values("
                                            + U_id + ",'"
                                            + Ctarray1.get(i).getText().trim() + "','"
                                            + Ctarray2.get(i).getText().trim() + "',"
                                            + Ctarray3.get(i).getText().trim() + ","
                                            + "'Regular',"
                                            + Ctarray4.get(i).getText().trim() + ",'"
                                            + Ctarray5.get(i).getText().trim() + "')";
                                    stmt.executeUpdate(insertSQL);
                                    System.out.println("inserted");
                                    new JoptionPane("Changes saved");
                                } catch (SQLException exec) {
                                    System.out.println("Regular insert fail");
                                }
                            }
                        }else{
                            new JoptionPane("Incomplete Data");
                            System.out.println("Incomplete Data");
                        }
                    }else{
                        new JoptionPane("Incomplete Data");
                        System.out.println("Incomplete Data");
                    }
                }
            }catch(SQLException exd){
                exd.printStackTrace();
            }

            int countInt = Itarray1.size();
            try{
                for (int i = 0; i < countInt; i++) {
                    if(Itarray1.get(i).getText()!= null && Itarray2.get(i).getText()!=null && Itarray3.get(i).getText()!=null &&  Itarray4.get(i).getText()!=null && Itarray5.get(i).getText()!=null){
                        if(Itarray1.get(i).getText().length()>0 && Itarray2.get(i).getText().length()>0 && Itarray3.get(i).getText().length()>0 &&  Itarray4.get(i).getText().length()>0 && Itarray5.get(i).getText().length()>0){
                            String sqlInt = "select * from experience where UID =" + U_id + " and jType = 'Internship' and company = '" + Itarray1.get(i).getText() + "'";
                            ResultSet rs = stmt.executeQuery(sqlInt);
                            Boolean status = FALSE;

                            while (rs.next()) {
                                if (rs.getString(2).trim().equals(Itarray1.get(i).getText().trim()) && rs.getString(3).trim().equals(Itarray2.get(i).getText().trim())) {
                                    status = TRUE;
                                    System.out.println("Row Exist");
                                    break;
                                }
                            }
                            if (status) {
                                try {
                                    String getRow = "select * from experience where UID = "
                                            + U_id + " and company = '"
                                            + Ctarray1.get(i).getText().trim()
                                            + "' and position = '"
                                            + Ctarray2.get(i).getText().trim()
                                            + "' and jType = 'Internship' ";
                                    System.out.println("updated");
                                    ResultSet updateResultSet = stmt.executeQuery(getRow);
                                    System.out.println(updateResultSet.isClosed());


                                    while (updateResultSet.next()) {
                                        try {
                                            PreparedStatement pStmt = conn.prepareStatement("update experience set company = ? , position = ? , period = ? , salary = ? , details =? where company = ? and position = ? and UID= ? and jType = ?");
                                            pStmt.setString(1, Itarray1.get(i).getText().trim());
                                            pStmt.setString(2, Itarray2.get(i).getText().trim());
                                            pStmt.setInt(3, Integer.parseInt(Itarray3.get(i).getText().trim()));
                                            pStmt.setInt(4, Integer.parseInt(Itarray4.get(i).getText().trim()));
                                            pStmt.setString(5, Itarray5.get(i).getText().trim());
                                            pStmt.setString(6, updateResultSet.getString(2));
                                            pStmt.setString(7, updateResultSet.getString(3));
                                            pStmt.setInt(8, Integer.parseInt(updateResultSet.getString(1)));
                                            pStmt.setString(9, "Internship");
                                            System.out.println(pStmt.executeUpdate());
                                            new JoptionPane("Changes saved");
                                        } catch (SQLException exception) {
                                            new JoptionPane("Changes saved");
                                            System.out.println("Could not update");
                                        }
                                    }
                                } catch (Exception same) {
                                    same.printStackTrace();
                                }

                            } else if (!status) {
                                try {
                                    String insertSQL = "insert into experience values("
                                            + U_id + ",'"
                                            + Itarray1.get(i).getText().trim() + "','"
                                            + Itarray2.get(i).getText().trim() + "',"
                                            + Itarray3.get(i).getText().trim() + ","
                                            + "'Internship',"
                                            + Itarray4.get(i).getText().trim() + ",'"
                                            + Itarray5.get(i).getText().trim() + "')";
                                    stmt.executeUpdate(insertSQL);
                                    new JoptionPane("Changes saved");
                                    System.out.println("inserted");
                                } catch (SQLException exec) {
                                    new JoptionPane("Changes saved");
                                    System.out.println("Internship failed to insert");
                                }
                            }
                        }else{
                            new JoptionPane("Incomplete Data");
                            System.out.println("Incomplete Data");
                        }
                    } else{
                        new JoptionPane("Incomplete Data");
                        System.out.println("Incomplete Data");
                    }
                }
            }catch(SQLException exd){
                exd.printStackTrace();
            }
        });


        PPRsave.setOnAction(e->{
            int countProj = Ptarray1.size();
            try{
                for (int i = 0; i < countProj; i++) {
                    if(Ptarray1.get(i).getText()!= null && Ptarray2.get(i).getText()!=null && Ptarray3.get(i).getText()!=null &&  Ptarray4.get(i).getText()!=null ){
                        if(Ptarray1.get(i).getText().length()>0 && Ptarray2.get(i).getText().length()>0 && Ptarray3.get(i).getText().length()>0 &&  Ptarray4.get(i).getText().length()>0 ){
                            String sqlInt = "select * from projects where UID =" + U_id + " and title = '" + Ptarray1.get(i).getText().trim() + "'";
                            ResultSet rs = stmt.executeQuery(sqlInt);
                            Boolean status = FALSE;

                            while (rs.next()) {
                                if (rs.getString(2).trim().equals(Ptarray2.get(i).getText().trim())) {
                                    status = TRUE;
                                    System.out.println("Row Exist");
                                    break;
                                }
                            }
                            if (status) {
                                try {
                                    String getRow = "select * from projects where UID = "
                                            + U_id + " and title = '"
                                            + Ptarray1.get(i).getText().trim() + "'";

                                    System.out.println("updated");

                                    ResultSet updateResultSet = stmt.executeQuery(getRow);
                                    System.out.println(updateResultSet.isClosed());


                                    while (updateResultSet.next()) {
                                        try {
                                            PreparedStatement pStmt = conn.prepareStatement("update projects set title = ? , projectDomain = ? , company = ?  , description =? where company = ?");
                                            pStmt.setString(1, Ptarray1.get(i).getText().trim());
                                            pStmt.setString(2, Ptarray2.get(i).getText().trim());
                                            pStmt.setString(3, Ptarray3.get(i).getText().trim());
                                            pStmt.setString(4, Ptarray4.get(i).getText().trim());
                                            pStmt.setString(5, updateResultSet.getString(4));
                                            System.out.println(pStmt.executeUpdate());
                                            new JoptionPane("Changes saved");
                                        } catch (SQLException exception) {
                                            new JoptionPane("Changes saved");
                                            System.out.println("Could not update");
                                        }
                                    }
                                } catch (Exception same) {
                                    same.printStackTrace();
                                }

                            } else if (!status) {
                                try {
                                    String insertSQL = "insert into projects values("
                                            + U_id + ",'"
                                            + Ptarray1.get(i).getText().trim() + "','"
                                            + Ptarray2.get(i).getText().trim() + "','"
                                            + Ptarray3.get(i).getText().trim() + "','"
                                            + Ptarray4.get(i).getText().trim() + "')";
                                    stmt.executeUpdate(insertSQL);
                                    System.out.println("inserted");
                                    new JoptionPane("Changes saved");
                                } catch (SQLException exec) {
                                    exec.printStackTrace();
                                }
                            }
                        }else{
                            new JoptionPane("Incomplete Data");
                            System.out.println("Incomplete Data");
                        }
                    }else{
                        new JoptionPane("Incomplete Data");
                        System.out.println("Incomplete Data");
                    }
                }
            }catch(SQLException exd){
                exd.printStackTrace();
            }

            int countpos = PRtarray1.size();
            try{
                for (int i = 0; i < countpos; i++) {
                    if(PRtarray1.get(i).getText()!= null && PRtarray2.get(i).getText()!=null && PRtarray3.get(i).getText()!=null){
                        if(PRtarray1.get(i).getText().length()>0 && PRtarray2.get(i).getText().length()>0 && PRtarray3.get(i).getText().length()>0){
                            String sqlInt = "select * from pos_resp where UID =" + U_id + " and pos_Name = '" + PRtarray1.get(i).getText().trim() + "' and held ='" + PRtarray2.get(i).getText().trim() + "'";
                            ResultSet rs = stmt.executeQuery(sqlInt);
                            Boolean status = FALSE;

                            while (rs.next()) {
                                if (rs.getString(2).trim().equals(PRtarray1.get(i).getText().trim()) && rs.getString(3).trim().equals(PRtarray2.get(i).getText().trim())) {
                                    status = TRUE;
                                    System.out.println("Row Exist");
                                    break;
                                }
                            }
                            if (status) {
                                try {
                                    String getRow = "select * from pos_resp where UID = "
                                            + U_id + " and pos_Name = '"
                                            + PRtarray1.get(i).getText().trim() + "' and held = '"
                                            + PRtarray2.get(i).getText().trim() + "'";
                                    System.out.println("updated");
                                    ResultSet updateResultSet = stmt.executeQuery(getRow);
                                    System.out.println(updateResultSet.isClosed());


                                    while (updateResultSet.next()) {
                                        try {
                                            PreparedStatement pStmt = conn.prepareStatement("update pos_resp set pos_Name = ? , held = ? , descp = ?  , where pos_Name = ? and held = ? and UID=?");
                                            pStmt.setString(1, Ptarray1.get(i).getText().trim());
                                            pStmt.setString(2, Ptarray2.get(i).getText().trim());
                                            pStmt.setString(3, Ptarray3.get(i).getText().trim());
                                            pStmt.setString(4, updateResultSet.getString(2));
                                            pStmt.setString(5, updateResultSet.getString(3));
                                            pStmt.setInt(6, U_id);
                                            System.out.println(pStmt.executeUpdate());
                                            new JoptionPane("Changes saved");

                                        } catch (SQLException exception) {
                                            System.out.println("Could not update");
                                        }
                                    }
                                } catch (Exception same) {
                                    same.printStackTrace();
                                }

                            } else if (!status) {
                                try {
                                    String insertSQL = "insert into pos_resp values("
                                            + U_id + ",'"
                                            + PRtarray1.get(i).getText().trim() + "','"
                                            + PRtarray2.get(i).getText().trim() + "','"
                                            + PRtarray3.get(i).getText().trim() + "')";
                                    stmt.executeUpdate(insertSQL);
                                    System.out.println("inserted");
                                    new JoptionPane("Changes saved");
                                } catch (SQLException exec) {
                                    System.out.println("Internship failed to insert");
                                }
                            }
                        }else{
                            new JoptionPane("Incomplete Data");
                            System.out.println("Incomplete Data");
                        }
                    }else{
                        new JoptionPane("Incomplete Data");
                        System.out.println("Incomplete Data");
                    }
                }
            }catch(SQLException exd){
                exd.printStackTrace();
            }
        });

        SECAsave.setOnAction(e->{
            int countskill = Starray1.size();
            try{
                for (int i = 0; i < countskill; i++) {
                    if(Starray1.get(i).getText()!= null && Starray2.get(i).getText()!=null ){
                        if(Starray1.get(i).getText().length()>0 && Starray2.get(i).getText().length()>0 ){
                            String sqlInt = "select * from skills where UID =" + U_id + " and skill = '" + Starray1.get(i).getText().trim() + "'";
                            ResultSet rs = stmt.executeQuery(sqlInt);
                            Boolean status = FALSE;

                            while (rs.next()) {
                                if (rs.getString(2).trim().equals(Starray1.get(i).getText().trim())) {
                                    status = TRUE;
                                    System.out.println("Row Exist");
                                    break;
                                }
                            }
                            if (status) {
                                try {
                                    String getRow = "select * from skills where UID = "
                                            + U_id + " and skill = '"
                                            + Starray1.get(i).getText().trim() + "' and proficiency = "
                                            + Starray2.get(i).getText().trim();
                                    System.out.println("updated");
                                    ResultSet updateResultSet = stmt.executeQuery(getRow);
                                    System.out.println(updateResultSet.isClosed());


                                    while (updateResultSet.next()) {
                                        try {
                                            PreparedStatement pStmt = conn.prepareStatement("update skills set skill = ? , proficiency = ?  where skill = ? and UID=?");
                                            pStmt.setString(1, Starray1.get(i).getText().trim());
                                            pStmt.setInt(2, Integer.parseInt(Starray2.get(i).getText().trim()));
                                            pStmt.setString(3, updateResultSet.getString(2));
                                            pStmt.setInt(4, U_id);
                                            System.out.println(pStmt.executeUpdate());
                                            new JoptionPane("Changes saved");
                                        } catch (SQLException exception) {
                                            System.out.println("Could not update");
                                        }
                                    }

                                } catch (Exception same) {
                                    same.printStackTrace();
                                }

                            } else if (!status) {
                                try {
                                    String insertSQL = "insert into skills values("
                                            + U_id + ",'"
                                            + Starray1.get(i).getText().trim() + "',"
                                            + Starray2.get(i).getText().trim() + ")";
                                    stmt.executeUpdate(insertSQL);
                                    System.out.println("inserted");
                                    new JoptionPane("Changes saved");
                                } catch (SQLException exec) {
                                    System.out.println("skill failed to insert");
                                }
                            }
                        }else{
                            new JoptionPane("Incomplete Data");
                            System.out.println("Incomplete Data");
                        }
                    }else{
                        new JoptionPane("Incomplete Data");
                        System.out.println("Incomplete Data");
                    }
                }
            }catch(SQLException exd){
                exd.printStackTrace();
            }



            int countECA = ECAtarray1.size();
            try{
                for (int i = 0; i < countECA; i++) {
                    if(ECAtarray1.get(i).getText()!= null && ECAtarray2.get(i).getText()!=null ){
                        if(ECAtarray1.get(i).getText().length()>0 && ECAtarray2.get(i).getText().length()>0){
                            String sqlInt = "select * from extracurr where UID =" + U_id + " and category = '" + ECAtarray1.get(i).getText().trim() + "'";
                            ResultSet rs = stmt.executeQuery(sqlInt);
                            Boolean status = FALSE;

                            while (rs.next()) {
                                if (rs.getString(2).trim().equals(ECAtarray1.get(i).getText().trim())) {
                                    status = TRUE;
                                    System.out.println("Row Exist");
                                    break;
                                }
                            }
                            if (status) {
                                try {
                                    String getRow = "select * from extracurr where UID = "
                                            + U_id + " and category = '"
                                            + ECAtarray1.get(i).getText().trim() + "' and description = '"
                                            + ECAtarray2.get(i).getText().trim() + "'";
                                    System.out.println("updated");
                                    ResultSet updateResultSet = stmt.executeQuery(getRow);
                                    System.out.println(updateResultSet.isClosed());


                                    while (updateResultSet.next()) {
                                        try {
                                            PreparedStatement pStmt = conn.prepareStatement("update exrtacurr set category = ? , description = ?  where category = ? and UID=?");
                                            pStmt.setString(1, ECAtarray1.get(i).getText().trim());
                                            pStmt.setString(2, (ECAtarray2.get(i).getText().trim()));
                                            pStmt.setString(3, updateResultSet.getString(2));
                                            pStmt.setInt(4, U_id);
                                            System.out.println(pStmt.executeUpdate());
                                            new JoptionPane("Changes saved");
                                        } catch (SQLException exception) {
                                            System.out.println("Could not update");
                                        }
                                    }

                                } catch (Exception same) {
                                    same.printStackTrace();
                                }

                            } else if (!status) {
                                try {
                                    String insertSQL = "insert into extracurr values("
                                            + U_id + ",'"
                                            + ECAtarray1.get(i).getText().trim() + "','"
                                            + ECAtarray2.get(i).getText().trim() + "')";
                                    stmt.executeUpdate(insertSQL);
                                    new JoptionPane("Changes saved");
                                    System.out.println("inserted");
                                } catch (SQLException exec) {
                                    System.out.println("ECA failed to insert");
                                }
                            }
                        }else{
                            new JoptionPane("Incomplete Data");
                            System.out.println("Incomplete Data");
                        }
                    }else{
                        new JoptionPane("Incomplete Data");
                        System.out.println("Incomplete Data");
                    }
                }
            }catch(SQLException exd){
                exd.printStackTrace();
            }

        });



        //Scene of comPane----------------------------------------------------------------------------------
//        BorderPane comPane = new BorderPane();
//        comScene = new Scene(comPane,0.9*r.getWidth(),0.9*r.getHeight());
//        TilePane left = new TilePane(Orientation.VERTICAL);
//        left.setPrefWidth(0.2*comScene.getWidth());
//        left.setStyle("-fx-border-color: black");
//        Button createJP = new Button("Create Job");createJP.setStyle("-fx-padding: 8 15 15 15;-fx-background-insets: 0,0 0 5 0,0 0 6 0,0 0 7 0;-fx-background-radius: 8;-fx-background-color:linear-gradient(from 0% 93% to 0% 100%,#a34313 0%,#903b12 100%),#9d4024,#d86e3a,radial-gradient(center 50% 50%, radius 100%,#d96e3a,#c54e2c); -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75),4,0,0,1);-fx-font-weight: bold;-fx-font-size: 2.5em;-fx-text-fill: white;");
//        Button showProfiles = new Button("Profiles");showProfiles.setStyle("-fx-padding: 8 35 15 35;-fx-background-insets: 0,0 0 5 0,0 0 6 0,0 0 7 0;-fx-background-radius: 8;-fx-background-color:linear-gradient(from 0% 93% to 0% 100%,#a34313 0%,#903b12 100%),#9d4024,#d86e3a,radial-gradient(center 50% 50%, radius 100%,#d96e3a,#c54e2c); -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.75),4,0,0,1);-fx-font-weight: bold;-fx-font-size: 2.5em;-fx-text-fill: white;");
//        left.setAlignment(Pos.CENTER);
//        left.getChildren().addAll(createJP,showProfiles);
//
//        Pane top = new Pane();
//        Label welcome = new Label("Welcome");
//        top.getChildren().addAll(welcome);
//        top.setPrefHeight(0.125*comScene.getHeight());
//        welcome.translateXProperty().bind(top.widthProperty().divide(2));
//        welcome.translateYProperty().bind(top.heightProperty().divide(2));
//        welcome.setFont(Font.font("Times New Roman",FontWeight.BOLD,40));
//        top.setStyle("-fx-border-color: black");
//
//        VBox main_content =new VBox();
//        //main_content.setBackground(new Background(new BackgroundFill(Color.rgb(157, 200, 141), CornerRadii.EMPTY, Insets.EMPTY)));
//        //main_content.setStyle("-fx-background-color:linear-gradient(to right, #e65c00, #f9d423);");
//        comPane.setCenter(main_content);
//
//        HBox jobfilters=new HBox();
//        Button unfiltered=new Button("Unfiltered");
//        Button filtered=new Button("Filtered");
//        jobfilters.getChildren().addAll(unfiltered,filtered);
//        //main_content.getChildren().add(jobfilters);
//
//
//        //Job Profile Details
//        ArrayList<String> s=new ArrayList<>();
//        VBox JPfinal=new VBox();
//        VBox jobprofile = new VBox();
//        Label JPlabel = new Label("Create Job Profile");
//        JPlabel.setStyle("-fx-font-size: 30px");
//        GridPane JPinfo = new GridPane();
//
//        VBox vbox = new VBox();
//
//        Label JPname = new Label("Job Profile Name: ");
//        TextField JPnameinput = new TextField();
//        Label JPcount = new Label("No of Jobs ");
//        TextField JPcountinput = new TextField();
//        Label JPsalary = new Label("Salary Offered");
//        TextField JPsalaryinput = new TextField();
//        Label JPdegreerequired = new Label("Degree required (if any)");
//        TextField JPdegreerequiredinput = new TextField();
//        Label JPDescription = new Label("Job Description");
//        TextArea JPdescriptioninput = new TextArea();
//        Button JPpost=new Button("Post Profile");
//        JPpost.setAlignment(Pos.BASELINE_RIGHT);

        BorderPane comPane = new BorderPane();
        comScene = new Scene(comPane,0.9*r.getWidth(),0.9*r.getHeight());

        FileInputStream compinputlogout = new FileInputStream("Resources/logout.png");
        Image cilo = new Image(compinputlogout);
        ImageView cimlo = new ImageView(cilo);
        cimlo.setFitWidth(25);
        cimlo.setFitHeight(25);
        Button complogout = new Button();
        complogout.setGraphic(imlo);
        complogout.setStyle("-fx-background-color:transparent;");
        comPane.setRight(complogout);complogout.setOnAction(e->{
            primaryStage.setScene(complogin);
             compusername.setText("");
             comppassword.setText("");
        });

        TilePane left = new TilePane(Orientation.VERTICAL);
        left.setVgap(30);
        left.setPrefWidth(0.2*comScene.getWidth());
        left.setStyle("-fx-border-color: black");
        Button createJP = new Button("Create Job");createJP.setStyle("-fx-background-color:linear-gradient(#f0ff35,#a9ff00), radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%); -fx-background-radius: 6,5;-fx-background-insets: 0,1;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.4), 5, 0.0, 0, 1);-fx-text-fill: #395306;-fx-font-size: 2.5em;");
        Button showProfiles = new Button("See Profiles");showProfiles.setStyle("-fx-background-color:linear-gradient(#f0ff35,#a9ff00), radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%); -fx-background-radius: 6,5;-fx-background-insets: 0,1;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.4), 5, 0.0, 0, 1);-fx-text-fill: #395306;-fx-font-size: 2.5em;");
        left.setAlignment(Pos.CENTER);
        left.getChildren().addAll(createJP,showProfiles);
        Pane top = new Pane();


        Label welcome = new Label("Welcome");
        top.getChildren().addAll(welcome);
        top.setPrefHeight(0.125*comScene.getHeight());
        welcome.translateXProperty().bind(top.widthProperty().divide(2));
        welcome.translateYProperty().bind(top.heightProperty().divide(2));
        welcome.setFont(Font.font("Times New Roman",FontWeight.BOLD,40));
        top.setStyle("-fx-border-color: black");
        VBox main_content =new VBox();
        main_content.setPadding(new Insets(7,14,7,14));
        main_content.setSpacing(20);
//main_content.setBackground(new Background(new BackgroundFill(Color.rgb(157, 200, 141), CornerRadii.EMPTY, Insets.EMPTY)));
//main_content.setStyle("-fx-background-color:linear-gradient(to right, #e65c00, #f9d423);");
        comPane.setCenter(main_content);
        HBox jobfilters=new HBox();
        Button unfiltered=new Button("Unfiltered");unfiltered.setStyle("-fx-background-color:linear-gradient(#ffd65b, #e68400), linear-gradient(#ffef84, #f2ba44), linear-gradient(#ffea6a, #efaa22), linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%), linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0)); -fx-background-radius: 30;-fx-background-insets: 0,1,2,3,0;-fx-text-fill: #654b00;-fx-font-weight: bold;-fx-font-size: 2em;-fx-padding: 10 10 10 10;");
        Button filtered=new Button("Filtered");filtered.setStyle("-fx-background-color:linear-gradient(#ffd65b, #e68400), linear-gradient(#ffef84, #f2ba44), linear-gradient(#ffea6a, #efaa22), linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%), linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0)); -fx-background-radius: 30;-fx-background-insets: 0,1,2,3,0;-fx-text-fill: #654b00;-fx-font-weight: bold;-fx-font-size: 2em;-fx-padding: 10 22 10 22;");
        jobfilters.getChildren().addAll(unfiltered,filtered);
        jobfilters.setAlignment(Pos.CENTER);
        jobfilters.setSpacing(40);
//main_content.getChildren().add(jobfilters);

//Job Profile Details
        ArrayList<String> s=new ArrayList<>();
        VBox JPfinal=new VBox();
        VBox jobprofile = new VBox();
        Label JPlabel = new Label("Create Job Profile");
        JPlabel.setFont(Font.font("Times New Roman",FontWeight.BOLD,32));
        GridPane JPinfo = new GridPane();
        JPinfo.setVgap(5);JPinfo.setHgap(5);
        jobprofile.setSpacing(8);
        JPfinal.setSpacing(10);
        Label JPname = new Label("Job Profile Name: ");JPname.setFont(Font.font("Times New Roman",FontWeight.BOLD,14));
        TextField JPnameinput = new TextField();
        Label JPcount = new Label("No of Jobs ");JPcount.setFont(Font.font("Times New Roman",FontWeight.BOLD,14));
        TextField JPcountinput = new TextField();
        Label JPsalary = new Label("Salary Offered");JPsalary.setFont(Font.font("Times New Roman",FontWeight.BOLD,14));
        TextField JPsalaryinput = new TextField();
        Label JPdegreerequired = new Label("Degree required (if any)");JPdegreerequired.setFont(Font.font("Times New Roman",FontWeight.BOLD,14));
        TextField JPdegreerequiredinput = new TextField();
        Label JPDescription = new Label("Job Description");JPDescription.setFont(Font.font("Times New Roman",FontWeight.BOLD,14));
        TextArea JPdescriptioninput = new TextArea();
        Button JPpost=new Button("Post Profile");JPpost.setStyle("-fx-background-color:#090a0c, linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),linear-gradient(#20262b, #191d22),radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0)); -fx-background-radius: 5,4,3,5;-fx-background-insets: 0,1,2,0;-fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );-fx-font-family: 'Arial';-fx-text-fill: linear-gradient(white, #d0d0d0); -fx-font-size: 12px;-fx-padding: 10 20 10 20;");
        JPpost.setAlignment(Pos.BASELINE_RIGHT);

        TableView tableView1=new TableView();
        TableColumn<Person, Integer> col1 = new TableColumn<>("U_ID");
        col1.setCellValueFactory(new PropertyValueFactory<>("u_id"));
        TableColumn<Person, String> col2 = new TableColumn<>("First Name");
        col2.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        TableColumn<Person, String> col3 = new TableColumn<>("Last Name");
        col3.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        TableColumn<Person, String> col4 = new TableColumn<>("Degree");
        col4.setCellValueFactory(new PropertyValueFactory<>("degree"));
        TableColumn<Person, Double> col5 = new TableColumn<>("CGPA");
        col5.setCellValueFactory(new PropertyValueFactory<>("cgpa"));
        TableColumn<Person, String> col6 = new TableColumn<>("College");
        col6.setCellValueFactory(new PropertyValueFactory<>("college"));


        tableView1.getColumns().add(col1);
        tableView1.getColumns().add(col2);
        tableView1.getColumns().add(col3);
        tableView1.getColumns().add(col4);
        tableView1.getColumns().add(col5);
        tableView1.getColumns().add(col6);


        JPpost.setOnAction(e->{
            tableView1.getItems().clear();
            s.clear();
            s.add(JPnameinput.getText());
            s.add(JPcountinput.getText());
            s.add(JPsalaryinput.getText());
            s.add(JPdegreerequiredinput.getText());
            s.add(JPdescriptioninput.getText());

            ArrayList<Person> filteredArraylist = new ArrayList<>();
            String joinfiltersql="select personaldetails.UID,fName,lName,degree,percentage,institution from personaldetails natural join education where degree not in ('12th','10th') and degree = '" + s.get(3) + "' order by personaldetails.UID";
            System.out.println(joinfiltersql);
            ResultSet joinfrs = null;
            try {
                joinfrs = stmt.executeQuery(joinfiltersql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            while(true) {
                try {
                    if (!joinfrs.next()) break;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                Person filteredapplicants = null;
                try {
                    filteredapplicants = new Person(joinfrs.getInt(1),joinfrs.getString(2),joinfrs.getString(3),joinfrs.getString(4),joinfrs.getDouble(5),joinfrs.getString(6));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                filteredArraylist.add(filteredapplicants);
            }
            int countfiltered = 0;
            while(countfiltered != filteredArraylist.size()){
                tableView1.getItems().add(filteredArraylist.get(countfiltered));
                countfiltered++;
            }
            //vbox.getChildren().add(tableView1);

        });
//        s.add(3,JPdegreerequiredinput.getText());
        JPinfo.add(JPname, 0, 0);
        JPinfo.add(JPnameinput, 1, 0);
        JPinfo.add(JPcount, 0, 1);
        JPinfo.add(JPcountinput, 1, 1);
        JPinfo.add(JPsalary, 0, 2);
        JPinfo.add(JPsalaryinput, 1, 2);
        JPinfo.add(JPdegreerequired, 0, 3);
        JPinfo.add(JPdegreerequiredinput, 1, 3);
        JPinfo.add(JPDescription, 0, 4);
        JPinfo.add(JPdescriptioninput, 1, 4);

        jobprofile.getChildren().addAll(JPlabel, JPinfo);
        JPfinal.getChildren().addAll(jobprofile,JPpost);

        createJP.setOnAction(e->{
                    main_content.getChildren().clear();
                    main_content.getChildren().add(JPfinal);
                }
        );

        //Show profile detail
        VBox infopane=new VBox();


        TableView tableView = new TableView();
        TableColumn<Person, Integer> column1 = new TableColumn<>("U_ID");
        column1.setCellValueFactory(new PropertyValueFactory<>("u_id"));
        TableColumn<Person, String> column2 = new TableColumn<>("First Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        TableColumn<Person, String> column3 = new TableColumn<>("Last Name");
        column3.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        TableColumn<Person, String> column4 = new TableColumn<>("Degree");
        column4.setCellValueFactory(new PropertyValueFactory<>("degree"));
        TableColumn<Person, Double> column5 = new TableColumn<>("CGPA");
        column5.setCellValueFactory(new PropertyValueFactory<>("cgpa"));
        TableColumn<Person, String> column6 = new TableColumn<>("College");
        column6.setCellValueFactory(new PropertyValueFactory<>("college"));


        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);
        tableView.getColumns().add(column5);
        tableView.getColumns().add(column6);


        ArrayList<Person> personArrayList = new ArrayList<>();
        String joinsql = "select personaldetails.UID,fName,lName,degree, percentage,institution from personaldetails natural join education where degree not in ('12th','10th') order by personaldetails.UID";
        ResultSet joinrs = stmt.executeQuery(joinsql);
        while(joinrs.next()) {
            Person applicants = new Person(joinrs.getInt(1),joinrs.getString(2),joinrs.getString(3),joinrs.getString(4),joinrs.getDouble(5),joinrs.getString(6));
            personArrayList.add(applicants);
        }
        int count = 0;
        while(count != personArrayList.size()){
            tableView.getItems().add(personArrayList.get(count));
            count++;
        }

        showProfiles.setOnAction(e->{
            main_content.getChildren().clear();
            main_content.getChildren().add(jobfilters);
        });
        filtered.setOnAction(e->{
            infopane.getChildren().clear();
            infopane.getChildren().add(tableView1);
            main_content.getChildren().addAll(infopane);});
        unfiltered.setOnAction(e-> {
            infopane.getChildren().clear();
            infopane.getChildren().add(tableView);
            main_content.getChildren().addAll(infopane);});

        FileInputStream inputcomp = new FileInputStream("Resources/snu9.jpg");
        Image imagecomp = new Image(inputcomp);
        BackgroundImage backgroundimagecomp = new BackgroundImage(imagecomp, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(100,100,true,true,true,false));
        Background backgroundcomp = new Background(backgroundimagecomp);
        comPane.setTop(top);
        comPane.setLeft(left);
        //comPane.setStyle("-fx-background-color:linear-gradient(to left, #1f1c2c, #928dab);");
        comPane.setBackground(backgroundcomp);


//        comPane.setTop(top);
//        comPane.setLeft(left);
//        comPane.setStyle("-fx-background-color:linear-gradient(to left, #1f1c2c, #928dab);");








        //Scene of FinalPane-------------------------------------------------------------------------
        DropShadow ds = new DropShadow();
        ds.setOffsetY(7.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

        Text t = new Text();
        t.setEffect(ds);
        t.setCache(true);
        t.setFill(Color.WHITE);
        t.setText("JOB RECRUITER");
        t.setFont(Font.font(null, FontWeight.BOLD, FontPosture.ITALIC, 122));

        BorderPane Finalpane =new BorderPane();
        Finalpane.setStyle("-fx-background-color:linear-gradient(to right, #ffe000, #799f0c)");
        VBox jobrecruiter =new VBox();
        jobrecruiter.setAlignment(Pos.CENTER);
        Button User= new Button("User");
        Button Company = new Button("Company");
        User.setStyle("-fx-padding: 8 80 15 80; -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;-fx-background-radius: 8;-fx-background-color: linear-gradient(from 0% 93% to 0% 100%, #186A3B   0%, #145A32 100%),#229954 , #1E8449,radial-gradient(center 50% 50%, radius 100%, #229954, #1E8449);-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );-fx-font-weight: bold;-fx-font-size: 4.5em; -fx-text-fill:white;");
        User.setOnAction(e->{primaryStage.setScene(login);});
        Company.setStyle("-fx-padding: 8 15 15 15; -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;-fx-background-radius: 8;-fx-background-color: linear-gradient(from 0% 93% to 0% 100%, #186A3B   0%, #145A32 100%),#229954 , #1E8449,radial-gradient(center 50% 50%, radius 100%, #229954, #1E8449);-fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );-fx-font-weight: bold;-fx-font-size: 4.5em; -fx-text-fill:white;");
        Company.setOnAction(e->{primaryStage.setScene(complogin);});
        //delete.setStyle("-fx-padding: 8 15 15 15; -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;-fx-background-radius: 8;-fx-background-color: linear-gradient(from 0% 93% to 0% 100%, #78281F 0%, #7B241C 100%),#922B21, #C0392B ,radial-gradient(center 50% 50%, radius 100%, #CB4335, #922B21);-fx-effect: dropshadow( gaussian , #CB4335 , 4,0,0,1 );-fx-font-weight: bold;-fx-font-size: 1.1em; -fx-text-fill:white;");
        HBox Buttons=new HBox(User,Company);
        Buttons.setSpacing(50);
        Buttons.setAlignment(Pos.CENTER);
        jobrecruiter.getChildren().addAll(t,Buttons);
        jobrecruiter.setSpacing(75);
        Finalpane.setCenter(jobrecruiter);


        logout.setOnAction(e -> {
                    {
                        Uinfo.getChildren().clear();
                        Cinfo.getChildren().clear();
                        Iinfo.getChildren().clear();
                        Pinfo.getChildren().clear();
                        PRinfo.getChildren().clear();
                        Sinfo.getChildren().clear();
                        ECAinfo.getChildren().clear();
                        Utarray1.clear();
                        Utarray1.clear();
                        Utarray2.clear();
                        Utarray3.clear();
                        Utarray4.clear();
                        Utarray5.clear();
                        Ularray1.clear();
                        Ularray2.clear();
                        Ularray3.clear();
                        Ularray4.clear();
                        Ularray5.clear();

                        Ctarray1.clear();
                        Ctarray2.clear();
                        Ctarray3.clear();
                        Ctarray4.clear();
                        Ctarray5.clear();
                        Clarray1.clear();
                        Clarray2.clear();
                        Clarray3.clear();
                        Clarray4.clear();
                        Clarray5.clear();

                        Ilarray1.clear();
                        Ilarray2.clear();
                        Ilarray3.clear();
                        Ilarray4.clear();
                        Ilarray5.clear();
                        Itarray1.clear();
                        Itarray2.clear();
                        Itarray3.clear();
                        Itarray4.clear();
                        Itarray5.clear();

                        Ptarray1.clear();
                        Ptarray2.clear();
                        Ptarray3.clear();
                        Ptarray4.clear();
                        Plarray1.clear();
                        Plarray2.clear();
                        Plarray3.clear();
                        Plarray4.clear();

                        PRlarray1.clear();
                        PRlarray2.clear();
                        PRlarray3.clear();
                        PRtarray1.clear();
                        PRtarray2.clear();
                        PRtarray3.clear();

                        Starray1.clear();
                        Starray2.clear();
                        Slarray1.clear();
                        Slarray2.clear();

                        ECAlarray1.clear();
                        ECAlarray2.clear();
                        ECAtarray1.clear();
                        ECAtarray2.clear();

                    }
                    System.out.println("experience array size " + Ctarray1.size());
                    username.setText("");
                    password.setText("");
                    primaryStage.setScene(login);
                }
        );

        Finalscene=new Scene(Finalpane,0.9*r.getWidth(),0.9*r.getHeight());
        primaryStage.setTitle("login");
        primaryStage.setScene(Finalscene);
        primaryStage.show();

    }



}



