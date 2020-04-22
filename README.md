# Teamproject 

자판기 소스를 만들면서 다양한 생각과, scene builder 를 배울 수 있었고 ,

알고리즘 소스를 직접 만들면서 발전 할 수 있는 기회를 주신 김동훈교수님꼐 감사하고 함께 만들면서 고생한 김병헌, 이상원 학우에게 감사의 마음 표합니다.



## 역할 분담

>
>
>이상원 학생은 기본적인 scene builder를 사용할 줄 알아서 기본적인 틀을 만들어주고 그  버튼에 대한 이벤트들을 정리하고 조사하였습니다

> 김병헌 학생은 소스를 확인하면서 줄일 수 있는 부분, 혹은 전체적인 소스에 대한 이해력이 빨라 좀더 효율적인 방법으로 수정하는 역할을 맡았습니다.

> 저는 버튼에 들어가는 이벤트를 작성을 하고, 중점이 되는 알고리즘을 사용하여 거스름돈이 나오는 코드를 제작하였습니다.









## 완성된 코드 소개 및 설명

```
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
```





맨 위부터 설명을 하면 

스트링 변수를 INT로 바꾼 후에 계산을 한 후 다시 총합(tf4)에 다시 넣어주는 

함수이다.



합 과 차는 동일하게 만들어주고



각 버튼에 대한 설명은 

더하기 할 경우에는 처음에 만들었던 함수에 다시 각 메뉴의 가격을 메개변수로 받아서 하나의 함수에 3개의 가격을 한번에 넣을 수 있었다.

(이부분을 하면서 애를 많이 먹긴 했지만 코드의 길이가 조금 길어졌지만 나름 성공한 것 같다.)



각 버튼 tf1,2,3에 대한 함수를 다 만든 후에는



빼기에 대한 설정을 해야하는데  특이한점은 A에대한 가격이 +인 상태에서 B가 -1이 되면 0값을 리턴하는게 아닌 -1를 리턴해서 조금 설정을 해 주었다.

```java
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
```







버튼이 끝난 후에는 

금액을 입력하는 구역을 만들어서 그 가격에 대한 



알고리즘을 적용해서 마지막 최종 거스름돈을 구하였다.

setText 함수를 적용할 경우 for문이 돌아가지 않아서 번거롭더라도 길게 쭉 써서 보이는 형식을 취하였다.





다음은 신빌더를 이용하여 제작하는 과정이다.



![제작 과정](https://user-images.githubusercontent.com/62735361/79826808-a48af980-83d7-11ea-88b8-c34943e975e4.PNG)



## 작동되는 과정





![캡처](https://user-images.githubusercontent.com/62735361/79826790-9c32be80-83d7-11ea-8733-e40282b0b51e.PNG)





정상적으로 작동을 하였다. 



우와아~