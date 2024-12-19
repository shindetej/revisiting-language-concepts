package com.jpa.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.demo.models.Tracking;

@Repository
public interface ITrackingRepository extends JpaRepository<Tracking,Long>{

}
