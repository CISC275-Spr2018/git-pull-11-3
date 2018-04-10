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

	JUMP_N ("jump_north",8),
	JUMP_NW("jump_northwest",8),
	JUMP_W ("jump_west",8),
	JUMP_SW("jump_southwest",8),
	JUMP_S ("jump_south",8),
	JUMP_SE("jump_southeast",8),
	JUMP_E ("jump_east",8),
	JUMP_NE("jump_northeast",8),

	IDLE_N ("idle_north",4),
	IDLE_NW("idle_northwest",4),
	IDLE_W ("idle_west",4),
	IDLE_SW("idle_southwest",4),
	IDLE_S ("idle_south",4),
	IDLE_SE("idle_southeast",4),
	IDLE_E ("idle_east",4),
	IDLE_NE("idle_northeast",4);

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
	public static OrcImage forward(Direction dir) {
		switch(dir) {
		case NORTH: return OrcImage.FORWARD_N;
		case NORTHEAST: return OrcImage.FORWARD_NE;
		case EAST: return OrcImage.FORWARD_E;
		case SOUTHEAST: return OrcImage.FORWARD_SE;
		case SOUTH: return OrcImage.FORWARD_S;
		case SOUTHWEST: return OrcImage.FORWARD_SW;
		case WEST: return OrcImage.FORWARD_W;
		case NORTHWEST: return OrcImage.FORWARD_NW;
		default: return OrcImage.FORWARD_S;
		}
	}
	public static OrcImage idle(Direction dir) {
		switch(dir) {
		case NORTH: return OrcImage.IDLE_N;
		case NORTHEAST: return OrcImage.IDLE_NE;
		case EAST: return OrcImage.IDLE_E;
		case SOUTHEAST: return OrcImage.IDLE_SE;
		case SOUTH: return OrcImage.IDLE_S;
		case SOUTHWEST: return OrcImage.IDLE_SW;
		case WEST: return OrcImage.IDLE_W;
		case NORTHWEST: return OrcImage.IDLE_NW;
		default: return OrcImage.IDLE_S;
		}
	}
	public static OrcImage jump(Direction dir) {
		switch(dir) {
		case NORTH: return OrcImage.JUMP_N;
		case NORTHEAST: return OrcImage.JUMP_NE;
		case EAST: return OrcImage.JUMP_E;
		case SOUTHEAST: return OrcImage.JUMP_SE;
		case SOUTH: return OrcImage.JUMP_S;
		case SOUTHWEST: return OrcImage.JUMP_SW;
		case WEST: return OrcImage.JUMP_W;
		case NORTHWEST: return OrcImage.JUMP_NW;
		default: return OrcImage.JUMP_S;
		}
	}
	public static OrcImage fire(Direction dir) {
		switch(dir) {
		case NORTH: return OrcImage.FIRE_N;
		case NORTHEAST: return OrcImage.FIRE_NE;
		case EAST: return OrcImage.FIRE_E;
		case SOUTHEAST: return OrcImage.FIRE_SE;
		case SOUTH: return OrcImage.FIRE_S;
		case SOUTHWEST: return OrcImage.FIRE_SW;
		case WEST: return OrcImage.FIRE_W;
		case NORTHWEST: return OrcImage.FIRE_NW;
		default: return OrcImage.FIRE_S;
		}
	}
}
