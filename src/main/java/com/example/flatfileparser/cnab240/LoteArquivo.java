package com.example.flatfileparser.cnab240;

import java.util.List;

import org.beanio.annotation.Group;

import com.example.flatfileparser.cnab240.lote.pagCcChOpDocTedPa.PagamentoLotePagCcChOpDocTedPa;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoteArquivo {

	@Group(minOccurs = 0, maxOccurs = -1)
	private List<PagamentoLotePagCcChOpDocTedPa> lote312s;

}