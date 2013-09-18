package br.com.projetoFormulario.dao;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.projetoFormulario.connection.ConnectionDao;
import br.com.projetoFormulario.domain.Template;

import com.google.code.morphia.Datastore;

@Component
public class TemplateDao {
	private Datastore ds;  

	private void abreConexao() throws Exception{  
		ds = ConnectionDao.getInstance().getDatastore();         
	}  
	
	public List<Template> findAllTemplates() throws Exception{
		this.abreConexao();
		List<Template> templateList = ds.createQuery(Template.class).asList();
		
		return templateList;
	}
	
	public List<Template> findTemplatesByID(String id) throws Exception{
		this.abreConexao();
		List<Template> productList = ds.createQuery(Template.class).field("id").contains(id).asList();
		return productList;  
	}

}


