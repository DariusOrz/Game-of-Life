package Test;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JPanel;


public class CellTable extends JPanel 
{
	 private int row=100;
	 private int col=100;//�������У�Ĭ��50*50
	 private int num=0;
	 private Cell[][] cell;
	 private int number[][];
	 private boolean pause;
	 private int times=0;//���ܴ���;
	 public CellTable() 
	 {
		 setTable(row,col);  

	 }
	 public int Gettimes()
	 {
		 return times;
	 }
	 public void setTablebyfile(String path) throws Exception
	 {
		 File file1 = new File("./Shape/"+path+".txt"); // ����File�����		
		 FileInputStream fis = new FileInputStream(file1); // ����FileInputStream������ȡFile	
		 InputStreamReader isr =  new InputStreamReader(fis);	 // ����InputStreamReader��������ļ���	
		 BufferedReader br =br = new BufferedReader(isr);	 // ����reader���������ļ���װ��ȥ		
		 String lineTxt = null;			// �ӻ����������ж�ȡ���룬����readLine()����	
		 this.clean();
		 while ((lineTxt = br.readLine()) != null)
		 {	
			String array[]=lineTxt.split(" ") ;
			int first= Integer.valueOf(array[0])>=0?Integer.valueOf(array[0]):row+Integer.valueOf(array[0]);
			int second= Integer.valueOf(array[1])>=0?Integer.valueOf(array[1]):col+Integer.valueOf(array[1]);
			
			try
			{
			cell[first][second].makeAlive();
			}catch(ArrayIndexOutOfBoundsException e)
			{
				throw new Exception("ϸ������������");
			}
		 }
		 	

	 }
	 
	 public void setTable(int row,int col)
	{
		this.row=row;
		this.col=col;
		this.removeAll();
		cell=new Cell[row][col];
		number=new int[row][col];
		setLayout(new GridLayout(row,col,0,0));
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                cell[i][j]=new Cell();
                add(cell[i][j]);
            }
        }
        this.validate();
	}
	 public boolean isPause()
	 {
		 return pause;
	 }
	 
	 public boolean changePause()
	 {
		 pause=pause?false:true;
		 return pause;
	 }
	 
	 
public void updatecolor()
{
	for(int i=0;i<row;i++)
        for(int j=0;j<col;j++)
        	if(cell[i][j].isAlive()) cell[i][j].makeAlive();
}

     public void getNumber()
     {
    	 	for(int i=0;i<row;i++)
    	 	{
	            for(int j=0;j<col;j++)
	            {
	                number[i][j]=0;//number����Χ��ϸ���ĸ���
	                for(int z=i-1;z<i+2;z++)
	                {
	                    for(int y=j-1;y<j+2;y++)
	                    {
	                        if(z<0||z>=row||y<0||y>=col){continue;}
	                        if(cell[z][y].isAlive())
	                            number[i][j]++;
	                    }
	                }
	                //��������ǻ�ϸ���Ļ���number��Ҫ-1
	                if(cell[i][j].isAlive())
	                    number[i][j]--;
	            }
	        }
     }
     public int getCount()
     {
    	 int cnt=0;
    	 for(int i=0;i<row;i++)
	            for(int j=0;j<col;j++)
	            	if(cell[i][j].isAlive()) cnt++;
		return cnt;
    	 
     }
     public void clean()
     {
    	 times=0;//��շ��ܴ���
    	 ControlPnl.cnt.setText("0");
    	 ControlPnl.times.setText("0");
    	 for(int i=0;i<row;i++)
	            for(int j=0;j<col;j++)
	            	cell[i][j].makeDie();
     }
	 public void once(){
		 times++;
		 getNumber();
		 int cnt=0;
	        //��Χ��ϸ���ĸ������������ڣ����Ϊ��ϸ������������ϸ��
		 for(int i=0;i<row;i++)
	        {
	            for(int j=0;j<col;j++)
	            {
	                switch(number[i][j])
	                {

	                    case 2:
	                        break;//����
	                    case 3:
	                        cell[i][j].makeAlive();
	                        break;
	                    default:
	                        cell[i][j].makeDie();;
	                }
	            }
	        }
		 ControlPnl.setcnttext();
		 ControlPnl.settimestext();
	    }
	
}
