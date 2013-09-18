package br.com.projetoFormulario.controller;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.projetoFormulario.dao.TemplateDao;
import br.com.projetoFormulario.domain.Template;

@Resource
public class TemplateController {

	private Result result; 
	private TemplateDao dao;
	
	public TemplateController(TemplateDao dao, Result result) throws Exception{
		this.result = result;
		this.dao = dao;
	}

	@Get("/templates")
	public void detailListTemplates() throws Exception{
		List<Template> templates = dao.findAllTemplates();
		result.use(Results.json()).from(templates, "templateList").serialize();  
	}
	
	@Get("/templates/id")
	public void detailListTemplatesByID() throws Exception{
		List<Template> templates = dao.findAllTemplates();
		result.use(Results.json()).from(templates, "templateList").serialize();  
	}

}
