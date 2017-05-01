package cz.cuni.amis.utils;

/**
 * N-argument key - used to store multiple keys within one object to provide
 * n-argument key for maps.
 * <p>
 * <p>
 * The keys are not commutative!
 */
public class NKey {

    // TODO: initialize this value properly
    private int hashCode;
    public Object[] keys;

    public NKey(Object... keys) {
        // TODO: implement me
        StringBuilder sb = new StringBuilder();
        this.keys = new Object[keys.length];

        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == null) {
                continue;
            }
            sb.append(keys[i].hashCode());
            sb.append('|');
            this.keys[i] = keys[i];
        }
        this.hashCode = sb.hashCode();
    }

    @Override
    public int hashCode() {
        return this.hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO: implement me
        if (obj == null) {
            return false;
        }
        if (obj.getClass().equals(this.getClass())) {
            if (((NKey) obj).keys.length == this.keys.length) {
                for (int i = 0; i < this.keys.length; i++) {
                    if (keys[i] == null) {
                        if (((NKey) obj).keys[i] == null) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                    if (!keys[i].equals(((NKey) obj).keys[i])) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

}
