package algorithm;

public class DFADeemo {
    // 用来存放输入内容
    private String content ;

    // 开始状态 S0
    private String startState ;

    // 结束状态 F
    private String endState ;

    // 状态集合 S
    private String[] states = {"Q0","Q1","Q2","Q3"};

    // 设定初始状态和 结束状态
    public DFADeemo(int start , int end){
        this.startState = this.states[start] ;
        this.endState = this.states[end] ;
    }

    // 设置content
    public void setContent( String content){
        this.content = content ;
    }

    // 输出识别结果
    public void result(){
        int contentLen = this.content.length() ;
        String state = this.startState ;
        // 记录当前的字符位置
        int i = 0 ;
        // 开始读取字符
        while ( i <  contentLen && state != "非法字符" && state != this.endState) {
            char token = this.getToken( i ) ;
            String nextState = this.nextState( state , token ) ;
            state = nextState ;
            i += 1 ;
            System.out.println(" => " + state);
        }
    }

    // 获取字符
    public char getToken(int i){
        return this.content.charAt(i) ;
    }

    //根据输入的状态和字符获取下一个状态
    public String nextState(String state , char token){
        // 存储下一个状态
        String nextState ;
        switch (state){
            case "Q0":
                nextState = token == 'a' ? "Q1" : "Q2" ;
            break;
            case "Q1" :
                // 当状态为Q1时 输入字符 b 进入状态Q2 输入字符c进入状态Q3 , 都不是则为null
                nextState =  token == 'b' ? "Q2" : token == 'c' ? "Q3"  : "非法字符" ;
            break;

            case "Q2" :
                // 当状态为Q2时 输入字符 a 进入状态Q1 输入字符进入状态Q3 , 都不是则为null ;
                nextState = token == 'a' ? "Q1" : token == 'c' ? "Q3" : "非法字符" ;
            break;

            case "Q3" :
                // 当状态为Q3时 , 输入字符c则继续停留在状态Q3 , 否则为 null ;
                nextState = token == 'c' ? "Q3" : "非法字符" ;
            break;
            default:
                // 当输入的字符 不在 ∑ 中 则为 null
                nextState = "非法字符" ;
            break;
        }
        return nextState ;
    }
}