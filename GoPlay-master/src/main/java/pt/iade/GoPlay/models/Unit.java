import javax.persistence.Id;

@Entity
@Table(name = "disciplinas")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dis_id")
    private int id;
    @Column(name = "dis_nome")
    private String name;
    @Column(name = "dis_creditos")
    private int credits;
}


