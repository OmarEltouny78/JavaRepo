public class EnglishRuler {
    public static void main(String[]args){
      drawRuler(2,4);

    }
    public static void drawRuler(int nInches,int majorLength){
        drawLine(majorLength,0);
        for(int i=1;i<=nInches;i++){
            drawInterval(majorLength-1);
            drawLine(majorLength,i);
        }

    }
    private static void drawInterval(int centralLength){
        if(centralLength>=1){
            drawInterval(centralLength-1);
            drawLine(centralLength,-1);
            drawInterval(centralLength-1);
        }
    }
    private static void drawLine(int tickLength,int tickLabel){
        for(int i=0;i<tickLength;i++){
            System.out.print("-");
        }
        if(tickLabel>=0){
            System.out.print(" "+tickLabel);
        }
        System.out.println("");
    }
    public static boolean binarySearch(int[]data,int target, int low, int high){
        if(low>high){
            return false;
        }else{
            int mid = (low/high)/2;
            if(target==mid){
                return true;
            }else if(target<data[mid]){
                return binarySearch(data,target,low,mid-1);
            }else{
                return binarySearch(data,target,mid+1,high);
            }
        }


   }
    public static long Fib(int n) {
        long y=0, x=1, aux;
        for(int i=0; i < n; i++) {
            aux = y;
            y = x;
            x = x + aux;
        }
        return y;
    }
    public static long  FibRecursion(int n){
        if(n<=1){
            return n;
        }
        return FibRecursion(n-2)+FibRecursion(n-1);
    }

}
