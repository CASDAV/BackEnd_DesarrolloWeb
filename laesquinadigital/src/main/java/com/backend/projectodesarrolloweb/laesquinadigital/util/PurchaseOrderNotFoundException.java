package com.backend.projectodesarrolloweb.laesquinadigital.util;

@SuppressWarnings("serial")
public class PurchaseOrderNotFoundException extends RuntimeException {

    public PurchaseOrderNotFoundException(Long id) {
		super("Could not find PurchaseOrder by id:" + id);
	}
	
	public PurchaseOrderNotFoundException(String identificacion) {
		super("Could not find PurchaseOrder by identificacion:" + identificacion);
	}
    
}
