import algorithm.DFADeemo;
import testPackage.SqlBuilder;
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

        DFADeemo dfaDeemo = new DFADeemo(0 , 3) ;
        dfaDeemo.setContent("abababsc");
        dfaDeemo.result();
    }
}