//Riley Shaw
//A nice place to put information about all the different image files, and map them to semantic names
public enum OrcImage {
	/*
	 * using an enum because there is a bunch of constant and static information
	 * that is external to the program which needs to be explicitly stated by the programmer
	 * 
	 * For instance, I can avoid assumption issues with different animation images by 
	 * explicitly stating here that the DIE animations are 7 frames long
	 * 
	 * Later, I can add imgWidth and imgHeight to these so that different 
	 * poses(for instance) can have different base image sizes.
	*/
	
	DIE_N ("die_north",7),
	DIE_W ("die_west", 7),
	DIE_S ("die_south",7),
	DIE_E ("die_east", 7),
	
	FIRE_N ("fire_north",4),
	FIRE_NW("fire_northwest",4),
	FIRE_W ("fire_west",4),
	FIRE_SW("fire_southwest",4),
	FIRE_S ("fire_south",4),
	FIRE_SE("fire_southeast",4),
	FIRE_E ("fire_east",4),
	FIRE_NE("fire_northeast",4),
	
	FORWARD_N ("forward_north",10),
	FORWARD_NW("forward_northwest",10),
	FORWARD_W ("forward_west",10),
	FORWARD_SW("forward_southwest",10),
	FORWARD_S ("forward_south",10),
	FORWARD_SE("forward_southeast",10),
	FORWARD_E ("forward_east",10),
	FORWARD_NE("forward_northeast",10),
	
	JUMP_N ("JUMP_north",8),
	JUMP_NW("JUMP_northwest",8),
	JUMP_W ("JUMP_west",8),
	JUMP_SW("JUMP_southwest",8),
	JUMP_S ("JUMP_south",8),
	JUMP_SE("JUMP_southeast",8),
	JUMP_E ("JUMP_east",8),
	JUMP_NE("JUMP_northeast",8);
	
	
	private final String path;
	private final int frameCount;
	
	OrcImage(String path, int frameCount){
		this.path="images/orc/orc_"+path+".png";
		this.frameCount = frameCount;
	}
	public String path() { //returns the path to the respective orc image
		return this.path;
	}
	public int frameCount() {
		return this.frameCount;
	}
}
