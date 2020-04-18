package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.text.Text;

public class Controller implements Initializable {
    // @FXML 꼭 추가해 줘야 함.
    @FXML
    private TextField tf1, tf2, tf3, tf4, tf5;
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
    private Button confirm;
    @FXML
    private Image img1, img2, img3;
    @FXML
    private Text t1;
    @FXML
    private TextArea ta1;

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

    public void func(int t) {
        int tf4int;
        String tf4val; // 현재 금액에 string 가져오기
        String taset;
        tf4val = tf4.getText();
        tf4int = Integer.parseInt(tf4val);
        tf4int += t;
        taset = Integer.toString(tf4int);
        tf4.setText(taset);
    }

    public void subfunc(int t2) {
        int tf4int2;
        String taset2;
        String tf4val;
        tf4val = tf4.getText();
        tf4int2 = Integer.parseInt(tf4val);
        tf4int2 -= t2;
        taset2 = Integer.toString(tf4int2);
        tf4.setText(taset2);
    }

    /*이렇게 쓰는게 좋다*/
    /*수량 더하기 버튼 동작*/
    public void plus(ActionEvent event) {
        int val; //수량에 있는 금액 int로
        String res; // 수량에 있는 string 가져오기
        String set; // 수량에 string 보내기
        String tf4val; // 현재 금액에 string 가져오기

        res = tf1.getText();
        val = Integer.parseInt(res);
        val += 1;
        set = Integer.toString(val);
        tf1.setText(set);
        func(6000);
    }

    public void plus2(ActionEvent event) {
        int val2;
        String res2;
        String set2;

        res2 = tf2.getText();
        val2 = Integer.parseInt(res2);
        val2 += 1;
        set2 = Integer.toString(val2);
        tf2.setText(set2);

        /*현재 금액에 액수 추가*/
        func(3000);
    }

    public void plus3(ActionEvent event) {
        int val3;

        String res3;
        String set3;

        res3 = tf3.getText();
        val3 = Integer.parseInt(res3);
        val3 += 1;
        set3 = Integer.toString(val3);
        tf3.setText(set3);

        /*현재 금액에 액수 추가*/
        func(4500);
    }
    /*--------------수량 더하기 버튼 동작------------*/

    /*수량 빼기 버튼 동작*/
    public void sub1(ActionEvent event) {
        int val3;
        String res3;
        String set3;

        res3 = tf1.getText();
        val3 = Integer.parseInt(res3);
        val3 -= 1;
        set3 = Integer.toString(val3);
        tf1.setText(set3);

        /*금액에서 빼기*/
        subfunc(6000);
        if (val3 < 0) {
            alert.setTitle("ERROR");
            alert.setHeaderText("수량이 없습니다");
            alert.showAndWait();
            tf1.setText("0");
            String a = tf4.getText();
            int r = Integer.parseInt(a);
            r += 6000;
            String e = Integer.toString(r);
            tf4.setText(e);
        }
    }

    public void sub2(ActionEvent event) {
        int val3;
        String res3;
        String set3;

        res3 = tf2.getText();
        val3 = Integer.parseInt(res3);
        val3 -= 1;
        set3 = Integer.toString(val3);
        tf2.setText(set3);

        /*금액에서 빼기*/
        subfunc(3000);
        if (val3 < 0) {
            alert.setTitle("ERROR");
            alert.setHeaderText("수량이 없습니다");
            alert.showAndWait();
            tf2.setText("0");
            String a = tf4.getText();
            int r = Integer.parseInt(a);
            r += 3000;
            String e = Integer.toString(r);
            tf4.setText(e);
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
        subfunc(4500);
        if (val3 < 0) {
            alert.setTitle("ERROR");
            alert.setHeaderText("수량이 없습니다");
            alert.showAndWait();
            tf3.setText("0");
            String a = tf4.getText();
            int r = Integer.parseInt(a);
            r += 4500;
            String e = Integer.toString(r);
            tf4.setText(e);
        }

    }
    /*------------------수량 빼기 버튼 동작------------------*/

    public void confirm() {
        String gettf4 = tf4.getText();
        int gettf4int = Integer.parseInt(gettf4);
        /*금액 입력창*/
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("확인");
        dialog.setHeaderText("투입 금액을 입력하시요");
        dialog.setContentText("금액");
        dialog.showAndWait();
        String a = dialog.getResult();
        tf5.setText(a); //금액 표시
        int resultmon = Integer.parseInt(a);
        int change = resultmon - gettf4int;

        /*거스름돈 알고리즘*/
        int[] coin = {10000, 5000, 1000, 500, 100, 50, 10};
        int leftcoin = 9;
        String[] str = new String[coin.length];
        for (int i = 0; i < coin.length; i++) {
            str[i] = Integer.toString(change / coin[i]);
            if (change / coin[i] > 0) {
                String m = Integer.toString(coin[i]);
                change %= coin[i];
                if (leftcoin >= change) {
                    leftcoin = change;
                }
            }
        }
        /*for문 안됨*/
        t1.setText(coin[0] + "원: " + str[0] + "개" + "\n" +
                coin[1] + "원: " + str[1] + "개" + "\n" +
                coin[2] + "원: " + str[2] + "개" + "\n" +
                coin[3] + "원: " + str[3] + "개" + "\n" +
                coin[4] + "원: " + str[4] + "개" + "\n" +
                coin[5] + "원: " + str[5] + "개" + "\n" +
                coin[6] + "원: " + str[6] + "개" + "\n" +
                "남은 금액: " + leftcoin);
    }
}

