package com.zzu.hezhifeng.dao;

import com.zzu.hezhifeng.common.base.dao.AbstractDAO;
import com.zzu.hezhifeng.pojo.DO.UserDO;
import com.zzu.hezhifeng.pojo.Param.UserParam;
import com.zzu.hezhifeng.pojo.VO.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface UserDAO extends AbstractDAO<UserDO, UserVO, UserParam> {
}
