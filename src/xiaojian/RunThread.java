package xiaojian;

public class RunThread extends Thread{
	private CellTableAdapter adapter;
	
	public RunThread(CellTableAdapter Adapter)
	{
		this.adapter=Adapter;
	}
	public void change()
	{
		adapter.changePause();
	}

	@Override
	public void run() 
	{
	// TODO �Զ����ɵķ������
		while(adapter.isPause()) 
		{
		try {
			adapter.once();
				Thread.sleep(Config.freshtime);
			} catch (InterruptedException e)
		    {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
			
	}
}
	


