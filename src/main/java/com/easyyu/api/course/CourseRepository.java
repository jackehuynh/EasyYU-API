package com.easyyu.api.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
    List<Course> findBySubjectAllIgnoreCase(String subject);
    List<Course> findBySubjectAndCourseNumberAllIgnoreCase(String subject, String courseNumber);
    List<Course> findByFacultyAllIgnoreCase(String faculty);
    List<Course> findByFacultyAndSubjectAndCourseNumberAllIgnoreCase(String faculty, String Subject, String courseNumber);

    // TODO: Query for courses offered in certain semesters
    // TODO: Query for courses with certain pre-reqs
    // TODO: Query for courses offered online
    // TODO: Query for course by ID (Also need to think of how to implement IDs on course entity)
    // @Query(value = "SELECT * FROM courses WHERE offerings @> '[{\"term\": \"F\"}]'")

    /*
    @Query(value = "select distinct subject, course_number, courses.name " +
            "from courses, jsonb_array_elements(offerings) offr " +
            "where offr #>> '{" +
            "   \"course_info\": [ " +
            "       {\"instructor\": ?1} " +
            "   ] " +
            "}'",
            nativeQuery = true)

     */

    // V1
    @Query(value = "WITH t1 AS (" +
            "SELECT courses.name, subject, course_number, " +
            "jsonb_array_elements_text(jsonb_array_elements(jsonb_array_elements(offerings)->'course_info')->'instructor') instructor FROM courses" +
            ")" +
            "SELECT DISTINCT subject, course_number, name, instructor FROM t1 WHERE t1.instructor ILIKE %:teacher%",
            nativeQuery = true)

    /* V2
    @Query(value = "SELECT DISTINCT subject, course_number, name, inst" +
            "FROM courses, jsonb_array_elements(offerings) ins, jsonb_array_elements(ins->'course_info') info," +
            "jsonb_array_elements_text(info->'instructor') inst" +
            "WHERE inst ILIKE %:teacher%",
            nativeQuery = true)

     */
    List<String> findByInstructor(@Param("teacher") String instructor);
}