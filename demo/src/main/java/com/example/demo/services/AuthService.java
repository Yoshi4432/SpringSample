package com.example.demo.services;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

/**
 * ログインサービス
 * 
 * @author perfect.yoshi@gmail.com
 *
 */
@Service
public class AuthService {

	/**
	 * Userリポジトリ
	 */
	protected UserRepository userRepository;

	/**
	 * パスワードエンコーダー
	 */
	protected PasswordEncoder passwordEncoder;

	/**
	 * コンストラクタ.
	 * 
	 * @param u ユーザーリポジトリ
	 * @param p パスワードエンコーダー
	 */
	public AuthService(UserRepository u, PasswordEncoder p) {
		this.userRepository = u;
		this.passwordEncoder = p;
	}

	/**
	 * ログイン処理を行う.
	 * 
	 * @param user ユーザー名
	 * @param pass パスワード
	 * @return TRUE：ログインOK、FALSE：ログインNG
	 */
	public boolean login(String user, String pass) {
		// DBからユーザー情報取得
		Optional<User> result = userRepository.findByName(user);
		if (result.isEmpty()) {
			return false;
		}

		// パスワードがマッチするかチェック
		return passwordEncoder.matches(pass, result.get().getPassword());
	}
}
