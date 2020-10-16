package com.resource.model;
/**
 * Interface to be implemented by document models
 * @author Retro Ronin
 * 
 * 1.Should be comparable for the child classes to be comparable
 *
 */

public interface IDocumentModel {
	
	
	/* method to get unique entity id from internal service
	 * internal object specific application */
	 public void setEntityId(Long entityId);
	 public Long getEntityId();
	/**
	 * Further Implementations required below these in child classes
	 */

	/** for comparing IdocumentModel Sub class
	 *  Collection<IDocumentModel> listToBeSorted = new TreeSet<>(new Comparator<IDocumentModel>(){
	 *  @Override
	 *  public int compare(IdocumentModel first, IdocumentModel second) {
	 *  	return Integer.compare(((Downcastedclass)first).getproperty(),((Downcastedclass)second).getproperty());
	 *  	}
	 *  });
	 */
	
}
