package week1;

import java.util.List;

public class DemoTest {
	private int[] dx={1,-1,0,0};
	private int[] dy={0,0,1,-1};
	public List<List<Integer>> updateMatrix(List<List<Integer>> matrix){
		int m=matrix.size();
		int n=matrix.get(0).size();
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(matrix.get(i).get(j)==1)matrix.get(i).set(j,10000);
			}
		}
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(matrix.get(i).get(j)!=0)continue;
				for(int k=0;k<4;k++){
					int x=i+dx[k];
					int y=j+dy[k];
					if(x<0||x>=m||y<0||y>=n)continue;
					if(matrix.get(x).get(y)!=0)matrix.get(x).set(y,1);
				}
			}
		}
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				dfsHelper(matrix,m,n,i,j);
			}
		}
		return matrix;
	}
	private void dfsHelper(List<List<Integer>> matrix,int m,int n,int i,int j){
		for(int k=0;k<4;k++){
			int x=i+dx[k];
			int y=j+dy[k];
			if(x<0||x>=m||y<0||y>=n)continue;
			if(matrix.get(x).get(y)>matrix.get(i).get(j)+1){
				matrix.get(x).set(y,matrix.get(i).get(j)+1);
				dfsHelper(matrix,m,n,x,y);
			}
		}
	}
	public static void main(String[] args){

	}	
}
