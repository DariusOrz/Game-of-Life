package Test;

public class RunThread extends Thread{
	private CellTable ct;
	
	public RunThread(CellTable ct)
	{
		this.ct=ct;
	}
	public void change()
	{
		ct.changePause();
	}

	@Override
	public void run() 
	{
	// TODO �Զ����ɵķ������
		while(ct.isPause()) 
		{
		try {
				ct.once();
				Thread.sleep(Config.freshtime);
			} catch (InterruptedException e)
		    {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
			
	}
}
	


