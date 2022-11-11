# Rotate-square-matrix-
# 11.11.2022
# Перестановка элементов двумерного массива по "спирали"
# [ссылка на задание](https://www.codewars.com/kata/58d3cf477a4ea9bb2f000103/train/java)
# Код:
```java
int n=a.length-1;
        int x1=0;
        int x2=0;
        int x3=0;
        int x4=0;
        int d =0;

        for(int h=0;h<=n/2;h++)
        {
            if(h%4==0)
            {
                d=n-h;

                    for(int k=0;k<n-2*h;k++)
                    {
                        // h- лев конец d прав верх
                        x1=a[h][h+k];
                        x2=a[d-k][h];
                        x3=a[d][d-k];
                        x4=a[h+k][d];

                        a[h][h+k]=x4;
                        a[d-k][h]=x1;
                        a[d][d-k]=x2;
                        a[h+k][d]=x3;

                    }

            }
            if(h%4==1)
            {
                d=n-h;

                for(int k=0;k<n-2*h;k++)//2*(d-h)-1
                {
                    x1=a[h][h+k];

                    x3=a[d][d-k];

                    a[h][h+k]=x3;
                    a[d][d-k]=x1;


                }
                for(int k=0;k<n-2*h;k++)//2*(d-h)-1
                {
                    x1=a[h+k][d];

                    x3=a[d-k][h];

                    a[h+k][d]=x3;
                    a[d-k][h]=x1;


                }

            }
            if(h%4==2)
            {
                d=n-h;

                for(int k=0;k<n-2*h;k++)
                {
                    // h- лев конец d прав верх
                    x1=a[h][h+k];
                    x2=a[d-k][h];
                    x3=a[d][d-k];
                    x4=a[h+k][d];

                    a[h][h+k]=x2;
                    a[d-k][h]=x3;
                    a[d][d-k]=x4;
                    a[h+k][d]=x1;

                }

            }

        }
        return a;
```
# Понравившееся решение((автор  Xentrics):
```java
public class Kata
{
  public static int[][] rotateLikeAVortex(int[][] mat)
  {    
    final int N = mat.length;
    if (N == 1) return new int[][]{new int[]{mat[0][0]}};
    
    int[][] ret = new int[N][N];
    
    for (int r = 0; r < N/2; ++r) {
      for (int i = r; i < N-r; ++i) {
        for (int j = r; j < N-r; ++j) {
          ret[i][j] = mat[j-r][N-i-1 -r];
        }
      }
      
      if (r < N/2) {
        final int n = N-2*(r+1);
        final int start = r+1;
        mat = new int[n][n];
        for (int x=0; x<n; ++x)
          for (int y=0; y<n; ++y)
            mat[x][y] = ret[start+x][start+y];
      }
    }
    
    return ret;
  }
}
        
        
