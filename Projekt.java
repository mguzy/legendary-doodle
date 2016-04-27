

public class Projekt{
	
	public static void main(String[] args){
		
		int[] t = {0,1,1,0,-1,1,0,0,1,2,3,4};
		
		//debug
		for(int i=0; i<(t.length-2); i+=3)
			System.out.println(t[i]+", "+t[i+1]+", "+t[i+2]);
		System.out.println();
		//
		System.out.println(areCoplanar(t, 0, 1, 4));
		makeRingsArray(t);
	}

	private static int[] makeRingsArray(int[] pointsArray){
		
		int n = pointsArray.length/3;
		
		double[] distanceArray = new double[n];
		int[] ringsArray = new int[n];
		
		for(int i=0; i<n*3-2; i+=3)
			distanceArray[i/3] = distance(pointsArray[i], pointsArray[i+1], pointsArray[i+2]);
		
		//debug
		for(int i=0; i<n; i++)
			System.out.print(distanceArray[i]+", ");
		System.out.println();
		//
		
		int ringNumber=0;
		for(int i=0; i<n; i++){
			
			double tempDistance = distanceArray[i];
			
			if(tempDistance==-1) continue;
			
			ringNumber++;
			for(int j=i; j<n; j++){
				if(distanceArray[j]==tempDistance){
					ringsArray[j] = ringNumber;
					distanceArray[j] = -1;
				}
			}	
		}
		
		//debug
		for(int i=0; i<n; i++)
			System.out.print(ringsArray[i]+", ");
		System.out.println();
		//
		
		return ringsArray;		
	}
	
	private static double distance(int x, int y, int z){
		return Math.sqrt(x*x+y*y+z*z);
	}
	
	private static boolean areCoplanar(int[] p, int A, int B, int C){
		A*=3;
		B*=3;
		C*=3;
		
		if(A>=p.length || B>=p.length || C>=p.length){
			System.out.println("Punkt poza zakresem");
			return false;
		}
		
		if(p[A]*p[B+1]*p[C+2]+p[A+1]*p[A+2]*p[C]+p[A+2]*p[B]*p[C+1]
			-(p[A+2]*p[B+1]*p[C]+p[A]*p[B+2]*p[C+1]+p[A+1]*p[B]*p[C+2]) == 0)
			return true;
		else
			return false;
	}
	
	
}