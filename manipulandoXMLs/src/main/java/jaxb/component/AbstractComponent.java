package jaxb.component;

import jaxb.Database.DatabaseService;

public class AbstractComponent {
    private DatabaseService db;

    public void InjectDependencies(DatabaseService db){
        this.db = db;
    }

}
