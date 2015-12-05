package nyc.c4q.ramonaharrison;

/**
 * Access Code 2.1
 * Ramona Harrison
 * RootNode.java
 */

public class RootNode extends Node {

    public RootNode() {
        super();
        for (int i = 65; i < 91; i++) {
            this.setChild((char)i);
        }
    }

}
