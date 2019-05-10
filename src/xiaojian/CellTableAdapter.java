package xiaojian;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class CellTableAdapter {
	private static CellTable ct;
	private boolean pause;
	private int times = 0;//���ܴ���;
	private int [][] number;
	public CellTableAdapter(CellTable ct)
	{
		this.ct=ct;
	}
	public CellTable GetCellTable()
	{
		return ct;
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
	 public int Gettimes() {
		 return times;
	 }
    public void clean()
    {
   	 times=0;//��շ��ܴ���
   	 ControlPnl.cnt.setText("0");
   	 ControlPnl.times.setText("0");
   	 for(int i=0;i<ct.Getrow();i++)
	            for(int j=0;j<ct.Getcol();j++)
	            	ct.getCell(i, j).makeDie();
    }
    public void setTablebyfile(String path) throws Exception
	 {
		 File file1 = new File("./Shape/"+path+".txt"); // ����File�����		
		 FileInputStream fis = new FileInputStream(file1); // ����FileInputStream������ȡFile	
		 InputStreamReader isr =  new InputStreamReader(fis);	 // ����InputStreamReader��������ļ���	
		 BufferedReader br =br = new BufferedReader(isr);	 // ����reader���������ļ���װ��ȥ		
		 String lineTxt = null;			// �ӻ����������ж�ȡ���룬����readLine()����	
		 this.clean();//���ϸ��Ⱥ���֣�ʹ����ϸ������
		 while ((lineTxt = br.readLine()) != null)
		 {	
			String array[]=lineTxt.split(" ") ;
			int first= Integer.valueOf(array[0])>=0?Integer.valueOf(array[0]):ct.Getrow()+Integer.valueOf(array[0]);
			int second= Integer.valueOf(array[1])>=0?Integer.valueOf(array[1]):ct.Getcol()+Integer.valueOf(array[1]);
			try
			{
				ct.getCell(first,second).makeAlive();
			}catch(ArrayIndexOutOfBoundsException e)
			{
				throw new Exception("ϸ������������");
			}
		 }
		 
	 }
    public void getNumber()
    {
    	number=new int[ct.Getrow()][ct.Getcol()];
   	 	for(int i=0;i<ct.Getrow();i++)
   	 	{
	            for(int j=0;j<ct.Getcol();j++)
	            {
	                number[i][j]=getNearNumber(i,j);//number����Χ��ϸ���ĸ���
	               
	            }
	        }
    }
    public int getNearNumber(int i,int j) {
   	 int num=0;
   	 for(int z=i-1;z<i+2;z++)
        {
            for(int y=j-1;y<j+2;y++)
            {
                if(z<0||z>=ct.Getrow()||y<0||y>=ct.Getcol()){continue;}//�߽�Խ��
                if(ct.getCell(z, y).isAlive())
                    num++;
            }
        }
        //��������ǻ�ϸ���Ļ���number��Ҫ-1
        if(ct.getCell(i, j).isAlive())
            num--;
		return num;
    }
    public int getCount()
    {
   	 int cnt=0;
   	 for(int i=0;i<ct.Getrow();i++)
	            for(int j=0;j<ct.Getcol();j++)
	            	if(ct.getCell(i, j).isAlive()) cnt++;
		return cnt;
   	 
    }

	 public void once(){
		 times++;
		 getNumber();
		 int cnt=0;
	        //��Χ��ϸ���ĸ������������ڣ����Ϊ��ϸ������������ϸ��
		 for(int i=0;i<ct.Getrow();i++)
	        {
	            for(int j=0;j<ct.Getcol();j++)
	            {
	                switch(number[i][j])
	                {

	                    case 2:
	                        break;//����
	                    case 3:
	                    	ct.getCell(i, j).makeAlive();
	                        break;
	                    default:
	                    	ct.getCell(i, j).makeDie();;
	                }
	            }
	        }
		 ControlPnl.setcnttext();
		 ControlPnl.settimestext();
	    }
}
