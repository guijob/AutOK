package com.pcs.autok.controller.validators.agenda;

import java.sql.SQLException;

import com.pcs.autok.model.Agenda;
import com.pcs.autok.utils.ResultParameters;

public class CadastrarAgendaValidator {

	Agenda agenda;

	public CadastrarAgendaValidator(Agenda agenda) {
		this.agenda = agenda;
	}

	public int validar(Agenda agenda) throws SQLException {
		return ResultParameters.OK.getResult();
	}
}
