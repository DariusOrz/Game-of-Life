package xiaojian;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class ControlPnl extends JPanel implements ActionListener ,ChangeListener{
	private static CellTableAdapter adapter;
	JMenuBar menuBar=new JMenuBar();
    JMenu game_seting=new JMenu("��Ϸ");
    JMenu preview_seting=new JMenu("Ԥ��");
    JMenuItem gs[]= {new JMenuItem("25*25"), 
    		         new JMenuItem("50*50"),  
    		         new JMenuItem("100*100")};
    JMenuItem ps[]= {new JMenuItem("�����"),
    		         new JMenuItem("���ͷɴ�"),
    		         new JMenuItem("���ͷɴ�"),
    		         new JMenuItem("���ͷɴ�"),
    		         new JMenuItem("�̻�"),
    		         new JMenuItem("���1��"),
    		         new JMenuItem("ʮ�岽"),
    		         new JMenuItem("����"),
    		         new JMenuItem("60P5H2V0�ɴ�"),
    		         new JMenuItem("�����ǹ"),
    		         new JMenuItem("һ����")
    };
    JButton btn=new JButton();
    JButton once=new JButton();
    JButton cleanbtn=new JButton();
    JButton color=new JButton();
    static JLabel cnt=new JLabel();
    static JLabel times=new JLabel();//���ܴ���
    JSlider settime=new JSlider();
    JLabel refreshtime=new JLabel();
   // JButton icon[]=new JButton[8];
    public ControlPnl(CellTableAdapter adapter, Main main)
    {
    	this.adapter=adapter;
    	//setBackground(new Color(255,255,255));
    	setLayout(new FlowLayout());
    	
    	for(int i=0;i<gs.length;i++)
    	{
    		gs[i].addActionListener(this);
            game_seting.add(gs[i]);
    		
    	}
    	for(int i=0;i<ps.length;i++)
    	{
    		ps[i].addActionListener(this);
            preview_seting.add(ps[i]);
    		
    	}
    	menuBar.add(game_seting);
        menuBar.add(preview_seting);
      //�˵���
        
        btn.setBackground(new Color(255,255,255));
        btn.setSize(20,20);
        btn.setPreferredSize(new Dimension(20,20));
        btn.addActionListener(this);
        setIcon("./drawable/play.png",btn);
        //��ʼ��ť
        once.setBackground(new Color(255,255,255));
        once.setSize(20,20);
        once.setPreferredSize(new Dimension(20,20));
        once.addActionListener(this);
        setIcon("./drawable/next.png",once);
        
        cleanbtn.setBackground(new Color(255,255,255));
        cleanbtn.setSize(20,20);
        cleanbtn.setPreferredSize(new Dimension(20,20));
        cleanbtn.addActionListener(this);
        setIcon("./drawable/clean.png",cleanbtn);
        //���ð�ť
        color.setBackground(new Color(255,255,255));
        color.setSize(20,20);
        color.setPreferredSize(new Dimension(20,20));
        color.addActionListener(this);
        setIcon("./drawable/color.jpg",color);
        //��ɫѡ��
        JLabel cnttext=new JLabel();
        cnttext.setPreferredSize(new Dimension(100,20));
        cnttext.setForeground(Color.GREEN);
        cnttext.setText("���ϸ��������");
        cnttext.setHorizontalAlignment(JLabel.CENTER);
        cnt.setPreferredSize(new Dimension(30,10));
        cnt.setHorizontalAlignment(JLabel.CENTER);
        cnt.setForeground(Config.alive);
        //ϸ���������ʾ
        JLabel timestext=new JLabel();
        timestext.setPreferredSize(new Dimension(100,20));
        timestext.setForeground(Color.GREEN);
        timestext.setText("���ܴ�����");
        timestext.setHorizontalAlignment(JLabel.CENTER);
        times.setPreferredSize(new Dimension(30,10));
        times.setHorizontalAlignment(JLabel.CENTER);
        times.setForeground(Config.alive);
        //ϸ���������ʾ
        settime=new JSlider(SwingConstants.HORIZONTAL,1,1000,1);
        settime.setPreferredSize(new Dimension(200,10));
        settime.setValue(100);
        settime.addChangeListener(this);
        //ʱ��ؼ�
        refreshtime.setPreferredSize(new Dimension(50,10));
        refreshtime.setForeground(Color.MAGENTA);

        refreshtime.setText(Config.freshtime+"ms");
        
		/*
		 * for(int i=0;i<8;i++) { icon[i]=new JButton(); icon[i].setBackground(new
		 * Color(255,255,255)); icon[i].setSize(70,70); icon[i].setPreferredSize(new
		 * Dimension(70,70)); icon[i].addActionListener(this);
		 * setIcon("./icon/icon"+i+".png", icon[i]); }
		 */
        add(menuBar);
        add(btn);
        add(once);
        add(cleanbtn);
        add(color);
        add(cnttext);
        add(cnt);
        add(timestext);
        add(times);
        add(settime);
        add(refreshtime);
		/*
		 * for(int i=0;i<8;i++) { add(icon[i]); }
		 */
        
       
    }
    public static void setcnttext()
    {
    	cnt.setForeground(Config.alive);
    	cnt.setText(adapter.getCount()+"");
    }
    public static void settimestext()
    {
    	times.setForeground(Config.alive);
    	times.setText(adapter.Gettimes()+"");
    }
    public void setIcon(String file, JButton iconButton) {
    		ImageIcon icon = new ImageIcon(file);
    		Image temp = icon.getImage().getScaledInstance(iconButton.getWidth(),
    				iconButton.getHeight(), icon.getImage().SCALE_DEFAULT);
    		icon = new ImageIcon(temp);
    		iconButton.setIcon(icon);
    	}


	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource().equals(btn))
		{
		if(adapter.isPause())  setIcon("./drawable/play.png",btn);
		else  setIcon("./drawable/pause.png",btn);
		// TODO �Զ����ɵķ������
		adapter.changePause();
		RunThread b= new RunThread(adapter);
		b.start();
		}
		else if(e.getSource().equals(once)) 
		{
			adapter.once();
		}
		else if(e.getSource().equals(cleanbtn))
			adapter.clean();
		else if(e.getSource().equals(color))
		{
			Config.setcolor();
			adapter.GetCellTable(). updatecolor();
		}
		else if(e.getActionCommand()=="25*25")
		{
			adapter.GetCellTable().setTable(25,25);
			adapter.GetCellTable().updatecolor();
		}
		else if(e.getActionCommand()=="50*50")
		{
			adapter.GetCellTable().setTable(50,50);
			adapter.GetCellTable().updatecolor();
		}
		else if(e.getActionCommand()=="100*100")
		{
			adapter.GetCellTable().setTable(100,100);
			adapter.GetCellTable().updatecolor();
		}
		else
		{
			try {
				adapter.setTablebyfile(e.getActionCommand());
				ControlPnl.setcnttext();
				
			} catch (Exception e1) {
				// TODO �Զ����ɵ� catch ��
			}
		}
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO �Զ����ɵķ������
		refreshtime.setText(settime.getValue()+"ms");
		Config.settime(settime.getValue());
	}
	
}
