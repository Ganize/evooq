package com.evooq.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * A Medicine.
 */
@Entity
@Table(name = "medicine")
public class Medicine implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "medicine_name")
    private String medicineName;

    @Column(name = "medicine_description")
    private String medicineDescription;

    @Column(name = "natural_medicine")
    private Boolean naturalMedicine;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public Medicine medicineName(String medicineName) {
        this.medicineName = medicineName;
        return this;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineDescription() {
        return medicineDescription;
    }

    public Medicine medicineDescription(String medicineDescription) {
        this.medicineDescription = medicineDescription;
        return this;
    }

    public void setMedicineDescription(String medicineDescription) {
        this.medicineDescription = medicineDescription;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    // evooq 6 - solution
    public Medicine naturalMedicine(Boolean naturalMedicine){
        this.naturalMedicine = naturalMedicine;
        return this;
    }
    public Boolean getNaturalMedicine() {
        return naturalMedicine;
    }

    public void setNaturalMedicine(Boolean naturalMedicine) {
        this.naturalMedicine = naturalMedicine;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Medicine)) {
            return false;
        }
        return id != null && id.equals(((Medicine) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Medicine{" +
            "id=" + getId() +
            ", medicineName='" + getMedicineName() + "'" +
            ", medicineDescription='" + getMedicineDescription() + "'" +
            "}";
    }
}
