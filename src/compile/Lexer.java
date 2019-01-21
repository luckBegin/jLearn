package compile;
import java.util.* ;

public class Lexer{
    // 存放操作符
    private HashMap<String, String> keyWordMap = new HashMap<String, String>() ;
    // 存放输入文本
    private String content  ;

    public void  run( String content ){
        this.setContent(content);
        this.scan(0);
    }

    private void setContent(String content){
        keyWordMap.put(";" , "1") ;
        keyWordMap.put("+" , "2") ;
        keyWordMap.put("*" , "3") ;
        keyWordMap.put("NUM_OR_ID" , "4") ;
        this.content = content ;
    }

    private void scan( int index ){

        if( index < this.content.length() ){
            // 读取字符流
            char token = this.getToken( index ) ;

            // 判断是否是数字
            boolean isDigit = this.isIllegal( token ) ;

            if(isDigit){
                index += Character.isDigit( token ) ? this.digital( index )  :  this.token( index ) ;
                this.scan( index );
            }else{
                System.out.println("illegal input string");
            }
        }
    }

    private char getToken( int index){
        return this.content.charAt(index) ;
    }

    private boolean isIllegal(char token ){
        return Character.isDigit( token )
                || this.keyWordMap.containsKey( token )
                || token == ' ';
    }

    public int digital( int index ) {
        String output = "" ;
        String symbol = this.keyWordMap.get("NUM_OR_ID") ;

        while ( Character.isDigit( this.content.charAt(index))){
            output += this.content.charAt(index) ;
            index += 1 ;
        }
        System.out.println("Token : " + output + " , Symbol : " + symbol  );
        return index ;
    }

    public int token( int index) {
        char token = this.content.charAt(index) ;

        String output ;
        switch (token){
            case '+' :
                output = this.keyWordMap.get("+") ;
            break;
            case '*' :
                output = this.keyWordMap.get("*") ;
            break;

            case ';' :
                output = this.keyWordMap.get(";") ;
            break;
            case ' ' :
                output = "space" ;
            break;
            default:
                output = "invalid token " ;
            break;
        }

        System.out.println("Token : " + output + " , Symbol : " + "space"  );
        return 1 ;
    }
}