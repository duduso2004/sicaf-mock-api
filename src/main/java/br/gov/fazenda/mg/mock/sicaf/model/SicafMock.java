package br.gov.fazenda.mg.mock.sicaf.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("SICAF_MOCK")
public class SicafMock {

    @Id
    @Column("ID")
    private Long id;

    @Column("RENAVAM")
    private Long renavam;

    @Column("ANO_EXERCICIO")
    private Integer anoExercicio;

    @Column("CODIGO_STATUS")
    private Integer codigoStatus;

    @Column("DESCRICAO")
    private String descricao;

}
