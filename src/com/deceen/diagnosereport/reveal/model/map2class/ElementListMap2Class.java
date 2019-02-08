package com.deceen.diagnosereport.reveal.model.map2class;

import java.io.Serializable;
import java.util.List;

import com.deceen.diagnosereport.reveal.model.molecule.Molecule;

/**
 * 用于封装要素下所有指标的诊断结果的类
 */
public class ElementListMap2Class implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String element;//要素的名称
	
	private List<Molecule> moleculeList;//装有Molecule的集合

	public ElementListMap2Class() {
		super();
	}

	public ElementListMap2Class(String element, List<Molecule> moleculeList) {
		super();
		this.element = element;
		this.moleculeList = moleculeList;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public List<Molecule> getMoleculeList() {
		return moleculeList;
	}

	public void setMoleculeList(List<Molecule> moleculeList) {
		this.moleculeList = moleculeList;
	}
	
}
