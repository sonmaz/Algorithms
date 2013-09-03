import java.util.Arrays;
public class MySorts
{
	
	public static int[] insertionSort(int[] arr)
	{
		for(int i = 1; i < arr.length; i++)
		{
			int j = i - 1;
			while(j >= 0 && arr[i] < arr[j])
			{
				arr[i] = arr[i] + arr[j];
				arr[j] = arr[i] - arr[j];
				arr[i] = arr[i] - arr[j];
				j--;
				i--;	
			}
		}
		return arr;
	}

  private static int[] merge(int[] arr, int i, int j, int k)
	{
		int ii = 0, ij = 0;
		int[] a = new int[k - i + 2];
		int[] b = new int[j - k+1];
		System.arraycopy(arr, i,a,0, k -i + 1);
		System.arraycopy(arr, k + 1,b,0, j - k);
		
		a[a.length - 1] = Integer.MAX_VALUE;
	  b[b.length - 1] = Integer.MAX_VALUE;	
	
		System.out.println("a " + Arrays.toString(a));	
		System.out.println("arr " + Arrays.toString(arr));	
		for(int t = i; t <= j; t++)
		{
			if(a[ii] < b[ij])
			{
				arr[t] = a[ii];
				ii++;
				continue;
			}
			arr[t] = b[ij];
			ij++;
		}
		return arr;
	}
	public static int[] mergeSort(int [] arr, int i, int j)
	{
		if (j - i < 2)
		{
			return arr;
		}
		int mid = (i+j)/2;
		mergeSort(arr, i, mid);
		mergeSort(arr, mid+ 1, j);
		return merge(arr, i, j, mid);

	}
	public static int[] selectionSort(int[] arr)
	{
		int min;
		int ind;
		for(int i = 0; i < arr.length - 1; i++)
		{
			ind = i;
			min = arr[i];
			for(int j = i + 1; j < arr.length; j++)
			{
				if(arr[j] < min)
				{
					ind = j;
					min = arr[j];
				}
			}
			arr[ind] =arr[i];
		 	arr[i]=	min;		
		}
		return arr;
	
	}

	public static void main(String[] args)
	{
		int[] arr = new int[] {3,4,1, 8,2,42,3,6};
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(mergeSort(arr, 0, arr.length - 1)));
	}
}
