package kr.ac.knu.gdsc.Eywa.domain.dictionary;

import kr.ac.knu.gdsc.Eywa.domain.Register;
import kr.ac.knu.gdsc.Eywa.domain.Report;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn //하위 테이블의 구분 칼럼 생성 default = DTYPE
public abstract class Dictionary {
    @Id @GeneratedValue
    @Column(name = "dictionary_id")
    private Long id;

    @Column(name = "korean_name")
    private String korName;

    @Column(name = "english_name")
    private String EngName;

    private String summary;

    private String kind;

    private String image;

    @OneToMany(mappedBy = "dictionary")
    private List<Report> reports = new ArrayList<>();

    @OneToMany(mappedBy = "dictionary")
    private List<Register> registers = new ArrayList<>();

    public Dictionary(String korName, String engName, String summary, String kind, String image) {
        this.korName = korName;
        EngName = engName;
        this.summary = summary;
        this.kind = kind;
        this.image = image;
    }
}
