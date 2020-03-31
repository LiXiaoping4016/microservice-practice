package member.service;

import com.model.BaseResponse;
import member.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 会员服务接口
 *
 * @Author lixp23692
 * @Date 2019/8/30
 */
public interface IMemberService {

    @PostMapping("/getUserInfo")
    BaseResponse getUserInfo(@RequestParam("id") int id, @RequestParam("type") String type);

    @PostMapping("/getUserInfoById")
    User getUserInfoById(@RequestParam("id") int id);
}
