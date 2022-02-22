package com.example.demo.entities;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * ユーザー情報を格納するエンティティクラス.
 * 
 * @author perfect.yoshi@gmail.com
 *
 */
@Setter
@Getter
@Table(name = "users")
@Entity
public class User {

	/**
	 * ID(PK)
	 */
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;

	/**
	 * ユーザー名
	 */
	private String name;

	/**
	 * メールアドレス
	 */
	private String email;

	/**
	 * パスワード（HASH）
	 */
	private String password;

	/**
	 * ロール
	 */
	private String roles;

	/**
	 * パスワード忘れた？
	 */
	private String rememberToken;

	/**
	 * 作成ユーザーID
	 */
	private Integer createdUserId;

	/**
	 * 更新ユーザーID
	 */
	private Integer updatedUserId;

	/**
	 * 作成日
	 */
	private Timestamp createdAt;

	/**
	 * 更新日
	 */
	private Timestamp updatedAt;

	/**
	 * 削除日
	 */
	private Timestamp deletedAt;
}
