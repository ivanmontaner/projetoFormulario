package br.com.projetoFormulario.connection;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;

public class ConnectionDao {
	private static ConnectionDao myInstance = null;  
	  
    private Mongo mongo = null;  
    private static Datastore datastore = null;  
      
    private ConnectionDao() throws Exception {  
        mongo = new Mongo();  
        datastore = new Morphia().createDatastore(mongo, "noname");  
        datastore.ensureIndexes();  
    }  
      
    public synchronized static ConnectionDao getInstance() throws Exception{  
        if(myInstance == null){  
            myInstance = new ConnectionDao();  
        }  
        return myInstance;  
    }  
      
    public Datastore getDatastore() throws Exception{  
        if(datastore == null){  
            getInstance();  
        }  
        return datastore;  
    }  
  
          
    public Object save(Object object){  
        datastore.save(object);  
        return object;  
    }  
}
