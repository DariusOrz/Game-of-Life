package Test;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class Cell extends JButton implements MouseListener{
	
	private boolean isalive=false;
	
	public Cell()
	{
		setBackground(Config.death);
		this.addMouseListener(this);
	}
	public boolean isAlive()
	{
		return isalive;
	}
	
	public void makeAlive()
	{
		isalive=true;
		setBackground(Config.alive);
	}
	
	public void makeDie()
	{
		isalive=false;
		setBackground(Config.death);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO �Զ����ɵķ������
		if(isalive) 
		{
		setBackground(Config.death);
		isalive=false;
		}
	else 
	{
		setBackground(Config.alive);
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
