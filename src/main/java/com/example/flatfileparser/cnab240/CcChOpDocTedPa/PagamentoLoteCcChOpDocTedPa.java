package com.example.flatfileparser.cnab240.CcChOpDocTedPa;

import org.beanio.annotation.Record;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PagamentoLoteCcChOpDocTedPa {

	@Record(minLength = 240, maxLength = 240, name = "RegistroHeaderLote", minOccurs = 1, maxOccurs = 1)
	private RegistroHeaderLoteCcChOpDocTedPa registroHeaderLote;

	@Record(minLength = 240, maxLength = 240, name = "RegistroSegmentoALote312", minOccurs = 1, maxOccurs = 1)
	private RegistroSegmentoALoteCcChOpDocTedPa registroSegmentoALote312;

	@Record(minLength = 240, maxLength = 240, name = "RegistroSegmentoBLote312", minOccurs = 1, maxOccurs = 1)
	private RegistroSegmentoBLoteCcChOpDocTedPa registroSegmentoBLote312;

	@Record(minLength = 240, maxLength = 240, name = "RegistroSegmentoCLote312", minOccurs = 0, maxOccurs = 1)
	private RegistroSegmentoCLoteCcChOpDocTedPa registroSegmentoCLote312;

	@Record(minLength = 240, maxLength = 240, name = "RegistroTrailerLote", minOccurs = 1, maxOccurs = 1)
	private RegistroTrailerLoteCcChOpDocTedPa registroTrailerLote;

}