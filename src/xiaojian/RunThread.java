package xiaojian;

public class RunThread extends Thread{
	private CellTableAdapter adapter;
	
	public RunThread (CellTableAdapter adapter)
	{
		this.adapter=adapter;
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
				Thread.sleep(ConfigUtils.freshtime);
			} catch (InterruptedException e)
		    {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
			
	}
}
	


