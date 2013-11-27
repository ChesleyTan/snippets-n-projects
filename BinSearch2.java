// Chesley Tan
// pd9
// HW34
// 2013-11-27
/*==================================================
  class BinSearch
  skeleton file
  ==================================================*/

public class BinSearch2 {


    /*==================================================
      int binSearch(int[],int) -- searches an array of ints for target int
      pre:  input array is sorted in ascending order
      post: returns index of target, or returns -1 if target not found
      ==================================================*/
    public static int binSearch ( Comparable[] a, int target ) {
		if (!isSorted(a)){
			System.out.println("Array not sorted.");
			return -1;
		}
		//uncomment exactly 1 of the 2 stmts below:
		return binSearchIter(a, target, 0, a.length-1 );
		//return binSearchRec( a, target, 0, a.length-1 );
    }


    public static int binSearchRec( Comparable[] a, Comparable target, int lo, int hi ) {
		if (lo > hi)
			return -1;
		else{
			if (a[(lo + hi) / 2].equals(target))
				return (lo + hi) / 2;
			else if (a[(lo + hi) / 2].compareTo(target) > 0){
				hi = ((lo + hi) / 2) - 1;
				return binSearchRec(a, target, lo, hi);
			}
			else if (a[(lo + hi) / 2].compareTo(target) < 0){
				lo = ((lo + hi) / 2) + 1;
				return binSearchRec(a, target, lo, hi);
			}
			return -1;
		}
    }


    public static int binSearchIter( Comparable[] a, Comparable target, int lo, int hi ) {
		while (lo <= hi){
			if (a[(lo + hi) / 2].equals(target))
				return (lo + hi) / 2;
			else if (a[(lo + hi) / 2].compareTo(target) > 0)
				hi = ((lo + hi) / 2) - 1;
			else if (a[(lo + hi) / 2].compareTo(target) < 0)
				lo = ((lo + hi) / 2) + 1;
		}
		return -1;
    }



    //tell whether an array is sorted in ascending order
    private static boolean isSorted( Comparable[] arr ) {
		for (int x = 0; x < arr.length - 1; x++){
			if (arr[x].compareTo(arr[x+1]) > 0)
				return false;
		}
		return true;
    }


    // utility/helper fxn to display contents of an array of Objects
    private static void printArray( Comparable[] arr ) {
	String output = "[ "; 

	for( Comparable i : arr )
	    output += i + ", ";

	output = output.substring( 0, output.length()-2 ) + " ]";

	System.out.println( output );
    }


    //main method for testing
    public static void main ( String[] args ) {


	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	System.out.println("\nNow testing binSearch on int array...");

	//Declare and initialize array of ints
	Comparable[] iArr = { 2, 4, 6, 8, 6, 42 };
	printArray( iArr );
	System.out.println( "iArr sorted? -- " + isSorted(iArr) );

	Comparable[] iArr2 = { 2, 4, 6, 8, 13, 42 };
	printArray( iArr2 );
	System.out.println( "iArr2 sorted? -- " + isSorted(iArr2) );
	//search for 6 in array 
	System.out.println("Searching for 6 in iArr2: " +  binSearch(iArr2,6) );

	//search for 43 in array 
	System.out.println("Searching for 43 in iArr2: " +  binSearch(iArr2,43) );
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    }//end main()

}//end class BinSearch
