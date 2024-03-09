package com.hummingbird.org.spring.jpa.deep.dive.repository;

import com.hummingbird.org.spring.jpa.deep.dive.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Page<Course> findByTitleContaining(String string, Pageable pageable);
}
