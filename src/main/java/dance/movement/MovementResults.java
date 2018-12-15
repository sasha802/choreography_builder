package dance.movement;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

/**
 * Class movement results entity
 * @author oponomarova
 */
@Generated("com.robohorse.robopojogenerator")
public class MovementResults{

	@JsonProperty("danceName")
	private String danceName;

	@JsonProperty("deleted")
	private int deleted;

	@JsonProperty("danceMovement")
	private String danceMovement;

	@JsonProperty("dancePosition")
	private String dancePosition;

	@JsonProperty("id")
	private int id;

	/**
	 * Set dance name
	 * @param danceName String dance name
	 */
	public void setDanceName(String danceName){
		this.danceName = danceName;
	}

	/**
	 * Get dance name
	 * @return danceName String dance name
	 */
	public String getDanceName(){
		return danceName;
	}

	/**
	 * Set deleted (soft delete)
	 * @param deleted int deleted
	 */
	public void setDeleted(int deleted){
		this.deleted = deleted;
	}

	/**
	 * Get deleted
	 * @return int deleted
	 */
	public int getDeleted(){
		return deleted;
	}

	/**
	 * Set dance movement description
	 * @param danceMovement String dance movement
	 */
	public void setDanceMovement(String danceMovement){
		this.danceMovement = danceMovement;
	}

	/**
	 * Get dance movement description
	 * @return String dance movement description
	 */
	public String getDanceMovement(){
		return danceMovement;
	}

	/**
	 * Set dance position description
	 * @param dancePosition String dance position description
	 */
	public void setDancePosition(String dancePosition){
		this.dancePosition = dancePosition;
	}

	/**
	 * Get dance position description
	 * @return dance poositon String
	 */
	public String getDancePosition(){
		return dancePosition;
	}


	/**
	 * Set id
	 * @param id int id
	 */
	public void setId(int id){
		this.id = id;
	}

	/**
	 * get id
	 * @return int id
	 */
	public int getId(){
		return id;
	}

	/**
	 * To string method
	 * @return String movemnt results
	 */
	@Override
 	public String toString(){
		return 
			"MovementResults{" + 
			"danceName = '" + danceName + '\'' + 
			",deleted = '" + deleted + '\'' + 
			",danceMovement = '" + danceMovement + '\'' + 
			",dancePosition = '" + dancePosition + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}