package com.pcs.autok.controller.validators.agenda;

import java.sql.SQLException;

import com.pcs.autok.model.Agenda;
import com.pcs.autok.utils.ResultParameters;

public class EditarAgendaValidator {

	Agenda agenda;

	public EditarAgendaValidator(Agenda agenda) {
		this.agenda = agenda;
	}

	public int validar(Agenda agenda) throws SQLException {
		return ResultParameters.OK.getResult();
	}
}
