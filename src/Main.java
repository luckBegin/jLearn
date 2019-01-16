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
    }
}