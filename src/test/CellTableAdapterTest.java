package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import xiaojian.CellTable;
import xiaojian.CellTableAdapter;
import xiaojian.ControlPnl;
import xiaojian.Main;

class CellTableAdapterTest {
	/**
	 * ΪCellTableAdapter���ó�ʼ��CellTable����
	 * ���������ֲ�ͬԤ�������µ����
	 */			
	private static CellTable ct=new CellTable();
	private static CellTableAdapter adapter = new CellTableAdapter(ct);
	private static ControlPnl cpnl = new ControlPnl(adapter,new Main());
	private static String testpath[]= {"�����",
			                           "�̻�",
			                           "ʮ�岽",
			                           "����",
			                          // "case2"
			                           };

	@BeforeEach
	void setUp() throws Exception {
		adapter.clean();
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testsettablebyfule() throws Exception {
		
		  String expection[]= {"0 0","0 1","0 9","1 0","1 1","1 9","9 0","9 1","9 9"};
		  adapter.GetCellTable().setTable(10, 10); adapter.setTablebyfile("case1");
		  Assert.assertArrayEquals(expection,adapter.getAliveCell());
		 
	}
	
	@Test
	void testgetCount() throws Exception {
		int expection[]= {5,5,12,25,9};
		for(int i = 0;i< testpath.length;i++) {
			adapter.setTablebyfile(testpath[i]);
			Assert.assertEquals(expection[i], adapter.getCount());
		}
	}

	@Test
	void testgetNumber() throws Exception {
		/**
		 * ���Ի����
		 */		
		int expection1[][]={{1, 3, 2 },
		                    {4, 4, 2 },
		                    {2, 3, 3 }};
		adapter.GetCellTable().setTable(3, 3);
		adapter.setTablebyfile(testpath[0]);
		Assert.assertArrayEquals(expection1, adapter.getNumber());
		/**
		 * �����̻�
		 */
		int expection2[][]={{0, 0, 0, 0, 0, 0},
		                    {0, 0, 0, 0, 0, 0},
		                    {0, 0, 0, 1, 1, 1},
		                    {0, 0, 1, 3, 3, 3},
		                    {0, 0, 1, 3, 4, 3},
		                    {0, 0, 1, 3, 3, 3}};
		adapter.GetCellTable().setTable(6, 6);
		adapter.setTablebyfile(testpath[1]);
		Assert.assertArrayEquals(expection2, adapter.getNumber());
	}
	
	@Test
	void testonce() throws Exception {
		adapter.GetCellTable().setTable(10,10);
		/**
		 * ���Ի����
		 */	
		adapter.setTablebyfile(testpath[0]);
		adapter.once();
		String expection1[]= {"0 1","1 2","2 0","2 1","2 2"};
		Assert.assertArrayEquals(expection1,adapter.getAliveCell());
		/**
		 * �����̻�
		 */
		adapter.setTablebyfile(testpath[1]);
		adapter.once();
		String expection2[]= {"3 3","3 4","3 5","4 3","4 5","5 3","5 4","5 5"};
		Assert.assertArrayEquals(expection2,adapter.getAliveCell());
		
		
	}

}
 