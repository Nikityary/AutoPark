package com.example.autopark;

import javafx.collections.*;
import javafx.fxml.*;

import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

public class HelloController implements Initializable {
    @FXML
    private TextArea bug;
    @FXML
    private ComboBox box;
    @FXML
    private Label l2, l3, l4, l5, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l22, l23;
    @FXML
    private ProgressBar l1, l6, l7, l8, l9, l10, l21;
    @FXML
    private ImageView im1, im2, im3, im4, im5, im6;
    @FXML
    private Button bt1, upt_bt, submit_bt, nw_bt, yes_bt, cont_bt, close_bt, yes_bt1;
    @FXML
    private CheckBox ch10, ch11, ch12, ch13,ch14,ch15,ch16,ch17,ch18,ch19,ch110,ch111,ch112,ch113,ch114,ch115,ch116,ch117, k2, k3, k4, k5, k11, k12, k13, k14, k15, k16, k17, k18;
    @FXML
    private TextField e3, e4, na1;
    @FXML
    private DatePicker e2;
    @FXML
    private AnchorPane npane;
    @FXML
    private Line line1, line2;
    @FXML
    private Slider k1, k6, k7, k8, k9, k10;

    public String user = "Nikityara";
    public String password = "qwerly123098";
    public String url = "jdbc:mysql://213.167.218.132:3306/AutoPark";
    public String old_auto = "";
    public double engine;
    public String front_left_wheel;
    public String front_right_wheel;
    public String rear_left_wheel;
    public String rear_right_wheel;
    public double oil;
    public double front_left_brake;
    public double front_right_brake;
    public double rear_left_brake;
    public double rear_right_brake;
    public String front_left_turn_signal;
    public String front_right_turn_signal;
    public String rear_left_turn_signal;
    public String rear_right_turn_signal;
    public String left_headlight;
    public String right_headlight;
    public String left_brake_light;
    public String right_brake_light;
    boolean k = true;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        fill_box();
        fill_auto_status();
        fill_images();

    }
    public void fill_box(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = "select auto_name from auto";
            Statement statement = connection.createStatement();
            ResultSet answ =  statement.executeQuery(sql);
            ObservableList<String> items = FXCollections.observableArrayList();
            while (answ.next()){
                items.add(answ.getString("auto_name"));
            }
            connection.close();
            box.setItems(items);
            box.setValue(box.getItems().get(0));
            old_auto = box.getSelectionModel().getSelectedItem().toString();
            } catch (SQLException e) {
                bug.setText(String.valueOf(e));
            }
            catch (ClassNotFoundException e){
                bug.setText("Ошибка драйвера:\n" + e);
            }
            catch (Exception e){
            bug.setText(String.valueOf(e));
        }
    }
    public void fill_auto_status(){
        try {
            old_auto = box.getSelectionModel().getSelectedItem().toString();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = "select * from auto where auto_name ='"+box.getSelectionModel().getSelectedItem().toString()+"'";
            Statement statement = connection.createStatement();
            ResultSet answ =  statement.executeQuery(sql);
            answ.next();

            engine = Double.parseDouble(answ.getString("motor"));
            front_left_wheel = answ.getString("front_left_wheel");
            front_right_wheel = answ.getString("front_right_wheel");
            rear_left_wheel = answ.getString("rear_left_wheel");
            rear_right_wheel = answ.getString("rear_right_wheel");
            oil = Double.parseDouble(answ.getString("oil"));
            front_left_brake = Double.parseDouble(answ.getString("front_left_brake"));
            front_right_brake = Double.parseDouble(answ.getString("front_right_brake"));
            rear_left_brake = Double.parseDouble(answ.getString("rear_left_brake"));
            rear_right_brake = Double.parseDouble(answ.getString("rear_right_brake"));
            front_left_turn_signal = answ.getString("front_left_turn_signal");
            front_right_turn_signal = answ.getString("front_right_turn_signal");
            rear_left_turn_signal = answ.getString("rear_left_turn_signal");
            rear_right_turn_signal = answ.getString("rear_right_turn_signal");
            left_headlight = answ.getString("left_headlight");
            right_headlight = answ.getString("right_headlight");
            left_brake_light = answ.getString("left_brake_light");
            right_brake_light = answ.getString("right_brake_light");

            l1.setProgress(engine/100);
            if(front_left_wheel.equals("1")){l2.setText("Исправно");l2.setStyle("-fx-text-fill: black;");}else{l2.setText("Неисправно");l2.setStyle("-fx-text-fill: red;");}
            if(front_right_wheel.equals("1")){l3.setText("Исправно");l3.setStyle("-fx-text-fill: black;");}else{l3.setText("Неисправно");l3.setStyle("-fx-text-fill: red;");}
            if(rear_left_wheel.equals("1")){l4.setText("Исправно");l4.setStyle("-fx-text-fill: black;");}else{l4.setText("Неисправно");l4.setStyle("-fx-text-fill: red;");}
            if(rear_right_wheel.equals("1")){l5.setText("Исправно");l5.setStyle("-fx-text-fill: black;");}else{l5.setText("Неисправно");l5.setStyle("-fx-text-fill: red;");}
            l6.setProgress(oil/100);
            l7.setProgress(front_left_brake/100);
            l8.setProgress(front_right_brake/100);
            l9.setProgress(rear_left_brake/100);
            l10.setProgress(rear_right_brake/100);
            if(front_left_turn_signal.equals("1")){l11.setText("Исправно");l11.setStyle("-fx-text-fill: black;");}else{l11.setText("Неисправно");l11.setStyle("-fx-text-fill: red;");}
            if(front_right_turn_signal.equals("1")){l12.setText("Исправно");l12.setStyle("-fx-text-fill: black;");}else{l12.setText("Неисправно");l12.setStyle("-fx-text-fill: red;");}
            if(rear_left_turn_signal.equals("1")){l13.setText("Исправно");l13.setStyle("-fx-text-fill: black;");}else{l13.setText("Неисправно");l13.setStyle("-fx-text-fill: red;");}
            if(rear_right_turn_signal.equals("1")){l14.setText("Исправно");l14.setStyle("-fx-text-fill: black;");}else{l14.setText("Неисправно");l14.setStyle("-fx-text-fill: red;");}
            if(left_headlight.equals("1")){l15.setText("Исправно");l15.setStyle("-fx-text-fill: black;");}else{l15.setText("Неисправно");l15.setStyle("-fx-text-fill: red;");}
            if(right_headlight.equals("1")){l16.setText("Исправно");l16.setStyle("-fx-text-fill: black;");}else{l16.setText("Неисправно");l16.setStyle("-fx-text-fill: red;");}
            if(left_brake_light.equals("1")){l17.setText("Исправно");l17.setStyle("-fx-text-fill: black;");}else{l17.setText("Неисправно");l17.setStyle("-fx-text-fill: red;");}
            if(right_brake_light.equals("1")){l18.setText("Исправно");l18.setStyle("-fx-text-fill: black;");}else{l18.setText("Неисправно");l18.setStyle("-fx-text-fill: red;");}

            sql = "select id, auto_name, departure_date, arrival_date, \n" +
                    "start_point, end_point, on_the_way from transportation_plan where auto_name = '"+box.getSelectionModel().getSelectedItem().toString()+"'";
            statement = connection.createStatement();
            answ =  statement.executeQuery(sql);
            answ.next();
            l19.setText(reformate_date(answ.getString("departure_date")));
            l20.setText(reformate_date(answ.getString("arrival_date")));

            LocalDate fromDate = LocalDate.parse(answ.getString("departure_date"));
            LocalDate toDate = LocalDate.parse(answ.getString("arrival_date"));
            LocalDate nowDate = LocalDate.now();
            long daysBetween = ChronoUnit.DAYS.between(fromDate, toDate);
            long daysBetween1 = ChronoUnit.DAYS.between(nowDate, toDate);
            double percent = (double) (daysBetween - daysBetween1)/daysBetween;
            l21.setProgress(percent);
            if (percent<1){
                e2.setVisible(false);
                e3.setVisible(false);
                e4.setVisible(false);
                nw_bt.setDisable(true);
                yes_bt.setDisable(true);
            }else {
                e2.setVisible(false);
                e3.setVisible(false);
                e4.setVisible(false);
                nw_bt.setDisable(false);
                yes_bt.setDisable(false);
            }
            l22.setText(answ.getString("start_point")+"--");
            l23.setText("->"+answ.getString("end_point"));
            connection.close();
        }
        catch (SQLException e) {
            bug.setText(String.valueOf(e));
        }
            catch (ClassNotFoundException e){
            bug.setText("Ошибка драйвера:\n" + e);
        }
            catch (Exception e){
            bug.setText(String.valueOf(e));
        }
    }
    public String reformate_date(String date){
        LocalDate locdate = LocalDate.parse(date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return String.valueOf(locdate.format(formatter));
    }
    public void fill_images(){
        try {
            Image image1 = null;
            Image image2 = null;
            Image image3 = null;
            Image image4 = null;
            Image image5;
            Image image6;

            if(rear_right_wheel.equals("1")&&rear_right_brake>20){
                image1 = new Image("file:images/Lada_R_B.png");
            }
            else if (rear_right_wheel.equals("0")&&rear_right_brake<21) {
                image1 = new Image("file:images/Lada_R_B_3.png");
            } else if (rear_right_wheel.equals("0")) {
                image1 = new Image("file:images/Lada_R_B_1.png");
            } else if (rear_right_brake<16) {
                image1 = new Image("file:images/Lada_R_B_2.png");
            }

            if(front_right_wheel.equals("1")&&front_right_brake>20){
                image2 = new Image("file:images/lada_R_F.png");
            }
            else if (front_right_wheel.equals("0")&&front_right_brake<21) {
                image2 = new Image("file:images/Lada_R_F_3.png");
            } else if (front_right_wheel.equals("0")) {
                image2 = new Image("file:images/Lada_R_F_1.png");
            } else if (front_right_brake<16) {
                image2 = new Image("file:images/Lada_R_F_2.png");
            }

            if(rear_left_wheel.equals("1")&&rear_left_brake>20){
                image3 = new Image("file:images/Lada_L_B.png");
            }
            else if (rear_left_wheel.equals("0")&&rear_left_brake<21) {
                image3 = new Image("file:images/Lada_L_B_3.png");
            } else if (rear_left_wheel.equals("0")) {
                image3 = new Image("file:images/Lada_L_B_1.png");
            } else if (rear_left_brake<16) {
                image3 = new Image("file:images/Lada_L_B_2.png");
            }

            if(front_left_wheel.equals("1")&&front_left_brake>20){
                image4 = new Image("file:images/lada_L_F.png");
            }
            else if (front_left_wheel.equals("0")&&front_left_brake<21) {
                image4 = new Image("file:images/Lada_L_F_3.png");
            } else if (front_right_wheel.equals("0")) {
                image4 = new Image("file:images/Lada_L_F_1.png");
            } else if (front_left_brake<16) {
                image4 = new Image("file:images/Lada_L_F_2.png");
            }

            String binaryRepresentation = front_right_turn_signal  + right_headlight + left_headlight + front_left_turn_signal;
            int signalValue = Integer.parseInt(binaryRepresentation, 2);
            image5 = new Image(SignalImageMapper.getImagePath(signalValue));

            binaryRepresentation = rear_left_turn_signal + left_brake_light + right_brake_light + rear_right_turn_signal;
            signalValue = Integer.parseInt(binaryRepresentation, 2);
            image6 = new Image(SignalImageMapper.getImagePath1(signalValue));

            im1.setImage(image1);
            im2.setImage(image2);
            im3.setImage(image3);
            im4.setImage(image4);
            im5.setImage(image5);
            im6.setImage(image6);
        } catch (Exception e) {
            bug.setText(String.valueOf(e));
        }
    }

    @FXML
    public void auto_changed(){
        if (!old_auto.equals(box.getSelectionModel().getSelectedItem().toString())) {
            fill_auto_status();
            fill_images();
        }
    }
    @FXML
    public void bt1_click(){
        if (im1.isVisible()){
            im1.setVisible(false);
            im2.setVisible(false);
            im3.setVisible(true);
            im4.setVisible(true);
        }
        else{
            im1.setVisible(true);
            im2.setVisible(true);
            im3.setVisible(false);
            im4.setVisible(false);
        }
    }
    @FXML
    public void upt_bt_click(){
        submit_bt.setVisible(true);
        boolean[] conditions = {
                engine != 100,
                "0".equals(front_left_wheel),
                "0".equals(front_right_wheel),
                "0".equals(rear_left_wheel),
                "0".equals(rear_right_wheel),
                oil != 100,
                front_left_brake != 100,
                front_right_brake != 100,
                rear_left_brake != 100,
                rear_right_brake != 100,
                "0".equals(front_left_turn_signal),
                "0".equals(front_right_turn_signal),
                "0".equals(rear_left_turn_signal),
                "0".equals(rear_right_turn_signal),
                "0".equals(left_headlight),
                "0".equals(right_headlight),
                "0".equals(left_brake_light),
                "0".equals(right_brake_light)
        };
        CheckBox[] checkboxes = {ch10, ch11, ch12, ch13, ch14, ch15, ch16, ch17, ch18, ch19, ch110, ch111, ch112, ch113, ch114, ch115, ch116, ch117};
        for (int i = 0; i < conditions.length; i++) {
            if (conditions[i]) {
                checkboxes[i].setVisible(true);
            }
        }
        for (CheckBox checkbox : checkboxes) {
            checkbox.setSelected(false);
        }
    }

    @FXML
    public void submit_bt_click(){
        submit_bt.setVisible(false);
        CheckBox[] checkboxes = {ch10, ch11, ch12, ch13, ch14, ch15, ch16, ch17, ch18, ch19, ch110, ch111, ch112, ch113, ch114, ch115, ch116, ch117};
        for (CheckBox checkbox : checkboxes) {
            checkbox.setVisible(false);
        }
        try {
            String a1 = ch10.isSelected() ? "100" : String.valueOf(engine);
            String a2 = ch11.isSelected() ? "1" : front_left_wheel;
            String a3 = ch12.isSelected() ? "1" : front_right_wheel;
            String a4 = ch13.isSelected() ? "1" : rear_left_wheel;
            String a5 = ch14.isSelected() ? "1" : rear_right_wheel;
            String a6 = ch15.isSelected() ? "100" : String.valueOf(oil);
            String a7 = ch16.isSelected() ? "100" : String.valueOf(front_left_brake);
            String a8 = ch17.isSelected() ? "100" : String.valueOf(front_right_brake);
            String a9 = ch18.isSelected() ? "100" : String.valueOf(rear_left_brake);
            String a10 = ch19.isSelected() ? "100" : String.valueOf(rear_right_brake);
            String a11 = ch110.isSelected() ? "1" : front_left_turn_signal;
            String a12 = ch111.isSelected() ? "1" : front_right_turn_signal;
            String a13 = ch112.isSelected() ? "1" : rear_left_turn_signal;
            String a14 = ch113.isSelected() ? "1" : rear_right_turn_signal;
            String a15 = ch114.isSelected() ? "1" : left_headlight;
            String a16 = ch115.isSelected() ? "1" : right_headlight;
            String a17 = ch116.isSelected() ? "1" : left_brake_light;
            String a18 = ch117.isSelected() ? "1" : right_brake_light;

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = "update auto set \n" +
                "motor = '"+a1+"', \n" +
                "front_left_wheel = '"+a2+"', \n" +
                "front_right_wheel = '"+a3+"', \n" +
                "rear_left_wheel = '"+a4+"', \n" +
                "rear_right_wheel = '"+a5+"', \n" +
                "oil = '"+a6+"',\n" +
                "front_left_brake = '"+a7+"',\n" +
                "front_right_brake = '"+a8+"',\n" +
                "rear_left_brake = '"+a9+"',\n" +
                "rear_right_brake = '"+a10+"',\n" +
                "front_left_turn_signal = '"+a11+"',\n" +
                "front_right_turn_signal = '"+a12+"',\n" +
                "rear_left_turn_signal = '"+a13+"',\n" +
                "rear_right_turn_signal = '"+a14+"',\n" +
                "left_headlight = '"+a15+"',\n" +
                "right_headlight = '"+a16+"',\n" +
                "left_brake_light = '"+a17+"',\n" +
                "right_brake_light = '"+a18+"'\n" +
                "where auto_name = '"+box.getSelectionModel().getSelectedItem().toString()+"';";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            fill_auto_status();
            fill_images();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for (CheckBox checkbox : checkboxes) {
            checkbox.setSelected(false);
        }
    }

    @FXML
    public void nw_bt_click(){
        e2.setVisible(true);
        e3.setVisible(true);
        e4.setVisible(true);
        l19.setVisible(false);
        l20.setVisible(false);
        l22.setVisible(false);
        l23.setVisible(false);
    }
    @FXML
    public void yes_bt_click(){
        e2.setVisible(false);
        e3.setVisible(false);
        e4.setVisible(false);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            LocalDate locdate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
            locdate.format(formatter);

            LocalDate locdate1 = e2.getValue();
            locdate1.format(formatter);

            String sql ="update transportation_plan set \n" +
                    "departure_date = '"+locdate+"', \n" +
                    "arrival_date='"+locdate1+"', \n" +
                    "start_point='"+e3.getText()+"', \n" +
                    "end_point='"+e4.getText()+"', \n" +
                    "on_the_way ='1' \n" +
                    "where auto_name = '"+box.getSelectionModel().getSelectedItem().toString()+"'";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            l19.setVisible(true);
            l20.setVisible(true);
            l22.setVisible(true);
            l23.setVisible(true);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void date_edit(){
        if (LocalDate.now().isBefore(e2.getValue())) {
            yes_bt.setDisable(false);
        }else {
            yes_bt.setDisable(true);
        }
    }
    @FXML
    public void cont_bt_click(){
        line1.setVisible(true);
        line2.setVisible(true);
        npane.setVisible(true);
        im1.setVisible(false);
        im2.setVisible(false);
        im3.setVisible(false);
        im4.setVisible(false);
        im5.setVisible(false);
        im6.setVisible(false);
    }
    @FXML
    public void close_bt_click(){
        line1.setVisible(false);
        line2.setVisible(false);
        npane.setVisible(false);
        im1.setVisible(true);
        im2.setVisible(true);
        im3.setVisible(true);
        im4.setVisible(true);
        im5.setVisible(true);
        im6.setVisible(true);
    }
    @FXML
    public void yes_bt1_click(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = "select MAX(id) AS id from auto;";
            Statement statement = connection.createStatement();
            ResultSet answ = statement.executeQuery(sql);
            answ.next();
            int id = Integer.parseInt(answ.getString("id")) + 1;
            String nk2 = k2.isSelected() ? "1" : "0";
            String nk3 = k3.isSelected() ? "1" : "0";
            String nk4 = k4.isSelected() ? "1" : "0";
            String nk5 = k5.isSelected() ? "1" : "0";
            String nk11 = k11.isSelected() ? "1" : "0";
            String nk12 = k12.isSelected() ? "1" : "0";
            String nk13 = k13.isSelected() ? "1" : "0";
            String nk14 = k14.isSelected() ? "1" : "0";
            String nk15 = k15.isSelected() ? "1" : "0";
            String nk16 = k16.isSelected() ? "1" : "0";
            String nk17 = k17.isSelected() ? "1" : "0";
            String nk18 = k18.isSelected() ? "1" : "0";
            sql = "insert into auto value ('"+id+"'," +
                    "'"+na1.getText()+"'," +
                    "'"+k1.getValue()+"'," +
                    "'"+nk2+"'," +
                    "'"+nk3+"'," +
                    "'"+nk4+"'," +
                    "'"+nk5+"'," +
                    "'"+k6.getValue()+"'," +
                    "'"+k7.getValue()+"'," +
                    "'"+k8.getValue()+"'," +
                    "'"+k9.getValue()+"'," +
                    "'"+k10.getValue()+"'," +
                    "'"+nk11+"'," +
                    "'"+nk12+"'," +
                    "'"+nk13+"'," +
                    "'"+nk14+"'," +
                    "'"+nk15+"'," +
                    "'"+nk16+"'," +
                    "'"+nk17+"'," +
                    "'"+nk18+"')";
            statement = connection.createStatement();
            statement.execute(sql);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        line1.setVisible(false);
        line2.setVisible(false);
        npane.setVisible(false);
        im1.setVisible(true);
        im2.setVisible(true);
        im3.setVisible(true);
        im4.setVisible(true);
        im5.setVisible(true);
        im6.setVisible(true);
        fill_box();
    }
    @FXML
    public void na1_set(){
        if (!na1.equals("")||!na1.equals(" ")){
            yes_bt1.setDisable(false);
        }
        else
            yes_bt1.setDisable(true);
    }
}