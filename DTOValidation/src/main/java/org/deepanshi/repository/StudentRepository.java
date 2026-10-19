
package org.deepanshi.repository;

import org.deepanshi.entity.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final RowMapper<Student> rowMapper =
            new BeanPropertyRowMapper<>(Student.class);

    public StudentRepository(
            NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void create(Student student) {
        String sql = """
                INSERT INTO students(name, age, email)
                VALUES (:name, :age, :email)
                """;

        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("name", student.getName())
                .addValue("age", student.getAge())
                .addValue("email", student.getEmail());

        int rowAffected =
                namedParameterJdbcTemplate.update(sql, params);

        if (rowAffected == 1) {
            System.out.println("Create Student successful");
        } else {
            System.out.println("Create Student failed");
        }
    }

    public void update(Student student, int id) {
        String sql = """
                UPDATE students
                SET name = :name,
                    age = :age,
                    email = :email
                WHERE id = :id
                """;

        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("name", student.getName())
                .addValue("age", student.getAge())
                .addValue("email", student.getEmail())
                .addValue("id", id);

        int rowAffected =
                namedParameterJdbcTemplate.update(sql, params);

        if (rowAffected == 1) {
            System.out.println("Update operation successful");
        } else {
            System.out.println("Updation failed");
        }
    }

    public void delete(int id) {
        String sql = """
                DELETE FROM students WHERE id = :id
                """;

        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);

        int rowAffected =
                namedParameterJdbcTemplate.update(sql, params);

        if (rowAffected == 1) {
            System.out.println("Delete operation successful");
        } else {
            System.out.println("Deletion failed");
        }
    }

    public Student getStudentById(int id) {
        String sql = """
                SELECT id, name, email, age
                FROM students
                WHERE id = :id
                """;

        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);

        return namedParameterJdbcTemplate.queryForObject(
                sql, params, rowMapper);
    }

    public List<Student> getStudent() {
        String sql = """
                SELECT id, name, email, age
                FROM students
                """;

        return namedParameterJdbcTemplate.query(
                sql, new MapSqlParameterSource(), rowMapper);
    }


}