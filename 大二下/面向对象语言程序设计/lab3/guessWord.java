import java.util.Scanner;

public class guessWord {
    static String actualWord = null; 
    static int count = 0;

    /**
     * @param s 储存当前的字符
     * @return 返回 是否存在*
     */

    public static boolean findWild(StringBuffer s) {
        return s.toString().contains("*");
    }

    /**
     * @param s 目前的单词
     * @param t 用户猜测的单词
     * @return 转态码 0：没有 1 ：正确 2：已经存在
     */
    public static StringBuffer replace(StringBuffer s, char t) {
        
        StringBuffer temp = new StringBuffer();
        char[] t1 = s.toString().toCharArray();
        char[] t2 = actualWord.toCharArray();

        for(int i = 0 ; i < t2.length ; i++) {
            if( t2[i] == t && t1[i] == '*') {
                t1[i] = t;
                break;
            }
        }

        for( int i = 0 ; i < t1.length ; i ++ ) {
            temp.append(t1[i]);
        }

        return temp;
    }
 
    public static int isExist( StringBuffer s, char t) {
    
        int flag = 0; // not found
        char t1[] = actualWord.toCharArray();
        char t2[] = s.toString().toCharArray();

        for (int i = 0 ; i < s.length() ; i ++) {
            if (t1[i] == t && t2[i] == '*') {
                flag = 1;
                break;
            } else if(t1[i] == t &&  t == t2[i] ){
                flag = 2;
            }
        }
        return flag;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // 词汇表
        String [] words = {
            "generate", "helpful", "content", "great", "wordle", " wonder"
        };
        // 终止判断标志
        char conti = 'y';
        int idx = 0;

        while( idx < words.length && conti == 'y' ) {
            
            actualWord = words[idx];
            StringBuffer presentWord = new StringBuffer();
            
            // 全填充 *
            for( int i = 0 ; i < actualWord.length() ; i ++ ) {
                presentWord.append("*");
            }
            while( findWild(presentWord) ) {

                System.out.printf("(Guess) Enter a letter in word %s >", presentWord.toString());
                char t = scanner.next().charAt(0);
                int status = isExist(presentWord, t);
                if  ( status == 0) {
                    System.out.printf("\t%c is not in the word\n", t);
                    count ++;
                } else if( status == 1 ) {
                    presentWord = replace(presentWord, t);
                    
                } else if( status == 2 ) {
                    System.out.printf("\t%c is already in the word\n", t);
                }
            }
            System.out.printf("The word is %s. You missed %d time\n", actualWord, count);
            System.out.println("Do you want to guess another word? Enter y or n>");
            conti = scanner.next().replace(" ", "").charAt(0);

            if( conti == 'y' ) {
                count = 0;
                idx++;
            }
        }
    }
}
