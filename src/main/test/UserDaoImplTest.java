import com.information.dao.impl.UserDaoImpl;
import com.information.entity.User;
import org.junit.Test;

/**
 * @Author qiaoshu
 * @JDK 1.8
 * Date: 2020-10-19  15:59
 * Description:
 */
public class UserDaoImplTest {
    public static void main(String[] args) {
        UserDaoImpl dao = new UserDaoImpl();
        User user = new User();
        user.setUsername("007");
        user.setPassword("007");
        user.setType("000");
        System.out.println(dao.insertUser(user));
    }
}
