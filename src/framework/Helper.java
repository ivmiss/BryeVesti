package framework;


public class Helper {
    
    public static String getRandomText(){
//        int random = (int)(Math.random() * 250 + 1);
//        String randomText = "prIVM" + random;
//        return randomText;
        return "prIVM" + (int)(Math.random() * 250 + 1);
        
    }
    
//    public static int getRandomIntiger(){
//        return(int)(Math.random() * 1000);
//    }
    
    public static int getRandomIntiger(int range){
        return(int)(Math.random() * range);
    }
    

    public static int getRandomRegion(int max){
       return (int) (Math.random() * max);
  }
    
    public static String getRandomUrl() {
        return "http://".concat(getRandomText()).concat(".rs");
    }
}