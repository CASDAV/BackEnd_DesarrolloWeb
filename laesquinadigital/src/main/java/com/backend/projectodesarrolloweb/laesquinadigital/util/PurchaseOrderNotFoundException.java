package com.backend.projectodesarrolloweb.laesquinadigital.util;

@SuppressWarnings("serial")
public class PurchaseOrderNotFoundException extends RuntimeException {

    public PurchaseOrderNotFoundException(Long id) {
		super("Could not find Purchase Order by id:" + id);
	}
	
	public PurchaseOrderNotFoundException(String identificacion) {
		super("Could not find Purchase Order by identificacion:" + identificacion);
	}
    
}
