package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 認証処理のコンフィグを設定する.
 * 
 * @author perfect.yoshi@gmail.com
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * アカウント登録時のパスワードエンコードで利用するためDI管理する.
	 * 
	 * @return パスワードエンコード
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	/**
	 * WEBサービス全体に対するセキュリティを設定する.
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		/* 静的リソース（下記のマッチするリクエスト）に認証を行わせない. */
		// @formatter:off
		web.debug(false)
			.ignoring()
			.antMatchers("/img/**", "/js/**", "/css/**", "/mock/**");
		// @formatter:on

	}

	/**
	 * 指定のURLパターン毎のセキュリティを設定する.
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
			.authorizeHttpRequests()
				.mvcMatchers("/signup").permitAll() // ログイン画面のみ認証OK
				.anyRequest()
				.authenticated() // マッチしたリクエスト以外はすべて認証をかける.
			.and()
			.formLogin()
				.defaultSuccessUrl("/") // ログイン先
			.and()
			.logout()
				.invalidateHttpSession(true) // ログアウトしたらセッションを無効化する
				.deleteCookies("JSESSIONID") // ログアウトしたらクッキーの「JSESSIONID」を削除する
				.logoutSuccessUrl("/signup") // ログアウト先URL
		;
		// @formatter:on
	}
}
