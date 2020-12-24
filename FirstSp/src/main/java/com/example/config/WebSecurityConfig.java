package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.service.UserDetailsServiceImpl;

/**
 * SpringSecurityの設定ファイルです
 *ログインの情報や、認証不要のページを設定しています。
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	//パスワードの暗号化をやってくれるクラスの設定
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	/**
	 * 以下の場所は許可なしでアクセスできます
	 * 静的リソース(画像、描画の設定、スクリプト)が格納されています
	 * 許可しないと画面が寂しいことになります。
	 */
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                            "/img/**",
                            "/css/**",
                            "/javascript/**"
                            );
    }


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		/**
		 * 認証不要なURL・パラメータを取得するname属性の値を設定
		 */
		    .authorizeRequests()
		    	.mvcMatchers("/index").permitAll()
		    	.mvcMatchers("/create").permitAll()
		    	.mvcMatchers("/join").permitAll()
		    	.mvcMatchers("/success").permitAll()
		    	.mvcMatchers("/resultCtrl").permitAll()
		    	.mvcMatchers("/result").permitAll()
		        .anyRequest().authenticated()
		        .and()
		        /*
		         * ログイン周りの設定は以下に記述
		         */
		    .formLogin()
		        .loginPage("/login") //ログインページはコントローラを経由しないのでViewNameとの紐付けが必要
		        .loginProcessingUrl("/sign_in") //フォームのSubmitURL、このURLへリクエストが送られると認証処理が実行される
		        .usernameParameter("username") //リクエストパラメータのname属性を明示
		        .passwordParameter("password")
		        .successForwardUrl("/index")//ログイン成功したらここに飛びます
		        .failureUrl("/login?error")//失敗時
		        .permitAll()
		        .and()
		    .logout()
		 // ログアウト処理
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		        .logoutSuccessUrl("/login?logout")
		     // ログアウト時のセッション破棄を有効化
                .invalidateHttpSession(true)
		        .permitAll();
	}

	/**
	 * 認証時に利用するデータソースを定義する設定メソッド
	 * ここではDBから取得したユーザ情報をuserDetailsServiceへセットすることで認証時の比較情報としている
	 * @throws Exception
	 */
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		/*
		auth
		    .inMemoryAuthentication()
		        .withUser("user").password("{noop}password").roles("USER");
		*/
	}

}