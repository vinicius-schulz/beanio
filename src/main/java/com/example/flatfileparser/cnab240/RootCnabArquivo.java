package com.example.flatfileparser.cnab240;

import java.util.List;

import org.beanio.annotation.Group;
import org.beanio.annotation.Record;

import com.example.flatfileparser.cnab240.lotePagCcChOpDocTedPa.PagamentoLotePagCcChOpDocTedPa;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Group
@Getter
@Setter
@ToString
public class RootCnabArquivo {

	@Record(name = "RegistroHeaderArquivo", maxLength = 240, minOccurs = 1, maxOccurs = 1)
	private RegistroHeaderArquivo registroHeaderArquivo;

	@Group(minOccurs = 1, maxOccurs = -1)
	private List<PagamentoLotePagCcChOpDocTedPa> lote312s;

	@Record(name = "RegistroTrailerArquivo", maxLength = 240, minOccurs = 1, maxOccurs = 1)
	private RegistroTrailerArquivo registroTrailerArquivo;

}