package array.math;

public class SetMatrixZero {
// two extra array // easier  space : o(m+n) , o(m*n)
    public void setZeroes(int[][] arr) {
        int m=arr.length,n=arr[0].length;
        boolean [] row=new boolean [m];
        boolean [] col=new boolean [n];
        //marking row and col i.e identifying the rows and col which we have to make 0
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==0){
                    row[i]=true;
                    col[j]=true;
                }
            }
        }
        //set the true row to 0
        for(int i=0;i<m;i++){
            if(row[i]==true){
                //set ith row to 0
                for(int j=0;j<n;j++)
                    arr[i][j]=0;
            }
        }
        //set the true col to 0
        for(int j=0;j<n;j++){
            if(col[j]==true){
                //set jth row to 0
                for(int i=0;i<m;i++)
                    arr[i][j]=0;
            }
        }

    }
}
