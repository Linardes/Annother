import com.LMJ.utils.MD5Util;
import org.junit.Test;

/**
 * @author Hui
 * @date 2022/5/12 15:37
 */
public class TestMD5 {
    @Test
    public void testMD5(){
        String passwd = MD5Util.getMD5("123456mj");
        System.out.println(passwd);
    }
}
