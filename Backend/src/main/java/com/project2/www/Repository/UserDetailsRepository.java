package com.project2.www.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project2.www.Store.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails,Long>
{

	UserDetails getByUserName(String userName);

}
