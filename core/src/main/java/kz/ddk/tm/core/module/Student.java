package kz.ddk.tm.core.module;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "student", schema = "ddk_core", catalog = "")
public class Student {
    private int id;
    private int userId;
    private int groupId;

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

    @Basic
    @Column(name = "group_id")
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                userId == student.userId &&
                groupId == student.groupId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, groupId);
    }
}
