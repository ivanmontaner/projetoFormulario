package br.com.projetoFormulario.dao;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.projetoFormulario.connection.ConnectionDao;
import br.com.projetoFormulario.domain.Template;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.query.Query;
import com.google.code.morphia.query.UpdateOperations;

@Component
public class TemplateDao {
	private Datastore ds;  

	private void abreConexao() throws Exception{  
		ds = ConnectionDao.getInstance().getDatastore();         
	}  
	
	public List<Template> findAll() throws Exception{
		this.abreConexao();
		List<Template> templateList = ds.createQuery(Template.class).asList();
		
		return templateList;
	}
	
	public List<Template> findByID(String id) throws Exception{
		this.abreConexao();
		List<Template> productList = ds.createQuery(Template.class).field("id").equal(id).asList();
		return productList;  
	}
	
	public void insert(Template template) throws Exception{
		this.abreConexao();
		ds.save(template);
	}
	
	public void update(String title) throws Exception{
		this.abreConexao();
		
		UpdateOperations<Template> model = ds.createUpdateOperations(Template.class).add("id", title);
		Query<Template> query = ds.createQuery(Template.class).field("id").equal(title);
		
		ds.update(query, model);
	}
	
	public void delete(Template template) throws Exception{
		this.abreConexao();
		ds.delete(template);
	}
	
	public Template getTitleByName(String title) throws Exception {
		this.abreConexao();
		return ds.createQuery(Template.class).field("title").equal(title).get();
	}

}


