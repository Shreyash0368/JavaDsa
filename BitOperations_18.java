public class BitOperations_18 {

    public static void oddEven(int n) {
        int bitMask = 1;
        // by performing AND operation between the first digit of the number (n in binary form) (10 -> 1010) and 1
        // we can see whether the number is even or not since all odd no have a 1 at the LSB while even no have 0 at LSB
        if ((n & bitMask) == 1) {  
            System.out.println("odd");;
        }else {
            System.out.println("even");
        }
    }

    public static int getIthBit(int n, int i) {

        // here the logic is simm. to the above onewith slight modification, here we right shift 1 (0001) by i places (0 based indexing) 
        // and we perform AND between bitmask and n we get the ith bit
        if((n & 1 << i) == 0) {
            return 0;
        }  else {
            return 1;
        }
    }
    
    public static int setIthBit(int n, int i) {
        
        // here the logic is simm. to the above onewith slight modification, here we right shift 1 (0001) by i places (0 based indexing) 
        // and we perform OR between bitmask and n to set the ith bit, since this operation will always turn ith bit into 1
        return n | 1 << i;
    }
    
    public static int clearIthBit(int n, int i) {
        // we need perform logical AND between 0 and the bit we want to clear, but we cant right shift 0,
        // so we right shift 1 and then take its complement (00001 -> 00100 -> 11011),
        // since AND between 1 and any bit is the bit itself so other bits are not affected   

        int bitMask = ~(1 << i); 
        return n & bitMask;
    }

    public static int clearLastIBits(int n, int i) {
        int bitMask = -1 << i; // -1 -> 1111111 i.e after right shift 111100

        return n & bitMask;
    }

    public static void main(String[] args) {
        // odd even using AND         
        oddEven(2565252);

        // getIth bit using AND
        System.out.println( "get Ith bit: "+getIthBit(10, 3));     
        
        // setIth bit using OR
        System.out.println("set Ith bit: "+setIthBit(10, 2));  
        
        // clearIth bit
        System.out.println("clear Ith bit: "+clearIthBit(10, 1));  

        System.out.println("clear last i bits: "+clearLastIBits(14, 3));


    }
}
