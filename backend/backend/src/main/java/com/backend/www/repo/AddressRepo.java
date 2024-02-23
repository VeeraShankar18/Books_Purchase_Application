package com.backend.www.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.www.model.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address,Long>{

}
