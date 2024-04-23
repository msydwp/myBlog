package com.uy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uy.mapper.TUserMapper;
import com.uy.pojo.TUser;
import com.uy.redis.RedisTemplateUtils;
import com.uy.service.TUserService;
import com.uy.util.Result;
import com.uy.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
* @author my
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2022-11-29 10:41:39
*/
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser>
    implements TUserService {

    @Autowired
    private RedisTemplateUtils redisTemplateUtils ;

    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public Result userLogin(TUser tUser) {
        TUser result = null ;
        String userUserAccount = tUser.getUserAccount();
        String passWord = tUser.getPassWord();

        LambdaQueryWrapper<TUser> queryWrapper = new LambdaQueryWrapper<>();
        //拼接查询语句
        queryWrapper.eq(TUser::getUserAccount, userUserAccount);
        queryWrapper.eq(TUser::getPassWord, passWord);
        queryWrapper.eq(TUser::getStatus, 1);

        //调用service查询
        result = getOne(queryWrapper);

        if(result == null){

            return Result.<TUser>builder()
                    .code(HttpStatus.UNAUTHORIZED.value())
                    .message("用户不存在，请先注册！")
                    .data(null)
                    .build();
        }

        String token = TokenUtils.createToken(userUserAccount,passWord);
        redisTemplateUtils.set(token,result,300);

        updaterToken(token,tUser);

        return Result.<TUser>builder()
                .code(HttpStatus.OK.value())
                .message("登陆成功！")
                .data(result)
                .build();
    }

    @Override
    public Result userRegister(TUser tUser) {

        //验证用户账号和昵称 是否已存在 并且重复
        Integer count = tUserMapper.selectUserCount(tUser);
        if(count > 0){
            return Result.<TUser>builder()
                    .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .message("用户已经注册过了哟，请修改一下您的昵称和账号哦~ ")
                    .build();
        }

        String token = TokenUtils.createToken(tUser.getUserAccount(),tUser.getPassWord());

        tUser.setToken(token);
        tUser.setStatus(1L);
        if(!save(tUser)){
            return Result.<TUser>builder()
                    .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .message("用户注册失败，请重试 ")
                    .build();
        }

        redisTemplateUtils.set(token,tUser,300);

        return Result.<TUser>builder()
                .code(HttpStatus.OK.value())
                .message("用户注册成功！")
                .data(tUser)
                .build();
    }

    /**
     * 修改用户token
     */
    public void updaterToken(String token,TUser tUser){
        tUser.setToken(token);
        updateById(tUser);
    }

    /**
     * 用户查询
     * @param user
     * @return
     */
    public Result queryUser(TUser user){

        TUser tUser = new TUser();
        LambdaQueryWrapper<TUser> queryWrapper = new LambdaQueryWrapper<>();
        //拼接查询语句
        queryWrapper.eq(TUser::getUserAccount, user.getUserAccount());
        queryWrapper.eq(TUser::getPassWord, user.getPassWord());
        queryWrapper.eq(TUser::getStatus, 1);

        tUser = getOne(queryWrapper);

        return Result.<TUser>builder()
                .code(HttpStatus.OK.value())
                .data(tUser)
                .build();
    }


}




