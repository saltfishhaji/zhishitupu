package com.cxtx.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "RELATIONS")
public class Relations {
    /**
     * id
     entity1
     entity2
     relationtype
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * entity1
     */
    @Column
    private Long entity1;

    /**
     * entity2
     */
    @Column
    private Long entity2;

    /**
     * relationtype
     */
    @Column
    private String relationtype;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEntity1() {
        return entity1;
    }

    public void setEntity1(Long entity1) {
        this.entity1 = entity1;
    }

    public Long getEntity2() {
        return entity2;
    }

    public void setEntity2(Long entity2) {
        this.entity2 = entity2;
    }

    public String getRelationtype() {
        return relationtype;
    }

    public void setRelationtype(String relationtype) {
        this.relationtype = relationtype;
    }
}
