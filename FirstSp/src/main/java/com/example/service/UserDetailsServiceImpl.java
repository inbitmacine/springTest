package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Dao.LoginUserDao;
import com.example.entity.LoginUser;
import com.example.repository.LoginUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    //DBからユーザ情報を検索するメソッドを実装したクラス
    @Autowired
    private LoginUserDao userDao;

    @Autowired
    LoginUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        LoginUser user = userDao.findUser(userName);

        if (user == null) {
            throw new UsernameNotFoundException("User" + userName + "was not found in the database");
        }
        //権限のリスト
        //AdminやUserなどが存在するが、今回は利用しないのでUSERのみを仮で設定
        //権限を利用する場合は、DB上で権限テーブル、ユーザ権限テーブルを作成し管理が必要
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        GrantedAuthority authority = new SimpleGrantedAuthority("USER");
        grantList.add(authority);


        //UserDetailsはインタフェースなのでUserクラスのコンストラクタで生成したユーザオブジェクトをキャスト
        UserDetails userDetails = (UserDetails)new User(user.getUserName(), user.getPassword(),grantList);

        return userDetails;
    }

    @Transactional
    public void insertUser(String name, String password, String mail) {
                LoginUser user = new LoginUser();
        user.setUserName(name);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(password));
        if(mail!="") {
        	user.setMail(encoder.encode(mail));
        }
        else {
        	user.setMail("NoData");
        }
        userRepository.save(user);
    }

}