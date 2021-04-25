package com.example.flatfileparser.cnab240.lotePagCcChOpDocTedPa;

import org.beanio.annotation.Record;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PagamentoLotePagCcChOpDocTedPa {

	@Record(minLength = 240, maxLength = 240, name = "RegistroHeaderLote", minOccurs = 1, maxOccurs = 1)
	private RegistroHeaderLotePagCcChOpDocTedPa registroHeaderLote;

	@Record(minLength = 240, maxLength = 240, name = "RegistroSegmentoALote312", minOccurs = 1, maxOccurs = 1)
	private RegistroSegmentoALotePagCcChOpDocTedPa registroSegmentoALote312;

	@Record(minLength = 240, maxLength = 240, name = "RegistroSegmentoBLote312", minOccurs = 1, maxOccurs = 1)
	private RegistroSegmentoBLotePagCcChOpDocTedPa registroSegmentoBLote312;

	@Record(minLength = 240, maxLength = 240, name = "RegistroSegmentoCLote312", minOccurs = 0, maxOccurs = 1)
	private RegistroSegmentoCLotePagCcChOpDocTedPa registroSegmentoCLote312;

	@Record(minLength = 240, maxLength = 240, name = "RegistroTrailerLote", minOccurs = 1, maxOccurs = 1)
	private RegistroTrailerLotePagCcChOpDocTedPa registroTrailerLote;

}