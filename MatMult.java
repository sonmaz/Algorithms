import java.util.Arrays;
public class MatMult
{
	public static int[][] multiply(int[][] a, int[][] b)
	{
		int[][]res = new int[a.length][b[0].length];
		for(int i = 0; i < a.length; i++)
		{
			for(int j = 0; j < b[0].length; j++)
			{
				res[i][j] = 0;
				for(int k = 0; k < b.length; k++)
				{
					res[i][j] += a[i][k]*b[k][j];
				}
			}
		}
		return res;
	}

	public static void main(String[] args)
	{
		int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] b = {{1,1,1},{2,2,2},{3,3,3}};
		int[][] res = multiply(a, b);
		System.out.println(Arrays.deepToString(res));
	}
}
