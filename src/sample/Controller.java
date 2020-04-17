package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.*;
import javafx.scene.image.Image;

public class Controller implements Initializable {
    // @FXML 꼭 추가해 줘야 함.
    @FXML
    private TextField tf1, tf2, tf3, tf4;
    @FXML
    private Button plus1;
    @FXML
    private Button plus2;
    @FXML
    private Button plus3;
    @FXML
    private Button sub1;
    @FXML
    private Button sub2;
    @FXML
    private Button sub3;
    @FXML
    private Image img1, img2, img3;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*이런 방법도 있다.*/
        /*plus1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                plus(actionEvent);
            }
        });*/
    }

    Alert alert = new Alert(Alert.AlertType.ERROR);

    /*이렇게 쓰는게 좋다*/
    /*수량 더하기 버튼 동작*/
    public void plus(ActionEvent event) {
        int val; //수량에 있는 금액 int로
        int tf4int; // 현재금액에 액수 가져오기
        String res; // 수량에 있는 string 가져오기
        String set; // 수량에 string 보내기
        String tf4val; // 현재 금액에 string 가져오기
        String taset; // 현재금액에 보낼 string

        res = tf1.getText();
        val = Integer.parseInt(res);
        val += 1;
        set = Integer.toString(val);
        tf1.setText(set);

        /*현재 금액에 액수 추가*/
        tf4val = tf4.getText();
        tf4int = Integer.parseInt(tf4val);
        tf4int += 6000;
        taset = Integer.toString(tf4int);
        tf4.setText(taset);
    }

    public void plus2(ActionEvent event) {
        int val2;
        int tf4int2;
        String res2;
        String set2;
        String tf4val;
        String taset2;

        res2 = tf2.getText();
        val2 = Integer.parseInt(res2);
        val2 += 1;
        set2 = Integer.toString(val2);
        tf2.setText(set2);

        /*현재 금액에 액수 추가*/
        tf4val = tf4.getText();
        tf4int2 = Integer.parseInt(tf4val);
        tf4int2 += 3000;
        taset2 = Integer.toString(tf4int2);
        tf4.setText(taset2);
    }

    public void plus3(ActionEvent event) {
        int val3;
        int tf4int2;
        String res3;
        String set3;
        String tf4val;
        String taset2;

        res3 = tf3.getText();
        val3 = Integer.parseInt(res3);
        val3 += 1;
        set3 = Integer.toString(val3);
        tf3.setText(set3);

        /*현재 금액에 액수 추가*/
        tf4val = tf4.getText();
        tf4int2 = Integer.parseInt(tf4val);
        tf4int2 += 4500;
        taset2 = Integer.toString(tf4int2);
        tf4.setText(taset2);
    }
    /*--------------수량 더하기 버튼 동작------------*/

    /*수량 빼기 버튼 동작*/
    public void sub1(ActionEvent event) {
        int tf4int2;
        int val3;
        String res3;
        String set3;
        String tf4val;
        String taset2;

        res3 = tf1.getText();
        val3 = Integer.parseInt(res3);
        val3 -= 1;
        set3 = Integer.toString(val3);
        tf1.setText(set3);

        /*금액에서 빼기*/
        tf4val = tf4.getText();
        tf4int2 = Integer.parseInt(tf4val);
        tf4int2 -= 6000;
        taset2 = Integer.toString(tf4int2);
        tf4.setText(taset2);
        if (val3 < 0) {
            alert.setTitle("ERROR");
            alert.setHeaderText("수량이 없습니다");
            alert.showAndWait();
        }
    }

    public void sub2(ActionEvent event) {
        int tf4int2;
        int val3;
        String res3;
        String set3;
        String tf4val;
        String taset2;

        res3 = tf2.getText();
        val3 = Integer.parseInt(res3);
        val3 -= 1;
        set3 = Integer.toString(val3);
        tf2.setText(set3);

        /*금액에서 빼기*/
        tf4val = tf4.getText();
        tf4int2 = Integer.parseInt(tf4val);
        tf4int2 -= 3000;
        taset2 = Integer.toString(tf4int2);
        tf4.setText(taset2);
        if (val3 < 0) {
            alert.setTitle("ERROR");
            alert.setHeaderText("수량이 없습니다");
            alert.showAndWait();
        }
    }

    public void sub3(ActionEvent event) {
        int tf4int2;
        int val3;
        String set3;
        String res3;
        String tf4val;
        String taset2;

        res3 = tf3.getText();
        val3 = Integer.parseInt(res3);
        val3 -= 1;
        set3 = Integer.toString(val3);
        tf3.setText(set3);

        /*금액에서 빼기*/
        tf4val = tf4.getText();
        tf4int2 = Integer.parseInt(tf4val);
        tf4int2 -= 4500;
        taset2 = Integer.toString(tf4int2);
        tf4.setText(taset2);
        if (val3 < 0) {
            alert.setTitle("ERROR");
            alert.setHeaderText("수량이 없습니다");
            alert.showAndWait();
        }

    }
    /*------------------수량 빼기 버튼 동작------------------*/
}

