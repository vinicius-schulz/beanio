package com.example.flatfileparser.cnab240.lote.pagCcChOpDocTedPa;

import org.beanio.annotation.Field;
import org.beanio.annotation.Group;
import org.beanio.builder.Align;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Group
@Getter
@Setter
@ToString
public class RegistroHeaderLotePagCcChOpDocTedPa {
	@Field(at = 0, length = 3, padding = '0', align = Align.RIGHT)
	private int banco;

	@Field(at = 3, length = 4, padding = '0', align = Align.RIGHT)
	private int lote;

	@Field(at = 7, length = 1, rid = true, literal = "1")
	private int registro;
	
	@Field(at = 8, length = 1, rid = true, literal = "C")
	private String tipoOperacao;

	@Field(at = 9, length = 2, padding = '0', align = Align.RIGHT)
	private int tipoServico;

	@Field(at = 11, length = 2, padding = '0', align = Align.RIGHT)
	private int formaLancamento;
	
	@Field(at = 13, length = 3, rid = true, literal = "046")
	private int versaoLayout;

	@Field(at = 16, length = 224, padding = ' ')
	private String branco;
}