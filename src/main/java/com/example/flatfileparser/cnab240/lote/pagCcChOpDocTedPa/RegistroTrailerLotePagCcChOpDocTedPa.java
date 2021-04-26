package com.example.flatfileparser.cnab240.lote.pagCcChOpDocTedPa;

import org.beanio.annotation.Field;
import org.beanio.builder.Align;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RegistroTrailerLotePagCcChOpDocTedPa {
	@Field(at = 0, length = 3, padding = '0', align = Align.RIGHT)
	private int banco;

	@Field(at = 3, length = 4, padding = '0', align = Align.RIGHT)
	private int lote;

	@Field(at = 7, length = 1, rid = true, literal = "5")
	private int registro;

	@Field(at = 8, length = 232, padding = ' ')
	private String branco;
}