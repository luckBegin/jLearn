package algorithm ;

// DFA 是个五元组
// m = ( 状态集 , 字符集 , 开始状态 , 结束状态 , 状态转化函数 );
public class DFA {
    // 输入的内容
    private String content ;

    private String[] states = {"q0","q1","q2"};

    private String stateState ;

    private String endState ;

    public DFA(int start , int end){
        // 设置开始状态
        stateState = states[start] ;

        // 设置结束状态
        endState = states[end] ;
    }

    public void setContent(String content){
        this.content = content ;
    }

    public void result(){
        String status = getEndState( stateState ) ;
        if (status == null) {
            System.out.println("illegal input!");
        }else if(status.equals( endState )){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }


    //获取词法单元
    public char[] getToken(){
        int count = 0 ;

        int contentLen = this.content.length();

        char[] tokens = new char[ contentLen ] ;

        for(int i = 0 ; i < contentLen ; i ++ ){
            char token = this.content.charAt(i) ;

            if( token != ' ' || token != '\n'){
                tokens[i] = token ;
            }
        }
        return tokens ;
    }

    public String getEndState(String stateState){
        String state = stateState ;

        char[] tokens = this.getToken() ;

        for(int i = 0 , j = tokens.length ; i < j && state != null;  i++ ){
            char token = tokens[i] ;
            String nextState = this.getNextState(state , token) ;
            state = nextState ;
            System.out.print("-->" + state);
        }

        return state ;
    }
    // 根据当前状态 和 字符 获取下个状态
    public String getNextState( String start , char token){
        String nextState;
        switch (start) {
            case "q0":
                if(token == 'a') {
                    nextState = "q1";
                }
                else if(token == 'b'){
                    nextState = "q2";
                }else {
                    nextState = null;
                }
            break;
            case "q1":
                if(token == 'a' || token == 'b') {
                    nextState = "q1";
                }else {
                    nextState = null;
                }
            break;
            case "q2":
                if(token == 'a') {
                    nextState = "q2";
                }
                else if(token == 'b'){
                    nextState = "q1";
                }else {
                    nextState = null;
                }
            break;
            default:
                nextState = null;
                break;
        }
        return nextState;
    }
}
