import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComputerListener implements ActionListener {
    String s;
    public void setShenfen(String s){
        this.s = s;
    }
    public void actionPerformed(ActionEvent e) {
        try{
            if(s.equals("用户")){
                Member chengyuan = new Member();
            }
            if(s.equals("前台")){
                frontDesk qiantai = new frontDesk();
            }
            if(s.equals("管理员")){
                Administrator guanliyuan = new Administrator();
            }
            if(s.equals("经理")){
                Manager jingli = new Manager();
            }
        }
        catch (Exception exp){
            System.out.println("请下拉列表选择您的身份");
        }
    }
}
