package pt.iade.GoPlay.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="CodPostal")

public class CodPostal {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name="CP_Id")
    private int id;
    @Column (name="CP_4D")
    private int digitos4;
    @Column (name="CP_3D")
    private int digitos3;
    @Column (name="CP_Freguesia")
    private String freguesia;
    @Column (name="CP_Quart")
    private String quarteirao;

    public CodPostal() {}

    public int getId() {
        return id;
    }

    public int getDigitos4() {
        return digitos4;
    }

    public int getDigitos3() {
        return digitos3;
    }

    public String getFreguesia() {
        return freguesia;
    }

    public String getQuarteirao() {
        return quarteirao;
    }
}

