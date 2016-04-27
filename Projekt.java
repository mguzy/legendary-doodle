

public class Projekt{
	
	public static void main(String[] args){
		
		int[] t = {1,1,1,-1,-1,-1,1,-1,1,2,3,4};
		
		//debug
		for(int i=0; i<(t.length-2); i+=3)
			System.out.println(t[i]+", "+t[i+1]+", "+t[i+2]);
		System.out.println();
		//
		
		makeRingsArray(t);
	}

	private static int[] makeRingsArray(int[] pointsArray){
		
		int n = pointsArray.length;
		
		double[] distanceArray = new double[n/3];
		int[] ringsArray = new int[n/3];
		
		for(int i=0; i<n-2; i+=3)
			distanceArray[i/3] = distance(pointsArray[i], pointsArray[i+1], pointsArray[i+2]);
		
		//debug
		for(int i=0; i<n/3; i++)
			System.out.print(distanceArray[i]+", ");
		System.out.println();
		//
		
		int ringNumber=0;
		for(int i=0; i<n/3; i++){
			
			double tempDistance = distanceArray[i];
			
			if(tempDistance==-1) continue;
			
			ringNumber++;
			for(int j=i; j<n/3; j++){
				if(distanceArray[j]==tempDistance){
					ringsArray[j] = ringNumber;
					distanceArray[j] = -1;
				}
			}	
		}
		
		//debug
		for(int i=0; i<n/3; i++)
			System.out.print(ringsArray[i]+", ");
		System.out.println();
		//
		
		return ringsArray;		
	}
	
	private static double distance(int x, int y, int z){
		return Math.sqrt(x*x+y*y+z*z);
	}
	
	
}