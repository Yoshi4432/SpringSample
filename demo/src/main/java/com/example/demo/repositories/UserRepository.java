package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;

/**
 * ユーザー情報にアクセスリポジトリ.
 * 
 * @author perfect.yoshi@gmail.com
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	/**
	 * ユーザー名で検索.
	 * 
	 * @param name ユーザー名
	 * @return 指定のユーザー名と一致するユーザー.
	 */
	Optional<User> findByName(String name);
}
