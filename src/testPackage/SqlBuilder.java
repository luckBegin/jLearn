package testPackage;

public class SqlBuilder {
    private String selectPrefix = "select " ;

    private String out = "";

    public SqlBuilder select( String fields ){
        this.out += this.selectPrefix + fields ;
        return this ;
    }

    public SqlBuilder from( String tableName ){
        this.out += " from " + tableName ;
        return this ;
    }

    public String build(){
        return this.out ;
    }

    public static  SqlBuilder Mysql (){
        return new SqlBuilder();
    }
}