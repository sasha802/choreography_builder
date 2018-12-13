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

	public void setDanceName(String danceName){
		this.danceName = danceName;
	}

	public String getDanceName(){
		return danceName;
	}

	public void setDeleted(int deleted){
		this.deleted = deleted;
	}

	public int getDeleted(){
		return deleted;
	}

	public void setDanceMovement(String danceMovement){
		this.danceMovement = danceMovement;
	}

	public String getDanceMovement(){
		return danceMovement;
	}

	public void setDancePosition(String dancePosition){
		this.dancePosition = dancePosition;
	}

	public String getDancePosition(){
		return dancePosition;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

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