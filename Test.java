public class Test
{
	private static class InTest
	{
		public int x;
		public int y;
	}

	InTest it;

	private void useIT(InTest ex, int[] a)
	{
		ex.x = 0;
		ex = new InTest();
		ex.x = 9;
		a[0] = 1;
	}
	public static void main(String[] args)
	{
		int a[10];
		a[0] = 2;
		Test t = new Test();
		InTest mit = new InTest();
		mit.x = 5;
		System.out.println(a[0]);
		t.useIT(mit, a);
		System.out.println(mit.x);
	}

}
