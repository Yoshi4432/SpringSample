package com.example.demo.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.example.demo.services.AuthService;

/**
 * ログイン処理を行うクラス.
 * 
 * @author perfect.yoshi@gmail.com
 *
 */
@Configuration
public class AuthProvider implements AuthenticationProvider {

	/**
	 * ログイン処理サービス
	 */
	protected AuthService authService;

	/**
	 * コンストラクタ
	 * 
	 * @param a ログイン処理サービス
	 */
	public AuthProvider(AuthService a) {
		this.authService = a;
	}

	/**
	 * ログイン処理
	 */
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		/* 取得 */
		String user = auth.getPrincipal().toString();
		String pass = auth.getCredentials().toString();

		/* 認証 */
		boolean result = authService.login(user, pass);
		if (!result) {
			// 一致しなかったためエラー
			throw new BadCredentialsException("ユーザー名とパスワードが一致しません");
		}

		/* ログインOKトークン返却 */
		return new UsernamePasswordAuthenticationToken(user, pass, new ArrayList<>());
	}

	/**
	 * ID・PASSで認証を行う.
	 */
	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
}
