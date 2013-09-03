import java.lang.Math;
import java.util.Arrays;
public class MaxSub
{
//	public static int[] bruteMax(int []arr)
//	{
//		for(int i = 0; i <)
//	}
	public static int[] divConq(int[] arr, int low, int high)
	{
		if(low == high)
			return new int[]{low, high, arr[low]};
		
		
		int[] left = divConq(arr, low, (high+low)/2);
		int[] right = divConq(arr,(high + low) / 2 + 1, high);
		int[] cross = findcross(arr, low, (high+low)/2, high);

		int max = Math.max(left[2], Math.max(right[2], cross[2]));
		if(max == left[2])
				return left;
		if(max == right[2])
				return right;
		return cross;
	}	
	

	public static int[] findcross(int[]arr, int low, int mid, int high)
	{
		int[] res = new int[]{-1, -1, Integer.MIN_VALUE};
		int sum = 0;
		for(int i = mid+1; i <= high; i++)
		{
			sum+=arr[i];
			if(sum > res[2])
			{
				res[2] = sum;
				res[1] = i;
			}
		}
		sum = 0;
		
			int tmpSum = Integer.MIN_VALUE;
		for(int i = mid; i >=0; i--)
		{
			sum+=arr[i];
			if(sum > tmpSum)
			{
				tmpSum = sum;
				res[0] = i;
			}
		}
		res[2]+=tmpSum;
		return res;
	}

	public static void main(String[] args)
	{
	//	System.out.println(Arrays.toString(findcross(new int[]{-1,4,1,2,-1, 0}, 0, 2,5)));
		System.out.println(Arrays.toString(divConq(new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7}, 0, 15)));
	}
}
