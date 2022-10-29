
package com.argpro.axios.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Educ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    private String nomEduc;
    private String descEduc;

    public Educ() {
    }

    public Educ(String nomEduc, String descEduc) {
        this.nomEduc = nomEduc;
        this.descEduc = descEduc;
    }
    
    
}
