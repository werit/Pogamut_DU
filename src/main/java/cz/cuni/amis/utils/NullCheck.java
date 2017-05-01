package cz.cuni.amis.utils;

public class NullCheck {
	
	/**
	 * Throws {@link IllegalArgumentException} if obj == null. Used during the construction of the objects.
	 * @param obj
	 */
	public static void check(Object obj) {
		// TODO: implement me
            if(obj == null)
                throw new IllegalArgumentException("Object is null");
                //obj = new Object();
	}

}
