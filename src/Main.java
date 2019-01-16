import algorithm.DFADeemo;
import testPackage.SqlBuilder;
import algorithm.DFA ;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        SqlBuilder sqlBuilder = SqlBuilder.Mysql() ;

        String sql = SqlBuilder
                    .Mysql()
                    .select("id , name")
                    .from("table")
                    .build() ;

        System.out.println( sql );

        System.out.println("======================");

//        DFA Dfa = new DFA(0 , 2) ;
//
//        Dfa.setContent("abababa");
//
//        Dfa.result();

        DFADeemo dfaDeemo = new DFADeemo(0 , 3) ;
        dfaDeemo.setContent("absababcccccc");
        dfaDeemo.result();
    }
}