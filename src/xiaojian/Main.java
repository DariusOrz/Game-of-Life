package xiaojian;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;


public class Main extends JFrame {
  private static final long serialVersionUID = 1L; 
  private CellTable ct;
  private CellTableAdapter adapter;
  private ControlPnl cpnl;
  
  /**
  * 2019/5/5 created by xiaojian
  ***** �����湹��
  ��ControlPnl��CellTable���������.
  */ 
  public Main() {
    ct = new CellTable();
    ct.setPreferredSize(new Dimension(800,800));
    adapter=new CellTableAdapter(ct);
    cpnl = new ControlPnl(adapter,this);
    cpnl.setPreferredSize(new Dimension(800,100));
    setTitle("С��������Ϸ");
    try {
    	adapter.setTablebyfile("�����ǹ");
    } catch (Exception e) {
      // TODO �Զ����ɵ� catch ��
      e.printStackTrace();
    }
    setLayout(new BorderLayout());
        
    add(BorderLayout.WEST,cpnl);
    add(BorderLayout.SOUTH,ct);
    ControlPnl.setcnttext();
    ControlPnl.settimestext();
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);
     
  }
  
  /**
   * �������.
   */ 
  public static void main(String[] args) {
    Main m = new Main();
    m.setSize(850,900);
    m.setVisible(true);
    
  }
  
}
