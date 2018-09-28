package kz.ddk.tm.core.module;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "group", schema = "ddk_core", catalog = "")
public class Group {
    private int id;
    private String name;
    private String classroomNum;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "classroom_num")
    public String getClassroomNum() {
        return classroomNum;
    }

    public void setClassroomNum(String classroomNum) {
        this.classroomNum = classroomNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return id == group.id &&
                Objects.equals(name, group.name) &&
                Objects.equals(classroomNum, group.classroomNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, classroomNum);
    }
}
