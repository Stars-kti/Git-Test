import com.citic.common.util.object.ObjUtils;
import com.citic.common.util.rating.RatingUtils;
import com.management.dao.UserDao;
import com.management.entity.user.User;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ManagementServiceApplicationTest {

    @Test
    public void Test() {
        User user = new User();
        List list = new ArrayList();
        Boolean empty = ObjUtils.isEmpty(list);
        System.out.println(empty);
        Boolean empty1 = ObjUtils.isEmpty(user);
        System.out.println(empty1);

        String string = null;
        boolean empty2 = StringUtils.isEmpty(null);
        boolean notEmpty1 = StringUtils.isNotEmpty(null);
        boolean blank = StringUtils.isBlank(null);
        Boolean notEmpty = ObjUtils.isNotEmpty(null);
        System.out.println(blank);
        System.out.println(100000 >> 5);
    }

    @Test
    public void main() throws AWTException {
        final Robot rb = new Robot();
        new Thread() {
            public void run() {
                rb.delay(2000);
//回车
                rb.keyPress(KeyEvent.VK_ENTER);
                rb.keyRelease(KeyEvent.VK_ENTER);
            }
        }.start();
        //单击
        pressMouse(rb, InputEvent.BUTTON1_MASK, 500);
        //右击
        pressMouse(rb, InputEvent.BUTTON3_MASK, 500);
    }
    //鼠标单击,要双击就连续调用
    private static void pressMouse(Robot r, int m, int delay) {
        r.mousePress(m);
        r.delay(10);
        r.mouseRelease(m);
        r.delay(delay);
    }
    //键盘输入
    private static void pressKeys(Robot r, int[] ks, int delay) {
        for (int i = 0; i < ks.length; i++) {
            r.keyPress(ks[i]);
            r.delay(10);
            r.keyRelease(ks[i]);
            r.delay(delay);
        }
    }
    private Dimension dim; //存储屏幕尺寸
    private static Robot robot;//自动化对象

    public static void move(int width,int heigh){    //鼠标移动函数
        System.out.println("enter Move()...");
        Point mousing = MouseInfo.getPointerInfo().getLocation();
        System.out.println("移动前坐标：" + mousing.x + " " + mousing.y);
        width += mousing.x;
        heigh += mousing.y;

        try{
            robot = new Robot();
            robot.delay(3000);
            robot.mouseMove(width,heigh);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("移动后坐标：" + width + " " + heigh);
        //robot.mousePress(InputEvent.BUTTON1_MASK);//鼠标单击
    }

    @Test
    public void Test1() {
        move(0,0);
    }

    UserDao userDao;

    @Test
    public void userAdd() {

        double d = 2.0;
        float f = 2.0f;
        int c = 2;
        System.out.println(c++);
        System.out.println(c);


    }

    @Test
    public void Test2() {
        String s = "b.a";
        String[] split = s.split("\\.");

        RatingUtils.getProdId(s);
    }
}
