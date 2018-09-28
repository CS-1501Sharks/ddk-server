package kz.ddk.tm.core.module;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "discipline", schema = "ddk_core", catalog = "")
public class Discipline {
    private int id;
    private String name;
    private int disciplineTypeId;

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
    @Column(name = "discipline_type_id")
    public int getDisciplineTypeId() {
        return disciplineTypeId;
    }

    public void setDisciplineTypeId(int disciplineTypeId) {
        this.disciplineTypeId = disciplineTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discipline that = (Discipline) o;
        return id == that.id &&
                disciplineTypeId == that.disciplineTypeId &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, disciplineTypeId);
    }
}
