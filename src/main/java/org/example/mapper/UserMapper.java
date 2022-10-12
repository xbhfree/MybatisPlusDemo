package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.Map;


/**
 * @author xbhfr
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     *
     * @param id
     * @return
     */
    Map<String, Object> selectMapById(Long id);
}
