package kz.ddk.tm.core.module;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "course", schema = "ddk_core", catalog = "")
public class Course {
    private int id;
    private int teacherId;
    private int disciplineId;
    private int groupId;
    private int groupLeadId;

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
    @Column(name = "teacher_id")
    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Basic
    @Column(name = "discipline_id")
    public int getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(int disciplineId) {
        this.disciplineId = disciplineId;
    }

    @Basic
    @Column(name = "group_id")
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "group_lead_id")
    public int getGroupLeadId() {
        return groupLeadId;
    }

    public void setGroupLeadId(int groupLeadId) {
        this.groupLeadId = groupLeadId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id &&
                teacherId == course.teacherId &&
                disciplineId == course.disciplineId &&
                groupId == course.groupId &&
                groupLeadId == course.groupLeadId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teacherId, disciplineId, groupId, groupLeadId);
    }
}
