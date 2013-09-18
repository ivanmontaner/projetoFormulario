package br.com.projetoFormulario.controller;

import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
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
		List<Template> templates = dao.findAll();
		result.use(Results.json()).from(templates, "templateList").serialize();  
	}

	@Get("/templates/id")
	public void detailListTemplatesByID(String id) throws Exception{
		List<Template> templates = dao.findByID(id);
		result.use(Results.json()).from(templates, "templateList").serialize();  
	}

	@Post("/templates")
	public void insertTemplates(String title) throws Exception{
		Template template = null;  

		title = title.toUpperCase();  
		template = dao.getTitleByName(title);  
		if(template == null){  
			template = new Template();  
			template.setTitle(title);  

			dao.insert(template);  
		}  
	}

	@Put("/templates/id")
	public void updateTemplates(String title) throws Exception{
		Template template = null;  

		template = dao.getTitleByName(title);  

		if(template != null){  
			template.setTitle(title);  

			dao.update(title);  
		}  
	}
	
	@Delete("/templates/id")
	public void deleteTemplates(String title) throws Exception{
		Template template = null;  
		title = title.toUpperCase();  
		template = dao.getTitleByName(title);  
		
		if(template != null){  
			dao.delete(template);  
		}
	}
}
