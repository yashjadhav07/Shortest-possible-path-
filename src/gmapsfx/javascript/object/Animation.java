
package gmapsfx.javascript.object;


public enum Animation {

    NULL("null"),
    BOUNCE("google.maps.Animation.BOUNCE"),
    DROP("google.maps.Animation.DROP");

    protected String typeString;

    Animation(String typeString) {
        this.typeString = typeString;
    }

    @Override
    public String toString() {
        return typeString;
    }

}
