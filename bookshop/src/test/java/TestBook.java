import com.xuhai.bookshop.bean.Userinfo;
import com.xuhai.bookshop.service.UserinfoService;
import com.xuhai.bookshop.util.TokenUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestBook {

    @Autowired
    private UserinfoService userinfoService;

    @Test
    public void createToken(){

        System.out.println(TokenUtil.getInstance().makeToken());
    }

    @Test
    public void testMd5(){
        System.out.println(DigestUtils.md5Hex("admin"));
    }

    @Test
    public void testUserList(){
        System.out.println(userinfoService.getPage(1,5,new Userinfo()));
    }

}
