package com.hummingbird.org.spring.jpa.deep.dive.repository;

import com.hummingbird.org.spring.jpa.deep.dive.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
}
