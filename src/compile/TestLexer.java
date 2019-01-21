package compile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class TestLexer {
    // 关键词表
    private String keyWords[] = { "abstract", "boolean", "break", "byte",
            "case", "catch", "char", "class", "continue", "default", "do",
            "double", "else", "extends", "final", "finally", "float", "for",
            "if", "implements", "import", "instanceof", "int", "interface",
            "long", "native", "new", "package", "private", "protected",
            "public", "return", "short", "static", "super", "switch",
            "synchronized", "this", "throw", "throws", "transient", "try",
            "void", "volatile", "while", "strictfp","enum","goto","const","assert" , "FileNotFoundException"};
    // 运算符
    private char operators[] = { '+', '-', '*', '/', '=', '>', '<', '&' };

    // 分隔符
    private char separators[] = { ',', ';', '{', '}', '(', ')', '[', ']', '_', ':', '、', '.', '"' };

    // 当前处理的字符
    private char token ;

    // 拼接的语句串
    private String strToken ;

    //用来存放读取的序号
    private int i  ;

    //存放读取的词法单元类型
    private int keyType ;

    private static String fileSrcName = "./src/input.txt" ;

    // 判断是否为字母
    private boolean isLetter(){
        return Character.isLetter( token );
    }

    // 判断是否是数字
    private boolean isDigit (){
        return Character.isDigit( token ) ;
    }

    private StringBuffer buffer = new StringBuffer(); // 缓冲区

    // 判断是否为关键字
    private boolean isKeyword(){
        return Arrays.asList( keyWords ).contains( strToken ) ;
    }

    // 判断是否为分隔符
    private boolean isSperate (){
        return Arrays.asList( separators ).contains( token ) ;
    }

    // 判断是否为运算符号
    private boolean isOperate(){
        return Arrays.asList( operators ).contains( token ) ;
    }

    // 监测字符是否为空格 , 不是则继续读取
    private void isSpace(){
        if( Character.isSpaceChar( token ) ){
            getToken();
            isSpace();
        }
    }

    private void  getToken(){
        token = buffer.charAt(i);
        i++;
    }

    // 链接token到strToken上
    public void concat() {
        strToken += token ;
    }
    public void retract() {
        i--;
        token = ' ';
    }

    public void analyse(){
        boolean isCode, value;

        strToken = ""; // 置strToken为空串

        while ( i < buffer.length() ){
            getToken();
            isSpace();
            if( isLetter() ){
                while (isLetter() || isDigit()) {
                    concat();
                    getToken();
                }
                retract() ;

                // 如果是关键字则进行关键字处理
                if (isKeyword()) {
                    System.out.println("读取到关键字 ---- " + strToken );
                } else {
                    System.out.println("读取到其他词 ---- " + strToken );
                }

                // 分析完一个词 , 则置空strToken ;
                strToken = "";
            }else if( isDigit() ){
                while (isDigit()) {
                    concat();
                    getToken();
                }
                System.out.println("读取到数字 ---- " + strToken );
                retract() ;
                strToken = "";
            }else if( isOperate() ){
                System.out.println("读取到操作符 ---- " + strToken );
            }else if( isSperate() ){
                System.out.println("读取到分隔符 ---- " + strToken );
            }
        }
    }

    public void readFile() {
        try {
            FileReader fis = new FileReader(this.fileSrcName);

            BufferedReader br = new BufferedReader(fis);

            String temp = null;

            while ( ( temp = br.readLine() ) != null ){
                buffer.append( temp ) ;
            }

        }catch (FileNotFoundException e) {
            System.out.println("源文件未找到!" + e );
        }catch ( Exception e ){
            System.out.println("异常" + e);
        }
    }

    public static void main(String[] args) {
        TestLexer alr = new TestLexer();//文件路径
        alr.readFile();
        alr.analyse();
    }
}