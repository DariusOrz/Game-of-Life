package xiaojian;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class Cell extends JButton implements MouseListener {
  private static final long serialVersionUID = 1L; 
  private boolean isalive = false;
  
  /**
   * ��ʼϸ����Ĭ��ϸ������
   * ��Ϊ���������¼�������ı���״̬.
  */ 
  public Cell() {
    setBackground(ConfigUtils.death);
    this.addMouseListener(this);
    
  }
  
  public boolean isAlive() {
    return isalive;
    
  }

  /**
   * ʹϸ�����.
  */ 
  public void makeAlive() {
    isalive = true;
    setBackground(ConfigUtils.alive);
    
  }
  
  /**
   * ʹϸ������.
  */ 
  public void makeDie() {
    isalive = false;
    setBackground(ConfigUtils.death);

  }

  @Override
  public void mouseClicked(MouseEvent e) {
    // TODO �Զ����ɵķ������
 
  }

  @Override
  public void mousePressed(MouseEvent e) {
    // TODO �Զ����ɵķ������
    if (isalive) {
      setBackground(ConfigUtils.death);
      isalive = false;
  }
	else 
	{
		setBackground(ConfigUtils.alive);
		isalive=true;
	}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}

}
