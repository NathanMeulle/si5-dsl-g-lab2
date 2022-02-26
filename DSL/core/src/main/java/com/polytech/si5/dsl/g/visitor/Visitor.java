package com.polytech.si5.dsl.g.visitor;

import com.polytech.si5.dsl.g.model.*;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public abstract class Visitor<T> {

	public abstract void visit(App app);
	public abstract void visit(Champ champ);
	public abstract void visit(ClassementPage classementPage);
	public abstract void visit(Disposition disposition);
	public abstract void visit(Filtre filtre);
	public abstract void visit(Style style);
	public abstract void visit(Tableau tableau);


	/***********************
	 ** Helper mechanisms **
	 ***********************/

	protected Map<String,Object> context = new HashMap<>();

	protected T result;

	public T getResult() {
		return result;
	}


	public void visit(Titre titre) {
		//todo
	}
}

