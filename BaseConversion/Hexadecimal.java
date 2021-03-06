//Chesley Tan
//pd 9
//HW30
//2013-11-21
public class Hexadecimal implements Comparable {

    private int _decNum;
    private String _hexNum;
	private static final String HEXDIGITS = "0123456789ABCDEF";


    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _hexNum to "0"
      =====================================*/
    public Hexadecimal() { 
		_decNum = 0;
		_hexNum = "";
    }


    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _hexNum to equiv string of hex digits
      =====================================*/
    public Hexadecimal( int n ) {
		_decNum = n;
		_hexNum = decToHex(_decNum);
    }


    /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String of hex digits representing value of this Object
      =====================================*/
    public String toString() { 
		return _hexNum;
    }


    /*=====================================
      String decToHex(int) -- converts base-10 input to hexadecimal
      pre:  n >= 0
      post: returns String of hex digits
      eg  decToHex(0) -> "0"
          decToHex(1) -> "1"
	  decToHex(2) -> "2"
	  decToHex(3) -> "3"
	  decToHex(10) -> "A"
	  decToHex(16) -> "10"
	  decToHex(20) -> "14"
	  decToHex(32) -> "20"
	  decToHex(42) -> "2A"
      =====================================*/
    public static String decToHex( int n ) {
		String retStr = HEXDIGITS.substring(n % 16, n % 16 + 1);
		while (n > 0){
			retStr = HEXDIGITS.substring( (n = (n / 16)) % 16, n % 16 + 1) + retStr;
		}	
		return retStr.substring(1);// Removes extra 0 added from last iteration of the while loop
    }


    /*=====================================
      String decToHexR(int) -- converts base-10 input to hexadecimal, recursively
      pre:  n >= 0
      post: returns String of hex digits
      eg  decToHexR(0) -> "0"
          decToHexR(1) -> "1"
	  decToHexR(2) -> "2"
	  decToHexR(3) -> "3"
	  decToHexR(10) -> "A"
	  decToHexR(16) -> "10"
	  decToHexR(20) -> "14"
	  decToHexR(32) -> "20"
	  decToHexR(42) -> "2A"
      =====================================*/
    public static String decToHexR( int n ) { 
		return n == 0 ? "" : decToHexR(n / 16) + HEXDIGITS.substring((n % 16), (n % 16 + 1));
    }


    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Hexadecimal
      post: Returns true if this and other are aliases (pointers to same 
            Object), or if this and other represent equal hexadecimal values
      =============================================*/
    public boolean equals( Object other ) { 
		return (other instanceof Hexadecimal && _hexNum.equals( ((Hexadecimal) other).getHex()) ); 
    }


    /*=============================================
      int compareTo(Object) -- tells which of two Hexadecimal objects is greater
      pre:  other is instance of class Hexadecimal
      post: Returns 0 if this Object is equal to the input Object,
            negative integer if this<input, positive integer otherwise
      =============================================*/
    public int compareTo( Object other ) {
		return !(other instanceof Hexadecimal) ? -2 
				: ((Hexadecimal) other).getDec() > _decNum ? -1 
				: ((Hexadecimal) other).getDec() == _decNum ? 0 
				: 1; 
    }
	public int getDec(){
		return _decNum;
	}
	public String getHex(){
		return _hexNum;
	}


    //main method for testing
    public static void main( String[] args ) {

	System.out.println();
	System.out.println( "Testing ..." );

	Hexadecimal h1 = new Hexadecimal(10);
	Hexadecimal h2 = new Hexadecimal(10);
	Hexadecimal h3 = h1;
	Hexadecimal h4 = new Hexadecimal(20);

	System.out.println( h1 );
	System.out.println( h2 );
	System.out.println( h3 );       
	System.out.println( h4 );       

	System.out.println( "\n==..." );
	System.out.println( h1 == h2 ); //should be false
	System.out.println( h1 == h3 ); //should be true

	System.out.println( "\n.equals()..." );
	System.out.println( h1.equals(h2) ); //should be true
	System.out.println( h1.equals(h3) ); //should be true
	System.out.println( h3.equals(h1) ); //should be true
	System.out.println( h4.equals(h2) ); //should be false
	System.out.println( h1.equals(h4) ); //should be false

	System.out.println( "\n.compareTo..." );
	System.out.println( h1.compareTo(h2) ); //should be 0
	System.out.println( h1.compareTo(h3) ); //should be 0
	System.out.println( h1.compareTo(h4) ); //should be neg
	System.out.println( h4.compareTo(h1) ); //should be pos
    
	
	System.out.println("\nExtra: decToHex(1013531): " +  decToHex(1013531) );
	System.out.println("Extra: decToHexR(1013531): " +  decToHex(1013531) );
	}//end main()

} //end class
