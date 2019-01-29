package com.tj720.mip.enumeration;

/**
 * 文件类型枚举
 * @author CM
 *
 */
public enum FileType {
	IMG(1, "img"),
	DOC(2, "doc"),
	AUDIO(3, "audio"),
	VIDEO(4, "video"),
	OTHER(5, "other");
	
	private int type;
	private String name;
	
	private FileType(int type, String name) {
		this.type = type;
		this.name = name;
	}
	
	/**
	 * 根据类型，返回名称
	 * @param type
	 * @return
	 */
    public static String getName(int type) {  
        for (FileType c : FileType.values()) {  
            if (c.getType() == type) {  
                return c.name;
            }  
        }  
        return null;  
    }  
    // get set 方法  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}  
    
}
