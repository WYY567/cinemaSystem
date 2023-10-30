import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        windows win = new windows();
        win.setVisible(true);
        win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        win.setBounds(60,100,500,300);
    }
}
