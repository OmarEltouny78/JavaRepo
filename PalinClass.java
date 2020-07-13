public class PalinClass {
    public static boolean isPali(String s){
        if(s.length()==0||s.length()==1){
            return true;
        }
        if(s.charAt(0)==s.charAt(s.length()-1)){
            return isPali(s.substring(1,s.length()-1));
        }
        return false;
    }
    public static boolean areMoreVowels(String str,int c,int v){
        String vowels="aeiou";
        if(vowels.indexOf(str.charAt(0))>=0){
            v++;
        }else{
            c++;
        }
        if(str.length()==1){
            return v>c;
        }
        return areMoreVowels(str.substring(1),c,v);
    }
    public static int product(int m,int n){
        if(m<n)return product(n,m);
        else if(n!=0)return (m+product(m,n-1));
        else return 0;
    }
    public static void main(String args[]){
        int x=5;
        int y=2;
        int i=0;
        int j=0;
        System.out.println(isPali("abccba"));
        System.out.println(isPali("abbbb"));
        System.out.println(areMoreVowels("abccbaaaaaaaa",i,j));
        System.out.println(areMoreVowels("abbbb",i,j));
        System.out.println(product(x,y));
    }
}
