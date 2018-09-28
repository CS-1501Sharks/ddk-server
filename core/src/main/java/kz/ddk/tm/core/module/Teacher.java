package kz.ddk.tm.core.module;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "teacher", schema = "ddk_core", catalog = "")
public class Teacher {
    private int id;
    private int userId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id &&
                userId == teacher.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId);
    }
}
