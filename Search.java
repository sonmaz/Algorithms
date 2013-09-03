public class Search
{
	public static int binSearch(int[] arr, int i, int j, int v)
	{
		if(j == i)
		{
			if(arr[i] == v)
				return i;
			return -1;
		}
		int mid = (i+j)/2;
		if(arr[mid] == v)
		{
			return mid;
		}
		if(arr[mid] > v)
		{
			return binSearch(arr, i, mid - 1,v);
		}
		return binSearch(arr, mid + 1, j,v);
	}

	public static void main(String[]args)
	{
		System.out.println(binSearch(new int[]{0, 2, 3, 4,7, 10}, 0, 5, 1));
	}
}
