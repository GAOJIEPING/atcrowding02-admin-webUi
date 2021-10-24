import com.atguigu.util.MD5Util;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GaoUP
 * @Date 2021/10/13 9:46
 * @Version 1.0
 */
public class Md5Test {
    @Test
    public void getResouce(){
        String psd="123456";
        String md5Pswd = MD5Util.md5(psd);
        System.out.println(md5Pswd);
    }
}
