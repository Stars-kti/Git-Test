import com.citic.common.util.excel.TxtDataInput;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class UserServerApplicationTest {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    @Test
    public void test(){
        String encode = encoder.encode("001206");
        System.out.println(encode);
        boolean matches = encoder.matches("123456","$2a$10$0OrWIbr5QSc2J.P0Kwj2zuzJWi5MdGalCGQpW7kkZdzt.pPZ7b31C");
        System.out.println(matches);

    }

    @Test
    public void test1(){
        TxtDataInput txtDataInput = new TxtDataInput("C:/Users/citicsf/Documents/WeChat Files/wxid_qogswec0lyri22/FileStorage/File/2020-11/org_marketdeposit_20201116.data");
        List<String[]> data = txtDataInput.getData("\\|", 1);
        String[] strings = data.get(0);

        short s1 =1 ;
        s1 += 1;
        int max = Integer.max(1, 0);
        data.add(10,null);
        assert max == 1;
        max = ++max;
        assert max == 2;
        num(1237);
        int age = age(8);
        System.out.println(age);
        int[] ints = {2,5,6,1,8,-1,3,7,4};
        Arrays.sort(ints);
        System.out.println(-max);
    }


    public static void num(int i) {
        System.out.println(i);
        if (i <= 5000) {
            num(i * 2);
        }
        System.out.println(i);
    }

    public static int age(int n) {
        if (n == 1) return 10;
        return age(n - 1) + 2;
    }

}
