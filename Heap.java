import java.util.Arrays;
public class Heap
{
	private static void heapIncrease(int[] arr, int i, int value)
	{
		arr[i] += value;
		while(arr[i] > arr[i/2])
		{
			arr[i] += arr[i/2];
			arr[i/2] = arr[i] - arr[i/2];
			arr[i] = arr[i] - arr[i/2];
			i = i/2;
		}
	}
	private static int right(int i)
	{
		return 2*i + 1;
	}

	private static int left(int i)
	{
		return 2*i;
	}
	public static int[] maxHeapify(int[] arr, int i, int heapSize)
	{
		int largest;
		largest = i;
		if(right(i) <= heapSize && arr[i] < arr[right(i)])
		{
			largest = right(i);
		}
		
		if(left(i) <= heapSize && arr[largest] < arr[left(i)])
		{
			largest = left(i);
		}

		if(largest == i)
		{
			return arr;
		}
		
		arr[i] = arr[i] + arr[largest];
		arr[largest] = arr[i] - arr[largest];
		arr[i] = arr[i] - arr[largest];
			
		return maxHeapify(arr, largest, heapSize);
		
	}
	public static int[] heapSort(int[] arr)
	{
		arr = makeMaxHeap(arr);
		for(int i = arr.length - 1; i >= 0; i--)
		{
			arr[i] += arr[0];
			arr[0] = arr[i] - arr[0];
			arr[i] -= arr[0];
			arr = maxHeapify(arr, 0, i - 1);
		}
		return arr;
	}
	public static int[] makeMaxHeap(int[] arr)
	{
		for(int i = (arr.length)/2 - 1; i >= 0; i--)
		{
			arr = maxHeapify(arr, i, arr.length - 1);
		}
		return arr;
	}

	public static void main(String[] args)
	{
		int[] a= new int[] {5,6,3,89,0, 2, 15, 16, 17, 1,2,3};
		System.out.println(Arrays.toString(makeMaxHeap(a)));
		heapIncrease(a, 1, 90);
		System.out.println(Arrays.toString(a));
	}
}
